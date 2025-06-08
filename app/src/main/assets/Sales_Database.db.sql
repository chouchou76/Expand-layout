BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Category" (
	"id"	INTEGER,
	"Name"	TEXT,
	"ImageLink"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Customer" (
	"id"	INTEGER,
	"Name"	TEXT,
	"Email"	TEXT,
	"Phone"	INTEGER,
	"UserName"	TEXT,
	"Password"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Employee" (
	"id"	INTEGER,
	"Name"	TEXT,
	"Email"	INTEGER,
	"Phone"	INTEGER,
	"UserName"	TEXT,
	"Password"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "OrderDetails" (
	"id"	INTEGER,
	"OrderId"	INTEGER,
	"Productid"	INTEGER,
	"Quantity"	INTEGER,
	"Price"	REAL,
	"VAT"	REAL,
	"Discount"	REAL,
	"TotalValue"	REAL,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Orders" (
	"id"	INTEGER,
	"Code"	TEXT,
	"Name"	TEXT,
	"Employeeid"	INTEGER,
	"Customerid"	INTEGER,
	"OrderDate"	BLOB,
	"Description"	REAL,
	"Status"	INTEGER,
	"StatusDescription"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Payment Method" (
	"id"	INTEGER,
	"Name"	TEXT,
	"Description"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Product" (
	"id"	INTEGER,
	"Name"	TEXT,
	"Quantity"	INTEGER,
	"Price"	REAL,
	"CateId"	INTEGER,
	"Description"	TEXT,
	"ImageLink"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "Category" VALUES (1,'Soft Drink',NULL);
INSERT INTO "Category" VALUES (2,'Cake',NULL);
INSERT INTO "Category" VALUES (3,'Fastfood',NULL);
INSERT INTO "Category" VALUES (4,'Beer',NULL);
INSERT INTO "Category" VALUES (5,'Seafood',NULL);
INSERT INTO "Category" VALUES (6,'Vegetarian',NULL);
INSERT INTO "Category" VALUES (7,'Fruit',NULL);
INSERT INTO "Category" VALUES (8,'Snack',NULL);
INSERT INTO "Category" VALUES (9,'Coffee',NULL);
INSERT INTO "Category" VALUES (10,'Ice Cream',NULL);
INSERT INTO "Customer" VALUES (1,'Hee','hee1510@gmail.com',915102001,'heehee','123');
INSERT INTO "Customer" VALUES (2,'Jay','jay2004@gmail.com',920042002,'jay','1234');
INSERT INTO "Customer" VALUES (3,'Jake','jake1511@gmail.com',915112002,'jake','2345');
INSERT INTO "Customer" VALUES (4,'Hoon','hoon0912@gmail.com',920020912,'hoonie','3456');
INSERT INTO "Customer" VALUES (5,'Noo','noo2406@gmail.com',903240620,'ddeonu','4567');
INSERT INTO "Customer" VALUES (6,'Won','won0902@gmail.com',904090204,'wonnie','5678');
INSERT INTO "Customer" VALUES (7,'Ki','ki0812@gmail.com',912082005,'riki','6789');
INSERT INTO "Employee" VALUES (1,'Jay','jay@gmail.com',958204202,'jayie','0420');
INSERT INTO "Employee" VALUES (2,'Jake','jake@gmail.com',963887335,'jackeu','2002');
INSERT INTO "Employee" VALUES (3,'Jack','jack@gmail.com',853482375,'tuantrinh','1997');
INSERT INTO "OrderDetails" VALUES (1,1,24,2,44.0,8.0,20.0,NULL);
INSERT INTO "OrderDetails" VALUES (2,1,6,5,31.0,5.0,15.0,NULL);
INSERT INTO "OrderDetails" VALUES (3,1,23,4,24.0,10.0,10.0,NULL);
INSERT INTO "OrderDetails" VALUES (4,1,9,3,21.0,10.0,24.0,NULL);
INSERT INTO "OrderDetails" VALUES (5,2,12,1,25.0,5.0,0.0,NULL);
INSERT INTO "OrderDetails" VALUES (6,2,24,6,43.0,13.0,5.0,NULL);
INSERT INTO "OrderDetails" VALUES (7,2,7,6,36.0,12.0,25.0,NULL);
INSERT INTO "OrderDetails" VALUES (8,3,6,1,27.0,10.0,0.0,NULL);
INSERT INTO "OrderDetails" VALUES (9,3,29,2,65.0,20.0,12.0,NULL);
INSERT INTO "OrderDetails" VALUES (10,3,5,6,23.0,8.0,18.0,NULL);
INSERT INTO "Orders" VALUES (1,'HD01','Hóa đơn 1',1,1,'11/02/2025','Mô tả 1',1,'Đã giao hàng thành công');
INSERT INTO "Orders" VALUES (2,'HD02','Hóa đơn 2',2,5,'24/01/2025','Mô tả 2',2,'Đơn hàng bị bùng');
INSERT INTO "Orders" VALUES (3,'HD03','Hóa đơn 3',3,4,'23/03/2025','Mô tả 3',3,'Đang giao hàng');
INSERT INTO "Payment Method" VALUES (1,'Banking Account','Chuyển khoản ngân hàng');
INSERT INTO "Payment Method" VALUES (2,'MOMO','Thanh toán ví MOMO');
INSERT INTO "Payment Method" VALUES (3,'ZaloPay','Thanh toán ví ZaloPay');
INSERT INTO "Payment Method" VALUES (4,'COD','Thanh toán khi nhận hàng');
INSERT INTO "Product" VALUES (1,'Coca Cola',100,10.0,1,NULL,NULL);
INSERT INTO "Product" VALUES (2,'Pepsi',120,9.5,1,NULL,NULL);
INSERT INTO "Product" VALUES (3,'7Up',90,8.0,1,NULL,NULL);
INSERT INTO "Product" VALUES (4,'Fanta',85,8.5,1,NULL,NULL);
INSERT INTO "Product" VALUES (5,'Sprite',95,9.0,1,NULL,NULL);
INSERT INTO "Product" VALUES (6,'Chocolate Cake',30,25.0,2,NULL,NULL);
INSERT INTO "Product" VALUES (7,'Cheesecake',20,28.0,2,NULL,NULL);
INSERT INTO "Product" VALUES (8,'Carrot Cake',25,22.0,2,NULL,NULL);
INSERT INTO "Product" VALUES (9,'Tiramisu',15,30.0,2,NULL,NULL);
INSERT INTO "Product" VALUES (10,'Pineapple Cake',18,26.5,2,NULL,NULL);
INSERT INTO "Product" VALUES (11,'Burger',50,20.0,3,NULL,NULL);
INSERT INTO "Product" VALUES (12,'Fried Chicken',60,22.5,3,NULL,NULL);
INSERT INTO "Product" VALUES (13,'Pizza',40,30.0,3,NULL,NULL);
INSERT INTO "Product" VALUES (14,'Hotdog',55,18.0,3,NULL,NULL);
INSERT INTO "Product" VALUES (15,'French Fries',70,15.0,3,NULL,NULL);
INSERT INTO "Product" VALUES (16,'Heineken',100,18.0,4,NULL,NULL);
INSERT INTO "Product" VALUES (17,'Tiger',90,17.0,4,NULL,NULL);
INSERT INTO "Product" VALUES (18,'Budweiser',80,19.0,4,NULL,NULL);
INSERT INTO "Product" VALUES (19,'Larue',110,15.0,4,NULL,NULL);
INSERT INTO "Product" VALUES (20,'Saigon Beer',95,16.0,4,NULL,NULL);
INSERT INTO "Product" VALUES (21,'Grilled Squid',25,45.0,5,NULL,NULL);
INSERT INTO "Product" VALUES (22,'Fried Shrimp',30,50.0,5,NULL,NULL);
INSERT INTO "Product" VALUES (23,'Oyster',20,40.0,5,NULL,NULL);
INSERT INTO "Product" VALUES (24,'Lobster',10,150.0,5,NULL,NULL);
INSERT INTO "Product" VALUES (25,'Fish Fillet',35,35.0,5,NULL,NULL);
INSERT INTO "Product" VALUES (26,'Tofu Soup',40,20.0,6,NULL,NULL);
INSERT INTO "Product" VALUES (27,'Stir-fried Vegetables',45,22.0,6,NULL,NULL);
INSERT INTO "Product" VALUES (28,'Veggie Burger',30,25.0,6,NULL,NULL);
INSERT INTO "Product" VALUES (29,'Vegetarian Pizza',35,28.0,6,NULL,NULL);
INSERT INTO "Product" VALUES (30,'Mushroom Hotpot',25,32.0,6,NULL,NULL);
INSERT INTO "Product" VALUES (31,'Apple',100,5.0,7,NULL,NULL);
INSERT INTO "Product" VALUES (32,'Banana ',120,3.0,7,NULL,NULL);
INSERT INTO "Product" VALUES (33,'Mango',80,7.0,7,NULL,NULL);
INSERT INTO "Product" VALUES (34,'Orange',90,6.0,7,NULL,NULL);
INSERT INTO "Product" VALUES (35,'Grapes',85,8.0,7,NULL,NULL);
INSERT INTO "Product" VALUES (36,'Potato Chips',150,12.0,8,NULL,NULL);
INSERT INTO "Product" VALUES (37,'Popcorn',100,10.0,8,NULL,NULL);
INSERT INTO "Product" VALUES (38,'Rice Crackers',130,11.5,8,NULL,NULL);
INSERT INTO "Product" VALUES (39,'Nuts Mix',90,13.0,8,NULL,NULL);
INSERT INTO "Product" VALUES (40,'Choco Bar',140,9.5,8,NULL,NULL);
INSERT INTO "Product" VALUES (41,'Espresso',80,15.0,9,NULL,NULL);
INSERT INTO "Product" VALUES (42,'Cappuccino',75,18.0,9,NULL,NULL);
INSERT INTO "Product" VALUES (43,'Latte',85,17.5,9,NULL,NULL);
INSERT INTO "Product" VALUES (44,'Black Coffee',90,12.0,9,NULL,NULL);
INSERT INTO "Product" VALUES (45,'Iced Coffee',95,14.0,9,NULL,NULL);
INSERT INTO "Product" VALUES (46,'Vanilla',60,20.0,10,NULL,NULL);
INSERT INTO "Product" VALUES (47,'Chocolate',70,21.0,10,NULL,NULL);
INSERT INTO "Product" VALUES (48,'Strawberry',65,19.5,10,NULL,NULL);
INSERT INTO "Product" VALUES (49,'Matcha',55,22.0,10,NULL,NULL);
INSERT INTO "Product" VALUES (50,'Mango Sorbet',50,18.0,10,NULL,NULL);
COMMIT;
