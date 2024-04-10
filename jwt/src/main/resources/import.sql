-- Insertar datos en la tabla users
INSERT INTO USERS (
    EMAIL,
    PWD
) VALUES (
    'account@debuggeandoieas.com',
    'to_be_encoded'
);

INSERT INTO USERS (
    EMAIL,
    PWD
) VALUES (
    'cards@debuggeandoieas.com',
    'to_be_encoded'
);

INSERT INTO USERS (
    EMAIL,
    PWD
) VALUES (
    'loans@debuggeandoieas.com',
    'to_be_encoded'
);

INSERT INTO USERS (
    EMAIL,
    PWD
) VALUES (
    'balance@debuggeandoieas.com',
    'to_be_encoded'
);

--Insertar datos en las tabla de roles
INSERT INTO ROLES (
    ROLE_NAME,
    DESCRIPTION,
    ID_USER
) VALUES (
    'ROLE_ADMIN',
    'cant view account endpoint',
    1
);

INSERT INTO ROLES (
    ROLE_NAME,
    DESCRIPTION,
    ID_USER
) VALUES (
    'ROLE_ADMIN',
    'cant view cards endpoint',
    2
);

INSERT INTO ROLES (
    ROLE_NAME,
    DESCRIPTION,
    ID_USER
) VALUES (
    'ROLE_USER',
    'cant view account endpoint',
    3
);

INSERT INTO ROLES (
    ROLE_NAME,
    DESCRIPTION,
    ID_USER
) VALUES (
    'ROLE_USER',
    'cant view account endpoint',
    4
);