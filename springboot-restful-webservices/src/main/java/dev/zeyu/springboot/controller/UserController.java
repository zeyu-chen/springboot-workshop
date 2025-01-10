package dev.zeyu.springboot.controller;

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
import dev.zeyu.springboot.dto.UserDto;
import dev.zeyu.springboot.entity.User;
import dev.zeyu.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/api/v1")
@RestController
@AllArgsConstructor
@Tag(name = "User", description = "User management APIs")
public class UserController {

    private final UserService userService;

    // build create user api
    // http://localhost:8080/api/v1/users
    @Operation(summary = "Create a new user",
            description = "Creates a new user with the provided information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")})
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody final UserDto userDto) {
        final UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // build get user by id api
    // http://localhost:8080/api/v1/users/1
    @Operation(summary = "Get a user by id",
            description = "Retrieves a user by their unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable final Long id) {
        final UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    // build get all users api
    // http://localhost:8080/api/v1/users
    @Operation(summary = "Get all users", description = "Retrieves all users")
    @ApiResponse(responseCode = "200", description = "Users found successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class)))
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        final List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // build update user api
    // http://localhost:8080/api/v1/users/1
    @Operation(summary = "Update a user",
            description = "Updates a user with the provided information")
    @ApiResponse(responseCode = "200", description = "User updated successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class)))
    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable final Long id,
            @Valid @RequestBody final UserDto userDto) {
        userDto.setId(id);
        final UserDto updatedUser = userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // build delete user api
    // http://localhost:8080/api/v1/users/1
    @Operation(summary = "Delete a user", description = "Deletes a user by their unique identifier")
    @ApiResponse(responseCode = "204", description = "User deleted successfully")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
