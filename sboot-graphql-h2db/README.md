### TOOLS & TECHNOLOGIES
  1. Eclipse/STS
  2. SpringBoot
  3. H2DB
  4. GraphQL
  5. GraphiQL Tool

### CONCEPTS/TOPICS COVERED
  1. CRUD Operations using GraphQL

### HOW TO RUN?
http://localhost:6060/product/greeting

### Open H2 DB Console
http://localhost:6060/h2-console/

### Check your Schema
http://localhost:6060/graphql/schema.json

### GraphiQL Console
http://localhost:6060/graphiql

### Add Product
http://localhost:6060/graphiql

```json
mutation {
  newProduct(name: "Redmi 8A", category: "Mobile", price: 7000) {
    id
  }
}
```

### Find All Products
http://localhost:6060/graphiql

```json
{
  findAllProducts {
    id name price
  }
}
```

### Find Product By Id
http://localhost:6060/graphiql

```json
{
  findProductById(id: 1) {
    name
  }
}
```
