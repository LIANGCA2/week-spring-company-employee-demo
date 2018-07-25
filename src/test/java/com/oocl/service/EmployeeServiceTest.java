package com.oocl.service;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Company;
import com.oocl.model.Employee;
import com.oocl.serviceImpl.EmployeeServiceImpl;
import com.oocl.util.EqualUtil;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EmployeeServiceTest {

    @Mock
    CompanyService companyService;
    @InjectMocks
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Before
    public void initMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void return_all_employee_Test() {
        List<Employee> employeeList = EmpolyeeApiApplication.allEmployee();

        List<Employee> employeeList1 = employeeService.findAllEmployee();
        assertThat(EqualUtil.EmployeeListisEqual(employeeList1,employeeList)).isEqualTo(true);
    }

    @Test
    public void return_add_employee_sucessful_when_add_employee_Test() {

        when(companyService.findAllCompany()).thenReturn(EmpolyeeApiApplication.allCompany());
        Employee employee = employeeService.addEmployee(new Employee(6,1,"TT",22,"female"));
        assertThat(employeeService.findAllEmployee().stream().filter(item->item.getId()==6).collect(Collectors.toList()).get(0)).isEqualTo(employee);
    }


    @Test
    public void return_add_employee_unsucessful_when_add_employee_company_is_not_exist_Test() {

        when(companyService.findAllCompany()).thenReturn(new ArrayList<Company>());
        Employee employee = employeeService.addEmployee(new Employee(6,3,"TT",22,"female"));

        assertThat(employeeService.findAllEmployee().stream().filter(item->item.getId()==6).collect(Collectors.toList()).size()).isEqualTo(0);
    }



    @Test
    public void return_delete_employee_sucessful_when_list_exist_employee_Test() {

        List<Employee> employeeList = employeeService.findAllEmployee();
        assertThat(employeeList.stream().filter(item->item.getId()==1).collect(Collectors.toList()).size()).isEqualTo(1);
        employeeService.deleteEmployee(1);
        assertThat(employeeList.stream().filter(item->item.getId()==1).collect(Collectors.toList()).size()).isEqualTo(0);
    }

    @Test
    public void return_delete_employee_unsucessful_when_employee_is_not_exist_Test() {

        List<Employee> employeeList = employeeService.findAllEmployee();
        int size = employeeList.size();
        employeeService.deleteEmployee(6);
        assertThat(employeeList.size()).isEqualTo(size);
    }


    @Test
    public void return_update_info_when_employee_is_exist_Test() {

        List<Employee> employeeList = employeeService.findAllEmployee();
        Employee employee_1 = employeeList.stream().filter((item)->item.getId()==1).collect(Collectors.toList()).get(0);
        List<Employee> employeeList1 = employeeService.updateEmployee(1,new Employee(null,null,"TT",null,null));
        Employee employee_2 = employeeList1.stream().filter((item)->item.getId()==1).collect(Collectors.toList()).get(0);
        assertThat(employee_2.getName()).isEqualTo("TT");
        assertThat(employee_1.getId()).isEqualTo(employee_2.getId());
        assertThat(employee_1.getAge()).isEqualTo(employee_2.getAge());
        assertThat(employee_1.getGender()).isEqualTo(employee_2.getGender());
    }



    @Test
    public void return_employee_when_employee_is_exist_Test() {

        Employee employee = employeeService.findOneOfEmployee(1).get(0);
        assertThat(employee.getId()).isEqualTo(1);
    }


    @Test
    public void return_employeeList_size_is_3_when_find_employee_by_male_Test() {

        List<Employee> employeeList = employeeService.findEmployeeByGender("male");
        List<Employee> employeeList1 = EmpolyeeApiApplication.allEmployee().stream().filter((item) -> item.getGender().equals("male")).collect(Collectors.toList());
        assertThat(EqualUtil.EmployeeListisEqual(employeeList1,employeeList)).isEqualTo(true);
    }


    @Test
    public void return_employeeList_when_select_by_page_Test(){
        List<Employee> employeeList = employeeService.getEmployeeByPageAndpageSize(1, 2);
        List<Employee> employeeList1 = EmpolyeeApiApplication.allEmployee().stream().limit(2).collect(Collectors.toList());
        assertThat(EqualUtil.EmployeeListisEqual(employeeList1,employeeList)).isEqualTo(true);
    }

    @Test
    public void return_employeeList_when_input_company_id_Test() {

        List<Employee> employeeList = employeeService.findEmployeeByCompanyId(1);
        List<Employee> employeeList1 = EmpolyeeApiApplication.allEmployee();
        assertThat(EqualUtil.EmployeeListisEqual(employeeList,employeeList1)).isEqualTo(true);
    }




}
