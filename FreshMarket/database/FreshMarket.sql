create database FreshMarket;
drop database FreshMarket;
use  FreshMarket;
drop table Users;

select * from Users;

#用户信息表
create table Users(
`userID` int(11) primary key auto_increment,
`username` nvarchar(30) BINARY unique not null ,
`password` nvarchar(30) not null,
 `sex` nvarchar(2) default '男',
  `address` nvarchar(50) default '',
  `phone` nvarchar(50) default '',
  `email` nvarchar(50) default ''
);


insert into Admins(`username`,`password`) values('admin','ISMvKXpXpadDiUoOSoAfww==');

drop table Admins;



#管理员信息表
CREATE TABLE Admins (
  `adminID` int(11) primary key auto_increment,
  `username` nvarchar(30) BINARY unique not null ,
  `password` nvarchar(30) not null
);
drop table commodityType;
#商品种类信息表
create table commodityType (
  `commodityTypeID` int(11) primary key auto_increment,
  `commodityTypeName` nvarchar(50) unique not null
);

select * from commodityType;
insert into commodityType (`commodityTypeName`) values('蔬菜');
insert into commodityType (`commodityTypeName`) values('水果');
insert into commodityType (`commodityTypeName`) values('肉类');
insert into commodityType (`commodityTypeName`) values('海鲜');
insert into commodityType (`commodityTypeName`) values('豆类');



drop table commodity;

#商品信息表
create table `commodity` (
  `commodityID` int(11) primary key auto_increment,
  `commodityName` nvarchar(50) unique not null,
  `commodityTypeID` int(11) not null,
  `commodityPrice` decimal(8,2) not null,
  `url` nvarchar(255),
	foreign key(commodityTypeID) references commodityType(commodityTypeID)
);
select * from commodity;





drop TABLE orders;

/*订单表*/
CREATE TABLE orders (
  `ordersID` CHAR(40) PRIMARY KEY,/*主键*/
  ordertime DATETIME,/*订单生成时间*/
  total DECIMAL(10,0),/*订单合计*/
  state SMALLINT(1),/*订单状态：未付款、已付款但未发货、已发货但未确认收货、收货已结束*/
  `userID` int(11) NOT NULL,/*订单的主人*/
  address VARCHAR(200),/*订单的收货地址*/
  FOREIGN KEY (userID) REFERENCES Users(userID)/*建立主外键关系*/
);

SELECT * from orders;
SELECT * from orderitem;


drop TABLE orderitem;
/*订单项表*/
CREATE TABLE orderitem(
  orderitemID CHAR(40) PRIMARY KEY,/*主键*/
  `count` INT,/*数量*/
  subtotal DECIMAL(10,0),/*小计*/
  `ordersID` CHAR(40),/*所属订单*/
  commodityID int(11),/*订单项所指的商品*/
  FOREIGN KEY (`ordersID`) REFERENCES orders(`ordersID`),/*建立主外键关系*/
  FOREIGN KEY (`commodityID`) REFERENCES commodity(`commodityID`)/*建立主外键关系*/
);

