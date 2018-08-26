CREATE DATABASE certificateDB;

use certificateDB;

CREATE TABLE teacher(teachId int(10) PRIMARY KEY auto_increment,
					teachName VARCHAR(60) not null,
					teachPw VARCHAR(60) not null,
					manager BOOLEAN not null
					);

create table student(stuId int(10) PRIMARY KEY not null,
					stuName VARCHAR(60) not null,
					stuPw VARCHAR(60) not null,
					Grade int(2) not null,
					class VARCHAR(20) not null
					);

create table certificate(certificateId int(10) PRIMARY KEY not null,
						certificateName VARCHAR(40) not null
						);

create table status(statusId int(10) PRIMARY KEY not null,
					stuId int(10) not null,
					certificateId int(10) not null,
					testDay date not null,
					acceptance BOOLEAN not null
					);
/*教師INSERT*/					
insert into teacher VALUE(101,'細川','sasuzo',true);
insert into teacher value(102,'樋口','Asia',true);
insert into teacher value(103,'高橋','alfort',true);
insert into teacher value(104,'山口','Boring',true);
insert into teacher value(105,'高田','takadari',false);
insert into teacher value(106,'大坪','Robot',false);

/*学生insert*/

/*資格insert*/

/*状況insert*/

