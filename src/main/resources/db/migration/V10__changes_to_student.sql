alter table students
    modify registration_number varchar(50) null;

alter table teachers
drop column departmentController;

alter table teachers
    add department varchar(100) not null after qualification;


