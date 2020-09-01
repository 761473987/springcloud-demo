package com.vsofo.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class DeptApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptApplication.class, args);
    }

    //增加一个servlet
    @Bean
    public ServletRegistrationBean getServletBean () {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
                registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
