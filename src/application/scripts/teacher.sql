CREATE SCHEMA if not exists abc;

use abc;

drop table if exists teacher;

CREATE TABLE teacher(id varchar(10) PRIMARY KEY,teacherName varchar(20),department varchar(10),FOREIGN KEY(department) references department(id));

INSERT INTO teacher value('T01','Sriparna Saha','D01');
INSERT INTO teacher value('T02','Samrat Mondal','D01');
INSERT INTO teacher value('T03','Arijit Mondal','D01');
INSERT INTO teacher value('T04','Asif Ekbal','D01');

INSERT INTO teacher value('T05','Rishi Raj','D02');
INSERT INTO teacher value('T06','H.C. Verma','D02');
INSERT INTO teacher value('T07','Atul Thakur','D02');

INSERT INTO teacher value('T08','A.K. Sharma','D03');
INSERT INTO teacher value('T09','R.D. Verma','D03');

INSERT INTO teacher value('T10','Subrata Hait','D04');
INSERT INTO teacher value('T11','Om Prakash','D04');