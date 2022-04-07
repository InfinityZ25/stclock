package us.jcedeno.stclock.model;

import lombok.Data;

/**
 * A JSON object that represents a request to create a new employee.
 * 
 * @author jcedeno
 */
@Data
public class EmployeeCreationRequest {
    private String firstName;
    private String lastName;

}
