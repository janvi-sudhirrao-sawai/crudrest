package com.janvi.crudrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.janvi.crudrest.entities.Employee;



public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	public Employee findByEmpno(int empno);

}