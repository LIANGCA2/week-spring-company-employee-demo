package com.oocl.model;

import java.util.Objects;

public class Company {
    private Integer id;
    private String companyName;

    public Company(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public Company() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(companyName, company.companyName) ;
    }


}
