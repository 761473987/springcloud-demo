package com.vsofo.springcloud.dao;

import com.vsofo.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept queryById(long id);
    public List<Dept> queryAll();
}
