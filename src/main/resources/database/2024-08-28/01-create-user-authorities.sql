--liquibase formatted sql
--changeset rsherstiuk:4

CREATE TABLE users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    username varchar(50) not null UNIQUE,
    password varchar(68) not null,
    enabled boolean not null
);
create table authorities(
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authoirites_users foreign key (username) references
                        users(username),
                             UNIQUE KEY username_authority(username, authority)
);
insert into users(id, username, password, enabled)
values (1, 'test', '{bcrypt}$2a$10$3/uNIKvIVqvpa0nLVMkxUukOPkTaDgwybIC9l/DtWsj0dzQPROvku', true);
insert into authorities(username, authority) VALUES ('test', 'USER');