## TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot + Webflux
  3. REST API
  4. MongoDB

## CONCEPTS/TOPICS COVERED
  1. ReactiveMongoRepository
  2. Handler
  3. Router
  4. WebClient

## HOW TO RUN?  (use POSTMAN Client)

## RESTApi End-points
* GET: http://localhost:6060/products/all
* POST: http://localhost:6060/products/add

## API Operations
### GET PRODUCT
* GET: http://localhost:6060/springboot-restapi/products/all
* GET: http://localhost:6060/springboot-restapi/products/100

### ADD PRODUCT
* POST http://localhost:6060/springboot-restapi/products/add
``` json
{
  "id": "700",
  "name": "",
  "category": "Mobile",
  "price": "7777"
}
```

## TESTING
1. Start the Springboot application
2. ProductServiceTest.java -> Run As -> Junit Application