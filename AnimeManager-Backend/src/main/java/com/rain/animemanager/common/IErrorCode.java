package com.rain.animemanager.common;

/**
 * ierror 接口
 *
 * @author rain
 * @date 2024/04/05
 */
public interface IErrorCode {
    /**
     * 获取code
     *
     * @return long
     */
    long getCode();

    /**
     * 获取消息
     *
     * @return {@link String}
     */
    String getMessage();
}
