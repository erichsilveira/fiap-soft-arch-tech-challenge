INSERT INTO customers (id, cpf, name, email) VALUES ('174a948d-e049-4e70-a882-0045e536d8b7', '63046797001', 'Maria', 'maria@techchallenge.com');

INSERT INTO product_categories (id, name, description) VALUES ('771eeb81-0135-4eea-8b71-aa69a28c0b4f', 'Lanches', 'Categoria de Lanches');

INSERT INTO additional_items (id, name, description, price, product_category_id) VALUES ('208026e0-7bcd-4958-a9d2-e4bd5c375ecb', 'Bacon', 'Bacon', 1.90, '771eeb81-0135-4eea-8b71-aa69a28c0b4f');

INSERT INTO products (id, name, description, price, product_category_id) VALUES ('9bb4ffaa-45db-4a2a-b704-3e51b9707583', 'X-Salada', 'Lanche com salada', 15.00, '771eeb81-0135-4eea-8b71-aa69a28c0b4f');

INSERT INTO orders (id, products_id, order_price, status, customer_id, customer_cpf) VALUES ('553eeb81-0135-4eea-8b71-aa69a28c0b5b', '{9bb4ffaa-45db-4a2a-b704-3e51b9707583}', 15.00, 0, '174a948d-e049-4e70-a882-0045e536d8b7', '63046797001');