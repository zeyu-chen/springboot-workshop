package dev.zeyu.springboot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Schema(description = "User entity")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the user", example = "1",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "User's first name", example = "John",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @Column(nullable = false)
    @Schema(description = "User's last name", example = "Doe",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Schema(description = "User's email address", example = "john.doe@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
}
