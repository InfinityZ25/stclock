package us.jcedeno.stclock.service;

import org.springframework.stereotype.Service;

import us.jcedeno.stclock.exceptions.EmployeeNotFoundException;
import us.jcedeno.stclock.model.Employee;
import us.jcedeno.stclock.model.EmployeeCreationRequest;
import us.jcedeno.stclock.repository.EmployeeRepository;

/**
 * A class that holds all the logic related to employees (get, create, etc).
 * 
 * @author jcedeno
 */
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * A function that finds an employee by their id.
     * 
     * @param id The id of the employee to find.
     * @return An optional employee.
     * @throws IllegalArgumentException If the employee is not found.
     */
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    /**
     * A function that creates an employee.
     * 
     * @param request An object containing the employee's data.
     * @return The created employee.
     */
    public Employee createEmployee(EmployeeCreationRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        return employeeRepository.save(employee);
    }

    /**
     * A function that finds all employees.
     * 
     * @return An iterable of all employees.
     */
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
