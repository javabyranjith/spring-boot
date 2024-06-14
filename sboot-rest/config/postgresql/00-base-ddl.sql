/********************************************************************************
* Base scripts to setup user, database and schema. 
********************************************************************************/

CREATE USER ranjith;

ALTER USER ranjith createdb;

ALTER USER ranjith WITH ENCRYPTED PASSWORD 'Sekar@123';

DROP DATABASE springboot;

CREATE DATABASE springboot WITH OWNER=ranjith ENCODING 'UTF-8';
	
GRANT ALL PRIVILEGES ON DATABASE springboot TO ranjith;

CREATE SCHEMA sboot_restapi AUTHORIZATION ranjith;