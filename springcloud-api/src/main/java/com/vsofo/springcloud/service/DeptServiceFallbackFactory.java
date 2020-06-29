package com.vsofo.springcloud.service;

import com.vsofo.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept findDeptById(String id) {
                return new Dept().setDeptName("这个服务被关闭，服务被降级了！");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
