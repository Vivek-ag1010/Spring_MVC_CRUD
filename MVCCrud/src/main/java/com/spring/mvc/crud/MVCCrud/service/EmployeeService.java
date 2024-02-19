package com.spring.mvc.crud.MVCCrud.service;

import com.spring.mvc.crud.MVCCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);


}
