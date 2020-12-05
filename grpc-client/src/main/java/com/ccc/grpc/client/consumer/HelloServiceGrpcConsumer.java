package com.ccc.grpc.client.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ccc.grpc.proto.Common;
import com.ccc.grpc.proto.HelloServiceGrpc;

import javax.annotation.Resource;

@Component
public class HelloServiceGrpcConsumer {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceGrpcConsumer.class);

    @Resource
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public Common.CommonResponse hello(String name) {
        return helloServiceBlockingStub.hello(com.ccc.grpc.proto.Common.CommonRequest.newBuilder().setName(name).build());
    }
}
