CREATE DATABASE IF NOT EXISTS springboot;
DROP TABLE IF EXISTS app_user;
CREATE TABLE springboot.app_user(id INTEGER, username VARCHAR(30), password VARCHAR(30));
INSERT INTO springboot.app_user VALUES (100,"ranjith","sekar");
INSERT INTO springboot.app_user VALUES (300,"tom","cat");
INSERT INTO springboot.app_user VALUES (200,"spring","boot");
SELECT * FROM springboot.app_user;