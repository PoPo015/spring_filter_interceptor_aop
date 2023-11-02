package com.example.spring_filter_interceptor_aop.common.aop;

import com.example.spring_filter_interceptor_aop.weather.controller.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Before("@annotation(LogExecutionTime)")
    public void logExecutionTime(JoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        log.info("응답시간 :{} ", stopWatch.prettyPrint());
    }

    @AfterReturning(value = "execution(* com.example.spring_filter_interceptor_aop.weather.controller..*(..))", returning = "response")
    public void logInsert(JoinPoint jp, Object response) {
        log.info("전달 파라미터:{}", Arrays.toString(jp.getArgs()));
        log.info("응답객체 response : {}", response);

        if(response instanceof ResponseDto){
            ResponseDto responseDto = (ResponseDto) response;
            responseDto.setName(maskName(((ResponseDto) response).getName(), 1));
        }
    }

    public static String maskName(String name, int visibleCharacters) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        int nameLength = name.length();
        // 이름을 마스킹 처리할 부분의 길이를 계산
        int maskLength = nameLength - visibleCharacters;
        maskLength = Math.max(maskLength, 0); // 음수 길이 방지

        // 마스킹 문자열 생성
        StringBuilder maskingString = new StringBuilder();
        for (int i = 0; i < maskLength; i++) {
            maskingString.append("*");
        }

        // 마스킹 처리된 이름 생성
        String maskedName = name.substring(0, visibleCharacters) + maskingString.toString();

        return maskedName;
    }
}
