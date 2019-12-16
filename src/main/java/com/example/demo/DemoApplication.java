package com.example.demo;

import com.riozenc.titanTool.properties.Global;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@MapperScan("com.example.demo.dao")
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {

        Global.getConfig("namespace");
        SpringApplication.run(DemoApplication.class, args);
    }

}
