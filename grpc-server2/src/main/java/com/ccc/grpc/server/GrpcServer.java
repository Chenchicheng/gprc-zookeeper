package com.ccc.grpc.server;

import com.ccc.grpc.server.provider.HelloServiceProvider;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * GrpcServer
 */
@EnableDiscoveryClient //服务自动注册
@SpringBootApplication
@ComponentScan({"com.ccc.grpc.service"})
public class GrpcServer {

    private static final Logger logger = LoggerFactory.getLogger(GrpcServer.class);

    @Bean
    public HelloServiceProvider helloServiceProvider() {
        return new HelloServiceProvider();
    }

    public static void main(String[] args) {
        SpringApplication.run(GrpcServer.class, args);
    }
}
