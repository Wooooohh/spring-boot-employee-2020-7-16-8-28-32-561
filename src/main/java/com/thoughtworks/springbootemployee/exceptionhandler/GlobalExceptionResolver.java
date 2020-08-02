package com.thoughtworks.springbootemployee.exceptionhandler;

import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionResolver {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CompanyNotFoundException.class)
    public @ResponseBody List<String> handlerException(CompanyNotFoundException companyNotFoundException){
        List<String> ret = new ArrayList<>();
        ret.add(companyNotFoundException.getMessage());
        return ret;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public  @ResponseBody List<String> handlerException(EmployeeNotFoundException employeeNotFoundException){
        List<String> ret = new ArrayList<>();
        ret.add(employeeNotFoundException.getMessage());
        return ret;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    List<String> handleValidationFailure(MethodArgumentNotValidException exception){
        return exception.getBindingResult()
                .getFieldErrors()
                .stream().map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

    }

}
