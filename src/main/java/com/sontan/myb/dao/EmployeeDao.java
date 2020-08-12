package com.sontan.myb.dao;

import com.sontan.myb.entity.Employee;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface EmployeeDao {
    //查询列表
    public List<Employee> findAllEmployee();
    //根据id进行查询
    public Employee selectByPrimaryKey(Long id);
    //修改保存
    public void updateByPrimaryKet(Employee employee);
    //添加
    public void insert(Employee employee);

    //根据姓名
    List<Employee> findNameOrModel(@Param("name") String name);
    //根据id删除信息
    public void deleteByPrimaryKey(Long ids);

}
