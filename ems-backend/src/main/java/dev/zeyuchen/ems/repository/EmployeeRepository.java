package dev.zeyuchen.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.zeyuchen.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
