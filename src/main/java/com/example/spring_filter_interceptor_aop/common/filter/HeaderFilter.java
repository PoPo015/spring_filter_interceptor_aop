package com.example.spring_filter_interceptor_aop.common.filter;


import com.example.spring_filter_interceptor_aop.weather.controller.dto.CoreResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class HeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(">>>>>>>>>>>>>>>> init ::  SecondFilter 최초 servlet 기동시 1회 실행");
    }

    //example :: https://velog.io/@kimdy0915/Spring-Security-Filter-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%ED%95%A0%EA%B9%8C
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info(">>>>>>>>>>>>>>>> Header Filter Start");
        if(!servletRequest.getContentType().contains("application/json")){
            log.info("request.getContentType() : {}", servletRequest.getContentType());
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType(servletRequest.getContentType());
            httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
            String json = new ObjectMapper().writeValueAsString(CoreResponseDto.of(HttpServletResponse.SC_BAD_REQUEST, "잘못된 요청 타입입니다."));
            httpServletResponse.getWriter().write(json);
            return;
        }
        chain.doFilter(servletRequest, servletResponse);
        log.info(">>>>>>>>>>>>>>>> Header Filter End");
    }


    @Override
    public void destroy() {
        log.info(">>>>>>>>>>>>>>>> init :: XssFilter 최초 servlet 기동시 1회 실행");
    }

}
