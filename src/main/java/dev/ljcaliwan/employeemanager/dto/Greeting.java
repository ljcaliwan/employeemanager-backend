package dev.ljcaliwan.employeemanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting {

    @NotNull(message = "The MESSAGE should not be empty")
    @NotEmpty(message = "The MESSAGE should not be empty")
    private String msg;

    @NotNull(message = "The FROM should not be empty")
    @NotEmpty(message = "The FROM should not be empty")
    private String from;

    @NotNull(message = "The TO should not be empty")
    @NotEmpty(message = "The TO should not be empty")
    private String to;

}
