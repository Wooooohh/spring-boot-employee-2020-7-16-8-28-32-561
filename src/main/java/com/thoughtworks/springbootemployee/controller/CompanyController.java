package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("companyController")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies/{companyId}")
    public Company getCompanyByCompanyId(@PathVariable("companyId") int companyId){
        return companyService.getCompanyByCompanyId(companyId);
    }

    @GetMapping("/companies/{companyId}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable("companyId") int companyId) {
        return companyService.getEmployeesByCompanyId(companyId);
    }

    @GetMapping("/companies")
    public Page<Company> getCompaniesByPage(@PageableDefault(page = 0,size = 1) Pageable pageable, @RequestParam( name = "unPage",defaultValue = "false") Boolean unPaged){
        if(unPaged)
            return companyService.getCompaniesByPage(Pageable.unpaged());
        return companyService.getCompaniesByPage(pageable);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @PutMapping("/companies")
    public void updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
    }

    @DeleteMapping("/companies/{companyId}")
    public void deleteCompany(@PathVariable("companyId") int companyId) {
        companyService.deleteCompany(companyId);
    }
}
