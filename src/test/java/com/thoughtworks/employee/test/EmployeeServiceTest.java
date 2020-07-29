package com.thoughtworks.employee.test;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDto;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    CompanyRepository companyRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void contextLoads() {
    }

    @Test
    void when_add_employee_given_employee_with_company_id_is_1() throws CompanyNotFoundException {
        //given
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(8, "Jack", 1, "male", 1);
        when(companyRepository.findById(any())).thenReturn(Optional.of(new Company()));

        //when
        employeeService.addEmployee(employeeRequestDto);

        //then
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }



    @Test
    void should_return_not_null_when_add_employee_given_employee_with_company_id_is_8() throws CompanyNotFoundException {
        //given
        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto(8, "Jack", 1, "male", 8);
        when(companyRepository.findById(any())).thenReturn(null);

        //when
        employeeService.addEmployee(employeeRequestDto);

        //then
        Assert.assertThrows(CompanyNotFoundException.class,()->{
            System.out.println("1");
        } );
    }
}
