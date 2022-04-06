package us.jcedeno.stclock.service;

import org.springframework.stereotype.Service;

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

}
