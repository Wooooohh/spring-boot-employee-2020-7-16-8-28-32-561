package com.thoughtworks.springbootemployee.entity;

public class Company {

    private int companyId;

    public Company(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
