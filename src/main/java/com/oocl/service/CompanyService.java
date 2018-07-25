package com.oocl.service;

import com.oocl.model.Company;

import java.util.List;

public interface CompanyService {


    List<Company> findAllCompany();

    Company findCompanyById(Integer id);

    List<Company> getCompanyByPageAndpageSize(Integer page, Integer pageSize);

    Company addCompany(Company company);
}
