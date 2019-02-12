create database bankingapp;
use bankingapp;
create table customers (customerid int,firstname varchar(25),lastname varchar(25),
	username varchar(25), password varchar(25), primary key(customerid));
create table accounts (accountno int,balance double, customerid int, primary key(accountno),
	constraint accountsconstraint foreign key(customerid) references customers(customerid));
create table beneficiaries (beneficiaryid int auto_increment,beneficiaryname varchar(35),
	beneficiaryaccountno int,customerid int,primary key(beneficiaryid),
	constraint baconstraint foreign key(beneficiaryaccountno) references
	accounts(accountno), constraint bcconstraint foreign key(customerid)
	references customers(customerid));
create table transactions (transactionsid int auto_increment, customeracc int, beneficiaryaccountno int,
	dot timestamp, transactionsamt double, primary key(transactionsid),
	constraint transactionscustomerconstraint foreign key(customeracc) references accounts(accountno),
	constraint transactionsbeneficiaryacc foreign key(beneficiaryaccountno) references beneficiaries(beneficiaryaccountno))
	;

delimiter //
create procedure customersprocedure(in param0 int,in param1 varchar(25),in param2 varchar(25),in param3 varchar(25),
	in param4 varchar(25))
begin
	insert into customers(customerid,firstname,lastname,username,password) values(param0,param1,param2,param3,param4);
end
//

create procedure accountsprocedure(in param1 int,in param2 double,in param3 int)
begin
	insert into accounts(accountno,balance,customerid) values(param1,param2,param3);
end
//

create procedure beneficiaryprocedure(in param1 varchar(35),in param2 int,in param3 int)
begin
	insert into beneficiaries(beneficiaryname,beneficiaryaccountno,customerid)
		values(param1,param2,param3);
end
//
delimiter ;