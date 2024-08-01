package com.rain.animemanager.model.bangumi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 每日放送
 *
 * @author rain
 * @date 2024/08/01
 */
@NoArgsConstructor
@Data
public class Calendar {

    @JsonProperty("weekday")
    private Weekday weekday;
    @JsonProperty("items")
    private List<Items> items;

    @NoArgsConstructor
    @Data
    public static class Weekday {
        @JsonProperty("en")
        private String en;
        @JsonProperty("cn")
        private String cn;
        @JsonProperty("ja")
        private String ja;
        @JsonProperty("id")
        private Integer id;
    }

    @NoArgsConstructor
    @Data
    public static class Items {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("url")
        private String url;
        @JsonProperty("type")
        private Integer type;
        @JsonProperty("name")
        private String name;
        @JsonProperty("name_cn")
        private String nameCn;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("air_date")
        private String airDate;
        @JsonProperty("air_weekday")
        private Integer airWeekday;
        @JsonProperty("rating")
        private Rating rating;
        @JsonProperty("rank")
        private Integer rank;
        @JsonProperty("images")
        private Images images;
        @JsonProperty("collection")
        private Collection collection;

        @NoArgsConstructor
        @Data
        public static class Rating {
            @JsonProperty("total")
            private Integer total;
            @JsonProperty("count")
            private Count count;
            @JsonProperty("score")
            private Double score;

            @NoArgsConstructor
            @Data
            public static class Count {
                @JsonProperty("1")
                private Integer $1;
                @JsonProperty("2")
                private Integer $2;
                @JsonProperty("3")
                private Integer $3;
                @JsonProperty("4")
                private Integer $4;
                @JsonProperty("5")
                private Integer $5;
                @JsonProperty("6")
                private Integer $6;
                @JsonProperty("7")
                private Integer $7;
                @JsonProperty("8")
                private Integer $8;
                @JsonProperty("9")
                private Integer $9;
                @JsonProperty("10")
                private Integer $10;
            }
        }

        @NoArgsConstructor
        @Data
        public static class Images {
            @JsonProperty("large")
            private String large;
            @JsonProperty("common")
            private String common;
            @JsonProperty("medium")
            private String medium;
            @JsonProperty("small")
            private String small;
            @JsonProperty("grid")
            private String grid;
        }

        @NoArgsConstructor
        @Data
        public static class Collection {
            @JsonProperty("doing")
            private Integer doing;
        }
    }
}
