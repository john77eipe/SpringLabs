DROP TABLE pizza IF EXISTS;
DROP TABLE pizza_category IF EXISTS;

CREATE TABLE pizza_category (
  id INTEGER IDENTITY PRIMARY KEY,
  category VARCHAR(45)
);

CREATE TABLE pizza (
	id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(45) DEFAULT NULL,
    price VARCHAR(45) DEFAULT NULL,
    description VARCHAR(200) DEFAULT NULL,
  	category INTEGER DEFAULT NULL
);

CREATE INDEX pizza_category ON pizza (category);

ALTER TABLE pizza ADD CONSTRAINT fk_category FOREIGN KEY (category) REFERENCES pizza_category (id);