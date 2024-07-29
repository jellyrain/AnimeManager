package com.rain.animemanager.model.bangumi.service;

import com.rain.animemanager.common.CommonResult;
import com.rain.animemanager.model.bangumi.dao.BangumiDao;
import com.rain.animemanager.model.bangumi.dto.OverviewView;
import com.rain.animemanager.model.bangumi.dto.SearchSubject;
import com.rain.animemanager.model.bangumi.entity.*;
import com.rain.animemanager.model.bangumi.entity.Character;
import com.rain.animemanager.model.bangumi.enums.CssQueryEnum;
import com.rain.animemanager.utils.RestTemplateUtil;
import jakarta.annotation.Resource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Bangumi Service
 *
 * @author rain
 * @date 2024/07/28
 */
@Service
public class BangumiService {

    /**
     * REST 模板 util
     */
    @Resource
    private RestTemplateUtil restTemplateUtil;

    /**
     * Bangumi Dao
     */
    @Resource
    private BangumiDao bangumiDao;

    /**
     * 请求头
     */
    private final Map<String, String> headers = Map.of("User-Agent", "jellyrain/anime-manager");

    /**
     * 获取动漫概述
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Overview }
     */
    public Overview getAnimeOverview(String bangumiId) {
        String html = restTemplateUtil.get("https://bangumi.tv/subject/" + bangumiId, null, headers, String.class);
        Overview overview = new Overview();
        overview.setBangumiId(bangumiId);
        overview.setUrl("https://bangumi.tv/subject/" + bangumiId);

        Document doc = Jsoup.parse(html);
        Elements el = null;

        el = doc.select(CssQueryEnum.NAME);
        overview.setName(el.text());

        el = doc.select(CssQueryEnum.COVER);
        overview.setCover("https:" + el.attr("href"));

        el = doc.select(CssQueryEnum.SUMMARY);
        overview.setSummary(el.text());

        el = doc.select(CssQueryEnum.SCORE);
        overview.setScore(el.text());

        for (Element element : doc.select(CssQueryEnum.INFOBOX)) {
            String text = element.select("span").text().trim();
            switch (text) {
                case "中文名:":
                    overview.setChineseName(element.text().split("中文名:")[1].trim());
                    break;
                case "话数:":
                    overview.setEpisode(Integer.valueOf(element.text().split("话数:")[1].trim()));
                    break;
                case "放送开始:":
                    overview.setStartDate(element.text().split("放送开始:")[1].trim());
                    break;
                case "放送星期:":
                    overview.setWeekDay(element.text().split("放送星期:")[1].trim());
                    break;
                case "原作:":
                    overview.setOriginal(element.text().split("原作:")[1].trim());
                    break;
                case "导演:":
                    overview.setDirector(element.text().split("导演:")[1].trim());
                    break;
                case "脚本:":
                    overview.setScriptwriter(element.text().split("脚本:")[1].trim());
                    break;
                case "分镜:":
                    overview.setStoryboard(element.text().split("分镜:")[1].trim());
                    break;
                case "演出:":
                    overview.setDirectorOfPhotography(element.text().split("演出:")[1].trim());
                    break;
                case "音乐:":
                    overview.setMusic(element.text().split("音乐:")[1].trim());
                    break;
                case "人物设定:":
                    overview.setCharacterDesign(element.text().split("人物设定:")[1].trim());
                    break;
                case "系列构成:":
                    overview.setSeriesComposition(element.text().split("系列构成:")[1].trim());
                    break;
                case "美术监督:":
                    overview.setArtDirector(element.text().split("美术监督:")[1].trim());
                    break;
                case "色彩设计:":
                    overview.setColorDesign(element.text().split("色彩设计:")[1].trim());
                    break;
                case "总作画监督:":
                    overview.setChiefAnimationDirector(element.text().split("总作画监督:")[1].trim());
                    break;
                case "作画监督:":
                    overview.setAnimationDirector(element.text().split("作画监督:")[1].trim());
                    break;
                case "摄影监督:":
                    overview.setPhotographyDirector(element.text().split("摄影监督:")[1].trim());
                    break;
                case "道具设计:":
                    overview.setPropDesign(element.text().split("道具设计:")[1].trim());
                    break;
                case "剪辑:":
                    overview.setEditing(element.text().split("剪辑:")[1].trim());
                    break;
                case "主题歌编曲:":
                    overview.setThemeSongArrangement(element.text().split("主题歌编曲:")[1].trim());
                    break;
                case "主题歌作曲:":
                    overview.setThemeSongComposition(element.text().split("主题歌作曲:")[1].trim());
                    break;
                case "主题歌作词:":
                    overview.setThemeSongLyrics(element.text().split("主题歌作词:")[1].trim());
                    break;
                case "主题歌演出:":
                    overview.setThemeSongPerformance(element.text().split("主题歌演出:")[1].trim());
                    break;
                case "企画:":
                    overview.setPlanning(element.text().split("企画:")[1].trim());
                    break;
                case "制作管理:":
                    overview.setProductionManagement(element.text().split("制作管理:")[1].trim());
                    break;
                case "製作:":
                    overview.setProduction(element.text().split("製作:")[1].trim());
                    break;
                case "音响监督:":
                    overview.setSoundDirector(element.text().split("音响监督:")[1].trim());
                    break;
                case "音响:":
                    overview.setSound(element.text().split("音响:")[1].trim());
                    break;
                case "音效:":
                    overview.setSoundEffects(element.text().split("音效:")[1].trim());
                    break;
                case "特效:":
                    overview.setSpecialEffects(element.text().split("特效:")[1].trim());
                    break;
                case "执行制片人:":
                    overview.setExecutiveProducer(element.text().split("执行制片人:")[1].trim());
                    break;
                case "制片人:":
                    overview.setProducer(element.text().split("制片人:")[1].trim());
                    break;
                case "音乐制作:":
                    overview.setMusicProduction(element.text().split("音乐制作:")[1].trim());
                    break;
                case "动画制作:":
                    overview.setAnimationProduction(element.text().split("动画制作:")[1].trim());
                    break;
                case "美术设计:":
                    overview.setArtDesign(element.text().split("美术设计:")[1].trim());
                    break;
                case "OP・ED 分镜:":
                    overview.setOpeningEndingStoryboard(element.text().split("OP・ED 分镜:")[1].trim());
                    break;
                case "3DCG:":
                    overview.setThreeDimensionalComputerGraphics(element.text().split("3DCG:")[1].trim());
                    break;
                case "协力:":
                    overview.setCooperation(element.text().split("协力:")[1].trim());
                    break;
                case "别名:":
                    overview.setAlias(overview.getAlias() == null ? element.text().split("别名:")[1].trim() : overview.getAlias() + "、" + element.text().split("别名:")[1].trim());
                    break;
                case "官方网站:":
                    overview.setOfficialWebsite(element.text().split("官方网站:")[1].trim());
                    break;
                case "播放电视台:":
                    overview.setTvStation(element.text().split("播放电视台:")[1].trim());
                    break;
                case "播放结束:":
                    overview.setPlayEnd(element.text().split("播放结束:")[1].trim());
                    break;
                case "Copyright:":
                    overview.setCopyright(element.text().split("Copyright:")[1].trim());
                    break;
                case "音乐制作人:":
                    overview.setMusicProducer(element.text().split("音乐制作人:")[1].trim());
                    break;
                default:
                    break;
            }
        }

        return overview;
    }

