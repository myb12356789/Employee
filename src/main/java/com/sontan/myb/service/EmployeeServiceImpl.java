package com.sontan.myb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sontan.myb.dao.EmployeeDao;
import com.sontan.myb.entity.Employee;
import com.sontan.myb.utils.PagerResult;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeDao employeeDao;

    @Override
    public PagerResult<Employee> findPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<Employee> page=(Page<Employee>) employeeDao.findAllEmployee();
        PagerResult<Employee> pageResult=new PagerResult<>(page.getTotal(),page.getResult());
        return pageResult;
    }


//查询到id
    @Override
    public Employee findOne(Long id) {
        return employeeDao.selectByPrimaryKey(id);
    }
    //修改
    @Override
    public void update(Employee employee) {
         employeeDao.updateByPrimaryKet(employee);
    }
    //添加
    @Override
    public void add(Employee employee) {
        employeeDao.insert(employee);
    }


    //根据名字查询用户
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findNameOrModel(String name) {
        return employeeDao.findNameOrModel(name);
    }
    //数组删除
    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            employeeDao.deleteByPrimaryKey(id);
        }
    }
    //查询所有用户
    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.findAllEmployee();
    }
}
