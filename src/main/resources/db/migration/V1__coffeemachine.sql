create table coffee_machine (id bigserial not null, is_busy boolean, is_enabled boolean, machine_name varchar(255) not null unique, primary key (id));
