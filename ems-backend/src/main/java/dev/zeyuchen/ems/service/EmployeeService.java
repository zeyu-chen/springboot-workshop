package dev.zeyuchen.ems.service;

import java.util.List;
import dev.zeyuchen.ems.dto.EmployeeDto;

public interface EmployeeService {

    // Create Employee REST API
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    // Get all employees REST API
    List<EmployeeDto> getAllEmployees();

    // Get employee by ID REST API
    EmployeeDto getEmployeeById(Long id);

    // Update employee REST API
    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);

    // Delete employee REST API
    void deleteEmployee(Long id);
}
