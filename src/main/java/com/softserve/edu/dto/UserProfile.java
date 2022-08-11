package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class UserProfile {
    public long id;

    @NotNull(message = "name from cannot be null")
    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotNull(message = "email from cannot be null")
    @NotBlank(message = "email cannot be empty")
    @Pattern(regexp = "^[a-zA-Z0-9-\\.]+@([a-zA-Z-]+\\.)+[a-zA-Z-]{2,4}$", message = "email is not valid")
    private String email;

    @NotNull(message = "password from cannot be null")
    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotNull(message = "role from cannot be null")
    @NotBlank(message = "role cannot be empty")
    private String role;
}
