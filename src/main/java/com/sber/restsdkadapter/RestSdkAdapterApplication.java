package com.sber.restsdkadapter;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class RestSdkAdapterApplication {

    public static void main(String[] args) {
        log.error("meh");
        SpringApplication.run(RestSdkAdapterApplication.class, args);
    }
}
