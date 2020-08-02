package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.CompanyRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @PutMapping("/companies/{companyId}")
    public Company updateCompany(@PathVariable("companyId") int companyId, @RequestBody(required = true) @Valid CompanyRequest companyRequest) {
        return companyService.updateCompany(companyId, companyRequest);
    }

    @DeleteMapping("/companies/{companyId}")
    public void deleteCompany(@PathVariable("companyId") int companyId) {
        companyService.deleteCompany(companyId);
    }
}
