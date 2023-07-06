DROP TABLE item;
CREATE TABLE item (
	id serial4 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id)
);
INSERT INTO item("name") VALUES('');
SELECT * FROM item i;

DROP TABLE customer;
CREATE TABLE customer (
	id serial4 NOT NULL,
	"name" varchar(255) NULL,
	item_id int4 NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (id)
);
ALTER TABLE customer ADD CONSTRAINT fkcqadiwf7jkpsjnkrm5s2r1m7i FOREIGN KEY (item_id) REFERENCES item(id);

INSERT INTO customer("name", item_id) VALUES('', 0);
SELECT * FROM customer c;