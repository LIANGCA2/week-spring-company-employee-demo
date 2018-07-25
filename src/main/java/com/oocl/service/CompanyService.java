package com.oocl.service;

import com.oocl.model.Company;

import java.util.List;

public interface CompanyService {


    List<Company> findAllCompany();

    Company findCompanyById(Integer id);
}
