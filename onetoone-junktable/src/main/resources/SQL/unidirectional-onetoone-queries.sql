
CREATE TABLE customer (
	id serial4 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (id)
);
INSERT INTO public.customer ("name") VALUES('');
SELECT * FROM customer c;


CREATE TABLE customer_item (
	item_id int4 NULL,
	customer_id int4 NOT NULL,
	CONSTRAINT customer_item_pkey PRIMARY KEY (customer_id)
);
INSERT INTO customer_item (item_id, customer_id) VALUES(0, 0);
ALTER TABLE customer_item ADD CONSTRAINT fk3hlshckef8avlji59i9n6d6rg FOREIGN KEY (customer_id) REFERENCES customer(id);
ALTER TABLE customer_item ADD CONSTRAINT fkfdipqlijjrgayox21jjb0tdeg FOREIGN KEY (item_id) REFERENCES item(id);
SELECT * FROM customer_item ci;

CREATE TABLE item (
	id serial4 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id)
);
INSERT INTO public.item ("name") VALUES('');

SELECT * FROM item i;

