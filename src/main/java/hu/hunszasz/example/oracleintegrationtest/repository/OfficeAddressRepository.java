package hu.hunszasz.example.oracleintegrationtest.repository;

import hu.hunszasz.example.oracleintegrationtest.model.OfficeAddress;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addresses", path = "address")
public interface OfficeAddressRepository extends PagingAndSortingRepository<OfficeAddress, Long> {
}
