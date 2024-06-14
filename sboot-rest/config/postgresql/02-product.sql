DROP TABLE sboot_restapi.product;
CREATE TABLE sboot_restapi.product(
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  category VARCHAR NOT NULL,
  price INT NOT NULL,
  created_at TIMESTAMP DEFAULT now(),
  updated_at TIMESTAMP DEFAULT now()
);

INSERT INTO product(id, name, category, price) VALUES(1, 'Samsung S8', 'Mobile', 75000);
INSERT INTO product(id, name, category, price) VALUES(2, 'Realme 6', 'Mobile', 12000);
INSERT INTO product(id, name, category, price) VALUES(3, 'Usha Fan', 'Fan', 1100);
INSERT INTO product(id, name, category, price) VALUES(4, 'Orient Fan', 'Fan', 1200);
INSERT INTO product(id, name, category, price) VALUES(5, 'Dell Vostro', 'Laptop', 79000);
INSERT INTO product(id, name, category, price) VALUES(6, 'Lenovo 441', 'Laptop', 88000);
INSERT INTO product(id, name, category, price) VALUES(7, 'IFB Washer', 'Washing Machine', 25000);
INSERT INTO product(id, name, category, price) VALUES(8, 'Siemens', 'Washing Machine', 3300);
INSERT INTO product(id, name, category, price) VALUES(9, 'Redmi 8', 'Mobile', 7000);
INSERT INTO product(id, name, category, price) VALUES(10, 'Redmi 8', 'Mobile', 9000);
INSERT INTO product(id, name, category, price) VALUES(11, 'Samsung M30', 'Mobile', 13000);
INSERT INTO product(id, name, category, price) VALUES(12, 'Panasonic Eluga', 'Mobile', 9000);
INSERT INTO product(id, name, category, price) VALUES(13, 'Nokia 7', 'Mobile', 12000);