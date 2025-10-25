CREATE TABLE users
(
    id bigint auto_increment primary key,
    username varchar(100) not null unique,
    email varchar(150) not null unique,
    password varchar(255) not null,
    role varchar(50) not null check ( role in ('STUDENT', 'TEACHER', 'PRINCIPAL') )
);

CREATE TABLE students
(
    id bigint auto_increment primary key,
    registration_number varchar(50) not null unique,
    grade varchar(10),
    date_of_birth DATE,
    gender varchar(10),
    parent_contact varchar(50),
    user_id bigint unique,
    foreign key (user_id) references users(id) on delete cascade
);

CREATE TABLE teachers
(
    id bigint auto_increment primary key,
    subject varchar(100),
    departmentController varchar(100),
    qualification varchar(100),
    hire_date date,
    user_id bigint unique,
    foreign key (user_id) references users(id) on delete cascade
);

CREATE TABLE principal
(
    id bigint auto_increment primary key,
    office_location varchar(100),
    start_date date,
    user_id bigint unique,
    foreign key (user_id) references users(id) on delete cascade
);