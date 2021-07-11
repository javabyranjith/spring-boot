package jbr.graphql.datafetcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import jbr.graphql.dao.AddressRepository;
import jbr.graphql.dao.ProductRepository;
import jbr.graphql.dao.StudentRepository;
import jbr.graphql.model.Address;
import jbr.graphql.model.Product;
import jbr.graphql.model.Student;

public class Query implements GraphQLQueryResolver {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> findAllProducts() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll()
        .forEach(e ->
          {
            Product prod = new Product();
            prod.setId(e.getId());
            prod.setName(e.getName());
            prod.setCategory(e.getCategory());
            prod.setPrice(e.getPrice());

            products.add(prod);
          });
    return products;
  }

  public Product findProductById(Long id) {
    return productRepository.findById(id)
        .get();
  }

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private AddressRepository addressRepository;

  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    studentRepository.findAll()
        .forEach(e ->
          {
            Student student = new Student();
            student.setId(e.getId());
            student.setName(e.getName());
            student.setDepartment(e.getDepartment());
            student.setAddress(getAddress(e.getId()));
            student.setPhone(e.getPhone());
            students.add(student);
          });
    return students;
  }

  public Address getAddress(Long studId) {
    return addressRepository.findById(studId)
        .get();
  }

}
