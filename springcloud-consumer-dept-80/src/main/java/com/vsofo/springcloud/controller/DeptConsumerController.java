package com.vsofo.springcloud.controller;

import com.vsofo.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //负载均衡通过服务名称去调用
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @GetMapping("/getDept/{id}")
    public Dept get (@PathVariable String id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/findById/"+ id ,Dept.class);
    }

    @PostMapping("/addDept")
    public Boolean addDept (Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/addDept", dept, Boolean.class);
    }
    @GetMapping("/findAll")
    public List<Dept> findAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/findAll", List.class);
    }
}
