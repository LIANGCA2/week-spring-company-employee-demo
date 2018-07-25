package com.oocl.serviceImpl;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Company;
import com.oocl.model.Employee;
import com.oocl.service.CompanyService;
import com.oocl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
            private EmployeeService employeeService;

    List<Company> companyList = EmpolyeeApiApplication.allCompany();

    @GetMapping("/companies")
    public List<Company> findAllCompany(){
        return companyList;
    }

    @Override
    public Company findCompanyById(Integer id) {
        return companyList.stream().filter(item->item.getId()==id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Company> getCompanyByPageAndpageSize(Integer page, Integer pageSize) {
        List<Company> companys = new ArrayList<>();
        int start = (page-1)*pageSize;
        int end = page*pageSize;
        for(int i =start;i<end;i++){
            companys.add(companyList.get(i));
        }
        return companys;
    }

    @Override
    public Company addCompany(Company company) {
        companyList.add(company);
            return companyList.stream().filter((item) -> item.equals(company)).collect(Collectors.toList()).get(0);

    }

    @Override
    public List<Company> updateCompany(Integer id, Company company) {
        for(int i=0;i<companyList.size();i++){
            if(companyList.get(i).getId()==id){

                if (company.getId()!=null){
                    companyList.get(i).setId(company.getId());
                }
                if (company.getCompanyName()!=null){
                    companyList.get(i).setCompanyName(company.getCompanyName());
                }




                break;
            }
        }

        return companyList;
    }

    @Override
    public List<Company> deleteCompany(Integer id) {
        List<Employee> employeeList = employeeService.findAllEmployee();
        for(Integer i = 0;i<employeeList.size();i++){
            if(employeeList.get(i).getCompanyId()==id){
                employeeService.deleteEmployee(employeeList.get(i).getId());
            }
        }
        for(int i = 0;i<companyList.size();i++){
            if(companyList.get(i).getId()==id){
                companyList.remove(i);
                break;
            }
        }
        return  companyList;
    }


}
