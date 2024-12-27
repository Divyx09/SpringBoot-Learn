package com.springLearn.curdOperation.dao;

import com.springLearn.curdOperation.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements com.springLearn.curdOperation.dao.EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;

    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee newEmployee = entityManager.merge(theEmployee);
        return newEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);
    }
}
