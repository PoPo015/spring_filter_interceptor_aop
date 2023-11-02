package com.example.spring_filter_interceptor_aop.common.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class LoggingFilter implements Filter {

    private ObjectMapper objectMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(">>>>>>>>>>>>>>>> init ::  LoggingFilter 최초 servlet 기동시 1회 실행");
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
        objectMapper = applicationContext.getBean(ObjectMapper.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(">>>>>>>>>>>>>>>> doFilter 시작:: FirstFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        chain.doFilter(request, response); //다음 필터를 실행. (필수로 추가필요 )
        log.info(">>>>>>>>>>>>>>>> doFilter 종료:: FirstFilter [URL] : {}", httpServletRequest.getRequestURI());

    }

    @Override
    public void destroy() {
        log.info(">>>>>>>>>>>>>>>> 최초 LoggingFilter servlet 종료시 1회 실행");
    }
}
