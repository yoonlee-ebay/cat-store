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

INSERT INTO item_entity(
    item_id,
    item_status,
    name,
    price,
    image_url,
    created_by,
    created_date,
    last_modified_by,
    last_modified_date
) VALUES (
    null,
    'GREEN',
    '테스트 아이템 - 노르웨이숲',
    10000.0000,
    'images/norwegian_forest.jpeg',
    'admin',
    now(),
    'admin',
    now()
);
INSERT INTO item_entity(
    item_id,
    item_status,
    name,
    price,
    image_url,
    created_by,
    created_date,
    last_modified_by,
    last_modified_date
) VALUES (
    null,
    'GREEN',
    '테스트 아이템 - 스코티시 폴드',
    20000.0000,
    'images/scottish_fold.jpg',
    'admin',
    now(),
    'admin',
    now()
);

INSERT INTO order_entity(
    order_id,
    order_status,
    address,
    item_id,
    member_id,
    created_by,
    created_date,
    last_modified_by,
    last_modified_date
) VALUES (
    null,
    'ORDERED',
    '서울특별시 강남구 테헤란로 어딘가',
    1,
    1,
    'admin',
    now(),
    'admin',
    now()
);

INSERT INTO order_entity(
    order_id,
    order_status,
    address,
    item_id,
    member_id,
    created_by,
    created_date,
    last_modified_by,
    last_modified_date
) VALUES (
    null,
    'ORDERED',
    '서울특별시 강남구 테헤란로 어딘가2',
    2,
    1,
    'admin',
    now(),
    'admin',
    now()
);