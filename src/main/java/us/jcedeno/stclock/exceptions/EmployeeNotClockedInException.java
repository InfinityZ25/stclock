package us.jcedeno.stclock.exceptions;

/**
 * A simple, single use exception.
 * 
 * @author jcedeno.
 */
public class EmployeeNotClockedInException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public EmployeeNotClockedInException(String message) {
        super(message);
    }

}
