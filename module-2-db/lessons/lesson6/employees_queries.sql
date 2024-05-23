-- create table companies(
--     id integer primary key autoincrement,
--     name text not null
-- );
--
-- create table users( id integer primary key autoincrement,
--     name text not null, 
--     age integer,
--     company_id integer
-- );
--
-- insert into companies(name) 
-- values ('Microsoft'), ('Google');
--
-- insert into users(name, age, company_id) 
-- values('Tom', 37, (Select id from companies where name = 'Microsoft')),
-- ('Bob', 41, (Select id from companies where name = 'Google')),
-- ('Sam', 25, (select id from companies where name = 'Microsoft')),
-- ('Alice', 33, (Select id from companies where name = 'Google'));
--
-- select * from users;

-- select *, (select avg(age) from users) as avg_age from users where age > avg_age;

-- select name, age, (select name from companies where companies.id  = users.company_id) as company from users;

-- select name, age,
--     (select avg(age) from users as subuser 
--         where subuser.company_id = user.company_id) as avg_age
--     from users as user
--     where age > (select avg(age) from users as subuser where subuser.company_id = user.company_id);

-- select * from users
--     where company_id IN (select id from companies
--                             where name = 'Microsoft');

-- select * from users
-- where age IN (
--                 (select min(age) from users),
--                 (select max(age) from users)
--             );

-- select * from users 
-- where age between
--                   (select avg(age) from users) and
--                   (select max(age) from users);

-- update users 
-- set age = age + 3
-- where company_id = (select id from companies where name = 'Microsoft');

update users
set age = (select max(age) from users)
where id = 1;
select * from users;


