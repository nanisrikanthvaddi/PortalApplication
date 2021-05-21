

insert into PERMISSIONS  values  ((select PERMISSION_SEQUENCE.nextval  AS id from dual), 'System Administrator');
insert into ROLES values  ((select ROLE_SEQUENCE.nextval  AS id from dual), 'ADMIN');
insert into ROLES_PERMISSION values  (1,1);

insert into Facilities values((select facility_sequence.nextval  AS id from dual),'Treasury','Minneapolis','98845628187');


insert into users  (user_id ,facility_id,role_id,user_name,email  ,password  ,first_name  ,last_name,gender,address  ,active,Last_Login_time) values(1,1,1,'userA','harshini@abc.com','$2a$10$vUdgrOZTvXHqeNmG0z.EdOLCJ79Z1KHjb2MQxdOuMhXDxq.uZIVI.','harshini','bachu','FEMALE','d.no 5-18 , Minneaplois',TRUE ,CURRENT_TIMESTAMP);

