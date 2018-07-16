package jbr.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.spring.boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
