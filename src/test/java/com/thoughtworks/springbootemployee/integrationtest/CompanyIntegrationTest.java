package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.SpringBootEmployeeApplication;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {SpringBootEmployeeApplication.class})
@AutoConfigureMockMvc
public class CompanyIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private EmployeeRepository employeeRepository;

  @Autowired private CompanyRepository companyRepository;

  @AfterEach
  void tearDown() {
    employeeRepository.deleteAll();
    companyRepository.deleteAll();
  }

  @Test
  void should_return_company_when_get_company_by_id_given_company_id() throws Exception {
    // given
    Company company = new Company("oocl");
    companyRepository.save(company);
    Company addedCompany = companyRepository.findByName("oocl");
    // when
    mockMvc
        .perform(get("/companies/" + addedCompany.getCompanyId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("oocl"));
  }

  @Test
  void
      should_return_employees_when_get_employees_by_company_id_given_company_id_and_two_employees_in_this_company()
          throws Exception {
    List<Employee> employees = new ArrayList<>();
    Company company = new Company("oocl");
    Employee employee = new Employee("Jack", 20, "male", company);
    employees.add(employee);
    Employee employee2 = new Employee("Rose", 20, "female", company);
    employees.add(employee2);
    company.setEmployees(employees);
    companyRepository.save(company);
    employeeRepository.save(employee);
    employeeRepository.save(employee2);
    Company addedCompany = companyRepository.findByName("oocl");
    mockMvc
        .perform(get("/companies/" + addedCompany.getCompanyId() + "/employees"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("[0].name").value("Jack"));
  }

  @Test
  void should_return_paged_companies_when_get_employees_by_page_given_page_info() throws Exception {
    // given
    List<Employee> employees = new ArrayList<>();
    Company company = new Company("oocl");
    Employee employee = new Employee("Jack", 20, "male", company);
    employees.add(employee);
    Employee employee2 = new Employee("Rose", 20, "female", company);
    employees.add(employee2);
    company.setEmployees(employees);
    companyRepository.save(company);
    employeeRepository.save(employee);
    employeeRepository.save(employee2);
    Company company2 = new Company("tw");
    companyRepository.save(company2);

    // when
    mockMvc
        .perform(get("/companies").param("page", "0").param("size", "1").param("unPaged", "false"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("content[1]").doesNotExist());
  }

  @Test
  void should_return_updated_company_when_update_company_given_company() throws Exception {
    Company company = new Company("oocl");
    companyRepository.save(company);

    String companyJson =
            " {\n"
                    + "            \"name\": \"tw\"\n"
                    + " }";
    // when
    mockMvc
            .perform(
                    put("/companies/" + company.getCompanyId())
                            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                            .content(companyJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("name").value("tw"));
  }

  @Test
  void should_return_added_company_when_add_company_given_company() {}

  @Test
  void should_return_ok_when_delete_company_given_company_id() {}
}
