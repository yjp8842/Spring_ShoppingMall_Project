SELECT * FROM member;

CREATE TABLE member (
    id INT NOT NULL PRIMARY KEY,
    user_id VARCHAR(50) NOT NULL,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    contact VARCHAR(20) NOT NULL
)