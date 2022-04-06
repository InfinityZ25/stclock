package us.jcedeno.stclock.exceptions;

/**
 * A simple, single use exception.
 * 
 * @author jcedeno.
 */
public class EmployeeClockedInException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public EmployeeClockedInException(String message) {
        super(message);
    }

}
