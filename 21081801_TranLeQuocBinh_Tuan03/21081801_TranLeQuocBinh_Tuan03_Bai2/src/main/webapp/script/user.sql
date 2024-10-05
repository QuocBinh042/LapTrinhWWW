CREATE DATABASE UserDB;
USE UserDB;

CREATE TABLE users (
    id INT IDENTITY, 
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    dob VARCHAR(255),
    gender VARCHAR(50),
    PRIMARY KEY (id)
);