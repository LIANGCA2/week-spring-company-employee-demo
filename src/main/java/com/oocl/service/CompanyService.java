package com.oocl.service;

import com.oocl.model.Company;

import java.util.List;

public interface CompanyService {
    void deleteEmployeeFromCompany(Integer companyId);

    List<Company> findAllCompany();
}
