package github.com.get2ashish.springreactiveapplication.repository;

import github.com.get2ashish.springreactiveapplication.model.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employee,Integer> {
}
