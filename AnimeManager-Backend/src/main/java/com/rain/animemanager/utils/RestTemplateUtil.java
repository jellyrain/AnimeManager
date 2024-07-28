package com.rain.animemanager.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * REST 模板 util
 *
 * @author rain
 * @date 2024/07/28
 */
@Component
public class RestTemplateUtil {
    private final RestTemplate restTemplate;

    public RestTemplateUtil() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }


    /**
     * 获取最终网址
     *
     * @param url    网址
     * @param params 参数
     * @return {@link String }
     */
    private String getFinalUrl(String url, Map<String, String> params) {
        // 构建 URI 并添加参数
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                uriBuilder.queryParam(entry.getKey(), entry.getValue());
            }
        }
        return uriBuilder.toUriString();
    }

    /**
     * 获取 HTTP 标头
     *
     * @param headers 头
     * @return {@link HttpHeaders }
     */
    private HttpHeaders getHttpHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpHeaders.set(entry.getKey(), entry.getValue());
            }
        }
        return httpHeaders;
    }

    public <T> T get(String url, Map<String, String> params, Map<String, String> headers, Class<T> responseType) {
        // 拼接 URL
        String finalUrl = getFinalUrl(url, params);

        // 创建 HttpHeaders 对象并设置请求头
        HttpHeaders httpHeaders = getHttpHeaders(headers);

        // 创建 HttpEntity 对象
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        // 使用 exchange 方法发送请求
        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.GET, entity, responseType);

        // 返回响应体
        return response.getBody();

    }

    public <T> T post(String url, Map<String, String> params, Map<String, Object> body, Map<String, String> headers, Class<T> responseType) {
        // 拼接 URL
        String finalUrl = getFinalUrl(url, params);

        // 创建 HttpHeaders 对象并设置请求头
        HttpHeaders httpHeaders = getHttpHeaders(headers);

        // 创建请求体
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, httpHeaders);

        // 使用 exchange 方法发送请求
        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.POST, entity, responseType);

        // 返回响应体
        return response.getBody();
    }

    public <T> T put(String url, Map<String, String> params, Map<String, Object> body, Map<String, String> headers, Class<T> responseType) {
        // 拼接 URL
        String finalUrl = getFinalUrl(url, params);

        // 创建 HttpHeaders 对象并设置请求头
        HttpHeaders httpHeaders = getHttpHeaders(headers);

        // 创建请求体
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, httpHeaders);

        // 使用 exchange 方法发送请求
        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.PUT, entity, responseType);

        // 返回响应体
        return response.getBody();
    }

    public <T> T delete(String url, Map<String, String> params, Map<String, String> headers, Class<T> responseType) {
        // 拼接 URL
        String finalUrl = getFinalUrl(url, params);

        // 创建 HttpHeaders 对象并设置请求头
        HttpHeaders httpHeaders = getHttpHeaders(headers);

        // 创建 HttpEntity 对象
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        // 使用 exchange 方法发送请求
        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.DELETE, entity, responseType);

        // 返回响应体
        return response.getBody();
    }
}
