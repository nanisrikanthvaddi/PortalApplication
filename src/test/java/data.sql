 
 
insert into users  (user_id ,user_name ,email  ,password  ,name  ,last_name  ,active) values(1,'harshini','harshini@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','harshini','harshini',TRUE);

 insert into users  (user_id ,user_name ,email  ,password  ,name  ,last_name  ,active) values(2,'user1','user1@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','user1','user1_lastname',TRUE);

 insert into users  (user_id ,user_name ,email  ,password  ,name  ,last_name  ,active) values(2,'user2','user2@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','user2','user2_lastname',TRUE);
 

 insert into roles(role_id,role) values(1,'ADMIN');
insert into user_role (role_id,user_id) values(1,1);
insert into user_role (role_id,user_id) values(1,2);
insert into user_role (role_id,user_id) values(1,3);

