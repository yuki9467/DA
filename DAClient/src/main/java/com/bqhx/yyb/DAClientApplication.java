package com.bqhx.yyb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DAClientApplication
{
    public static void main( String[] args )
    {
    	SpringApplication.run(DAClientApplication.class, args);
    }
    
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping(value = "/hello5", method = RequestMethod.POST)
    public String testHello(@RequestParam("id") String id) {
        return "hi "+id+",i am from port:" +port;
    }
    
    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    public String testHello4(@RequestParam("id") String id) {
        return "hi "+id+",i am from port:" +port;
    }
}
