package dev.ljcaliwan.employeemanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;
    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 3, message = "Email must be at least 3 characters")
    private String email;
    @NotNull(message = "Job Title cannot be null")
    @NotEmpty(message = "Job Title cannot be empty")
    @Size(min = 3, message = "Job Title must be at least 3 characters")
    private String jobTitle;
    @NotNull(message = "Phone cannot cannot be null")
    @NotEmpty(message = "Phone cannot cannot be empty")
    private String phone;
    @NotNull(message = "Image url cannot be null")
    @NotEmpty(message = "Image url cannot be empty")
    private String imageUrl;
}
