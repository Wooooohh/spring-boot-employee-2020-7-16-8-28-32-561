package com.thoughtworks.springbootemployee.exceptionhandler;

import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionResolver {
    @ExceptionHandler(CompanyNotFoundException.class)
    public static void handlerException(CompanyNotFoundException companyNotFoundException){
        System.out.println(companyNotFoundException.getMessage());
    }
}
