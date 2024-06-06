create table authors(
    id integer primary key autoincrement,
    name varchar(255) not null check(length(name) > 0),
    surname varchar(255) not null check(length(surname) > 0),
    country_id integer not null,
    FOREIGN KEY(country_id) REFERENCES countries(id)
);

create table books(
    id integer primary key autoincrement,
    name varchar(255) not null check(length(name) > 0),
    pages integer not null check(pages > 0),
    price decimal not null check(price >= 0),
    publish_date date not null,
    author_id integer not null,
    theme_id integer not null,
    FOREIGN KEY(author_id) REFERENCES authors(id),
    FOREIGN KEY(theme_id) REFERENCES theme(id)
);

create table countries(
    id integer primary key autoincrement,
    name varchar(50) not null check(length(name) > 0) unique
);

create table sales(
    id integer primary key autoincrement,
    price decimal not null check(price >= 0),
    quantity integer not null check(quantity > 0),
    sale_date date not null default (date()),
    book_id integer not null,
    shop_id integer not null,
    FOREIGN KEY(book_id) REFERENCES books(id),
    FOREIGN KEY(shop_id) REFERENCES shops(id)
);

create table shops(
    id integer primary key autoincrement,
    name varchar(255) not null check(length(name) > 0),
    country_id integer not null,
    FOREIGN KEY(country_id) REFERENCES countries(id)
);

create table themes(
    id integer primary key autoincrement,
    name varchar(100) not null check(length(name) > 0)
);
