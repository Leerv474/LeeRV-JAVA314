create table if not exists curators(
    id integer primary key autoincrement not null,
    name nvarchar(100) not null check(length(name) > 0),
    surname nvarchar(100) not null check(length(surname) > 0)
);

create table if not exists faculties(
    id integer primary key autoincrement not null,
    financing money not null check(financing >= 0) default 0,
    name nvarchar(100) not null check(length(name) > 0) unique
);
create table if not exists departments(
    id integer primary key autoincrement not null,
    financing money not null check(financing >= 0) default 0,
    name nvarchar(100) not null check(length(name) > 0) unique,
    faculty_id integer not null,
    FOREIGN KEY (faculty_id) REFERENCES faculties(id) on delete cascade
);
create table if not exists groups(
    id integer primary key autoincrement not null,
    name nvarchar(100) not null check(length(name) > 0) unique,
    year integer not null check(year >= 1 and year <= 5),
    department_id integer not null,
    FOREIGN KEY (department_id) REFERENCES departments(id) on DELETE CASCADE
);
create table if not exists groups_curators(
    id integer primary key autoincrement not null,
    curator_id integer not null,
    group_id integer not null,
    FOREIGN KEY (curator_id) REFERENCES curators(id) on DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES groups(id) on DELETE CASCADE
);
create table if not exists teachers(
    id integer primary key autoincrement not null,
    name nvarchar not null check(length(name) > 0),
    surname nvarchar not null check(length(surname) > 0),
    salary money not null check(salary > 0)
);
create table if not exists subjects(
    id integer primary key autoincrement not null,
    name nvarchar not null check(length(name) > 0) unique
);
create table if not exists lectures(
    id integer primary key autoincrement not null,
    lecture_room nvarchar(100) not null check(length(lecture_room) > 0),
    subject_id integer not null,
    teacher_id integer not null,
    FOREIGN KEY (subject_id) REFERENCES subjects(id) on DELETE CASCADE,
    FOREIGN KEY (teacher_id) REFERENCES teachers(id) on DELETE CASCADE
);
create table if not exists groups_lectures(
    id integer primary key autoincrement not null,
    group_id integer not null,
    lecture_id integer not null,
    foreign key (group_id) references groups(id) on delete CASCADE,
    foreign key (lecture_id) REFERENCES lectures(id) on DELETE CASCADE
);

-- Insert data into curators table
INSERT INTO curators (name, surname) VALUES 
('Alice', 'Smith'),
('Bob', 'Johnson'),
('Charlie', 'Williams');

-- Insert data into faculties table
INSERT INTO faculties (financing, name) VALUES 
(1000000.00, 'Faculty of Science'),
(750000.00, 'Faculty of Arts'),
(500000.00, 'Faculty of Engineering');

-- Insert data into departments table
INSERT INTO departments (financing, name, faculty_id) VALUES 
(300000.00, 'Department of Physics', 1),
(250000.00, 'Department of Chemistry', 1),
(200000.00, 'Department of History', 2),
(150000.00, 'Department of Literature', 2),
(100000.00, 'Department of Civil Engineering', 3);

-- Insert data into groups table
INSERT INTO groups (name, year, department_id) VALUES 
('Group A', 1, 1),
('Group B', 2, 1),
('Group C', 3, 2),
('Group D', 1, 3),
('Group E', 2, 4),
('Group F', 3, 5),
('Group G', 5, 5),
('Group U', 5, 5);

-- Insert data into groups_curators table
INSERT INTO groups_curators (curator_id, group_id) VALUES 
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6);

-- Insert data into teachers table
INSERT INTO teachers (name, surname, salary) VALUES 
('David', 'Brown', 60000.00),
('Emma', 'Davis', 65000.00),
('Frank', 'Miller', 55000.00);

-- Insert data into subjects table
INSERT INTO subjects (name) VALUES 
('Mathematics'),
('Physics'),
('Chemistry'),
('History'),
('Literature'),
('Civil Engineering');

-- Insert data into lectures table
INSERT INTO lectures (lecture_room, subject_id, teacher_id) VALUES 
('Room 101', 1, 1),
('Room 102', 2, 1),
('Room 103', 3, 2),
('Room 104', 4, 2),
('Room 105', 5, 3),
('Room 106', 6, 3);

-- Insert data into groups_lectures table
INSERT INTO groups_lectures (group_id, lecture_id) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

-- 1. Вывести все возможные пары строк преподавателей и групп.
select (select name from groups where id = group_id) as group_name, (select name from teachers where id = (select 
        teacher_id from lectures where id = lecture_id)) as teacher from groups_lectures;
-- 2. Вывести названия факультетов, фонд финансирования кафедр которых превышает фонд финансирования факультета.
select name, financing from faculties where financing < (select financing from departments);
-- 3. Вывести фамилии кураторов групп и названия групп, которые они курируют.
select (select surname from curators where id = curator_id) as curator,
        (select name from groups where id = group_id) as group_name from groups_curators;
-- 4. Вывести имена и фамилии преподавателей, которые читают лекции у группы “P107”.
select name, surname from teachers where id = (select teacher_id from lectures where id =
    (select lecture_id from groups_lectures where group_id = (select id from groups where name = 'Group B')));
-- 5. Вывести фамилии преподавателей и названия факультетов на которых они читают лекции.
select (select surname from teachers where id = (select teacher_id from lectures where id = lecture_id)) as teachers, 
     (select name from faculties where id = 
     (select faculty_id from departments where id = 
     (select department_id from groups where id = group_id))) as faculties from groups_lectures;
-- 6. Вывести названия кафедр и названия групп, которые к ним относятся.
select name as group_name, (select name from departments where id = department_id) as department from groups;
-- 7. Вывести названия дисциплин, которые читает преподаватель “Samantha Adams”.
select (select name from subjects where id = subject_id) as subject, (select surname || name from teachers where id = teacher_id) as teacher from lectures;
-- 8. Вывести названия кафедр, на которых читается дисциплина “Database Theory”.
select name from departments where id =
    (select department_id from groups where id =
        (select group_id from groups_lectures where lecture_id =
            (select id from lectures where subject_id = (select id from subjects where name = 'Physics'))));
-- 9. Вывести названия групп, которые относятся к факультету “Computer Science”.
select name as group_name from groups where department_id = (select id from departments where name = 'Department of Physics');
-- 10. Вывести названия групп 5-го курса, а также название факультетов, к которым они относятся.
select groups.name, faculties.name from faculties join groups on groups.department_id = (select id from departments where faculty_id = faculties.id) where groups.year = 5;
-- 11. Вывести полные имена преподавателей и лекции, которые они читают (названия дисциплин и групп), 
-- причем отобрать только те лекции, которые читаются в аудитории “B103”.
select teachers.name || teachers.surname as teacher, (select name from subjects where id = lectures.subject_id) as subject from lectures join teachers on lectures.teacher_id = teachers.id where lectures.lecture_room = 'Room 103';
