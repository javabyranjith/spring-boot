package jbr.sboot.repository;

import org.springframework.data.repository.CrudRepository;

import jbr.sboot.model.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {
  AppUser findByUsername(String username);
}
