package com.oocl.service;

import com.oocl.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployee();

    Employee addEmployee(Employee employee);

    List<Employee> deleteEmployee(Integer id);

    List<Employee> updateEmployee(Integer id, Employee employee);

    Employee findOneOfEmployee(Integer id);

    List<Employee> findEmployeeByGender(String gender);
}
