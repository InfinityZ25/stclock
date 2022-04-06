package us.jcedeno.stclock.exceptions;

public class EmployeeNotClockedInException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public EmployeeNotClockedInException(String message) {
        super(message);
    }

}
