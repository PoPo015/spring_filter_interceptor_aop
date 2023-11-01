package com.example.spring_filter_interceptor_aop.weather.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.ToString;

import javax.swing.*;
import java.time.LocalDateTime;

@Getter
@ToString
public class CoreResponseDto {

    private final String code;
    private final String msg;

    public CoreResponseDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    public static CoreResponseDto of(int scBadRequest, String message) {
        String code = String.valueOf(scBadRequest);
        return new CoreResponseDto(code, message);
    }
}
