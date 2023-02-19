package hu.hunszasz.example.oracleintegrationtest.projection;

import hu.hunszasz.example.oracleintegrationtest.model.Email;
import hu.hunszasz.example.oracleintegrationtest.model.OfficialEmployee;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "employeeProjection", types = {OfficialEmployee.class})
public interface EmployeeProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    List<Email> getEmails();
}
