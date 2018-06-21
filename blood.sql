
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS bloodbags;
DROP TABLE IF EXISTS bloodlist;

CREATE TABLE IF NOT EXISTS bloodlist (
	bloodid INTEGER NOT NULL PRIMARY KEY,
	typeid VARCHAR(2) NOT NULL,
	rheusid VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS bloodbags (
	bloodbagsid INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	donor VARCHAR(255) NOT NULL,
	collectiondate DATE NOT NULL,
	expirydate DATE NOT NULL,
	bloodid INTEGER NOT NULL,
	label INTEGER(255) NOT NULL,
	FOREIGN KEY (bloodid) REFERENCES bloodlist(bloodid)
);

CREATE TABLE IF NOT EXISTS patients (
	patientsid INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	phone INTEGER NOT NULL,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	bloodid INTEGER NOT NULL,
	FOREIGN KEY (bloodid) REFERENCES bloodlist(bloodid)
);

INSERT INTO bloodlist (bloodid, typeid, rheusid) VALUES
(1, "A", "POSITIVE"), (2, "A", "NEGATIVE"), (3, "B", "POSITIVE"),
(4, "B", "NEGATIVE"), (5, "AB", "POSITIVE"),(6, "AB", "NEGATIVE"),
(7, "O", "POSITIVE"), (8, "O", "NEGATIVE");

INSERT INTO bloodbags (donor, collectiondate, expirydate, bloodid, label) VALUES
("Rafael Gabon", "2018-06-16", "2018-07-26",
(SELECT bloodid FROM bloodlist WHERE bloodid=1), 7001420),
("Walter White","2018-06-04","2018-07-17",
(SELECT bloodid FROM bloodlist WHERE bloodid=2), 5182300),
("Jessie Pinkman", "2018-06-15", "2018-07-28",
(SELECT bloodid FROM bloodlist WHERE bloodid=3), 6048128),
("Chupa Kabra", "2018-05-01", "2018-06-24",
(SELECT bloodid FROM bloodlist WHERE bloodid=4), 1082026),
("Avery Dakota", "2018-06-12","2018-07-28",
(SELECT bloodid FROM bloodlist WHERE bloodid=5), 9162192),
("Riley Reese", "2018-05-24","2018-06-19",
(SELECT bloodid FROM bloodlist WHERE bloodid=6), 7918224),
("Jordan Zion", "2018-06-19","2018-07-23",
(SELECT bloodid FROM bloodlist WHERE bloodid=7), 8234012),
("Kanor Mahng", "2018-06-09", "2018-08-01",
(SELECT bloodid FROM bloodlist WHERE bloodid=8), 4926581);

INSERT INTO patients (name, phone, address, email, bloodid) VALUES 
("Angel Remington", 513830637, "Pennington St. Hopkins", "remington.angel@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=1)),
("Parker Payton", 494246851, "Rock Maple St. Ashland", "pparker87@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=2)),
("Saywer Amari", 740888260, "Laywer St. Bay Shore", "amarisaywer09@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=3)),
("Alucard Dracula", 623745675, "Dasmarinas, Cavite", "alucard@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=4)),
("Graf Orlok", 532991802, "Sta Rosa, Laguna", "orlokgraf69@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=5)),
("Quinn Kendall", 539735898, "Wild Horse St. Miami Beach", "kendall101@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=6)),
("Alexis Dallas", 745508059, "East Harvey Road, Cincinnati", "alexisdallas420@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=7)),
("Edward Cullen", 809657092, "Uckblack Bloke", "cullenedward420@gmail.com",
(SELECT bloodid FROM bloodlist WHERE bloodid=8));
