CREATE TABLE Employee(
	EmpId  int(7) not null auto_increment,
	Name varchar(25) NOT NULL,
	BasicSalary int(10) NOT NULL CHECK(BasicSalary>0),
	Allowances int(10) NOT NULL CHECK(Allowances>0),
    primary key(EmpId)
)AUTO_INCREMENT = 10;

INSERT INTO Employee VALUES(1001,"Akash",9000,18000);
INSERT INTO Employee VALUES(1002,"Swati",18000,40000);
INSERT INTO Employee VALUES(1003,"Pawan",218000,440000);
INSERT INTO Employee VALUES(1004,"Raju",5718000,940000);
INSERT INTO Employee (NAME,basicsalary,allowances) VALUES("Raju",5718000,940000);

select * from Employee;

Drop table employee;

ALTER TABLE employee AUTO_INCREMENT = 100;