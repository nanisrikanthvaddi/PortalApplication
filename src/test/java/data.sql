


insert into users  (user_id ,user_name ,email  ,password  ,name  ,address  ,active,facility,Last_Login_time) values(1,'harshini','harshini@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','harshini','d.no 5-18 , Minneaplois',TRUE , 'MDHHS',CURRENT_TIMESTAMP);

insert into users  (user_id ,user_name ,email  ,password  ,name  ,address  ,active,facility,Last_Login_time)  values(2,'user1','user1@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','user1','d.no 5-17 , Minneaplois',FALSE,'MDHHS',CURRENT_TIMESTAMP);

insert into users  (user_id ,user_name ,email  ,password  ,name   ,address  ,active,facility,Last_Login_time) values(3,'user2','user2@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','user2','d.no 5-16 , Minneaplois',TRUE, 'AMAZON',CURRENT_TIMESTAMP);




insert into roles(role_id,role) values(1,'ADMIN');
insert into user_role (role_id,user_id) values(1,1);
insert into user_role (role_id,user_id) values(1,2);
insert into user_role (role_id,user_id) values(1,3);

