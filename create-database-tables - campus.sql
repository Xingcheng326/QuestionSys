drop database if exists campus;
create database campus;

use campus;

CREATE TABLE DimStudent(
	Name varchar(50) NULL,
	Id int PRIMARY KEY NOT NULL,
	Age int NULL,
	Degree varchar(50) NULL,
	TimeStart varchar(50) NULL
	);
	
