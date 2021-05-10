

create table IF NOT EXISTS   users   (
    user_id long auto_increment ,
    user_name varchar(64) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    name varchar(100) not null,
    last_name varchar(100) not null,
    active Boolean not null
    );

create table IF NOT EXISTS roles( role_id  long auto_increment,  role varchar(100));

create table IF NOT EXISTS   user_role   (
     user_id long auto_increment,
     role_id long ,
     foreign key (role_id) references roles(role_id),
     foreign key (user_id) references users(user_id)

);
