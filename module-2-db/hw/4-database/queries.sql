create table if not exists groups(
    id integer not null primary key autoincrement,
    name nvarchar(10) not null check(length(name) > 0) unique,
    rating integer not null check(rating >= 0 and rating <= 5),
    year integer not null check(year >= 1 and year <= 5)
);

create table if not exists departments(
    id integer not null primary key autoincrement,
    financing money not null default 0 check(financing >= 0),
    name nvarchar(100) not null unique check(length(name) > 0)
);
create table if not exists faculties(
    id integer not null primary key autoincrement,
    name nvarchar(100) not null unique check(length(name) > 0)
);

create table if not exists teachers(
    id integer not null primary key autoincrement,
    employment_date date not null check(employment_date > '01.01.1990'),
    surname nvarchar(100) not null check(length(name) > 0),
    name nvarchar(100) not null check(length(name) > 0),
    premium money not null check(premium >= 0) default 0,
    salary money not null check(salary > 0)
);
