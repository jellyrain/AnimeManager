package com.rain.animemanager.common;


/**
 * 结果代码
 *
 * @author rain
 * @date 2024/04/05
 */
public enum ResultCode implements IErrorCode {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 失败
     */
    FAILED(500, "操作失败"),
    /**
     * 验证失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),
    /**
     * 未经 授权
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 禁止
     */
    FORBIDDEN(403, "没有相关权限");

    /**
     * code
     */
    private final long code;
    /**
     * 消息
     */
    private final String message;

    /**
     * 结果代码
     *
     * @param code    法典
     * @param message 消息
     */
    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取代码
     *
     * @return long
     */
    @Override
    public long getCode() {
        return code;
    }

    /**
     * 获取消息
     *
     * @return {@link String}
     */
    @Override
    public String getMessage() {
        return message;
    }
}
