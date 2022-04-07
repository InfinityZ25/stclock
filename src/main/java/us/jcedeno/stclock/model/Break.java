package us.jcedeno.stclock.model;

import java.time.Instant;

import lombok.Data;

@Data
public class Break {
    private Instant startTime;
    private Instant endTime;

}
