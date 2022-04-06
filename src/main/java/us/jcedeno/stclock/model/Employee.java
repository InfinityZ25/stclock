package us.jcedeno.stclock.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * An object representation of an employee.
 * 
 * @author jcedeno
 */
@Getter
@Setter
@Document
public class Employee {
    private @Id String id;
    private String firstName;
    private String lastName;

}
