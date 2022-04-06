package us.jcedeno.stclock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import us.jcedeno.stclock.model.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
