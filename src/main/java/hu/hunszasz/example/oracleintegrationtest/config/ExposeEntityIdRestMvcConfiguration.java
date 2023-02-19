package hu.hunszasz.example.oracleintegrationtest.config;

import hu.hunszasz.example.oracleintegrationtest.model.Email;
import hu.hunszasz.example.oracleintegrationtest.model.Office;
import hu.hunszasz.example.oracleintegrationtest.model.OfficeAddress;
import hu.hunszasz.example.oracleintegrationtest.model.OfficialEmployee;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Email.class);
        config.exposeIdsFor(Office.class);
        config.exposeIdsFor(OfficeAddress.class);
        config.exposeIdsFor(OfficialEmployee.class);
    }

}