package com.spring.mvc.crud.MVCCrud.controller;

import com.spring.mvc.crud.MVCCrud.entity.Employee;
import com.spring.mvc.crud.MVCCrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        //create model attribue to bind the form data
        Employee theEmployee=new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
        //save the employees
        employeeService.save(theEmployee);
        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdated(@RequestParam("employeeId") int theID, Model theModel)
    {
        //get the employee from the service
        Employee theEmployee=employeeService.findById(theID);
        //set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);
        //send over to our form

        return "employees/employee-form";
    }
     @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId)
     {
         //delete the employee from the database
         employeeService.deleteById(theId);

         return "redirect:/employees/list";
     }

}
