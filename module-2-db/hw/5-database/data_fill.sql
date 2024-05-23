INSERT INTO teachers (surname, name, employment_date, is_assistant, is_professor, position, premium, salary) VALUES
('Smith', 'John', '1995-08-24', 0, 1, 'Professor of Mathematics', 5000.00, 75000.00),
('Johnson', 'Emily', '2000-01-15', 1, 0, 'Assistant Professor of Physics', 2500.00, 50000.00),
('Williams', 'Michael', '1998-11-30', 0, 1, 'Professor of Chemistry', 4500.00, 72000.00),
('Brown', 'Jessica', '2005-09-12', 1, 0, 'Assistant Professor of Biology', 2000.00, 48000.00),
('Jones', 'Daniel', '1992-03-05', 0, 1, 'Professor of Computer Science', 5500.00, 80000.00),
('Garcia', 'Laura', '2010-07-20', 1, 0, 'Assistant Professor of Literature', 1500.00, 45000.00),
('Martinez', 'James', '2003-04-10', 0, 1, 'Professor of History', 4000.00, 68000.00),
('Davis', 'Sarah', '1997-06-25', 0, 1, 'Professor of Economics', 4700.00, 71000.00),
('Rodriguez', 'Chris', '2012-02-18', 1, 0, 'Assistant Professor of Philosophy', 1800.00, 46000.00),
('Hernandez', 'Ashley', '1994-12-01', 0, 1, 'Professor of Sociology', 4200.00, 69000.00);

INSERT INTO groups (name, rating, year) VALUES
('Group A', 4, 1),
('Group B', 3, 2),
('Group C', 5, 3),
('Group D', 2, 4),
('Group E', 1, 5),
('Group F', 4, 2),
('Group G', 3, 3),
('Group H', 5, 4),
('Group I', 2, 1),
('Group J', 1, 2);

INSERT INTO faculties (dean, name) VALUES
('Dr. John Smith', 'Faculty of Science'),
('Dr. Emily Johnson', 'Faculty of Arts'),
('Dr. Michael Williams', 'Faculty of Engineering'),
('Dr. Jessica Brown', 'Faculty of Medicine'),
('Dr. Daniel Jones', 'Faculty of Law'),
('Dr. Laura Garcia', 'Faculty of Business'),
('Dr. James Martinez', 'Faculty of Education'),
('Dr. Sarah Davis', 'Faculty of Social Sciences'),
('Dr. Chris Rodriguez', 'Faculty of Humanities'),
('Dr. Ashley Hernandez', 'Faculty of Computer Science');

INSERT INTO departments (financing, name) VALUES
(150000.00, 'Department of Mathematics'),
(200000.00, 'Department of Physics'),
(180000.00, 'Department of Chemistry'),
(220000.00, 'Department of Biology'),
(250000.00, 'Department of Computer Science'),
(175000.00, 'Department of Economics'),
(160000.00, 'Department of History'),
(140000.00, 'Department of Literature'),
(210000.00, 'Department of Philosophy'),
(230000.00, 'Department of Sociology');
