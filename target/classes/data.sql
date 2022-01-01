INSERT INTO m_user (
	name,
	email,
	password,
	birthday,
	sex,
	phone_number
)
values NOT EXISTS(
	'Tom',
	'test@email.com',
	'$2a$10$/Hr9m1n3tDABNJJPCGNEm.XNIkDBpQ5sZs10oLgKSkV9Y88Mo7ZL6',
	'1980/01/01',
	1,
	09012345678
);