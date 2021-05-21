
CREATE SEQUENCE  IF NOT EXISTS  role_sequence START WITH 1   INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS  facility_sequence START WITH 1   INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS  permission_sequence START WITH 1   INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS  users_sequence START WITH 1   INCREMENT BY 1;




create table IF NOT EXISTS   Facilities   (
    facility_id long auto_increment unique,
    facility_name varchar(64)  unique not null,
    address varchar(500) not null,
    contact_number varchar(100) not null
    );


create table IF NOT EXISTS permissions( permission_id long auto_increment not null,  permission varchar(30) not null );


create table IF NOT EXISTS roles(
                                    role_id  long auto_increment not null,
                                    role_name varchar(30) not null
    );

create table IF NOT EXISTS roles_permission(
          role_id  long auto_increment not null,
           permission_id long not null ,
             foreign key (role_id) references roles(role_id),
    foreign key (permission_id) references permissions(permission_id)
    );


create table IF NOT EXISTS   users   (
    user_id long auto_increment unique ,
    facility_id long  ,
    role_id long ,
    user_name varchar(64)  unique not null,
    email varchar(100) not null,
    password varchar(100) not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    gender   varchar(6) not null,
    address  varchar(100) not null,
    active Boolean not null,
    Last_Login_time timestamp,

    foreign key (facility_id) references Facilities(facility_id),
    foreign key (role_id) references roles(role_id)
    );


