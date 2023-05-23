DROP table IF EXISTS Users;
DROP table IF EXISTS Address;
DROP table IF EXISTS Orders;
DROP table IF EXISTS Order_item;
DROP table IF EXISTS Shipment;

CREATE TABLE Users(
    id BigInt NOT NULL primary key,
    name Varchar(50) Not Null ,
    phone Varchar(20) Not Null,
    email Varchar(30) Not Null unique ,
    birth_date TimeStamp,
    join_date TimeStamp,
    password Varchar(50) Not null
);
CREATE SEQUENCE IF NOT EXISTS  users_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  users.id;

CREATE TABLE Address(
    id BigInt Not Null primary key,
    user_id BigInt Not null,
    government Varchar(50) not null,
    town Varchar(50) not null,
    village Varchar(50),
    street Varchar(50) not null ,
    building_number int not null,
    FOREIGN KEY (user_id) REFERENCES Users (id)
);

CREATE SEQUENCE address_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  address.id;
CREATE TABLE Orders(
    id BigInt primary key,
    user_id BigInt Not null,
    discount_percentage FLOAT,
    shipment boolean default false,
    FOREIGN KEY (user_id)
    REFERENCES users (id)
);

CREATE SEQUENCE order_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  Orders.id;


Create table Order_item(
    id BigInt primary key,
    price FLOAT NOT NULL,
    quantity int NOT NULL,
    product_id BIGINT not null,
    discount_percentage FLOAT,
    FOREIGN KEY (product_id)
    REFERENCES product (id)
);
CREATE SEQUENCE order_item_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  Order_item.id;

Create table Shipment(
    id BigInt primary key,
    address_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    state Varchar(100) NOT NULL,
    user_acknowledge Boolean,
    FOREIGN KEY (address_id)
    REFERENCES Address (id),
    FOREIGN KEY (order_id)
    REFERENCES Orders (id)
);
CREATE SEQUENCE IF NOT EXISTS  shipment_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  shipment.id;