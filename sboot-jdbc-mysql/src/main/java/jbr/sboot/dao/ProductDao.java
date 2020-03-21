package jbr.sboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jbr.sboot.model.Product;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void addProduct() {
    log.info("add prod start");

    jdbcTemplate.execute("INSERT INTO product VALUES('100','Samsung S8', 'Mobile', '75000')");
    jdbcTemplate.execute("INSERT INTO product VALUES('200','Usha Fan', 'Fan', '6000')");
    jdbcTemplate.execute("INSERT INTO product VALUES('300','Dell Vostro', 'Laptop', '79000')");
  }

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    jdbcTemplate.query("SELECT * FROM product", new Object[] {},
        (rs, row) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getString("category"), rs.getString("price")))
        .forEach(products::add);

    return products;
  }
}
