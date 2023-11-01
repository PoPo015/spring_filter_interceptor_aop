package com.example.spring_filter_interceptor_aop.weather.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDto {
    private Long requestId;
    private String name;
}
