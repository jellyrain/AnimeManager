package com.rain.animemanager.model.bangumi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 集数
 *
 * @author rain
 * @date 2024/07/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    /**
     * ID
     */
    private Integer id;
    /**
     * bangumi Id
     */
    private String bangumiId;
    /**
     * 集数
     */
    private String number;
    /**
     * 类型
     */
    private String type;
    /**
     * 集数标题
     */
    private String title;
    /**
     * 中文标题
     */
    private String chineseTitle;
    /**
     * 时长
     */
    private String duration;
    /**
     * 首播时间
     */
    private String firstPlayTime;
}
