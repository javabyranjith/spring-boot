CREATE TABLE springboot.users(
  userid PRIMARY KEY,
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  firstname VARCHAR NOT NULL,
  lastname VARCHAR NOT NULL,
  address VARCHAR,
  created_at TIMESTAMP DEFAULT now()
);