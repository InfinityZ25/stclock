package us.jcedeno.stclock.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import us.jcedeno.stclock.model.Employee;
import us.jcedeno.stclock.model.Shift;

public interface ShiftRepository extends MongoRepository<Shift, String> {

    Optional<Shift> findByEmployeeId(String employeeId);

    /**
     * Function that checks if an employee is clocked in by checking if their clock
     * out time is null.
     * 
     * @param employee The employee to check.
     * @return An optional containing the user's last active shift.
     */
    @Query("{'endTime': null}")
    Optional<Shift> findEmployeesActiveShift(Employee employee);

}
