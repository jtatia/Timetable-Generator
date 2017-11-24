CREATE SCHEMA if not exists abc;

use abc;

drop table if exists batch;

CREATE TABLE batch(id varchar(10) PRIMARY KEY,dept varchar(10) NOT NULL);

INSERT INTO batch value('CSE15b','D01');
INSERT INTO batch value('CSE16b','D01');
INSERT INTO batch value('CSE15m','D01');
INSERT INTO batch value('CSE16m','D01');
INSERT INTO batch value('ME15b','D02');
INSERT INTO batch value('ME16b','D02');
INSERT INTO batch value('ME15m','D02');
INSERT INTO batch value('ME16m','D02');
INSERT INTO batch value('EE15b','D03');
INSERT INTO batch value('EE16b','D03');
INSERT INTO batch value('EE15m','D03');
INSERT INTO batch value('EE16m','D03');
INSERT INTO batch value('CE15b','D04');
INSERT INTO batch value('CE16b','D04');
INSERT INTO batch value('CE15m','D04');
INSERT INTO batch value('CE16m','D04');





