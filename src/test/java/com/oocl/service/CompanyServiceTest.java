package com.oocl.service;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Company;
import com.oocl.serviceImpl.CompanyServiceImpl;
import com.oocl.util.EqualUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

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

}
