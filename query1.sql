use aw;

call tryit()
call tryAgain('Jon')
select * from dimdepartmentgroup

select * from dimdepartmentgroup
where DepartmentGroupName = 'Sales and Marketing' and DepartmentGroupKey=7or tryAgaintryAgain
100
select * from DimEmployee
296

select * from DimGeography
655

select * from DimReseller
701
select TimeKey,CalendarYear, CalendarQuarter from dimtime
select SalesAmount,OrderDateKey from factinternetsales
select CalendarYear, CalendarQuarter, sum(SalesAmount)
from (dimtime inner join factinternetsales on dimtime.TimeKey =factinternetsales.OrderDateKey )
group by CalendarYear, CalendarQuarter


select count(*) from Dimsalesreason
select * from Dimsalesterritory
select * from dimreseller
select FirstName,MiddleName, LastName,BirthDate,MaritalStatus,GeographyKey from dimcustomer
select GeographyKey,EnglishCountryRegionName,StateProvinceName,City from dimgeography

(select count(temp.productKey) as InternetSaleNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select productKey,year( from_days( datediff( now( ), birthdate)))as Age 
from  dimcustomer inner join  factinternetsales on dimcustomer.CustomerKey =   factinternetsales.CustomerKey  ) as temp
group by AgeGroup) 

select concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( now( ), birthdate)))as Age 
from  dimcustomer inner join  factinternetsales on dimcustomer.CustomerKey =   factinternetsales.CustomerKey

select temp.CustomerKey ,temp.FullName,  temp.Age, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select CustomerKey,concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( now( ), birthdate)))as Age from  dimcustomer) as temp

(select count(temp.CustomerKey)as CustomerNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select CustomerKey,concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( now( ), birthdate)))as Age from  dimcustomer) as temp
group by AgeGroup)

select CustomerKey,concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( '1990-01-01', birthdate))) as Age, BirthDate from  dimcustomer

select temp1.InternetSaleNumber,temp2.CustomerNumber, temp1.AgeGroup from (select count(temp.productKey) as InternetSaleNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select productKey,year( from_days( datediff( now( ), birthdate))) - 31 as Age 
from  dimcustomer inner join  factinternetsales on dimcustomer.CustomerKey =   factinternetsales.CustomerKey  ) as temp
group by AgeGroup) as temp1 inner join (select count(temp.CustomerKey)as CustomerNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select CustomerKey,concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( now( ), birthdate))) - 31 as Age from  dimcustomer) as temp
group by AgeGroup) as temp2 on temp1.AgeGroup =temp2.AgeGroup


(select count(temp.productKey) as InternetSaleNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select productKey,year( from_days( datediff( now( ), birthdate)))as Age 
from  dimcustomer inner join  factinternetsales on dimcustomer.CustomerKey =   factinternetsales.CustomerKey  ) as temp
group by AgeGroup) 


(select count(temp.CustomerKey)as CustomerNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select CustomerKey,concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( now( ), birthdate)))as Age from  dimcustomer) as temp
group by AgeGroup)




select temp1.InternetSaleNumber,temp2.CustomerNumber, temp1.AgeGroup from (select count(temp.productKey) as InternetSaleNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select productKey,year( from_days( datediff( ‘1990-01-01’, birthdate)))as Age 
from  dimcustomer inner join  factinternetsales on dimcustomer.CustomerKey =   factinternetsales.CustomerKey  ) as temp
group by AgeGroup) as temp1 inner join (select count(temp.CustomerKey)as CustomerNumber, case when temp.Age <30 then '<30' when temp.Age<=50 then '30-50' when temp.Age>50 then '>50' end as AgeGroup
from (select CustomerKey,concat(FirstName, ' ',LastName) as FullName, year( from_days( datediff( ‘1990-01-01’, birthdate)))as Age from  dimcustomer) as temp
group by AgeGroup) as temp2 on temp1.AgeGroup =temp2.AgeGroup

select * from factinternetsales t1 inner join dimcustomer t2 on t1.CustomerKey=t2.CustomerKey
where FirstName = 'Jon' or LastName = 'Jon'

DELIMITER //
CREATE PROCEDURE tryAgain(InputName  varchar(50))
BEGIN
	select 
		* 
	from 
		factinternetsales t1 inner join dimcustomer t2 on t1.CustomerKey=t2.CustomerKey
	where
		FirstName = InputName or LastName = InputName ;
END //
DELIMITER ;

call tryAgain('Jon')


DELIMITER //
	     
CREATE PROCEDURE tryAgain2(InputName  varchar(50))
BEGIN
	select 
		* 
	from 
		factinternetsales t1 inner join dimcustomer t2 on t1.CustomerKey=t2.CustomerKey
	where
		FirstName = InputName
	limit 5;
END //
DELIMITER ;

call tryAgain2('Jon')


DELIMITER //
	     
CREATE PROCEDURE tryAgain8(
	IN InputName  varchar(50),
	OUT OutName  varchar(50)
)
BEGIN
	select 
		EnglishProductName into OutName
	from 
		dimproduct
	where
		ProductAlternateKey = InputName;
END //
DELIMITER ;

call tryAgain8('BC-M005', @PK);
select @PKgetLinegetLine




select * from dimdepartmentgroup where DepartmentGroupKey >2
DELIMITER //
	     
CREATE PROCEDURE tryAgain12(
	IN num  int,
	OUT p_DepartmentGroupKey  int,
    OUT p_ParentDepartmentGroupKey  int,
    OUT p_DepartmentGroupName varchar(50)
)
BEGIN
	select 
		DepartmentGroupKey,
        ParentDepartmentGroupKey,
        DepartmentGroupName
	INTO
		p_DepartmentGroupKey  ,
		p_ParentDepartmentGroupKey  ,
		p_DepartmentGroupName 		
        
	from 
		dimdepartmentgroup
	where
		DepartmentGroupKey > num;
END //
DELIMITER ;

call tryAgain12(2, @p_DepartmentGroupKey  ,
		@p_ParentDepartmentGroupKey  ,
		@p_DepartmentGroupName )

        
select @p_DepartmentGroupKey  ,
		@p_ParentDepartmentGroupKey  ,
		@p_DepartmentGroupName





CREATE PROCEDURE sp_Param_Multiple
@InputName varchar(50)
AS
select * from factinternetsales t1 inner join dimcustomer t2 on t1.CustomerKey=t2.CustomerKey 
where FirstName = @InputName or LastName = @InputName


DELIMITER //
CREATE function getLine(a INT, b int) returns int deterministic
BEGIN
	return  sqrt( a*a+b*b);
END //
DELIMITER ;

call tryAgain('Jon')


drop database if exists userdb;
create database userdb;

use userdb;

select * from userdb.users;
INSERT INTO users (name, email,country) VALUES  ('Xingcheng Dong', 'frank890326@gmail.com', 'USA');
deletecountryPRIMARY from users where id=1;
INSERT INTO question (qid, questionText, cid) VALUES  (1,'What we should use to delete data', 2);
select * from question;
select * from question where id =1 

