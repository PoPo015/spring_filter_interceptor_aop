package com.example.spring_filter_interceptor_aop.weather.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
public class UserEntity {
    private Long id;

    private String name;
    private String ctn;

    public UserEntity(Long id, String name, String ctn) {
        this.id = id;
        this.name = name;
        this.ctn = ctn;
    }


    public String maskingName(){
        log.info("호출임");
        return this.name;
    }





}
