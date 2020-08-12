package com.sontan.myb.service;

import com.sontan.myb.entity.Employee;
import com.sontan.myb.utils.PagerResult;


import java.util.List;

public interface EmployeeService {
    //查询列表
    public List<Employee> findAllEmployee();

    //分页
    public PagerResult<Employee> findPage(Integer pageNo, Integer pageSize);
    //修改
    public void update(Employee employee);
    //根据id查找到用户
    public Employee findOne(Long id);
    //添加
    public void add(Employee employee);

    //模糊搜索
    List<Employee> findNameOrModel(String name);

    //删除
    public void delete(Long[] ids);
}
