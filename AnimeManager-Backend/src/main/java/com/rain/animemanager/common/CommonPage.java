package com.rain.animemanager.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 通用页面
 *
 * @author rain
 * @date 2024/04/05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonPage<T> {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 列表
     */
    private List<T> list;
}
