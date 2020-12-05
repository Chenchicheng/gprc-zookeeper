package com.ccc.grpc.server.provider;

import com.ccc.grpc.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import com.ccc.grpc.proto.Common;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.ccc.grpc.service.HelloService;


@GRpcService
public class HelloServiceProvider extends HelloServiceGrpc.HelloServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceProvider.class);

    @Autowired
    HelloService helloService;

    @Override
    public void hello(Common.CommonRequest request, StreamObserver<Common.CommonResponse> responseObserver) {
        //call service
        String result = helloService.hello(request.getName());

        //process response Message
        Common.CommonResponse response = Common.CommonResponse.newBuilder().setResult(result).build();

        //Receives a value from the stream
        responseObserver.onNext(response);

        //Receives a notification of successful stream completion.
        responseObserver.onCompleted();
    }
}
