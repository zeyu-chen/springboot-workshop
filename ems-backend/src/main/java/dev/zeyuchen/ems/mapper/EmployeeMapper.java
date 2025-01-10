package dev.zeyuchen.ems.mapper;

import dev.zeyuchen.ems.dto.EmployeeDto;
import dev.zeyuchen.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(final Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
                employee.getEmail());
    }

    public static Employee mapToEmployee(final EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(),
                employeeDto.getLastName(), employeeDto.getEmail());
    }

}
