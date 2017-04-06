
drop table if exists todos;
CREATE TABLE todos (
    id bigint NOT NULL PRIMARY KEY auto_increment,
    subject  VARCHAR(50),
    detail VARCHAR(255),
    targetdatetime DATETIME,
    status  VARCHAR(8)
);
