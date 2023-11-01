package com.example.spring_filter_interceptor_aop.weather.controller;

import com.example.spring_filter_interceptor_aop.weather.controller.dto.RequestDto;
import com.example.spring_filter_interceptor_aop.weather.controller.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/weather")
public class WeatherController {

    @PostMapping
    public ResponseDto findWeather(@RequestBody RequestDto requestDto){
        log.info("> controller 호출 ! {}", requestDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setName(">이름<");
        return responseDto;
    }



}
