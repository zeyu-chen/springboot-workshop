package dev.zeyuchen.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import dev.zeyuchen.ems.dto.EmployeeDto;
import dev.zeyuchen.ems.entity.Employee;
import dev.zeyuchen.ems.exception.ResourceNotFoundException;
import dev.zeyuchen.ems.mapper.EmployeeMapper;
import dev.zeyuchen.ems.repository.EmployeeRepository;
import dev.zeyuchen.ems.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Create Employee REST API
    @Override
    public EmployeeDto createEmployee(final EmployeeDto employeeDto) {
        final Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        final Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // Get all employees REST API
    @Override
    public List<EmployeeDto> getAllEmployees() {
        final List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    // Get employee by ID REST API
    @Override
    public EmployeeDto getEmployeeById(final Long id) {
        final Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    // Update employee REST API
    @Override
    public EmployeeDto updateEmployee(final EmployeeDto employeeDto, final Long id) {
        final Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    // Delete employee REST API
    @Override
    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }
}
