package com.oocl.service;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Company;
import com.oocl.model.Employee;
import com.oocl.serviceImpl.CompanyServiceImpl;
import com.oocl.util.EqualUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class CompanyServiceTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    CompanyServiceImpl companyService = new CompanyServiceImpl();

    @Before
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void return_all_Company_Test() {
        List<Company> companyList = EmpolyeeApiApplication.allCompany();

        List<Company> companyList1 = companyService.findAllCompany();
        assertThat(EqualUtil.CompanyListisEqual(companyList,companyList1)).isEqualTo(true);
    }

    @Test
    public void return_one_Company_Test() {
        Company company= companyService.findCompanyById(1);
        assertThat(company.getId()).isEqualTo(1);
    }


    @Test
    public void return_companyList_when_select_by_page_Test(){
        List<Company> companyList = companyService.getCompanyByPageAndpageSize(1, 2);
        List<Company> companyList1 = EmpolyeeApiApplication.allCompany().stream().limit(2).collect(Collectors.toList());
        assertThat(EqualUtil.CompanyListisEqual(companyList,companyList1)).isEqualTo(true);
    }

    @Test
    public void return_add_company_sucessful_when_add_company_Test() {

        Company company = companyService.addCompany(new Company(6,"thoughtWork"));
        assertThat(companyService.findAllCompany().stream().filter(item->item.getId()==6).collect(Collectors.toList()).get(0)).isEqualTo(company);
    }


    @Test
    public void return_update_info_when_Company_is_exist_Test() {

        List<Company> companyList = companyService.findAllCompany();
        Company company_1 = companyList.stream().filter((item)->item.getId()==1).collect(Collectors.toList()).get(0);
        List<Company> companyList1 = companyService.updateCompany(1,new Company(null,"OOLV"));
        Company company_2 = companyList1.stream().filter((item)->item.getId()==1).collect(Collectors.toList()).get(0);
        assertThat(company_2.getCompanyName()).isEqualTo("OOLV");
        assertThat(company_1.getId()).isEqualTo(company_2.getId());
    }

    @Test
    public void return_delete_Company_unsucessful_when_employee_is_not_exist_Test() {
        List<Company> companyList = companyService.findAllCompany();
        int size = companyList.size();
        when(employeeService.findAllEmployee()).thenReturn(new ArrayList<>());
        companyService.deleteCompany(6);
        assertThat(companyList.size()).isEqualTo(size);
    }

    @Test
    public void return_delete_Company_sucessful_when_employee_is__exist_Test() {
        List<Company> companyList = companyService.findAllCompany();
        int size = companyList.size();
        when(employeeService.findAllEmployee()).thenReturn(EmpolyeeApiApplication.allEmployee());
        when(employeeService.deleteEmployee(anyInt())).thenReturn(null);
        companyService.deleteCompany(1);
        assertThat(companyList.stream().filter(item->item.getId()==1).collect(Collectors.toList()).size()).isEqualTo(0);
    }



}
