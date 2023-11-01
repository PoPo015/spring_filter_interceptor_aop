package com.example.spring_filter_interceptor_aop.common.interceptor;

import com.example.spring_filter_interceptor_aop.weather.controller.WeatherController;
import com.example.spring_filter_interceptor_aop.weather.controller.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class AuthenticatedInterceptor implements HandlerInterceptor {


    //https://gngsn.tistory.com/153
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("> Controller 동작이전 실행");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        log.info("Call Bean: " + handlerMethod.getBean());
        log.info("Call Method: " + method);
        String authorization = request.getHeader("Authorization");

        if ((handlerMethod.getBean() instanceof WeatherController)) {
            WeatherController bean = (WeatherController) handlerMethod.getBean();
            RequestDto requestDto = new RequestDto();
            requestDto.setName(authorization);
            bean.findWeather(requestDto);
        }

        log.info("interceptor : {}", authorization);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("> Controller 동작이후 실행");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("> DispatchServlet 의 화면 처리(뷰)가 완료된 상태에서 처리");
    }
}
