create table users(
id serial primary key,
name varchar(100),
password varchar(100),
emailaddress varchar(100),
phonenumber varchar(20),
role varchar(20),
creationtime time,
approvaltime time);

create table category(
id serial primary key,
name varchar(100));

create table product(
id serial primary key,
name varchar(100),
quantity int,
price decimal,
discount int,
retailerid int references users(id),
creationtime time,
approvaltime time);

create table productimage(
id serial primary key,
path varchar(255),
productid int references product(id));


create table bill(
id serial primary key,
totalprice decimal,
creationdate date,
ischeck boolean,
retailerid int references users(id),
approvaldate date,
creationtime time,
approvaltime time);

create table cart(
id serial primary key,
quantity int,
price decimal,
isCheck boolean,
productId int references product(id),
billId int references bill(id));
