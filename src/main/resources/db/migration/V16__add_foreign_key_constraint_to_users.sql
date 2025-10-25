alter table users
    add constraint users_teachers_id_fk
        foreign key (teacher_id) references teachers (id);