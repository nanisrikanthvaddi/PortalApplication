

create table IF NOT EXISTS   users   (
    user_id long auto_increment unique ,
    user_name varchar(64)  unique not null,
    email varchar(100) not null,
    password varchar(100) not null,
    name varchar(100) not null,
    address  varchar(100) not null,
    active Boolean not null,
    facility varchar(100) not null,
    Last_Login_time timestamp
    );

create table IF NOT EXISTS roles( role_id  long auto_increment not null,  role_name varchar(30) not null , permission varchar(30));

create table IF NOT EXISTS   user_role   (
     user_id long auto_increment,
     role_id long ,
     foreign key (role_id) references roles(role_id),
     foreign key (user_id) references users(user_id)
);
create table IF NOT EXISTS   Facility   (
    facility_id long auto_increment unique,
    facility_name varchar(64)  unique not null,
    address varchar(500) not null,
    contact_number varchar(100) not null
    );

CREATE SEQUENCE  IF NOT EXISTS  role_sequence START WITH 1   INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS  facility_sequence START WITH 1   INCREMENT BY 1;

