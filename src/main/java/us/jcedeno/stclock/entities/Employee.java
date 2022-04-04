package us.jcedeno.stclock.entities;

import java.util.UUID;

/**
 * An object representation of an employee.
 * 
 * @author jcedeno
 */
public record Employee(UUID id, String firstName, String lastName) {

}
