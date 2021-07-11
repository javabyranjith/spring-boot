package jbr.graphql.dao;

import org.springframework.data.repository.CrudRepository;

import jbr.graphql.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
