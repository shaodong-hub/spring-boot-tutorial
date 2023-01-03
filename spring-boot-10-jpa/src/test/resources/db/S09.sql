INSERT INTO s09_user
SET id       = '1',
    username = 'username1';
INSERT INTO s09_user
SET id       = '2',
    username = 'username2';
INSERT INTO s09_user
SET id       = '3',
    username = 'username3';

INSERT INTO s09_role
SET id        = '1',
    role_name = 'role1';
INSERT INTO s09_role
SET id        = '2',
    role_name = 'role2';
INSERT INTO s09_role
SET id        = '3',
    role_name = 'role3';

INSERT INTO s09_role_user
SET user_id = '1',
    role_id = '1';

INSERT INTO s09_role_user
SET user_id = '1',
    role_id = '2';

INSERT INTO s09_role_user
SET user_id = '2',
    role_id = '2';