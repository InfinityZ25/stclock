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
import us.jcedeno.stclock.service.TimeClockService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    private final TimeClockService timeClockService;

    public EmployeeController(TimeClockService timeClockService) {
        this.timeClockService = timeClockService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.getEmployeeById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return ResponseEntity.ok(timeClockService.getAllEmployees());
    }

    // Create employee post endpoint
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeCreationRequest employeeCreationRequest) {
        return ResponseEntity.ok(timeClockService.createEmployee(employeeCreationRequest));
    }

}
