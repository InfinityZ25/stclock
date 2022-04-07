package us.jcedeno.stclock.exceptions;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

/**
 * Utility data class to build an error response.
 * 
 * @author jcedeno
 */
@Data
@Builder
public class ErrorResponse {
    private final Instant timeStamp = Instant.now();
    private String message;
    private int code;

}
