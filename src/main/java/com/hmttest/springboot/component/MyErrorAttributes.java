package com.hmttest.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义数据进行响应
 * @Auther: HMT
 */
@Component //向容器中添加该组件
public class MyErrorAttributes extends DefaultErrorAttributes {

    /**
     * 自定义数据进行响应
     * @param webRequest
     * @param includeStackTrace
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "HMT-hmt.test.com.cn");
        return map;
    }

}
