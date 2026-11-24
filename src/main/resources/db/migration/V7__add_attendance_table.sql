create table departments
(
    id         bigint auto_increment
        primary key,
    name       varchar(255) not null,
    members    varchar(255) not null,
    teacher_id bigint not null,
    constraint departments_teachers_id_fk
        foreign key (teacher_id) references teachers (id)
);

create table subjects
(
    id            bigint auto_increment
        primary key,
    subject_name  varchar(255) not null,
    department_id bigint       not null,
    constraint subjects_departments_id_fk
        foreign key (department_id) references departments (id)
);

create table attendances
(
    id         bigint auto_increment
        primary key,
    student_id bigint not null,
    subject_id bigint not null,
    date       DATE   not null,
    status     text   not null,
    constraint attendances_students_id_fk
        foreign key (student_id) references students (id),
    constraint attendances_subjects_id_fk
        foreign key (subject_id) references subjects (id)
);

create table exams
(
    id         bigint auto_increment
        primary key,
    subject_id bigint not null,
    exam_date  date   not null,
    type       text   not null,
    constraint exams_subjects_id_fk
        foreign key (subject_id) references subjects (id)
);

create table enrollments
(
    id            bigint auto_increment
        primary key,
    date_issued   date         not null,
    student_id    bigint       not null,
    subject_id    bigint       not null,
    academic_year varchar(255) not null,
    form          varchar(255) not null,
    constraint enrollments_students_id__fk
        foreign key (student_id) references students (id),
    constraint enrollments_subjects_id_fk
        foreign key (subject_id) references subjects (id)
);

create table results
(
    id         bigint auto_increment
        primary key,
    student_id bigint       not null,
    exam_id    bigint       not null,
    marks      varchar(255) not null,
    grade      varchar(255) not null,
    status     text         not null,
    constraint results_exams_id_fk
        foreign key (exam_id) references exams (id),
    constraint results_students_id_fk
        foreign key (student_id) references students (id)
);

