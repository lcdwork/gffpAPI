package com.jlsd.gffp;

import com.riozenc.titanTool.properties.Global;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@MapperScan("com.example.demo.dao")
@EnableScheduling
@EnableRetry
public class DemoApplication {

    public static void main(String[] args) {

        Global.getConfig("namespace");
        SpringApplication.run(DemoApplication.class, args);
    }

}
