package com.springLearn.curdOperation.rest;


import com.springLearn.curdOperation.Entity.Employee;
import com.springLearn.curdOperation.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

//    private EmployeeDAO employeeDAO;

    private EmployeeService employeeService;

//    public EmployeeController(EmployeeDAO theEmployeeDAO) {
//        employeeDAO = theEmployeeDAO;
//    }


    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    @GetMapping("/employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("No User Found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);

        Employee newEmployee = employeeService.save(theEmployee);

        return newEmployee;

    }

    @PutMapping("/employee/edit")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee newEmployee = employeeService.save(theEmployee);
        return newEmployee;

    }

    @DeleteMapping("/employee/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("No User Found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return employeeId + " - Deleted Succefully";
    }

    
}
