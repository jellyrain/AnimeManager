package com.rain.animemanager.model.bangumi.dao;

import com.rain.animemanager.model.bangumi.dto.OverviewView;
import com.rain.animemanager.model.bangumi.entity.Character;
import com.rain.animemanager.model.bangumi.entity.Episode;
import com.rain.animemanager.model.bangumi.entity.Overview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Bangumi Dao
 *
 * @author rain
 * @date 2024/07/29
 */
@Mapper
public interface BangumiDao {
    /**
     * 查询番剧概览通过番剧 bangumi 上的 ID
     */
    public OverviewView selectOverviewByBangumiId(@Param("bangumiId") String bangumiId);
    /**
     * 插入概览 选择性
     *
     * @param record 记录
     * @return {@link Integer }
     */
    public Integer insertOverviewSelective(Overview record);

    /**
     * 删除概览通过番剧 bangumi 上的 ID
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer deleteOverviewByBangumiId(@Param("bangumiId") String bangumiId);

    /**
     * 插入角色 选择性
     *
     * @param record 记录
     * @return {@link Integer }
     */
    public Integer insertCharacterSelective(Character record);

    /**
     * 删除角色通过番剧 bangumi 上的 ID
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer deleteCharacterByBangumiId(@Param("bangumiId") String bangumiId);

    /**
     * 插入剧集选择性
     *
     * @param record 记录
     * @return {@link Integer }
     */
    public Integer insertEpisodeSelective(Episode record);

    /**
     * 删除剧集通过番剧 bangumi 上的 ID
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer deleteEpisodeByBangumiId(@Param("bangumiId") String bangumiId);
}
