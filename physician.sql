Create Database  If NOT EXISTS physician;
USE physician;
CREATE TABLE PHYSICIAN_INFO
(Phys_id varchar(6),
Phys_name varchar(25),
Phys_email varchar(20),
Phys_phone varchar(15),
PRIMARY KEY (Phys_id));
CREATE TABLE MED_FACILITY
(Fac_id varchar(6),
Fac_address varchar(30),
Fac_name varchar(15),
Fac_phone varchar(15),
PRIMARY KEY (Fac_id));
CREATE TABLE WORKS_AT
(Phys_id varchar(6),
Fac_id varchar(6),
Off_phone varchar(15),
Room_no varchar(4),
KEY (Phys_id),
FOREIGN KEY (Phys_id) REFERENCES PHYSICIAN_INFO (Phys_id),
KEY (Fac_id),
FOREIGN KEY (Fac_id) REFERENCES MED_FACILITY (Fac_id));



INSERT INTO PHYSICIAN_INFO (Phys_id, Phys_name, Phys_email, Phys_phone)
VALUES (123456, Dr. John Smith, drjohnsmith@email.com, 5552223333)
INSERT INTO MED_FACILITY (Fac_id, Fac_address, Fac_name, Fac_phone)
VALUES ()
INSERT INTO WORKS_AT (Phys_id, Fac_id, Off_phone, Room_no)
VALUES ()

INSERT INTO PHYSICIAN_INFO (Phys_id, Phys_name, Phys_email, Phys_phone)
VALUES (213452, Dr. Jane Black, drjaneblack@email.com, 7776668888)
INSERT INTO MED_FACILITY (Fac_id, Fac_address, Fac_name, Fac_phone)
VALUES ()
INSERT INTO WORKS_AT (Phys_id, Fac_id, Off_phone, Room_no)
VALUES ()

INSERT INTO PHYSICIAN_INFO (Phys_id, Phys_name, Phys_email, Phys_phone)
VALUES (234451, Dr. Doug Dunbar, drdougdunbar@email.com, 2223334444)
INSERT INTO MED_FACILITY (Fac_id, Fac_address, Fac_name, Fac_phone)
VALUES ()
INSERT INTO WORKS_AT (Phys_id, Fac_id, Off_phone, Room_no)
VALUES ()

INSERT INTO PHYSICIAN_INFO (Phys_id, Phys_name, Phys_email, Phys_phone)
VALUES (213452, Dr. Rebecca Regan, drrebeccaregan@email.com, 1119998888)
INSERT INTO MED_FACILITY (Fac_id, Fac_address, Fac_name, Fac_phone)
VALUES ()
INSERT INTO WORKS_AT (Phys_id, Fac_id, Off_phone, Room_no)
VALUES ()
