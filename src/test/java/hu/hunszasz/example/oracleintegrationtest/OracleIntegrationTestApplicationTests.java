package hu.hunszasz.example.oracleintegrationtest;

import hu.hunszasz.example.oracleintegrationtest.model.Email;
import hu.hunszasz.example.oracleintegrationtest.model.Office;
import hu.hunszasz.example.oracleintegrationtest.model.OfficialEmployee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@DirtiesContext
class OracleIntegrationTestApplicationTests {
    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Container
    public static OracleContainer oracleDB = new OracleContainer("gvenzl/oracle-xe:21-slim");


    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", oracleDB::getJdbcUrl);
        registry.add("spring.datasource.username", oracleDB::getUsername);
        registry.add("spring.datasource.password", oracleDB::getPassword);
        registry.add("spring.datasource.driverClassName", oracleDB::getDriverClassName);
        registry.add("spring.jpa.database", () -> "oracle");
    }

    @Test
    void getAllEmail() throws InterruptedException {
        OfficialEmployee officialEmployee = new OfficialEmployee();
        officialEmployee.setFirstName("Elek");
        officialEmployee.setLastName("Teszt");
        ResponseEntity<OfficialEmployee> officialEmployeeResponseEntity = testRestTemplate.postForEntity("/employee", officialEmployee, OfficialEmployee.class);
        Email email = new Email();
        email.setAddress("elek.teszt@idomsoft.hu");
        ResponseEntity<Email> emailResponseEntity = testRestTemplate.postForEntity("/email", email, Email.class);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/uri-list");
        HttpEntity<String> emailHttpEntity
                = new HttpEntity(officialEmployeeResponseEntity.getHeaders().getLocation().toString(), requestHeaders);
        testRestTemplate.exchange(emailResponseEntity.getHeaders().getLocation() + "/employee",
                HttpMethod.PUT, emailHttpEntity, String.class);

        int status = testRestTemplate.getForEntity("/email/" + emailResponseEntity.getBody().getId(), Email.class).getStatusCodeValue();
        Assert.assertEquals(200, status);
    }

}
