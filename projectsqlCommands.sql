Drop database carbookingdb;
create database carbookingdb;
use carbookingdb;
create table customers(
	customer_id INT NOT NULL AUTO_INCREMENT,
	first_name varchar(15),
	last_name varchar(15),
	cust_address varchar(25),
	date_of_birth varchar(10),
	PRIMARY KEY (customer_id)
);

create table vehicles(
	vehicle_id INT NOT NULL AUTO_INCREMENT,
	vehicle_type varchar(15),
	vehicle_reg varchar(15),
	vehicle_colour varchar(10),
	vehicle_engine_cc int,
	PRIMARY KEY (vehicle_id)
);

create table bookings(
	booking_id int NOT NULL AUTO_INCREMENT,
	vehicle_id int,
	customer_id int,
	start_date char(10),
	end_date char(10),
	PRIMARY KEY (booking_id),
	FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id),
	FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

INSERT INTO customers VALUES(
	001,"Kevin", "Barry", "Galway", "16-07-1991"
);
INSERT INTO customers VALUES(
	002,"Conor", "Raftery", "Westside", "15-04-1987"
);
INSERT INTO customers VALUES(
	003,"Gary", "Con", "Ballinslow", "12-04-1992"
);
INSERT INTO vehicles VALUES(
100, "Skoda", "07-v-1985", "BLUE", 1900
);

INSERT INTO bookings VALUES(
	1000,001,100,"01-09-2018","10-09-2018"
);
INSERT INTO bookings VALUES(
	1001,002,100,"04-09-2018","06-09-2018"
);
INSERT INTO bookings (vehicle_id,customer_id,start_date,end_date)VALUES(
	002,100,"11-11-2018","15-11-2018"
);
INSERT INTO bookings (vehicle_id,customer_id,start_date,end_date)VALUES(
	100,003,"11-11-2017","15-11-2017"
);