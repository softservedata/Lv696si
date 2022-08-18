package com.softserve.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleProfile {
    public long id;

    @NotNull(message = "name from cannot be null")
    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotNull(message = "Age from cannot be null")
    @NotBlank(message = "description cannot be empty")
    @Size(min = 10, max = 1500, message = "description should be between 10 and 1500 chars")
    private String description;
}
