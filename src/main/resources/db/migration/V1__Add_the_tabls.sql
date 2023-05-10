DROP VIEW IF EXISTS category;
DROP VIEW IF EXISTS product;


CREATE TABLE  category (
	 id  BigInt NOT NULL ,
	 name  VARCHAR(100) NOT NULL,
	 description  VARCHAR(10000) DEFAULT '',
	PRIMARY KEY ( id )
);

CREATE TABLE product (
	 id  BigInt NOT NULL ,
	 name  VARCHAR(100) NOT NULL,
	 name_ar  VARCHAR(100) NOT NULL,
	 price  FLOAT NOT NULL,
	 description  VARCHAR(10000) DEFAULT '',
	 quantity  INT NOT NULL,
	 category_id  BIGINT NOT NULL,
	PRIMARY KEY ( id )
);
CREATE SEQUENCE IF NOT EXISTS  product_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  product.id;
CREATE SEQUENCE IF NOT EXISTS  category_id_seq
    AS BIGINT
    INCREMENT 1
    start 1
    OWNED BY  category.id;
ALTER TABLE product ADD CONSTRAINT category_product_realtion FOREIGN KEY (category_id) REFERENCES category (id);


