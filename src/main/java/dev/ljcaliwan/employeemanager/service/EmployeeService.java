package dev.ljcaliwan.employeemanager.service;

import dev.ljcaliwan.employeemanager.dto.EmployeeDTO;
import dev.ljcaliwan.employeemanager.dto.Greeting;
import dev.ljcaliwan.employeemanager.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    Employee get(Long id);

    Collection<EmployeeDTO> employeeList(int limit);
    EmployeeDTO update(Long id, EmployeeDTO employeeDTO);
    Boolean delete(Long id);

    String saveGreeting(Greeting greeting);
}
