package us.jcedeno.stclock.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import us.jcedeno.stclock.model.Employee;
import us.jcedeno.stclock.model.Shift;

public interface ShiftRepository extends MongoRepository<Shift, String> {

    Optional<Shift> findByEmployeeId(String employeeId);

    @Query("{'endTime': null}")
    Optional<Shift> findEmployeesActiveShift(Employee employee);

}
