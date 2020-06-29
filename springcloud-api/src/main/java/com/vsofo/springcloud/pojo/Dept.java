package com.vsofo.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//开启链式写法
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class Dept {

  private long id;
  private String deptName;
  private String dbSource;

  public Dept(String dbSource) {
    this.dbSource = dbSource;
  }
}
