package com.oocl.controller;


import com.oocl.model.Company;
import com.oocl.model.CompanyWithEmployee;
import com.oocl.model.Employee;
import com.oocl.service.CompanyService;
import com.oocl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        List<CompanyWithEmployee> companyWithEmployeeList = new ArrayList<>();
        for (int i = 0; i < allCompany.size(); i++) {
            Integer companyId = allCompany.get(i).getId();
            List<Employee> employeeList = employeeService.findEmployeeByCompanyId(companyId);
            companyWithEmployeeList.add(new CompanyWithEmployee(allCompany.get(i).getCompanyName(), employeeList.size(), employeeList));
        }
        return companyWithEmployeeList;
    }



    @GetMapping("/companies/{id}")
    @ResponseBody
    public CompanyWithEmployee findOneCompany(@PathVariable Integer id) {
        Company company = companyService.findCompanyById(id);
        List<Employee> employeeList = employeeService.findEmployeeByCompanyId(id);
        CompanyWithEmployee companyWithEmployee= new CompanyWithEmployee(company.getCompanyName(), employeeList.size(), employeeList);
       return companyWithEmployee;
    }

    @GetMapping("/companies/{id}/employees")
    @ResponseBody
    public List<Employee> findEmployeeByCompanyId(@PathVariable Integer id) {

        return employeeService.findEmployeeByCompanyId(id);
    }




    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    @ResponseBody
    public List<Company> selectCompanyByPageAndPageSize(@PathVariable Integer page,@PathVariable Integer pageSize) {
        return companyService.getCompanyByPageAndpageSize(page,pageSize);
    }


    @PostMapping("/companies")
    @ResponseBody
    public Company addCompany(@RequestBody Company company){
        Company newCompany = companyService.addCompany(company);
        return newCompany;
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
