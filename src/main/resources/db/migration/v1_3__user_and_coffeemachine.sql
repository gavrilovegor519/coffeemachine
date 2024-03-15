create table coffee_machines (is_busy boolean, is_enabled boolean, id bigserial not null, user_id bigint, machine_name varchar(255) not null, primary key (id));
create table users (id bigserial not null, password varchar(255) not null, username varchar(255) not null unique, primary key (id));
alter table if exists coffee_machines add constraint fk_coffee_machines__user_id foreign key (user_id) references users;
