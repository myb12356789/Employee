package com.sontan.myb.controller;


import com.sontan.myb.entity.Employee;
import com.sontan.myb.entity.Result;
import com.sontan.myb.service.EmployeeService;
import com.sontan.myb.utils.PagerResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/showAllEmployee")
    public List<Employee> showAllEmp(){

        return employeeService.findAllEmployee();
    }
    //分页
    @ApiOperation(value = "分页查询")
    @GetMapping("/findPage")
    public PagerResult<Employee> findPage(Integer pageNo, Integer pageSize){
        if(pageNo<=0)
            pageNo=1;
        if( pageSize<=0)
            pageSize=10;
        PagerResult<Employee> pagerResult=employeeService.findPage(pageNo,pageSize);
        return pagerResult;
    }
    //修改方法
    @ApiOperation(value = "通过id拿到用户信息")
    @GetMapping("/findOne.do")
    public Employee findOne(Long id){
        return employeeService.findOne(id);

    }
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/update.do")
    public Result update(@RequestBody Employee employee){
        try {
            employeeService.update(employee);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }


    //添加信息
    @ApiOperation(value = "添加用户信息")
    @ResponseBody
    @PostMapping("/add.do")
    public Result add(@RequestBody Employee employee){
        try {
            employeeService.add(employee);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,"增加失败");
        }
    }
    //条件查询
    @ApiOperation(value = "模糊查询")
    @GetMapping("/findLike")
    public List<Employee> findNameOrModel(String name){
        return employeeService.findNameOrModel(name);
    }
    //根据id删除信息
    @ApiOperation(value = "根据id删除用户信息")
    @GetMapping("/delete.do")
    public Result delete(Long [] ids){
        try {
            employeeService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
