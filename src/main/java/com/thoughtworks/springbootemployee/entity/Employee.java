package com.thoughtworks.springbootemployee.entity;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDto;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Employee(EmployeeRequestDto employeeRequestDto) {
        this.id = employeeRequestDto.getId();
        this.name = employeeRequestDto.getName();
        this.age = employeeRequestDto.getAge();
        this.gender = employeeRequestDto.getGender();
    }

    public Employee() {
    }

    public Employee(int id, String name, int age, String gender, Company company) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}