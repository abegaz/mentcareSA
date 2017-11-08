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
