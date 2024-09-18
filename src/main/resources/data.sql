INSERT INTO CUSTOMER (customer_id,name) VALUES ('cust1', 'John Doe');
INSERT INTO CUSTOMER (customer_id,name) VALUES ('cust2', 'Jane Smith');

INSERT INTO CUSTOMER_TRANSACTION (customer_id, amount, date) VALUES('cust1', 120.0,'2024-01-15');
INSERT INTO CUSTOMER_TRANSACTION (customer_id, amount, date) VALUES('cust1', 75.0,'2024-02-10');
INSERT INTO CUSTOMER_TRANSACTION (customer_id, amount, date) VALUES('cust1', 200.0,'2024-03-05');
INSERT INTO CUSTOMER_TRANSACTION (customer_id, amount, date) VALUES('cust2', 50.0,'2024-01-20');
INSERT INTO CUSTOMER_TRANSACTION (customer_id, amount, date) VALUES('cust2', 150.0,'2024-02-25');

INSERT INTO REWARD_POINTS (customer_id, month, year, points) VALUES ('cust1', 'JANUARY', 2024, 90);
INSERT INTO REWARD_POINTS (customer_id, month, year, points) VALUES ('cust1', 'FEBRUARY', 2024, 25);
INSERT INTO REWARD_POINTS (customer_id, month, year, points) VALUES ('cust1', 'MARCH', 2024, 200);
INSERT INTO REWARD_POINTS (customer_id, month, year, points) VALUES ('cust2', 'JANUARY', 2024, 0);
INSERT INTO REWARD_POINTS (customer_id, month, year, points) VALUES ('cust2', 'FEBRUARY', 2024, 100);
INSERT INTO REWARD_POINTS (customer_id, month, year, points) VALUES ('cust2', 'MARCH', 2024, 40);