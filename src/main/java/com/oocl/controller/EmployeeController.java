package com.oocl.controller;

import com.oocl.model.Employee;
import com.oocl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{id}")
    @ResponseBody
    public Employee findOneOfEmployee(@PathVariable Integer id) {
        return employeeService.findOneOfEmployee(id);
    }

//    @GetMapping("/employees/{param}")
//    @ResponseBody
//    public List<Employee> findOneOfEmployee(@PathVariable String param) {
//        if(param)
//        return employeeService.findEmployeeByGender(gender);
//    }



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