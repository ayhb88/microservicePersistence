DROP TABLE IF EXISTS tweet;

CREATE TABLE tweet (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	user VARCHAR(250) DEFAULT NULL,
	text VARCHAR(250) DEFAULT NULL,
	location VARCHAR(250) DEFAULT NULL,
	validation bool DEFAULT FALSE
);