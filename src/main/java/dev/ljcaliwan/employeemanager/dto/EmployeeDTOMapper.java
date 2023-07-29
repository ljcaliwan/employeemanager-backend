package dev.ljcaliwan.employeemanager.dto;

import dev.ljcaliwan.employeemanager.model.Employee;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EmployeeDTOMapper implements Function<Employee, EmployeeDTO> {
    @Override
    public EmployeeDTO apply(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getJobTitle(),
                employee.getPhone(),
                employee.getImageUrl()
        );
    }
}
