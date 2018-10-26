CREATE SCHEMA if not exists abc;

use abc;

drop table if exists course_teacher;

CREATE TABLE course_teacher(courseId varchar(10),teacherId varchar(10),FOREIGN KEY (courseId) references course(courseId),FOREIGN KEY (teacherId) references teacher(id));

INSERT INTO course_teacher value('C01','T01');
INSERT INTO course_teacher value('C02','T02');
INSERT INTO course_teacher value('C03','T03');
INSERT INTO course_teacher value('C04','T04');
INSERT INTO course_teacher value('C05','T05');
INSERT INTO course_teacher value('C06','T06');
INSERT INTO course_teacher value('C07','T07');
INSERT INTO course_teacher value('C08','T08');
INSERT INTO course_teacher value('C09','T09');
INSERT INTO course_teacher value('C10','T10');

