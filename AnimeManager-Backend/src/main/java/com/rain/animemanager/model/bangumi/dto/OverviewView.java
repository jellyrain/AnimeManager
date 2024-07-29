package com.rain.animemanager.model.bangumi.dto;

import com.rain.animemanager.model.bangumi.entity.Character;
import com.rain.animemanager.model.bangumi.entity.Episode;
import com.rain.animemanager.model.bangumi.entity.Overview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 番剧集合
 *
 * @author rain
 * @date 2024/07/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OverviewView {
    /**
     * 番剧 bangumi 上的 ID
     */
    private String bangumiId;
    /**
     * 概览
     */
    private Overview overview;
    /**
     * 角色列表
     */
    private List<Character> characterList;
    /**
     * 剧集列表
     */
    private List<Episode> episodeList;
}
