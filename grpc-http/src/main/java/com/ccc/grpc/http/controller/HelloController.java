package com.ccc.grpc.http.controller;

import com.ccc.grpc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ccc.grpc.client.consumer.HelloServiceGrpcConsumer;


import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @Autowired
    HelloServiceGrpcConsumer consumer;

    /**
     * hello from local service
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String show(@RequestParam(value = "name") String name)  {

        return helloService.hello(name);
    }

    /**
     * hello from rpc service
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/helloFromRpc", method = RequestMethod.GET)
    public String showx(@RequestParam(value = "name") String name)  {
        return consumer.hello(name).getResult();
    }
}
