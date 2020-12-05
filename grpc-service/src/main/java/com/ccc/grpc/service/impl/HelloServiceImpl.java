package com.ccc.grpc.service.impl;

import org.springframework.stereotype.Service;
import com.ccc.grpc.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "HELLO: " + name;
    }
}
