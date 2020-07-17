### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot
  3. H2DB
  4. REST API
  5. Swagger

### CONCEPTS/TOPICS COVERED
  1. CRUD Operations using JPA
  2. Swagger Implementation for RESTful API

### HOW TO RUN?
http://localhost:6060/restapi-swagger/

### H2 DB Console
http://localhost:6060/restapi-swagger/h2-console

### **Get response as json**
* http://localhost:6060/restapi-swagger/v2/api-docs 

copy the response and paste @ https://editor.swagger.io/

### **View Swagger UI**
* http://localhost:6060/restapi-swagger/swagger-ui.html

### **REST End-points**
* GET: http://localhost:6060/restapi-swagger/products
* GET: http://localhost:6060/restapi-swagger/products/{id}
* POST: http://localhost:6060/restapi-swagger/addProduct
* PUT: http://localhost:6060/restapi-swagger/updateProduct/{id}
* DELETE: http://localhost:6060/restapi-swagger/deleteProduct/{id}

### TEST CUSTOM EXCEPTIONS
#### CustomExceptionGlobalHandler.handleMethodArgumentNotValid(); - Choose POST method in POSTMAN
``` json
{
  "id": "",
  "name": "dddd S8",
  "category": "Mobile",
  "price": "7777"
}
```
#### CustomExceptionGlobalHandler.handleHttpRequestMethodNotSupported(): - Choose PATCH method
``` json
{
  "id": "222",
  "name": "dddd S8",
  "category": "Mobile",
  "price": "7777"
}
```

#### After adding 1) @Validated in Controller 2) @Min(1)
http://localhost:6060/restapi-swagger/getProductById/0
OUTPUT:
javax.validation.ConstraintViolationException: getProductById.id: must be greater than or equal to 1

```
{
    "timestamp": "2020-02-26T07:25:52.331+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "getProductById.id: must be greater than or equal to 1",
    "path": "/restapi-swagger/getProductById/0"
}
```
After handling the Excetion in Global handler (400 BadRequest)

```
{
    "timestamp": "2020-02-26T07:31:20.620+0000",
    "message": "getProductById.id: must be greater than or equal to 1",
    "exceptionInfo": "uri=/restapi-swagger/getProductById/0"
}
```

#### CustomExceptionGlobalHandler.handleProductNameNotFoundException(): - Choose GET
http://localhost:6060/restapi-swagger/getProductByName/Usha


### CLASSES/INTERFACES/ANNOTATIONS USED
#### CLASSES
1. ResponseEntityExceptionHandler
 
#### INTERFACES
1.

#### ANNOTATIONS
1. ControllerAdvice
2. ExceptionHandler
3. RestControllerAdvice