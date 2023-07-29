package dev.ljcaliwan.employeemanager.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ObjectNotValidException extends RuntimeException {
    private final Map<String, String> errorMessages;
}
