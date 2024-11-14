CREATE DATABASE BankMan;
use BankMan;
CREATE TABLE Bank (
    id INT primary key,
    name VARCHAR(255),
    dob DATE,
    balance INT
);
desc Bank;