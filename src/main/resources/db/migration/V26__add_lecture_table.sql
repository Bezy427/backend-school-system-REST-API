CREATE TABLE lectures
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    start_time   time NULL,
    end_time     time NULL,
    subject_name VARCHAR(255) NULL,
    teacher_name VARCHAR(255) NULL,
    location     VARCHAR(255) NULL,
    teacher_id   BIGINT NOT NULL,
    CONSTRAINT pk_lectures PRIMARY KEY (id)
);

ALTER TABLE lectures
    ADD CONSTRAINT FK_LECTURES_ON_TEACHER FOREIGN KEY (teacher_id) REFERENCES teachers (id);