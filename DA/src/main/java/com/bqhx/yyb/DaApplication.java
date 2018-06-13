package com.bqhx.yyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bqhx.yyb.config.DynamicDataSourceRegister;

@Import({DynamicDataSourceRegister.class}) // 注册动态多数据源
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableAutoConfiguration
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class DaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaApplication.class, args);
	}
}
