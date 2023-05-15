package github.com.get2ashish.springreactiveapplication.controller;

import github.com.get2ashish.springreactiveapplication.model.Employee;
import github.com.get2ashish.springreactiveapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mono<Employee>> getEmployeeById(@PathVariable(name = "id") Integer id){
        Mono<Employee> response = employeeRepository.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> getAllEmployees(){
        return employeeRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping()
    public ResponseEntity<Mono<Employee>> saveEmployee(@RequestBody Employee employee){
        Mono<Employee> response = employeeRepository.save(employee);
        return ResponseEntity.ok(response);
    }
}
