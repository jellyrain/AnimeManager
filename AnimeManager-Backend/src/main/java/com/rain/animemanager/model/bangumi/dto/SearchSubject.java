package com.rain.animemanager.model.bangumi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * 搜索主题
 *
 * @author rain
 * @date 2024/07/28
 */
@NoArgsConstructor
@Data
public class SearchSubject {

    @JsonProperty("data")
    private List<Data> data;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("offset")
    private Integer offset;

    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        @JsonProperty("date")
        private String date;
        @JsonProperty("image")
        private String image;
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("name")
        private String name;
        @JsonProperty("name_cn")
        private String nameCn;
        @JsonProperty("tags")
        private List<Tags> tags;
        @JsonProperty("score")
        private Double score;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("rank")
        private Integer rank;
        @JsonProperty("nsfw")
        private Boolean nsfw;

        @NoArgsConstructor
        @lombok.Data
        public static class Tags {
            @JsonProperty("name")
            private String name;
            @JsonProperty("count")
            private Integer count;
        }
    }
}
