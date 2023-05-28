package com.example.spring_filter_interceptor_aop.common.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class FirstFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(">>>>>>>>>>>>>>>> init ::  FirstFilter 최초 servlet 기동시 1회 실행");
    }

    // header 정보, 세션 정보, URL 등등 가져올수 있겠네.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(">>>>>>>>>>>>>>>> doFilter 시작:: FirstFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        chain.doFilter(request, response); //다음 필터를 실행. (필수로 추가필요 )
        log.info(">>>>>>>>>>>>>>>> doFilter 종료:: FirstFilter [URL] : {}", httpServletRequest.getRequestURI());

    }

    @Override
    public void destroy() {
        log.info(">>>>>>>>>>>>>>>> 최초 FirstFilter servlet 종료시 1회 실행");
    }
}
