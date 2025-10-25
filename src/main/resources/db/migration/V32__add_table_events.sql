create table events
(
    id         bigint auto_increment
        primary key,
    title      varchar(255) not null,
    lectures   varchar(255) not null,
    date       date         not null,
    start_time timestamp    not null,
    end_time   timestamp    not null,
    comments   varchar(255) not null
);
