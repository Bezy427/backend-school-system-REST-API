create table payment_history
(
    id           bigint   not null
        primary key,
    balance      double   not null,
    amount_paid  double   not null,
    payment_date DATETIME not null,
    student_id   bigint   not null,
    constraint payment_history_students_id_fk
        foreign key (student_id) references students (id)
);
