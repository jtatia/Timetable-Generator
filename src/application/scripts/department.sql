CREATE SCHEMA if not exists abc;

use abc;

drop table if exists department;

CREATE TABLE department(id varchar(10) PRIMARY KEY,deptName varchar(30) NOT NULL);

INSERT INTO department value('D01','Computer Science and Engineering');
INSERT INTO department value('D02','Mechanical Engineering');
INSERT INTO department value('D03','Electrical Engineering');
INSERT INTO department value('D04','Civil Engineering');

