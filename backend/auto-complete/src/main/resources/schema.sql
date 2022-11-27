DROP TABLE IF EXISTS company;

CREATE TABLE company (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           name VARCHAR(250) NOT NULL,
                           description VARCHAR(250) NOT NULL
);