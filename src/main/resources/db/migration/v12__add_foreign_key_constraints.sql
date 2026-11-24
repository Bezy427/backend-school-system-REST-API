alter table users
    add constraint users_students_id_fk
        foreign key (student_id) references students (id);