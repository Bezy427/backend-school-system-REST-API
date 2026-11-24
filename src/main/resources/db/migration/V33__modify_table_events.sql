alter table events
    modify start_time time not null;

alter table events
    modify end_time time not null;

