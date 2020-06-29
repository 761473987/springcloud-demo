package com.vsofo.springcloud.service;

import com.vsofo.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT", fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptClientService {
    @GetMapping("/dept/findById/{id}")
    Dept findDeptById(@PathVariable(value = "id") String id);
    @GetMapping("/dept/findAll")
    List<Dept> findAll();
}
