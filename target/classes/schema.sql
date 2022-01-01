CREATE TABLE IF NOT EXISTS m_user (
id SERIAL
	, name VARCHAR(50)
	, email VARCHAR(50) PRIMARY KEY
	, password VARCHAR(100)
	, birthday DATE
	, sex INT
	, phone_number CHAR(11)
);