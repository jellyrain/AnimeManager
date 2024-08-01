package com.rain.animemanager.model.bangumi.controller;

import com.rain.animemanager.common.CommonResult;
import com.rain.animemanager.model.bangumi.vo.Daily;
import com.rain.animemanager.model.bangumi.vo.Search;
import com.rain.animemanager.model.bangumi.service.BangumiService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Bangumi Controller
 *
 * @author rain
 * @date 2024/07/29
 */
@RestController
@RequestMapping("/bangumi")
public class BangumiController {

    /**
     * Bangumi Service
     */
    @Resource
    private BangumiService bangumiService;


    /**
     * 搜索番剧
     *
     * @param keyword 关键词
     * @return {@link CommonResult }<{@link List }<{@link Search }>>
     */
    @GetMapping("/search")
    public CommonResult<List<Search>> search(String keyword) {
        try {
            return CommonResult.success(bangumiService.searchAnime(keyword), "搜索番剧成功");
        } catch (Exception e) {
            return CommonResult.failed("搜索番剧失败" + e.getMessage());
        }
    }

    /**
     * 获取每日番剧
     *
     * @param weekday 星期
     * @return {@link CommonResult }<{@link List }<{@link Daily }>>
     */
    @GetMapping("/daily")
    public CommonResult<List<Daily>> daily(String weekday) {
        try {
            return CommonResult.success(bangumiService.getDaily(weekday), "获取每日番剧成功");
        } catch (Exception e) {
            return CommonResult.failed("获取每日番剧失败" + e.getMessage());
        }
    }

    /**
     * 获取番剧信息
     *
     * @param id id
     * @return {@link CommonResult }<{@link Object }>
     */
    @GetMapping("/info")
    public CommonResult<Object> info(String id) {
        try {
            return CommonResult.success(bangumiService.findOverviewByBangumiId(id), "获取番剧信息成功");
        } catch (Exception e) {
            return CommonResult.failed("获取番剧信息失败" + e.getMessage());
        }
    }


    /**
     * 注册番剧信息
     *
     * @param id id
     * @return {@link CommonResult }<{@link String }>
     */
    @PostMapping("/register")
    public CommonResult<String> register(String id) {
        try {
            bangumiService.scrapeAndSave(id);
            return CommonResult.success("注册番剧成功");
        } catch (Exception e) {
            return CommonResult.failed("注册番剧失败" + e.getMessage());
        }
    }


    /**
     * 更新番剧信息
     *
     * @param id id
     * @return {@link CommonResult }<{@link String }>
     */
    @PostMapping("/update")
    public CommonResult<String> update(String id) {
        try {
            bangumiService.update(id);
            return CommonResult.success("更新番剧成功");
        } catch (Exception e) {
            return CommonResult.failed("更新番剧失败" + e.getMessage());
        }
    }

}