    /**
     * 获取动漫剧集
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link List }<{@link Episode }>
     */
    public List<Episode> getAnimeEpisodeList(String bangumiId) {
        String html = restTemplateUtil.get("https://bangumi.tv/subject/" + bangumiId + "/ep", null, headers, String.class);
        List<Episode> episodeList = new ArrayList<>();
        Document doc = Jsoup.parse(html);

        String type = "";
        for (Element element : doc.select(CssQueryEnum.EPISODE)) {
            if ("cat".equals(element.attr("class"))) {
                type = element.text();
                continue;
            }

            if (element.attr("class").contains("clearit")) {
                continue;
            }

            Episode episode = new Episode();
            episode.setType(type);

            String title = element.select("a").get(0).text();
            int i = title.lastIndexOf(".");
            episode.setNumber(title.substring(0, i));
            episode.setTitle(title.substring(i + 1));

            String chineseTitle = element.select("span.tip").get(0).text();
            episode.setChineseTitle(chineseTitle.substring(1).trim());

            String duration = element.select("small.grey").get(0).text();
            int j = duration.indexOf("/");
            episode.setDuration(duration.substring(duration.indexOf("时长:") + 3, j).trim());
            episode.setFirstPlayTime(duration.substring(duration.indexOf("首播:") + 3).trim());

            episodeList.add(episode);
        }

        return episodeList;
    }

