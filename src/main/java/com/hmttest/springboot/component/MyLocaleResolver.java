package com.hmttest.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义区域解析器
 * @Auther: HMT
 */
public class MyLocaleResolver implements LocaleResolver {
    Logger logger = LoggerFactory.getLogger(getClass());

    //解析区域信息
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取自定义请求头信息
        String l = httpServletRequest.getParameter("l");
        logger.info("解析区域信息：" + l);
        //获取浏览器上的区域信息
        Locale locale = httpServletRequest.getLocale();
        //获取当前操作系统 默认的区域信息
//        Locale locale = Locale.getDefault();

        if(!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            //接收第1个参数为：语言代码， 国家代码
            locale = new Locale(split[0], split[1]);
        }
        logger.info("最终采用的区域信息：" + locale.getLanguage() + "_" + locale.getCountry());
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
