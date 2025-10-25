alter table users
drop foreign key users_teachers_id_fk;

alter table users
    add constraint users_teachers_id_fk
        foreign key (teacher_id) references teachers (id)
            on update cascade on delete cascade;


alter table teachers
    add constraint teachers_fk_1
        foreign key (user_id) references users (id)
            on update cascade on delete cascade;

