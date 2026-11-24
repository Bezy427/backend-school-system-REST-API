create table Assignments
(
    id           bigint auto_increment
        primary key,
    subject_id bigint not null,
    teacher_id bigint not null,
    due_date     DATETIME     not null,
    actions      varchar(255) not null,
    constraint Assignments_subjects_subject_name_fk
        foreign key (subject_id) references subjects (id),
    constraint Assignments_teachers_first_name_fk
        foreign key (teacher_id) references teachers (id)
);