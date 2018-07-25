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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;

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



}
