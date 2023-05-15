package github.com.get2ashish.springreactiveapplication.controller;

import github.com.get2ashish.springreactiveapplication.model.Employee;
import github.com.get2ashish.springreactiveapplication.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeByIdTApiTest_Success(){

        Mono<Employee> employeeMono = Mono.just(Employee.builder()
                .id(1)
                .first_name("Tom")
                .last_name("Jerry")
                .email("tom.jerry@tomjerry.com")
                .build());

        when(employeeRepository.findById(1)).thenReturn(employeeMono);

        webTestClient.get()
                .uri("/api/v1/employee/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Employee.class);
    }
}
