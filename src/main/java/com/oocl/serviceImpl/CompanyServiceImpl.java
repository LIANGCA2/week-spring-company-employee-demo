package com.oocl.serviceImpl;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Company;
import com.oocl.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {


    List<Company> companyList = EmpolyeeApiApplication.allCompany();

    @GetMapping("/companies")
    public List<Company> findAllCompany(){
        return companyList;
    }


    @Override
    public void deleteEmployeeFromCompany(Integer companyId) {
        for(int i =0;i<companyList.size();i++){
            if(companyList.get(i).getId()==companyId){
                companyList.get(i).setEmployeesNumber(companyList.get(i).getEmployeesNumber()-1);
            }
        }
    }
}
