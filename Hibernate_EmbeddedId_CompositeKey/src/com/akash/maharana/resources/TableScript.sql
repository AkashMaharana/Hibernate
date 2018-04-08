drop table employee123;
drop table certification;
drop table employeeCertification;


CREATE TABLE employee123(
	EmpId  int(7),
	Name varchar(25) NOT NULL,
	primary key(EmpId)
);

CREATE TABLE certification(
	CertificationCode varchar(25) not null,
	CertificationName varchar(25) not null,
	CertificationType varchar(25) unique not null,
	primary key(CertificationCode)
);

CREATE TABLE employeeCertification(
	CertificationCode varchar(25) references certification(CertificationCode),
	EmpId int(7) references employee123(EmpId),
	Marks int(5) not null CHECK(Marks BETWEEN 1 and 100),
	primary key(CertificationCode,EmpId)
);

INSERT INTO employee123 VALUES (101,'Akash');
INSERT INTO employee123 VALUES (102,'Prakash');
INSERT INTO employee123 VALUES (103,'Bikash');
INSERT INTO employee123 VALUES (104,'Rakhash');

INSERT INTO certification VALUES ('IZO-805','OCJP','JAVA Associate');
INSERT INTO certification VALUES ('IZO-804','CATIA','Mechanical Designer');
INSERT INTO certification VALUES ('IZO-809','ANSYS','CFD Analyst');
INSERT INTO certification VALUES ('IZO-801','CFA','Finance Analyst');

INSERT INTO employeeCertification VALUES ('IZO-805',101,27);
INSERT INTO employeeCertification VALUES ('IZO-805',103,86);
INSERT INTO employeeCertification VALUES ('IZO-804',104,47);
INSERT INTO employeeCertification VALUES ('IZO-809',103,95);