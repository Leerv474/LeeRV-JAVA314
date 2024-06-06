INSERT INTO countries (name) VALUES
('United States'),
('United Kingdom'),
('Canada'),
('Australia'),
('Germany'),
('France'),
('Italy'),
('Spain'),
('Japan'),
('Brazil');

INSERT INTO authors (name, surname, country_id) VALUES
('John', 'Smith', 1),
('Jane', 'Doe', 2),
('Alice', 'Johnson', 3),
('Bob', 'Brown', 4),
('Maria', 'Garcia', 5),
('Hans', 'Schmidt', 6),
('Giulia', 'Rossi', 7),
('Carlos', 'Lopez', 8),
('Yuki', 'Tanaka', 9),
('Paulo', 'Silva', 10);

INSERT INTO themes (name) VALUES
('Science Fiction'),
('Fantasy'),
('Mystery'),
('Thriller'),
('Romance'),
('Non-Fiction'),
('Biography'),
('Historical Fiction'),
('Horror'),
('Self-Help');

INSERT INTO books (name, pages, price, publish_date, author_id, theme_id) VALUES
('The Great Adventure', 320, 19.99, '2023-01-15', 1, 2),
('Mystery of the Old House', 280, 15.50, '2022-05-10', 2, 3),
('Science Wonders', 150, 12.00, '2021-08-22', 3, 6),
('Romantic Escapes', 220, 17.75, '2023-04-18', 4, 5),
('Horror Nights', 350, 25.00, '2020-10-31', 5, 9),
('Historical Battles', 400, 29.99, '2019-11-11', 6, 8),
('Life of a Scientist', 200, 18.50, '2022-09-05', 7, 7),
('Thrilling Journeys', 280, 21.00, '2023-02-14', 8, 4),
('Japanese Legends', 300, 22.50, '2021-07-07', 9, 1),
('Brazilian Recipes', 180, 16.00, '2022-12-25', 10, 10);

INSERT INTO shops (name, country_id) VALUES
('Books Unlimited', 1),
('London Bookstore', 2),
('Maple Books', 3),
('Aussie Readers', 4),
('Berlin Book Haven', 5),
('Paris Pages', 6),
('Rome Reads', 7),
('Madrid Manuscripts', 8),
('Tokyo Tomes', 9),
('Rio Reads', 10);

INSERT INTO sales (price, quantity, sale_date, book_id, shop_id) VALUES
(19.99, 3, '2023-05-01', 1, 1),
(15.50, 2, '2023-04-22', 2, 2),
(12.00, 1, '2023-03-15', 3, 3),
(17.75, 4, '2023-02-28', 4, 4),
(25.00, 2, '2023-01-20', 5, 5),
(29.99, 1, '2022-12-10', 6, 6),
(18.50, 5, '2022-11-25', 7, 7),
(21.00, 3, '2022-10-18', 8, 8),
(22.50, 2, '2022-09-14', 9, 9),
(16.00, 4, '2022-08-30', 10, 10);
