package com.oocl.service;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Employee;
import com.oocl.serviceImpl.EmployeeServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;


public class EmployeeServiceTest {


    @Test
    public void return_all_employee_Test() {
        List<Employee> employeeList = EmpolyeeApiApplication.allEmployee();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList1 = employeeService.findAllEmployee();
        assertThat(employeeList).isEqualTo(employeeList1);
    }


    @Test
    public void return_delete_employee_sucessful_when_list_exist_employee_Test() {

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.findAllEmployee();
        assertThat(employeeList.stream().filter(item->item.getId()==1).collect(Collectors.toList()).size()).isEqualTo(1);
        employeeService.deleteEmployee(1);
        assertThat(employeeList.stream().filter(item->item.getId()==1).collect(Collectors.toList()).size()).isEqualTo(0);
    }

    @Test
    public void return_delete_employee_unsucessful_when_employee_is_not_exist_Test() {

        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList = employeeService.findAllEmployee();
        int size = employeeList.size();
        employeeService.deleteEmployee(6);
        assertThat(employeeList.size()).isEqualTo(size);
    }

}