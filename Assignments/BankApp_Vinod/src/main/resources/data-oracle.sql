
Insert into BOOKS_ADMIN.CUSTOMER (ACC_NO,BALANCE,NAME) values (CUSTOMER_SEQUENCE.nextval,1000,'Navin');
Insert into BOOKS_ADMIN.CUSTOMER (ACC_NO,BALANCE,NAME) values (CUSTOMER_SEQUENCE.nextval,1000,'Vinod');

--create table Users(id integer, username varchar2(200),password varchar2(1000));
insert into Users(id,username,password)values(101,'navin','$2a$10$kpmoIiay55TwpuY0EiDhxODGCK5bkK1IkDHtpO6rpAuhj5LRgtd3u');
insert into Users(id,username,password)values(102,'kiran','$2a$10$kpmoIiay55TwpuY0EiDhxODGCK5bkK1IkDHtpO6rpAuhj5LRgtd3u');


--create table auth_user_group(id integer, username varchar2(200),auth_group varchar2(200));
insert into auth_user_group(id,username,auth_group) values(1,'navin','CUSTOMER');
insert into auth_user_group(id,username,auth_group) values(2,'navin','ADMIN');
insert into auth_user_group(id,username,auth_group) values(3,'kiran','CUSTOMER');

