package dev.ljcaliwan.employeemanager.controller;

import dev.ljcaliwan.employeemanager.dto.EmployeeDTO;
import dev.ljcaliwan.employeemanager.dto.Greeting;
import dev.ljcaliwan.employeemanager.model.Employee;
import dev.ljcaliwan.employeemanager.model.Response;
import dev.ljcaliwan.employeemanager.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.OK;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<Response> getEmployeeList() {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("employees", employeeService.employeeList(5)))
                .message("Employees retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }
    @PostMapping("/save")
    public ResponseEntity<Response> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("employees", employeeService.addEmployee(employeeDTO)))
                .message("employee created")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Response> findEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("employee", employeeService.get(id)))
                .message("employee retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("employee", employeeService.update(id, employeeDTO)))
                .message("updated employee successful")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Response.builder()
                .timeStamp(now())
                .data(of("employee deleted", employeeService.delete(id)))
                .message("deleted employee")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/demo")
    public ResponseEntity<String> postGreeting(@RequestBody Greeting greeting) {
        final String greetingMsg = employeeService.saveGreeting(greeting);
        return ResponseEntity
                .accepted()
                .body(greetingMsg);
    }

}
