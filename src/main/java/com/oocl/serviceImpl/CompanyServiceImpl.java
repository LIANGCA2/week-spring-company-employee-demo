package com.oocl.serviceImpl;

import com.oocl.model.Company;
import com.oocl.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {


    @GetMapping("/companies")
    public List<Company> findAllCompany(){
        return null;
    }


}
