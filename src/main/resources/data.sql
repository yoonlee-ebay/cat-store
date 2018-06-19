INSERT INTO member_entity(
    member_id,
    email,
    name,
    password,
    created_by,
    created_date,
    last_modified_by,
    last_modified_date
) VALUES(
    null,
    'testuser@gmail.com',
    'testuser',
    '{bcrypt}$2a$10$usIovoFXynL/oh59LzCpZO5EeTVC9sS7G/te4ZrNXjkW5jpXbPVYW',
    'admin',
    now(),
    'admin',
    now()
);