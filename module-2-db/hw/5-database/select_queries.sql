-- 1
--select name, financing, id from departments;

-- 2
--select name as group_name, rating as group_rating from groups;

-- 3
-- select name, (salary * 100 / premium) as salary_to_premium, (salary * 100 / (salary + premium)) as salary_to_wage from teachers;

-- 4
-- select 'The dean of faculty ' || faculties.name || 'is ' || faculties.dean || '.' as deans_of_the_faculties from faculties;

-- 5
-- select surname from teachers where is_professor = 1 and salary > 60000;

-- 6
-- select name from departments where financing < 150000 or financing > 200000;

-- 7 
-- select name from departments where not name = 'Department of Computer Science';

-- 8
-- select surname, position from teachers where not is_professor = 1;

-- 9
-- select surname, position, salary, premium from teachers where is_assistant = 1 and premium between 1000 and 5000;

-- 10
-- select surname, salary from teachers where is_assistant = 1;

-- 11
-- select surname, position from teachers where employment_date < '2000.01.01';

-- 12
-- select name as 'Name of Department' from departments where name < 'Department of Sociology' order by name asc;

-- 13
-- select surname from teachers where salary + premium <= 150000;

-- 14
-- select name from groups where year = 5 and rating between 2 and 4;

-- 15
select surname from teachers where is_assistant = 1 and (salary < 150000 or premium < 5000);


