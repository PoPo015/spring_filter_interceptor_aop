package com.example.spring_filter_interceptor_aop.common.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(">>>>>>>>>>>>>>>> init ::  SecondFilter 최초 servlet 기동시 1회 실행");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(">>>>>>>>>>>>>>>> dofilter 시작 ::  SecondFilter ");
        chain.doFilter(request,response);
        log.info(">>>>>>>>>>>>>>>> dofilter 종료 ::  SecondFilter ");

    }

    @Override
    public void destroy() {
        log.info(">>>>>>>>>>>>>>>> init :: SecondFilter 최초 servlet 기동시 1회 실행");
    }
}
