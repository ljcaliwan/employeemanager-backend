package dev.ljcaliwan.employeemanager.service;

import dev.ljcaliwan.employeemanager.dto.EmployeeDTO;
import dev.ljcaliwan.employeemanager.dto.EmployeeDTOMapper;
import dev.ljcaliwan.employeemanager.dto.Greeting;
import dev.ljcaliwan.employeemanager.exception.EmployeeNotFoundException;
import dev.ljcaliwan.employeemanager.model.Employee;
import dev.ljcaliwan.employeemanager.repository.EmployeeRepository;
import dev.ljcaliwan.employeemanager.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.*;

@Service @RequiredArgsConstructor @Slf4j
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectsValidator<EmployeeDTO> employeeValidator;
    private final ObjectsValidator<Greeting> greetingValidator;
    private final EmployeeDTOMapper employeeDTOMapper;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        employeeValidator.validate(employeeDTO);

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setPhone(employeeDTO.getPhone());
        employee.setImageUrl(employeeDTO.getImageUrl());
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeRepository.save(employee);

        return employeeDTO;
    }

    @Override
    public Employee get(Long id) {
       return employeeRepository.findById(id)
               .orElseThrow(() -> new EmployeeNotFoundException("Employee not found."));
    }

    @Override
    public Collection<EmployeeDTO> employeeList(int limit) {
        return employeeRepository.findAll(of(0, limit)).stream().map(employeeDTOMapper).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        employeeValidator.validate(employeeDTO);
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found."));
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setJobTitle(employeeDTO.getJobTitle());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setImageUrl(employeeDTO.getImageUrl());
        employeeRepository.save(existingEmployee);
        return employeeDTO;
    }

    @Override @Transactional
    public Boolean delete(Long id) {
        employeeRepository.deleteEmployeeById(id);
        return TRUE;
    }

    public String saveGreeting(Greeting greeting) {
        greetingValidator.validate(greeting);
        final String greetingMsg =
                "Greeting message <<" +
                        greeting.getMsg()
                        + ">> from: " +
                        greeting.getFrom().toUpperCase() +
                        " to: " +
                        greeting.getTo().toUpperCase();
        return greetingMsg;
    }
}
