CREATE SCHEMA if not exists abc;

use abc;

drop table if exists course;

CREATE TABLE course(courseId varchar(10) PRIMARY KEY,courseName varchar(20),frequencyOfCourse int,courseCredits int);

INSERT INTO course value('C01','Algorithms',3,6);
INSERT INTO course value('C02','Database',3,6);
INSERT INTO course value('C03','Operating System',3,6);
INSERT INTO course value('C04','FLAT',3,6);

INSERT INTO course value('C05','Mechanics',2,4);
INSERT INTO course value('C06','Fluids',3,6);
INSERT INTO course value('C07','Engineering Drawing',2,4);

INSERT INTO course value('C08','Transistors',3,6);
INSERT INTO course value('C09','Power',2,4);

INSERT INTO course value('C10','Building Desing',3,6);

