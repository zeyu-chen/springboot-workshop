package dev.zeyuchen.ems.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.zeyuchen.ems.dto.EmployeeDto;
import dev.zeyuchen.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
@Tag(name = "Employee Management", description = "Employee management APIs")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Create employee REST API
    @Operation(summary = "Create new employee",
            description = "Creates a new employee with the provided information")
    @ApiResponse(responseCode = "201", description = "Employee created successfully")
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody final EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto),
                HttpStatus.CREATED);
    }

    // Get all employees REST API
    @Operation(summary = "Get all employees", description = "Retrieves all employees")
    @ApiResponse(responseCode = "200", description = "Employees retrieved successfully")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Get employee by ID REST API
    @Operation(summary = "Get employee by ID", description = "Retrieves an employee by their ID")
    @ApiResponse(responseCode = "200", description = "Employee retrieved successfully")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") final Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    // Update employee REST API
    @Operation(summary = "Update employee",
            description = "Updates an employee with the provided information")
    @ApiResponse(responseCode = "200", description = "Employee updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") final Long employeeId,
            @RequestBody final EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto, employeeId));
    }

    // Delete employee REST API
    @Operation(summary = "Delete employee", description = "Deletes an employee by their ID")
    @ApiResponse(responseCode = "204", description = "Employee deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") final Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
