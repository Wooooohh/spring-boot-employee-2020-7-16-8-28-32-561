package com.thoughtworks.springbootemployee.entity;

public class Employee {

    private int employeeId;

    private String gender;

    public Employee() {
    }

    public Employee(int employeeId, String gender) {
        this.employeeId = employeeId;
        this.gender = gender;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