    /**
     * 获取动漫角色
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link List }<{@link Character }>
     */
    public List<Character> getAnimeCharacterList(String bangumiId) {
        String html = restTemplateUtil.get("https://bangumi.tv/subject/" + bangumiId + "/characters", null, headers, String.class);
        List<Character> characterList = new ArrayList<>();
        Document doc = Jsoup.parse(html);

        for (Element element : doc.select(CssQueryEnum.CHARACTER)) {
            Character character = new Character();

            character.setAvatar("https:" + element.select("img").get(0).attr("src"));
            character.setName(element.select("h2 .l").get(0).text());
            // 有些角色没有中文名
            Elements select = element.select("h2 .tip");
            if (!select.isEmpty()) {
                character.setChineseName(select.get(0).text().substring(1).trim());
            }
            character.setType(element.select(".badge_job").text());

            //  有些角色没有性别和生日
            Elements tip = element.select("span.tip");
            if (tip.size() >= 2) {
                Element el = tip.get(1);
                if (el.childNodeSize() >= 3) {
                    character.setSex(el.childNode(2).toString().trim().substring(0, 1));
                }
                if (el.childNodeSize() >= 5) {
                    character.setBirthday(el.childNode(4).toString().trim());
                }
            }

            // 有些角色没有声优
            Elements img = element.select("img");
            if (img.size() >= 2) {
                character.setVoiceActorAvatar("https:" + element.select("img").get(1).attr("src"));
                character.setVoiceActor(element.select("p .l").text());
                character.setVoiceActorChineseName(element.select("p .grey").text());
            }

            characterList.add(character);
        }

        return characterList;
    }

    /**
     * 搜索动漫
     *
     * @param keyword 关键词
     * @return {@link List }<{@link Search }>
     */
    public List<Search> searchAnime(String keyword) {
        Map<String, String> params = Map.of("limit", "10", "offset", "0");
        Map<String, Object> body = Map.of("keyword", keyword, "filter", Map.of("type", new int[]{2}));
        SearchSubject subject = restTemplateUtil.post("https://api.bgm.tv/v0/search/subjects", params, body, headers, SearchSubject.class);
        List<Search> searchList = new ArrayList<>();
        for (SearchSubject.Data data : subject.getData()) {
            Search search = new Search();
            search.setId(String.valueOf(data.getId()));
            search.setName(data.getName());
            search.setChineseName(data.getNameCn());
            search.setCover(data.getImage());
            search.setSummary(data.getSummary());
            searchList.add(search);
        }

        return searchList;
    }

    /**
     * 插入剧集
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer insertOverview(String bangumiId) {
        Overview overview = getAnimeOverview(bangumiId);
        return bangumiDao.insertOverviewSelective(overview);
    }

    /**
     * 删除概览通过番剧 bangumi 上的 ID
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer deleteOverviewByBangumiId(String bangumiId) {
        return bangumiDao.deleteOverviewByBangumiId(bangumiId);
    }

    /**
     * 插入角色
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer insertCharacter(String bangumiId) {
        List<Character> characterList = getAnimeCharacterList(bangumiId);
        int count = 0;
        for (Character character : characterList) {
            character.setBangumiId(bangumiId);
            count += bangumiDao.insertCharacterSelective(character);
        }
        return count;
    }

    /**
     * 删除角色通过番剧 bangumi 上的 ID
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer deleteCharacterByBangumiId(String bangumiId) {
        return bangumiDao.deleteCharacterByBangumiId(bangumiId);
    }

    /**
     * 插入剧集
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer insertEpisode(String bangumiId) {
        List<Episode> episodeList = getAnimeEpisodeList(bangumiId);
        int count = 0;
        for (Episode episode : episodeList) {
            episode.setBangumiId(bangumiId);
            count += bangumiDao.insertEpisodeSelective(episode);
        }
        return count;
    }

    /**
     * 删除剧集通过番剧 bangumi 上的 ID
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link Integer }
     */
    public Integer deleteEpisodeByBangumiId(String bangumiId) {
        return bangumiDao.deleteEpisodeByBangumiId(bangumiId);
    }

    /**
     * 刮削番剧数据保存数据库
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     */
    public void scrapeAndSave(String bangumiId) {
        insertOverview(bangumiId);
        insertCharacter(bangumiId);
        insertEpisode(bangumiId);
    }

    /**
     * 通过番剧 bangumi 上的 ID 查找概览
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     * @return {@link CommonResult }<{@link OverviewView }>
     */
    public OverviewView findOverviewByBangumiId(String bangumiId) {
        return bangumiDao.selectOverviewByBangumiId(bangumiId);
    }

    /**
     * 更新番剧数据
     *
     * @param bangumiId 番剧 bangumi 上的 ID
     */
    public void update(String bangumiId) {
        deleteOverviewByBangumiId(bangumiId);
        deleteCharacterByBangumiId(bangumiId);
        deleteEpisodeByBangumiId(bangumiId);
        scrapeAndSave(bangumiId);
    }
}
