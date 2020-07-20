### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot
  3. REST API
  4. H2DB

### CONCEPTS/TOPICS COVERED
  1. CRUD Operations with H2DB. 

### HOW TO RUN?  (use POSTMAN Client)
## RESTApi End-points
* GET: http://localhost:6060/springboot-restapi/product/all
* GET: http://localhost:6060/springboot-restapi/product/{id}
* POST: http://localhost:6060/springboot-restapi/product/add
* PUT: http://localhost:6060/springboot-restapi/product/update
* DELETE: http://localhost:6060/springboot-restapi/product/delete/{id}

### H2 DB Console
http://localhost:6060/springboot-restapi/h2-console

### API Operations
## GET PRODUCT
* GET: http://localhost:6060/springboot-restapi/product/all
* GET: http://localhost:6060/springboot-restapi/product/100

## ADD PRODUCT
* POST http://localhost:6060/springboot-restapi/product/add
``` json
{
  "id": "700",
  "name": "",
  "category": "Mobile",
  "price": "7777"
}
```

## UPDATE PRODUCT
* PUT: http://localhost:6060/springboot-restapi/product/update
``` json
{
  "id": "700",
  "name": "name updated",
  "category": "Mobile",
  "price": "7777"
}
```

## DELETE PRODUCT
* DELETE: http://localhost:6060/springboot-restapi/product/delete/200