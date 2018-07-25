package com.oocl.serviceImpl;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Company;
import com.oocl.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {


    List<Company> companyList = EmpolyeeApiApplication.allCompany();

    @GetMapping("/companies")
    public List<Company> findAllCompany(){
        return companyList;
    }

    @Override
    public Company findCompanyById(Integer id) {
        return companyList.stream().filter(item->item.getId()==id).collect(Collectors.toList()).get(0);
    }


}
