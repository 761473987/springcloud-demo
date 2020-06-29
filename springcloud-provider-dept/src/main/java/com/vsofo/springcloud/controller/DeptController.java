package com.vsofo.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vsofo.springcloud.pojo.Dept;
import com.vsofo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/addDept")
    public Boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }
    @GetMapping("/findById/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Dept findById (@PathVariable Long id) {
        return deptService.queryById(id);
    }
    @RequestMapping("/findAll")
    public List<Dept> findAll() {
        return deptService.queryAll();
    }
    public Dept getFallback (Long id) {
        return new Dept().setDeptName("服务被熔断了,这是一个默认对象");
    }
}
