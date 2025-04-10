package com.ibrahim.platform.repositories;


import com.ibrahim.platform.domain.entities.Address;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ElasticsearchRepository<Address, String> {
}
