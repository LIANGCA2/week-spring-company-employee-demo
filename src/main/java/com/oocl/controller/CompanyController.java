package com.oocl.controller;


import com.oocl.model.Company;
import com.oocl.model.CompanyWithEmployee;
import com.oocl.model.Employee;
import com.oocl.service.CompanyService;
import com.oocl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/companies")
    @ResponseBody
    public List<CompanyWithEmployee> findAllCompany() {
        List<Company> allCompany = companyService.findAllCompany();
        List<Employee> allEmployee= employeeService.findAllEmployee();
        List<CompanyWithEmployee> companyWithEmployeeList = new ArrayList<>();
for(int i =0;i<allCompany.size();i++){
    Integer companyId = allCompany.get(i).getId();
    List<Employee> employeeList = employeeService.findEmployeeByCompanyId(companyId);
    companyWithEmployeeList.add( new CompanyWithEmployee(allCompany.get(i).getCompanyName(), employeeList.size(),employeeList));
}
return  companyWithEmployeeList;
    }

}
