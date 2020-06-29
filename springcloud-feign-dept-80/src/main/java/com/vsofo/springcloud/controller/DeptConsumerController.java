package com.vsofo.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vsofo.springcloud.pojo.Dept;
import com.vsofo.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {
    @Autowired
    private DeptClientService service = null;

    @GetMapping("/getDept/{id}")
    public Dept get (@PathVariable String id) {
        return service.findDeptById(id);
    }
    @PostMapping("/addDept")
    public Boolean addDept (Dept dept) {
        return null;
    }
    @GetMapping("/findAll")
    public List<Dept> findAll() {
        return service.findAll();
    }
}
