//package com.thoughtworks.employee.test;
//
//import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
//import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
//import com.thoughtworks.springbootemployee.entity.Company;
//import com.thoughtworks.springbootemployee.entity.Employee;
//import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
//import com.thoughtworks.springbootemployee.repository.CompanyRepository;
//import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
//import com.thoughtworks.springbootemployee.service.EmployeeService;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static java.util.Optional.of;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class EmployeeServiceTest {
//
//    @Mock
//    CompanyRepository companyRepository;
//
//    @Mock
//    EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    EmployeeService employeeService;
//
//    @Test
//    void contextLoads() {
//    }
//
////    @Test
////    void should_return_employeeResponse_when_add_employee_given_employeeRequest() throws CompanyNotFoundException {
////        //given
////        EmployeeRequest employeeRequest = new EmployeeRequest("Jack", 1, "male", 1);
////        when(companyRepository.findById(any())).thenReturn(Optional.of(new Company()));
////
////        //when
////        employeeService.addEmployee(employeeRequest);
////
////        //then
////        verify(employeeRepository, times(1)).save(any(Employee.class));
////    }
//
//
//
//    @Test
//    void should_return_not_null_when_add_employee_given_employee_with_company_id_is_8() throws CompanyNotFoundException {
//        //given
//        EmployeeRequest employeeRequest = new EmployeeRequest( "Jack", 1, "male", 8);
//        when(companyRepository.findById(anyInt())).thenReturn(null);
//
//        //when
//        employeeService.addEmployee(employeeRequest);
//
//        //then
//        assertThrows(CompanyNotFoundException.class,()->
//            employeeService.addEmployee(employeeRequest), "");
//
//    }
//
//    @Test
//    void should_return_employeeResponse_when_add_employee_given_employeeRequest(){
//        //given
//        Company company = new Company();
//        company.setCompanyId(1);
//        company.setName("oocl");
//        Employee employee = new Employee(6, "alisa", 1, "female", company);
//        EmployeeRequest employeeRequest = new EmployeeRequest("alisa", 1, "female",1);
//        when(companyRepository.findById(any())).thenReturn(of(company));
//        when(employeeRepository.save(any())).thenReturn(employee);
//
//        //when
//        EmployeeResponse result = employeeService.addEmployee2(employeeRequest);
//
//        //then
//        assertNotNull(result);
//
//    }
//}
