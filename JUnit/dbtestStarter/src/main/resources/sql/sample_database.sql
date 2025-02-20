DROP
    DATABASE IF EXISTS sample;
CREATE
    DATABASE sample;
USE sample;
CREATE
    TABLE account(
        id VARCHAR(50) NOT NULL PRIMARY KEY
        ,pass VARCHAR(50) NOT NULL
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;
COMMIT
