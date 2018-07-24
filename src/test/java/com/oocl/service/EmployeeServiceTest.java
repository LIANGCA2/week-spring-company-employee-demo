package com.oocl.service;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Employee;
import com.oocl.serviceImpl.EmployeeServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


public class EmployeeServiceTest {


    @Test
    public void return_all_employee_Test() {
        List<Employee> employeeList = EmpolyeeApiApplication.allEmployee();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        List<Employee> employeeList1 = employeeService.findAllEmployee();
        assertThat(employeeList).isEqualTo(employeeList1);
    }


}
