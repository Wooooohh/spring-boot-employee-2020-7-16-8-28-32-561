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

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
        companyRepository.deleteAll();
    }

    @Test
    void should_return_ok_when_get_employees() throws Exception {
        Company company =new Company("oocl");
        Employee employee = new Employee("jack", "male", company);
        employeeRepository.save(employee);
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk()).andExpect(jsonPath("content[0].name").value("jack"));
    }

    @Test
    void should_return_created_when_post_employee_given_employee() throws Exception {
        String employee = " {\n" +
                "            \"id\": 5,\n" +
                "            \"name\": \"Zoeaa\",\n" +
                "            \"age\": 15,\n" +
                "            \"gender\": \"male\",\n" +
                "            \"companyId\": \"1\" \n" +
                " }";
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_PROBLEM_JSON).content(employee))
                .andExpect(status().isOk()).andExpect(jsonPath("name").value("Zoeaa"));
    }

    @Test
    void should_return_employees_when_get_employees_by_page_given_page_info() throws Exception {
        Company company =new Company("oocl");
        Employee emloyee1 = new Employee("jack", 20, "male", company);
        Employee emloyee2 = new Employee("alisa", 20, "female", company);
        employeeRepository.save(emloyee1);
        employeeRepository.save(emloyee2);
        mockMvc.perform(get("/employees").param("page", "0").param("size", "1").param("unPaged", "false"))
                .andExpect(status().isOk()).andExpect(jsonPath("content[1]").doesNotExist());
    }

    @Test
    void when_delete_employee_given_employee_id() throws Exception {
        //given
        Company company = companyRepository.findById(1).get();
        Employee employee = new Employee( "Jack", 20, "male", company);
        employeeRepository.save(employee);
        Employee addedEmployee = employeeRepository.findByName(employee.getName());
        //when
        mockMvc.perform(delete("/employees/"+ addedEmployee.getId())).andExpect(status().isOk());
    }
}