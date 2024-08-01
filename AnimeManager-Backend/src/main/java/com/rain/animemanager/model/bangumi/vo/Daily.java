package com.rain.animemanager.model.bangumi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 每日放送搜索结果
 *
 * @author rain
 * @date 2024/07/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Daily {
    /**
     * ID
     */
    private String id;
    /**
     * 名字
     */
    private String name;
    /**
     * 中文名
     */
    private String chineseName;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 简介
     */
    private String summary;
}
