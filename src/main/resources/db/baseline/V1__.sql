CREATE TABLE departments (
  id INTEGER NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_departments PRIMARY KEY (id)
);

CREATE TABLE students (
  id INTEGER NOT NULL,
   name VARCHAR(255),
   second_name VARCHAR(255),
   age INTEGER,
   department_id INTEGER,
   CONSTRAINT pk_students PRIMARY KEY (id)
);

ALTER TABLE students ADD CONSTRAINT FK_STUDENTS_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES departments (id);

