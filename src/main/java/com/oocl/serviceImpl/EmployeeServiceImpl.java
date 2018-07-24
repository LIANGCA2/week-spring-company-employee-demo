package com.oocl.serviceImpl;

import com.oocl.EmpolyeeApiApplication;
import com.oocl.model.Employee;
import com.oocl.service.CompanyService;
import com.oocl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private CompanyService companyService;

    private List<Employee> employeeList = EmpolyeeApiApplication.allEmployee();
    @Override
    public List<Employee> findAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(companyService.findAllCompany().stream().filter(item->item.getId()==employee.getCompanyId()).collect(Collectors.toList()).size()>0) {
            employeeList.add(employee);
            return employeeList.stream().filter((item) -> item.equals(employee)).collect(Collectors.toList()).get(0);
        }else{
            return null;
        }
        }

    @Override
    public  List<Employee> deleteEmployee(Integer id) {
        for(int i=0;i<employeeList.size();i++){
            if(employeeList.get(i).getId()==id){
                Integer companyId = employeeList.get(i).getCompanyId();
                companyService.deleteEmployeeFromCompany(companyId);
                employeeList.remove(i);
                break;
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> updateEmployee(Integer id, Employee employee) {
        for(int i=0;i<employeeList.size();i++){
            if(employeeList.get(i).getId()==id){

                if (employee.getId()!=null){
                    employeeList.get(i).setId(employee.getId());
                }
                if (employee.getName()!=null){
                    employeeList.get(i).setName(employee.getName());
                }
                if (employee.getAge()!=null){
                    employeeList.get(i).setAge(employee.getAge());
                }
                if (employee.getGender()!=null){
                    employeeList.get(i).setGender(employee.getGender());
                }



                break;
            }
        }

        return employeeList;
    }

    @Override
    public Employee findOneOfEmployee(Integer id) {
        return employeeList.stream().filter((item)->item.getId()==id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Employee> findEmployeeByGender(String gender) {
        return employeeList.stream().filter((item)->item.getGender()==gender).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeByPageAndpageSize(int page, int pageSize) {
        List<Employee> employees = new ArrayList<>();
int start = (page-1)*pageSize;
int end = page*pageSize;
for(int i =start;i<end;i++){
    employees.add(employeeList.get(i));
}
            return employees;

    }
}
