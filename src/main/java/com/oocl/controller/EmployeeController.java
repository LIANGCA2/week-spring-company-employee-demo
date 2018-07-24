package com.oocl.controller;

import com.oocl.model.Employee;
import com.oocl.service.EmployeeService;
import com.oocl.util.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }


    @GetMapping("/employees/{param}")
    @ResponseBody
    public List<Employee> findOneOfEmployee(@PathVariable String param) {
        if(TypeUtil.isNum(param)){
            return employeeService.findOneOfEmployee(Integer.parseInt(param));
        }else {

            return employeeService.findEmployeeByGender(param);
        }
    }


    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    @ResponseBody
    public List<Employee> selectEmployeeByPageAndPageSize(@PathVariable Integer page,@PathVariable Integer pageSize) {
      return employeeService.getEmployeeByPageAndpageSize(page,pageSize);
    }



    @PostMapping("/employees")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return newEmployee;
    }

    @DeleteMapping("/employees/{id}")
    @ResponseBody
    public List<Employee> deleteEmployee(@PathVariable Integer id ){
         employeeService.deleteEmployee(id);
        return employeeService.deleteEmployee(id);
    }

    @PatchMapping("/employees/{id}")
    @ResponseBody
    public List<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }






}