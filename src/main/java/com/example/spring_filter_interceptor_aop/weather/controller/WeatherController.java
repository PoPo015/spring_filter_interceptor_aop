package com.example.spring_filter_interceptor_aop.weather.controller;

import com.example.spring_filter_interceptor_aop.weather.controller.dto.RequestDto;
import com.example.spring_filter_interceptor_aop.weather.controller.dto.ResponseDto;
import com.example.spring_filter_interceptor_aop.weather.controller.dto.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/weather")
public class WeatherController {

    private UserEntity userEntity = new UserEntity(1L, "김승태", "01092742848");

    private final ObjectMapper objectMapper;

    @PostMapping
//    @LogExecutionTime
    public ResponseDto findWeather(@RequestBody RequestDto requestDto){
        log.info("> controller 호출 ! {}", requestDto);
        String name = userEntity.maskingName();
        ResponseDto responseDto = new ResponseDto();
        responseDto.setName(name);
        return responseDto;
    }

    @PostMapping("/filter")
    public void filterJsonTest(@RequestBody RequestDto requestDto){
        log.info("> controller [requestDto] :{}", requestDto);
//        log.info("> controller 호출 ! {}", requestDto);
//        String name = userEntity.maskingName();
//        ResponseDto responseDto = new ResponseDto();
//        responseDto.setName(name);
//        return responseDto;
    }


}
