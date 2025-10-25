create table school_fees
(
    id          bigint auto_increment
        primary key,
    balance     DOUBLE       not null,
    history     varchar(255) not null,
    amount_paid DOUBLE       not null,
    amount_due  double       not null,
    student_id  bigint       not null,
    constraint school_fees_students_id_fk
        foreign key (student_id) references students (id)
);
