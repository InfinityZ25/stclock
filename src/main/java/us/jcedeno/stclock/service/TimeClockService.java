package us.jcedeno.stclock.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.jcedeno.stclock.exceptions.EmployeeClockedInException;
import us.jcedeno.stclock.exceptions.EmployeeNotClockedInException;
import us.jcedeno.stclock.model.Shift;
import us.jcedeno.stclock.repository.ShiftRepository;

/**
 * The business logic for a time clock application.
 * 
 * @author jcedeno
 */
@Service
public class TimeClockService {
    private final ShiftRepository shiftRepository;

    @Autowired
    private EmployeeService employeeService;

    public TimeClockService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
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
        var employee = employeeService.getEmployeeById(employeeId);
        // Query all current shifts for the employee
        return shiftRepository.findEmployeesActiveShift(employee);
    }

    /**
     * A function that clocks in an employee.
     * 
     * @param employeeId The id of the employee to clock in.
     * @return The shift that was created.
     * @throws EmployeeClockedInException If the employee is already clocked in.
     */
    public Shift clockIn(String employeeId) {
        var employee = employeeService.getEmployeeById(employeeId);
        // If already clocked in, throw an exception.
        if (findActiveShift(employeeId).isPresent()) {
            throw new EmployeeClockedInException("Employee is already clocked in.");
        }
        // Create a new shift for the employee.
        var shift = new Shift();
        shift.setEmployee(employee);
        shift.setStartTime(Instant.now());
        // Save the shift to repo.
        return shiftRepository.save(shift);
    }

    /**
     * A function that clocks out an employee.
     * 
     * @param employeeId The id of the employee to clock out.
     * @return The shift that was clocked out.
     * @throws EmployeeNotClockedInException If the employee is not clocked in.
     */
    public Shift clockOut(String employeeId) {
        var shiftQuery = findActiveShift(employeeId);
        // If already clocked out, or with no active shifts, throw an exception.
        if (shiftQuery.isEmpty()) {
            throw new EmployeeNotClockedInException("Employee is not clocked in.");
        }
        var shift = shiftQuery.get();
        shift.setEndTime(Instant.now());
        // Save the shift to repo.
        return shiftRepository.save(shift);
    }

    /**
     * A function that returns all shifts in the system.
     * 
     * @return An iterable of all shifts.
     */
    public Iterable<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

}
