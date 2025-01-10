package dev.zeyuchen.ems.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Employee DTO for request and response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(example = "John", description = "Employee's first name")
    private String firstName;

    @Schema(example = "Doe", description = "Employee's last name")
    private String lastName;

    @Schema(example = "john.doe@company.com", description = "Employee's email address")
    private String email;
}
