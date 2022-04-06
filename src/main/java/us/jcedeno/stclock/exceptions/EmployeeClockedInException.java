package us.jcedeno.stclock.exceptions;

public class EmployeeClockedInException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public EmployeeClockedInException(String message) {
        super(message);
    }

}
