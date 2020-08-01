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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {SpringBootEmployeeApplication.class})
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private EmployeeRepository employeeRepository;

  @Autowired private CompanyRepository companyRepository;

  @AfterEach
  void tearDown() {
    employeeRepository.deleteAll();
    companyRepository.deleteAll();
  }

  @Test
  void should_return_ok_when_get_employees() throws Exception {
    Company company = new Company("oocl");
    companyRepository.save(company);
    Employee employee = new Employee("jack", "male", company);
    employeeRepository.save(employee);
    mockMvc
        .perform(get("/employees"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("content[0].name").value("jack"));
  }

  // 创建员工的信息不合法
  @Test
  void should_return_created_employee_when_post_employee_given_employee() throws Exception {
    Company company = new Company("oocl");
    companyRepository.save(company);
    String employee =
        " {\n"
            + "            \"name\": \"Zoeaa\",\n"
            + "            \"age\": 15,\n"
            + "            \"gender\": \"male\",\n"
            + "            \"companyId\": \"1\" \n"
            + " }";
    mockMvc
        .perform(
            post("/employees").contentType(MediaType.APPLICATION_PROBLEM_JSON).content(employee))
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("Zoeaa"));
  }

  // page信息错误
  @Test
  void should_return_paged_employees_when_get_employees_by_page_given_page_info() throws Exception {
    Company company = new Company("oocl");
    companyRepository.save(company);
    Employee emloyee1 = new Employee("jack", 20, "male", company);
    Employee emloyee2 = new Employee("alisa", 20, "female", company);
    employeeRepository.save(emloyee1);
    employeeRepository.save(emloyee2);
    mockMvc
        .perform(get("/employees").param("page", "0").param("size", "1").param("unPaged", "false"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("content[1]").doesNotExist());
  }

  // id不存在
  @Test
  void should_return_ok_when_delete_employee_given_employee_id() throws Exception {
    // given
    Company company = new Company("oocl");
    companyRepository.save(company);
    Employee employee = new Employee("Jack", 20, "male", company);
    employeeRepository.save(employee);
    Employee addedEmployee = employeeRepository.findByName(employee.getName());
    // when
    mockMvc.perform(delete("/employees/" + addedEmployee.getId())).andExpect(status().isOk());
  }

  // id不存在
  @Test
  void should_return_employee_when_get_employee_with_id_given_employee_id() {}

  @Test
  void
      should_return_employees_with_gender_is_male_when_get_employees_by_gender_given_gender_is_male() {}

  // employee's id 不存在
  @Test
  void should_return_updated_employee_when_update_employee_given_employee() {}
}
