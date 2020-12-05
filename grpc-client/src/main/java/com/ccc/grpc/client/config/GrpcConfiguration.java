package com.ccc.grpc.client.config;

import com.ccc.grpc.proto.HelloServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ccc.grpc.client.GrpcConstant;
import com.ccc.grpc.client.core.GrpcServiceDiscovery;

/**
 * rpc client config
 */
@Configuration
public class GrpcConfiguration {

    @Bean
    public HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub(@Qualifier(value = "helloChannel") Channel channel) {
        return HelloServiceGrpc.newBlockingStub(channel);
    }

    @Autowired
    GrpcServiceDiscovery grpcServiceDiscovery;

    @Bean(name = "helloChannel")
    public ManagedChannel channel() {
        //get random service from zookeeper
        ServiceInstance service = grpcServiceDiscovery.getService(GrpcConstant.GRPC_SERVICE);
        if (service != null) {
            //build channel
            return ManagedChannelBuilder.forAddress(service.getHost(), service.getPort()).usePlaintext().build();

        }
        return null;
    }
}
