package us.jcedeno.stclock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.jcedeno.stclock.model.Employee;
import us.jcedeno.stclock.model.EmployeeCreationRequest;
import us.jcedeno.stclock.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    /**
     * Endpoint to create an employee.
     * 
     * @param employeeCreationRequest An object containing the employee's first and
     *                                last name.
     * @return A new employee
     */
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeCreationRequest employeeCreationRequest) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeCreationRequest));
    }

}
