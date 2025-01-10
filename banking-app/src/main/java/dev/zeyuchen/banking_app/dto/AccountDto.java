package dev.zeyuchen.banking_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Schema(description = "Account Data Transfer Object")
public record AccountDto(
        @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Account ID",
                example = "1") Long id,

        @NotBlank(message = "Account holder name cannot be blank") @Size(min = 2, max = 100,
                message = "Account holder name must be between 2 and 100 characters") @Schema(
                        description = "Account holder's name", example = "John Doe",
                        required = true) String accountHolderName,

        @NotNull(message = "Balance cannot be null") @PositiveOrZero(
                message = "Balance must be zero or positive") @Schema(
                        description = "Account balance", example = "1000.00",
                        minimum = "0") double balance) {
}
