package com.oocl;

import com.oocl.model.Company;
import com.oocl.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmpolyeeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpolyeeApiApplication.class, args);
    }

    @Bean
    public static List<Employee> allEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, 1, "小明", 20, "male"));
        employeeList.add(new Employee(2, 1, "小红", 19, "female"));
        employeeList.add(new Employee(3, 1, "小智", 15, "male"));
        employeeList.add(new Employee(4, 1, "小刚", 16, "male"));
        employeeList.add(new Employee(5, 1, "小霞", 15, "female"));
        return employeeList;
    }

    @Bean
    public static List<Company> allCompany() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company(1, "oocl"));
        companyList.add(new Company(2, "meizu"));
        return companyList;
    }
}
