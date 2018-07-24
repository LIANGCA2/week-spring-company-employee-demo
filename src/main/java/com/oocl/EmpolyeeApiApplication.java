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
	public static List<Employee> allEmployee(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1,"小明",20,"男"));
		employeeList.add(new Employee(2,"小红",19,"女"));
		employeeList.add(new Employee(3,"小智",15,"男"));
		employeeList.add(new Employee(4,"小刚",16,"男"));
		employeeList.add(new Employee(5,"小霞",15,"女"));
		return employeeList;
	}
	@Bean
	public static List<Company> allCompany(){
		List<Company> companyList = new ArrayList<>();

		return companyList;
	}
}
