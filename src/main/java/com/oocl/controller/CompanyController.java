package com.oocl.controller;


import com.oocl.model.Company;
import com.oocl.model.Employee;
import com.oocl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @GetMapping("/companies")
    @ResponseBody
    public List<Company> findAllCompany() {
        companyService.findAllCompany();
    }

}
