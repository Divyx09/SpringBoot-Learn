package com.springLearn.curdOperation.jpa;

import com.springLearn.curdOperation.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    no need for code to write down for it
}
