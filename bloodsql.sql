DROP TABLE IF EXISTS bloodbaglist;
DROP TABLE IF EXISTS patientlist;

CREATE TABLE IF NOT EXISTS bloodbaglist (
	donor VARCHAR(255) NOT NULL,
	collectiondate DATE NOT NULL,
	expirydate DATE NOT NULL,
	type VARCHAR(255) NOT NULL,
	rheus VARCHAR(255) NOT NULL,
	label INTEGER(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS patientlist (
	name VARCHAR(255) NOT NULL,
	phone INTEGER NOT NULL,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	type VARCHAR(255) NOT NULL,
	rheus VARCHAR(255) NOT NULL
);

INSERT INTO bloodbaglist (donor, collectiondate, expirydate, type, rheus,
label)
VALUES("Rafael Gabon", "2018-06-16", '2018-07-26', "AB", "Positive", 0017420),
		("Chupa Kabra", "2018-06-01", '2018-07-12', "O", "Negative", 0018202),
		("Kanor Mahng", "2018-06-29", "2018-08-01", "B", "Negative", 0016581);

INSERT INTO patientlist (name, phone, address, email, type, rheus)
VALUES("Alucard Dracula", 4165594, "Dasmarinas Cavite", "alucard@gmail.com", "O",
		"Negative"),
		("Graf Orlok", 4158820, "Sta Rosa Laguna", "orlokgraf69@gmail.com", "A",
		"Positive"),
		("Edward Cullen", 41709112, "Uckblack Bloke", "cullenedward420@gmail.com",
		"B", "Negative");
