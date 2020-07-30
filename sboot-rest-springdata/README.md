### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. Spring Data
  3. SpringBoot
  4. REST API

### CONCEPTS/TOPICS COVERED
  1. CRUD Operations with Spring Data API.

### HOW TO RUN?  (use POSTMAN Client)

### Retrieve products
* GET: http://localhost:6060/api/products/all
* GET: http://localhost:6060/api/products/100

### Add products
POST: http://localhost:6060/api/products/add

``` json
{
    "id": "100",
    "name": "Galaxy S8",
    "type": "Mobile",
    "price": "55000"
}

{
    "id": "200",
    "name": "Dell Vostro",
    "type": "Laptop",
    "price": "75000"
}

{
    "id": "300",
    "name": "LG AC100",
    "type": "AC",
    "price": "45000"
}
```

### Update products
PUT: http://localhost:6060/api/products/update

``` json
{
    "id": "300",
    "name": "LG AC100 update",
    "type": "AC",
    "price": "45"
}
```

#### Delete products
DELETE: http://localhost:6060/api/products/delete/100