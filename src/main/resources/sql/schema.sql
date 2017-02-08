
drop table if exists todos;
CREATE TABLE todos (
    id bigint NOT NULL PRIMARY KEY auto_increment,
    title  VARCHAR(50),
    description VARCHAR(255),
    targetdatetime DATETIME,
    done tinyint(1)
);
