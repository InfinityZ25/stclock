package us.jcedeno.stclock.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private Long code;
    private String message;

}
