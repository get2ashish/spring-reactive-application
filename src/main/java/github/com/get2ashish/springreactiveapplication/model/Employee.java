package github.com.get2ashish.springreactiveapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    public Integer id;
    public String first_name;
    public String last_name;
    public String email;
}
