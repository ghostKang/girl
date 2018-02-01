package com.yuk.girl.interceptor;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuk on 2018/1/24.
 */
public class PageInterceptor {

    /*private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String pageNum = request.getParameter("pageNum");// 开始页数
        String pageSize = request.getParameter("pageSize");// 每页行数
        try {
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        } catch (Exception e) {
            logger.error(String.format("page分页拦截异常，原因：%s", e.getMessage()));
        }
        return true;
    }*/

}
