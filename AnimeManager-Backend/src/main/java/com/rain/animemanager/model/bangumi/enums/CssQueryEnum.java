package com.rain.animemanager.model.bangumi.enums;

/**
 * CSS Query Enum
 *
 * @author rain
 * @date 2024/07/28
 */
public final class CssQueryEnum {

    /**
     * 名字 css 选择器
     */
    public static final String NAME = "div#headerSubject h1 > a";
    /**
     * 封面 css 选择器
     */
    public static final String COVER = "div#bangumiInfo .infobox > div:nth-child(1) > a";

    /**
     * 信息框 css 选择器
     */
    public static final String INFOBOX = "ul#infobox li";

    /**
     * 简介 css 选择器
     */
    public static final String SUMMARY = "div#subject_summary";

    /**
     * 评分 css 选择器
     */
    public static final String SCORE = "div#panelInterestWrapper .global_score .number";
    /**
     * 集数 css 选择器
     */
    public static final String EPISODE = "div#columnInSubjectA .line_detail .line_list li";
    /**
     * 角色 css 选择器
     */
    public static final String CHARACTER = "div#columnInSubjectA div.light_odd";
    /**
     * 搜索结果
     */
    public static final String SEARCH_RESULT = "ul#browserItemList li";

    private CssQueryEnum() {

    }
}
