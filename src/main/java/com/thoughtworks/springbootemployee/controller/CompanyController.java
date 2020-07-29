package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("companyController")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies/{companyId}")
    public Company getCompany(@PathVariable("companyId") int companyId) {
        return companyService.getCompany(companyId);
    }

    @GetMapping("/companies/{companyId}/employees")
    public List<Employee> getEmployeesFromCompanyId(@PathVariable("companyId") int companyId) {
        return companyService.getEmployee(companyId);
    }

    @GetMapping("/companies")
    public List<Company> getCompaniesByPage(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "0") int pageSize) {
        if (pageSize == 0)
            return companyService.getCompanies();
        return companyService.getCompaniesByPage(page, pageSize);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping("/companies/{companyId}")
    public void updateCompany(@PathVariable("companyId") int companyId, @RequestBody Company company) {
        companyService.updateCompany(companyId, company);
    }

    @DeleteMapping("/companies/{companyId}")
    public void deleteCompanyEmployees(@PathVariable("companyId") int companyId) {
        companyService.deleteCompanyEmployees(companyId);
    }
}
