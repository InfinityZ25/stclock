package us.jcedeno.stclock.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Service;

import us.jcedeno.stclock.model.Employee;
import us.jcedeno.stclock.model.EmployeeCreationRequest;
import us.jcedeno.stclock.model.Shift;
import us.jcedeno.stclock.repository.EmployeeRepository;
import us.jcedeno.stclock.repository.ShiftRepository;

/**
 * The business logic for a time clock application.
 * 
 * @author jcedeno
 */
@Service
public class TimeClockService {
    private final EmployeeRepository employeeRepository;
    private final ShiftRepository shiftRepository;

    public TimeClockService(EmployeeRepository employeeRepository, ShiftRepository shiftRepository) {
        this.employeeRepository = employeeRepository;
        this.shiftRepository = shiftRepository;
    }

    /**
     * A function that finds an employee by their id.
     * 
     * @param id The id of the employee to find.
     * @return An optional employee.
     * @throws IllegalArgumentException If the employee is not found.
     */
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    }

    /**
     * A function that finds all employees.
     * 
     * @return An iterable of all employees.
     */
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeCreationRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        return employeeRepository.save(employee);
    }

    /**
     * A query function that queries the repository for an active (endTime == null)
     * shift for the given employee.
     * 
     * @param employeeId The id of the employee to query for.
     * @return An optional containing the active shift for the given employee.
     * 
     * @throws IllegalArgumentException If the employee is not found.
     */
    public Optional<Shift> findActiveShift(String employeeId) {
        var employee = getEmployeeById(employeeId);
        // Query all current shifts for the employee
        return shiftRepository.findEmployeesActiveShift(employee);
    }

    // Clock in an employee.
    public Shift clockIn(String employeeId) {
        var employee = getEmployeeById(employeeId);
        // If already clocked in, throw an exception.
        if (findActiveShift(employeeId).isPresent()) {
            throw new IllegalStateException("Employee is already clocked in.");
        }
        // Create a new shift for the employee.
        var shift = new Shift();
        shift.setEmployee(employee);
        shift.setStartTime(Instant.now());
        // Save the shift to repo.
        return shiftRepository.save(shift);
    }

    // Clock out
    public Shift clockOut(String employeeId) {
        var shiftQuery = findActiveShift(employeeId);
        // If already clocked out, or with no active shifts, throw an exception.
        if (shiftQuery.isEmpty()) {
            throw new IllegalStateException("Employee is already clocked out.");
        }
        var shift = shiftQuery.get();
        shift.setEndTime(Instant.now());
        // Save the shift to repo.
        return shiftRepository.save(shift);
    }
}
