package us.jcedeno.stclock.exceptions.types;

public class ShiftsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ShiftsNotFoundException(String message) {
        super(message);
    }

}
