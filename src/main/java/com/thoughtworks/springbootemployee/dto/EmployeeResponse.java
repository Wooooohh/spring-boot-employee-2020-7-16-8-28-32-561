package com.thoughtworks.springbootemployee.dto;

public class EmployeeResponse {
    private Integer id;
    private String name;
    private Integer age;
    private String companyName;

    public EmployeeResponse(){

    }

    public EmployeeResponse(Integer id, String name, Integer age, String companyName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
