package us.jcedeno.stclock.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Shift {
    @Id
    private String id;
    private Instant startTime;
    private Instant endTime;
    @DBRef
    private Employee employee;

}
