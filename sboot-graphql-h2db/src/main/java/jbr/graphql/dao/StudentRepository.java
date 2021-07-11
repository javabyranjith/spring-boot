package jbr.graphql.dao;

import org.springframework.data.repository.CrudRepository;

import jbr.graphql.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
