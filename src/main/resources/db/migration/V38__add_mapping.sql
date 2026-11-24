CREATE TABLE teachers_departments
(
    department_id BIGINT NOT NULL,
    teacher_id    BIGINT NOT NULL
);

ALTER TABLE teachers_departments
    ADD CONSTRAINT fk_teadep_on_department FOREIGN KEY (department_id) REFERENCES departments (id);

ALTER TABLE teachers_departments
    ADD CONSTRAINT fk_teadep_on_teacher FOREIGN KEY (teacher_id) REFERENCES teachers (id);