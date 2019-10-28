package com.hand.hiot;

import org.hzero.core.jackson.annotation.EnableObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableChoerodonResourceServer
@EnableDiscoveryClient
@EnableObjectMapper
@SpringBootApplication
@EnableFeignClients
public class HiotOrder25160Application {

    public static void main(String[] args) {
        SpringApplication.run(HiotOrder25160Application.class, args);
    }
}


