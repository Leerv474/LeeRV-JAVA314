-- CREATE TABLE products
-- (
--     id INTEGER PRIMARY KEY AUTOINCREMENT,
--     name TEXT NOT NULL,
--     company TEXT NOT NULL,
--     items_count INTEGER DEFAULT 0,
--     price INTEGER
-- );
-- CREATE TABLE customers
-- (
--     id INTEGER PRIMARY KEY AUTOINCREMENT,
--     name TEXT NOT NULL
-- );
-- CREATE TABLE orders
-- (
--     id INTEGER PRIMARY KEY AUTOINCREMENT,
--     product_id INTEGER NOT NULL,
--     customer_id INTEGER NOT NULL,
--     created_at TEXT NOT NULL,
--     items_count INTEGER DEFAULT 1,
--     price INTEGER NOT NULL,
--     FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
--     FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
-- );
--
-- INSERT INTO products (name, company, items_count, price)
-- VALUES
-- ('iPhone 13', 'Apple', 3, 76000),
-- ('iPhone 12', 'Apple', 2, 51000),
-- ('Galaxy S21', 'Samsung', 2, 56000),
-- ('Galaxy S20', 'Samsung', 1, 41000),
-- ('P40 Pro', 'Huawei', 5, 36000);
-- INSERT INTO customers(name) VALUES ('Tom'), ('Bob'),('Sam');
-- INSERT INTO orders (product_id, customer_id, created_at, items_count, price)
-- VALUES
-- ( 
--     (SELECT id FROM products WHERE name='Galaxy S21'),
--     (SELECT id FROM customers WHERE name='Tom'),
--     '2021-11-30', 
--     2, 
--     (SELECT price FROM products WHERE name='Galaxy S21')
-- ),
-- ( 
--     (SELECT id FROM products WHERE name='iPhone 12'),
--     (SELECT id FROM customers WHERE name='Tom'),
--     '2021-11-29',  
--     1, 
--     (SELECT price FROM products WHERE name='iPhone 12')
-- ),
-- ( 
--     (SELECT id FROM products WHERE name='iPhone 12'),
--     (SELECT id FROM customers WHERE name='Bob'),
--     '2021-11-29',  
--     1, 
--     (SELECT price FROM products WHERE name='iPhone 12')
-- );
--
-- select * from orders;

-- select * from orders, customers
-- where orders.customer_id = customers.id;

-- select customers.name, products.name, orders.created_at
-- from customers, products, orders
-- where orders.customer_id = customers.id and orders.product_id = products.id;

-- select C.name, P.name, O.created_at
-- from customers as C, products as P, orders as O
-- where O.customer_id = C.id and O.product_id = P.id;

-- select C.name, P.name, * 
-- from customers as C, products as P, orders as O
-- where O.customer_id = C.id and O.product_id = P.id;

-- select orders.created_at, orders.items_count, products.name
-- from orders join products on products.id = orders.product_id;

-- select customers.name, products.name, orders.created_at
-- from orders join products on orders.product_id = products.id
-- join customers on customers.id = orders.customer_id;

select customers.name, products.name, orders.created_at
from orders join products on orders.product_id = products.id
            join customers on customers.id = orders.customer_id
where products.price > 45000
order by customers.name desc;

