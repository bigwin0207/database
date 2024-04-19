create table member(
	userid varchar2(30) ,
	pwd varchar2(30) not null,
	name varchar2(30) not null,
	phone varchar2(30),
	email varchar2 (30),
 	constraint member_pk primary key (userid)

 	)
 		
 	
 	
 	
 create table board(
 	boardnum number(1) auto_increment,
 	writer varchar2 (30),
 	subject varchar2(100) not null,
 	content varchar2(100)not null,
 	writedate datetime default now(),
 	readcount nuber() default 0,
 	primary key(`boardnum`)

 )
 
insert into member(userid, pwd, name, phone, email)
values('id1', '1234', '류현진', '010-1111-2222','abc1@abc.com');
insert into member(userid, pwd, name, phone, email)
values('id2', '2234', '문동주', '010-2222-2222','abc2@abc.com');
insert into member(userid, pwd, name, phone, email)
values('id3', '3234', '장시환', '010-3333-2222','abc3@abc.com');