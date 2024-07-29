package com.rain.animemanager.model.bangumi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色
 *
 * @author rain
 * @date 2024/07/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    /**
     * ID
     */
    private Integer id;
    /**
     * bangumi Id
     */
    private String bangumiId;
    /**
     * 名字
     */
    private String name;
    /**
     * 中文名
     */
    private String chineseName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 类型
     */
    private String type;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 配音
     */
    private String voiceActor;
    /**
     * 配音中文名
     */
    private String voiceActorChineseName;
    /**
     * 配音头像
     */
    private String voiceActorAvatar;
}
