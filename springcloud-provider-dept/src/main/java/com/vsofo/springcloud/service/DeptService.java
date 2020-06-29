package com.vsofo.springcloud.service;

import com.vsofo.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);
    Dept queryById(long id);
    List<Dept> queryAll();
}
