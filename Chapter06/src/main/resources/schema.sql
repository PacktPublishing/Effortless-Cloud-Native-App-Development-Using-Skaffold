DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    age        integer,
    salary     decimal
);