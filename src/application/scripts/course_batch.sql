CREATE SCHEMA if not exists abc;

use abc;

drop table if exists course_batch;

CREATE TABLE course_batch(courseId varchar(10),batchId varchar(10),FOREIGN KEY (courseId) references course(courseId),FOREIGN KEY (batchId) references batch(id));

INSERT INTO course_batch value('C01','CSE15b');
INSERT INTO course_batch value('C02','CSE15b');
INSERT INTO course_batch value('C03','CSE15b');
INSERT INTO course_batch value('C01','CSE16m');
INSERT INTO course_batch value('C02','CSE16m');
INSERT INTO course_batch value('C03','CSE15m');
INSERT INTO course_batch value('C04','CSE15m');
INSERT INTO course_batch value('C01','CSE16b');
INSERT INTO course_batch value('C02','CSE16b');

INSERT INTO course_batch value('C05','ME15b');
INSERT INTO course_batch value('C06','ME15b');
INSERT INTO course_batch value('C06','ME15m');
INSERT INTO course_batch value('C07','ME15m');
INSERT INTO course_batch value('C06','ME16b');
INSERT INTO course_batch value('C07','ME16m');

INSERT INTO course_batch value('C08','EE15b');
INSERT INTO course_batch value('C08','EE15m');
INSERT INTO course_batch value('C09','EE16b');
INSERT INTO course_batch value('C09','EE16m');

INSERT INTO course_batch value('C10','CE15b');
INSERT INTO course_batch value('C10','CE16m');



