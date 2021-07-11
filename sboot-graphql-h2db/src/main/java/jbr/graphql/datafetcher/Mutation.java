package jbr.graphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import jbr.graphql.dao.AddressRepository;
import jbr.graphql.dao.ProductRepository;
import jbr.graphql.dao.StudentRepository;
import jbr.graphql.model.Address;
import jbr.graphql.model.Product;
import jbr.graphql.model.Student;

public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private StudentRepository studenttRepository;

  public Product newProduct(String name, String category, Long price) {
    Product newProduct = new Product();
    newProduct.setName(name);
    newProduct.setCategory(category);
    newProduct.setPrice(price);

    productRepository.save(newProduct);

    return newProduct;
  }

  public Student addStudent(String name, String department, Address address, Long phone) {

    Student student = new Student();
    student.setName(name);
    student.setDepartment(department);
    student.setAddress(address);
    student.setPhone(phone);

    studenttRepository.save(student);

    return student;
  }

  public Address addAddress(Long studId, String street, String city, Long pincode) {
    Address address = new Address(studId, street, city, pincode);
    addressRepository.save(address);

    return address;
  }
}
