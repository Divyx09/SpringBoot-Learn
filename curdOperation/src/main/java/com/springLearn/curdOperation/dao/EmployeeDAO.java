package com.springLearn.curdOperation.dao;

import com.springLearn.curdOperation.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();


    public Employee findById(int theId);

    public Employee save(Employee theEmployee);

    public void deleteById(int theId);
}
