-- Drop the database if it exists
DROP DATABASE IF EXISTS course_management_system;

-- Create the database
CREATE DATABASE course_management_system;

-- Use the database
USE course_management_system;

-- Drop tables if they exist (in order to avoid foreign key issues)
DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS modules;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS auth;

-- Create tables
CREATE TABLE auth (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(25),
    phoneNo VARCHAR(25),
    course VARCHAR(20)
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL
);

CREATE TABLE modules (
    module_id INT PRIMARY KEY AUTO_INCREMENT,
    module_name VARCHAR(100) NOT NULL,
    module_type VARCHAR(100) NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE results (
    student_id INT NOT NULL,
    module_id INT NOT NULL,
    marks INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES auth(id),
    FOREIGN KEY (module_id) REFERENCES modules(module_id),
    PRIMARY KEY (student_id, module_id)
);

-- Populate courses
INSERT INTO courses(course_name) VALUES
  ('OOP'),
  ('DB'),
  ('STS');

-- Populate modules
INSERT INTO modules (module_name, module_type, course_id) VALUES
    ('Computational Mathematics','core', 1),
    ('Fundamentals of Computing','core', 1),
    ('Internet Software Architecture','core', 1),
    ('Academic Skills and Team-Based Learning','optional', 1),
    ('Embedded System Programming','core', 1),						
    ('Introductory Programming and Problem Solving','core', 1),
    ('Database','optional', 1),
    ('OOP','core', 1),
    ('21st Century Management','core', 2),
    ('Preparing for Success at University','optional', 2),
    ('Principles of Business','core', 2),
    ('Project Based Learning','core', 2),
    ('The Digital Business','core', 2),
    ('The Innovative Business','optional', 2),
    ('The Responsible Business','optional', 2),
    ('The Sustainable Business','core', 2),
    ('Strategic Global Marketing','core', 3),
    ('Financial Decision Making','core', 3),
    ('The Masters Research Project I','optional', 3),
    ('The Masters Professional Project II','optional', 3),
    ('Contemporary Issues in Human Resources An International Perspective','core', 3),
    ('Strategic Operations Management','core', 3),
    ('The Masters Professional Project II','optional', 3),
    ('The Masters Professional Project II','optional', 3);

-- Populate auth with Muslim names
INSERT INTO auth (name, email, password, role, phoneNo, course) VALUES
    ('Ahmed Ali', 'ahmed.ali@gmail.com', 'pass123', 'student', '03001234567', 'OOP'),
    ('Fatima Zahra', 'fatima.zahra@gmail.com', 'pass456', 'student', '03007654321', 'DB'),
    ('Yasir Khan', 'yasir.khan@gmail.com', 'pass789', 'teacher', '03009876543', 'STS'),
    ('Ayesha Siddiqui', 'ayesha.siddiqui@gmail.com', 'pass321', 'student', '03005432198', 'OOP'),
    ('Bilal Ahmed', 'bilal.ahmed@gmail.com', 'pass654', 'student', '03002345678', 'DB');

-- Populate results for these students (assuming IDs 1-5 and module_ids 1-3 exist)
INSERT INTO results (student_id, module_id, marks) VALUES
    (1, 1, 85),
    (1, 2, 78),
    (2, 1, 90),
    (2, 3, 88),
    (4, 2, 92),
    (5, 3, 80);

-- Example query
SELECT * FROM auth WHERE email = 'yasir.khan@gmail.com';