package com.example.spring_filter_interceptor_aop.weather.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/weather")
public class WeatherController {

    @GetMapping
    public void findWeather(){
        log.info("> controller 호출 !");
    }



}
