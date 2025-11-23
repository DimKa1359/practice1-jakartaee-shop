-- Создание таблицы Category
CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Создание таблицы Product
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Заполнение таблиц тестовыми данными
INSERT INTO category (name) VALUES
    ('Электроника'),
    ('Книги'),
    ('Одежда');

INSERT INTO product (name, price, category_id) VALUES
    ('Смартфон', 29999.99, 1),
    ('Ноутбук', 59999.99, 1),
    ('Книга "Изучаем JakartaEE"', 1299.99, 2),
    ('Футболка', 999.00, 3);