package com.spring.mvc.crud.MVCCrud.controller;

import com.spring.mvc.crud.MVCCrud.entity.Employee;
import com.spring.mvc.crud.MVCCrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")  // base mapping for URL requests
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        // get the employees from db
        List<Employee> theEmployees=employeeService.findAll();
        //add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
