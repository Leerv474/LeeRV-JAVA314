create table if not exists departments(
    id integer not null primary key autoincrement,
    financing money not null default 0 check(financing >= 0),
    name varchar(100) not null unique check(length(name) > 0)
);

create table if not exists faculties(
    id integer not null primary key autoincrement,
    dean varchar(255) not null check(length(dean) > 0),
    name varchar(100) not null unique check(length(name) > 0)
);

create table if not exists groups(
    id integer not null primary key autoincrement,
    name varchar(100) not null unique check(length(name) > 0),
    rating integer not null check(rating >= 0 and rating <= 5),
    year integer not null check(year >= 1 and year <= 5)
);

create table if not exists teachers(
    id integer not null primary key autoincrement,
    surname varchar(100) not null check(length(name) > 0),
    name varchar(100) not null check(length(name) > 0),
    employment_date date not null check(employment_date >= '01.01.1990'),
    is_assistant bit not null default 0,
    is_professor bit not null default 0,
    position varchar(255) not null check(length(position) > 0),
    premium money not null default 0 check(premium >= 0),
    salary money not null check(salary > 0)
);

