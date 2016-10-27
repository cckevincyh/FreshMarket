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

INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('赤豆',5,5.0,'/FreshMarket/commodity/imags/0d2501a3-d148-4122-8d4f-d11e800d2375_8bed2724c0f642fda9ea9b91284e7fdb.jpg');


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
insert into commodityType (`commodityTypeName`) values('坚果类');
insert into commodityType (`commodityTypeName`) values('熟食类');
insert into commodityType (`commodityTypeName`) values('面包类');
insert into commodityType (`commodityTypeName`) values('菌类');
drop table commodity;

#商品信息表
create table `commodity` (
  `commodityID` int(11) primary key auto_increment,
  `commodityName` nvarchar(50) unique not null,
  `commodityTypeID` int(11) not null,
  `commodityPrice` decimal(8,2) not null,
  `url` nvarchar(255),
	foreign key(commodityTypeID) references commodityType(commodityTypeID) on DELETE CASCADE on UPDATE CASCADE 
);
select * from commodity order by commodityID;





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

SELECT * from orders order by ordertime ;
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



INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('赤豆',5,3.0,'/FreshMarket/commodity/imags/94e06460-8042-493e-a704-f79382ff1d9a_8bed2724c0f642fda9ea9b91284e7fdb.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('绿豆',5,2.0,'/FreshMarket/commodity/imags/63ca4457-6896-4207-b950-6b9572ab7332_10d8bbda834a383d06bfb801c2d8e3d0.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('花生',5,2.0,'/FreshMarket/commodity/imags/f3494b2b-1f5e-46ed-9186-0e7153a8f1be_55727ae737b762b823dacab5082397f0.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('黄豆',5,1.0,'/FreshMarket/commodity/imags/315a1482-f583-41bb-b8a4-a12b245dcfd8_31b19a6429133e96bd5124191c872e77.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('红豆',5,3.0,'/FreshMarket/commodity/imags/771f811d-5e97-41f0-bad0-d5508c324bc3_9662736363bfed5442060403b822d060.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('豆腐',5,3.0,'/FreshMarket/commodity/imags/574857b3-c6b4-4677-853a-a95605b4365b_d5b2aa80b5fa1faeb59bca46bb706890.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('鲍鱼',4,50.0,'/FreshMarket/commodity/imags/95b83c8e-3729-4507-bb5a-c20fa7d14c46_3b54ab4300bab0faeb4ed353b9239b0c.jpeg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('海螺',4,30.0,'/FreshMarket/commodity/imags/3a370c40-b21e-447b-9eb0-cce5c63a4de5_7ec61944f3101c08c3853c897366b42d.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('三文鱼刺身',4,35.0,'/FreshMarket/commodity/imags/3498394e-ebe4-41e2-83ca-af423d05c501_37b7d7d06a19146e67d7b45cfe84782f.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('白贝',4,20.0,'/FreshMarket/commodity/imags/9bb665e7-9842-4566-bfde-11d38855d528_56ee0e062b8a6e651ed9b1e43e397850.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('海参',4,35.0,'/FreshMarket/commodity/imags/ced561fc-52cc-4eb7-ac01-565bb5c48659_720f5f2ae2b951fbc05b9d2ca0c7020f.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('大闸蟹',4,45.0,'/FreshMarket/commodity/imags/69369642-2d4b-4e77-aa63-3b56165984f0_5983c13b61e69c35f698a6b81d43a061.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('虾',4,30.0,'/FreshMarket/commodity/imags/5987ddbb-aaca-414b-b3fd-86b27ba1692e_fb9c628b2f5116ea7202b32b6ade95fd.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('罗非鱼',4,20.0,'/FreshMarket/commodity/imags/4f4e75f2-3e3e-4d2b-afa5-368f012c0f4c_ace95da25dcf3a3a17c7ae3b0a0c3dea.jpeg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('鲷鱼',4,45.0,'/FreshMarket/commodity/imags/4aa8f536-a5b7-44b9-96a2-4eecf5816b9e_e81bad23b49376b86878b89aa628f0e4.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('海虾',4,30.0,'/FreshMarket/commodity/imags/fcaf5677-a2ab-46e2-979b-46f2a24190a9_fb9c628b2f5116ea7202b32b6ade95fd.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛肉丁',3,48.0,'/FreshMarket/commodity/imags/6b43cbc7-17a3-4f92-a45e-ee9b1df4dbde_0fdfefe17cb424ece49dfada3532a70b.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('鸡胸肉',3,23.0,'/FreshMarket/commodity/imags/9676af9d-c01f-4903-8df9-63a98e114a1c_6cdbaecd73be63baffa664c9ab709bbf.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛肉丸',3,30.0,'/FreshMarket/commodity/imags/f10bb82f-2874-4ffb-bf79-fdc8a5c17b28_29bbd282cbb858d1819fdd83658a58dc.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛里脊',3,68.0,'/FreshMarket/commodity/imags/c639e418-11f8-42e4-ad2b-b2ab4caf5863_54b0f61b03176e9ba836e5a76689177c.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛肉片',3,35.0,'/FreshMarket/commodity/imags/9f60f599-ba82-482a-a7bf-89affd969ba5_ef3841ff63c67d6e9b57161d4a22e094.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('整鸡',3,70.0,'/FreshMarket/commodity/imags/a09ac6a4-336c-4dfa-8b3a-203ccc86eceb_d68ea306a99d177e8c7499f262abf34c.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('猪腿肉',3,46.0,'/FreshMarket/commodity/imags/90df0170-e603-483b-85c4-10bb40b75bf7_c8118028b72236d721e46f67935060d0.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('羊排',3,50.0,'/FreshMarket/commodity/imags/1bed1aa3-e0c7-4570-af2e-25adf23071e1_c2b57734c8ae16b706dd3437cd8b9dc3.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛排',3,75.0,'/FreshMarket/commodity/imags/d073bb74-4b71-486c-b90e-36f5de6a9b72_e2e75ce9b8dc6e8daba9c5dd116b48fc.jpeg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('火鸡肉',3,70.0,'/FreshMarket/commodity/imags/63a22d32-2b42-484c-908b-c1c1a49ac519_d37da5fb02aa26a15e1db04c6504faf6.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('猪肉',3,45.0,'/FreshMarket/commodity/imags/5fa76bc3-7c61-4433-b2a4-fb57a8f60af6_cdc2bf700d5d53b77aa85c136f777a10.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('南瓜',1,10.0,'/FreshMarket/commodity/imags/677c261a-269c-4eaf-a9e4-3cd7343ec3f4_0d633d144860e1f4a6815e308e0d9198.jpeg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('西兰花',1,8.0,'/FreshMarket/commodity/imags/7936766a-1791-4eb5-aa3f-daa68be534ea_4a6f917b72d0d261e46f2a480597dc85.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('芥菜',1,5.0,'/FreshMarket/commodity/imags/05c443b7-9231-468a-8b80-3db27e509893_7ecc56ce78ce3c7780b063c98fb78e64.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('茄子',1,6.0,'/FreshMarket/commodity/imags/752f4853-aa01-4480-aaf0-2be80701a110_21d7d45611495956c08576cbeed20e41.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('玉米',1,4.0,'/FreshMarket/commodity/imags/53c4e814-dfad-4842-8311-a1992afe17a9_46c07cb361a2fb57d62fd386d2dd9237.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('秋葵',1,17.0,'/FreshMarket/commodity/imags/d00bb506-c10b-48f5-8d8b-1868c82b3414_48b90c0ddac7ee20b451febe6b86d047.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('西芹',1,13.0,'/FreshMarket/commodity/imags/b17ef18a-810a-4fd1-945c-9e6660a01552_751db2238ee0a22fc92fc9903296b72b.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('大白菜',1,3.0,'/FreshMarket/commodity/imags/bf8b828b-6d9a-4036-9fd8-0bf21f1e2125_6071d1beb589dd30054c80984d6f9d78.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('土豆',1,4.0,'/FreshMarket/commodity/imags/37cd2e78-08a6-4820-ba27-292922a4599c_ae8ab681cc0947299f782371c9791d46.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('西红柿',1,5.0,'/FreshMarket/commodity/imags/00e12817-4285-4437-bf36-7c9cd8b37e11_bf55e2c7d9c398ae0488db3f97978e5e.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('生菜',1,2.5,'/FreshMarket/commodity/imags/0ce05721-ebb1-4297-ba7a-c1a580faac3a_f9f41d114eff6a09d39108e7e30b2da4.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('芒果',2,16.0,'/FreshMarket/commodity/imags/78816880-b12b-48a8-834f-b3fd020cd0e6_1S9A5955.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('菠萝',2,26.0,'/FreshMarket/commodity/imags/b90ba124-7cfa-4afe-9631-cd1fdf370553_1S9A6095.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛油果',2,29.0,'/FreshMarket/commodity/imags/d0fb9c76-9521-4668-8c6e-cc3b73ea36a0_1S9A6155.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('柠檬',2,12.0,'/FreshMarket/commodity/imags/236171fe-d249-4432-8c11-8856daed10ee_1S9A6175.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('车厘子',2,24.0,'/FreshMarket/commodity/imags/80e935d9-c6b2-41e3-963b-30bd790de66d_N09A2378.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('百香果',2,20.0,'/FreshMarket/commodity/imags/eefe8241-44bd-42cb-87fe-ac91aeaca130_N09A5342.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('青芒果',2,16.0,'/FreshMarket/commodity/imags/278bd83c-f70d-49ee-adfd-41c1c0eca5cc_N09A7593.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('火龙果',2,21.0,'/FreshMarket/commodity/imags/b12f3788-e614-40bc-8e7b-5ff4a2e2b1cf_N09A7622.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('奇异果',2,20.0,'/FreshMarket/commodity/imags/1fd83ca7-7ab4-4d91-ac4b-988c3dbf5a32_N09A7736.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('椰子',2,25.0,'/FreshMarket/commodity/imags/8e452f04-ae47-4644-87a1-9803af2c898f_2.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('桔子',2,14.0,'/FreshMarket/commodity/imags/7ead7c17-77e9-4002-a65e-eaad2c74fa9e_3.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('蓝莓',2,30.0,'/FreshMarket/commodity/imags/b080743c-b5b2-4571-8b98-c8df541f39d7_9.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('青瓜',1,10.0,'/FreshMarket/commodity/imags/a36f6d43-8ac7-4bfa-a46c-e6c5b8179397_11.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('圣女果',2,18.0,'/FreshMarket/commodity/imags/80e7839f-e624-4faa-a1ff-f0755b220424_12.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('香蕉',2,13.0,'/FreshMarket/commodity/imags/17d79d46-f16d-4bc5-99f3-980b80f455bd_13.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('红毛丹',2,34.0,'/FreshMarket/commodity/imags/ec38dd41-f7e5-40e0-b158-111ff0e19fa6_14.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('猕猴桃',2,26.0,'/FreshMarket/commodity/imags/ecac3509-48ac-4ab2-9acf-e488393fe8f7_15.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('萝卜',1,10.0,'/FreshMarket/commodity/imags/5c14332e-4898-4805-92c3-5c1282b78b27_16.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('凤梨',2,16.0,'/FreshMarket/commodity/imags/32d08140-683a-4832-83af-8f9a1e8f96ef_17.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('蕃茄',2,12.0,'/FreshMarket/commodity/imags/a955834e-ce3c-4019-871a-0de1360ba457_18.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('蛇果',2,16.0,'/FreshMarket/commodity/imags/250181e4-b9f4-4d76-9ae7-4c4c6251fc70_20.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('鸡蛋果',2,20.0,'/FreshMarket/commodity/imags/50dbf773-cbc7-4280-892a-40f05b2fbed3_21.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('青柠',2,10.0,'/FreshMarket/commodity/imags/c00131f3-12da-4936-a269-93b12130291e_23.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('橘子',2,24.0,'/FreshMarket/commodity/imags/0db9465e-78c5-4bd9-8278-2241a68f21fd_24.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('哈密瓜',2,26.0,'/FreshMarket/commodity/imags/0d3200de-eba4-48c2-babf-7f46a75ffa5a_25.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('腌肉',3,38.0,'/FreshMarket/commodity/imags/c7f901e2-0723-4df8-bc41-93676437e4c1_26.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('碧根果',6,19.0,'/FreshMarket/commodity/imags/973bca4f-f46e-4e14-8017-346f58fbb619_29.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('巴旦木',6,36.0,'/FreshMarket/commodity/imags/40075009-535a-417b-985f-17d46fa4316f_30.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('青口',4,43.0,'/FreshMarket/commodity/imags/67bde361-17a1-4f4e-81e9-2b8942130b6a_31.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('香梨',2,12.0,'/FreshMarket/commodity/imags/de2e6a70-b3cb-4a9d-bcc9-1d5285b08db1_35.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('巧克力蛋糕',8,80.0,'/FreshMarket/commodity/imags/30656e58-aeab-49a2-a261-739e5a5a795c_4.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('黑森林蛋糕',8,90.0,'/FreshMarket/commodity/imags/2eeda0b3-3e88-4822-93ae-d3b682d90236_6.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('法式面包',8,46.0,'/FreshMarket/commodity/imags/a207f35a-6549-49f2-9a65-ae28e5c1f47e_22.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('披萨',8,45.0,'/FreshMarket/commodity/imags/024a1c02-7f17-4fe0-bdd3-139782e1582b_27.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('蔬菜披萨',8,48.0,'/FreshMarket/commodity/imags/6af7db5a-3642-49ab-8796-4ea8abb7b3f9_32.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('牛角包',8,29.0,'/FreshMarket/commodity/imags/c7ad5320-bb1d-463a-89d6-d239eebd9b64_34.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('鱼子派',8,123.0,'/FreshMarket/commodity/imags/c5c52450-e3c4-41a3-94cb-6578f8896e07_37.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('香肠包',8,23.0,'/FreshMarket/commodity/imags/2ac42c13-3d89-4054-879e-7a7d5f326dc5_40.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('热狗',8,25.0,'/FreshMarket/commodity/imags/2b813428-b7af-4fc9-9478-0fc3fa958a3f_41.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('面包拼盘',8,125.0,'/FreshMarket/commodity/imags/99aec971-9b72-4581-99b3-a7210e351504_39.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('蜜汁烤鸡',7,56.0,'/FreshMarket/commodity/imags/048ffdfc-8db8-4424-a34c-f07304d3b061_42.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('烤鸡翅',7,23.0,'/FreshMarket/commodity/imags/b4062d01-4a39-4886-aa53-cd5d6233bb1a_5ad3fa7170ec40d9f81c360626280013.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('烤全翅',7,25.0,'/FreshMarket/commodity/imags/5525420b-b515-4c20-8b33-a1aa6f1a089b_5cb4933cc40ac2148f13cc3927c7a08a.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('烤猪排',7,36.0,'/FreshMarket/commodity/imags/f2336987-55c9-4892-9146-9c8fb62a3462_8fd31a30a504dbe8f9d9a61bac934bf6.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('卤水凤爪',7,30.0,'/FreshMarket/commodity/imags/1a1bcb09-68d2-4075-a92f-b4ced8f44b36_4346f06ea6abdab7a7534b71885a97f2.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('炸豆腐',7,24.0,'/FreshMarket/commodity/imags/7f6bca0a-5b8f-4cb0-b560-e136bad6ed11_368624d075b7110773888071fdd38697.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('卤水牛肉片',7,36.0,'/FreshMarket/commodity/imags/efe256b4-854b-4122-88d0-d68280153c3d_bcacd463e404a3c719fe07f1093ca57d.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('猪耳朵',7,20.0,'/FreshMarket/commodity/imags/4aaa8b1b-da31-462e-96e6-f703189267e6_cf5caa00cd52e0840396e88a6ab168ad.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('叉烧',7,30.0,'/FreshMarket/commodity/imags/b2937912-8485-4694-a930-22062dcdc9a6_d532c51e4b31b12dc5d53321651e3d6f.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('猴头菇',9,50.0,'/FreshMarket/commodity/imags/e0c352df-d88b-4366-84f5-f2b43088d8bd_aa49f845d0ef45b55b738475c68d6581.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('冬菇',9,36.0,'/FreshMarket/commodity/imags/698bd56b-9d80-4101-9f95-d9514fd1de76_ae19ad0fd50c41073ddaaf329197d988.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('香菇',9,36.0,'/FreshMarket/commodity/imags/846676e8-da40-47eb-8cf7-c420b4fdbc61_bc86aac016c6b02ff46ad35c1ca818f4.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('木耳',9,43.0,'/FreshMarket/commodity/imags/3525f1fc-5150-4dff-a42e-0e19690ba1b7_be813958cc5f87e25e40bda821e42434.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('金针菇',9,34.0,'/FreshMarket/commodity/imags/a07c029c-cdec-4d19-97c5-5ea3c7fc0cbf_beb84f3314f82d5eedc423b8c4a8cf2d.jpg');
INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`,`url`) values('杂菇拼盘',9,45.0,'/FreshMarket/commodity/imags/78abdbf2-467c-4a34-931b-429c42e45cda_e26fde31664cac3cca41b40cff3e7547.jpg');
S
