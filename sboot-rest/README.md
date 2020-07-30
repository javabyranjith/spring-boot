### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot
  3. REST API
  4. H2DB

### CONCEPTS/TOPICS COVERED
  1. CRUD Operations with H2DB. 
  2. Customized REST API Response.
  3. JUnit Test for Rest Controller using RestTemplate

### HOW TO RUN?  (use POSTMAN Client)
### H2 DB Console
http://localhost:6060/springboot-restapi/h2-console

## RESTApi End-points
* GET: http://localhost:6060/springboot-restapi/products/all
* GET: http://localhost:6060/springboot-restapi/products/{id}
* POST: http://localhost:6060/springboot-restapi/products/add
* PUT: http://localhost:6060/springboot-restapi/products/update
* DELETE: http://localhost:6060/springboot-restapi/products/delete/{id}

### API Operations
## GET PRODUCT
* GET: http://localhost:6060/springboot-restapi/products/all
* GET: http://localhost:6060/springboot-restapi/products/100

## ADD PRODUCT
* POST http://localhost:6060/springboot-restapi/products/add
``` json
{
  "id": "700",
  "name": "",
  "category": "Mobile",
  "price": "7777"
}
```

## UPDATE PRODUCT
* PUT: http://localhost:6060/springboot-restapi/products/update
``` json
{
  "id": "700",
  "name": "name updated",
  "category": "Mobile",
  "price": "7777"
}
```

## DELETE PRODUCT
* DELETE: http://localhost:6060/springboot-restapi/products/delete/200


### TESTING
1. Start the Springboot application
2. ProductServiceTest.java -> Run As -> Junit Application