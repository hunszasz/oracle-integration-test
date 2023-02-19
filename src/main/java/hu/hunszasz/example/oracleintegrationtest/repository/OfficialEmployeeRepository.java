package hu.hunszasz.example.oracleintegrationtest.repository;

import hu.hunszasz.example.oracleintegrationtest.model.OfficialEmployee;
import hu.hunszasz.example.oracleintegrationtest.projection.EmployeeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employee", excerptProjection = EmployeeProjection.class)
public interface OfficialEmployeeRepository extends PagingAndSortingRepository<OfficialEmployee, Long> {
}
