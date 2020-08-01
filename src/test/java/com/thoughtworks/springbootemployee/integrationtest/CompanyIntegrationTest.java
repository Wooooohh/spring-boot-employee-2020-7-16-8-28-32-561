package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.SpringBootEmployeeApplication;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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
  void should_return_company_when_get_company_by_id_given_company_id() throws Exception {}

  @Test
  void should_return_employees_when_get_employees_by_company_id_given_company_id()
      throws Exception {}

  @Test
  void should_return_paged_companies_when_get_employees_by_page_given_page_info()
      throws Exception {}

  @Test
  void should_return_updated_company_when_update_company_given_company() throws Exception {}

  @Test
  void should_return_added_company_when_add_company_given_company() {}

  @Test
  void should_return_ok_when_delete_company_given_company_id() {}
}
