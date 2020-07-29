package com.thoughtworks.company.test;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    CompanyService companyService;

    @Test
    public void should_return_list_when_get_companies_by_page_info_given_page_info_and_companies(){
        //given
        int page = 2;
        int pageSize = 2;
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company(4));
        companyList.add(new Company(5));

        Mockito.when(companyRepository.findCompaniesByPageInfo(page, pageSize)).thenReturn(companyList);

        //when
//        List<Company> result = companyService.getCompaniesByPage(page, pageSize);

        //then
//        assertEquals(companyList.size(), result.size());
    }
}
