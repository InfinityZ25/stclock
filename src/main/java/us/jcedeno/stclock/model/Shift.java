package us.jcedeno.stclock.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * A JSON Object that represents a shift.
 * 
 * @author jcedeno
 */
@Data
@Document
public class Shift {
    @Id
    private String id;
    private Instant startTime;
    private Instant endTime;
    /**
     * Referencing the employee like this means a lot of duplicated data in the DB,
     * but makes it easy to query.
     */
    @DBRef
    private Employee employee;

}
