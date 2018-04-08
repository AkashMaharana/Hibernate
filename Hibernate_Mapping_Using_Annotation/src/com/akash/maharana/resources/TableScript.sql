drop table customer123;

create table customer123(
	id VARCHAR(100) NOT NULL,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	dob DATE NOT NULL,
	city VARCHAR(100) NOT NULL,
	PRIMARY KEY(id)
	);
	
insert into customer123 values(1001,'Akash Maharana','akashmaharana93@gmail.com','1993-05-06','Rourkela');