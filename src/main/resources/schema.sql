CREATE TABLE IF NOT EXISTS Person (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    first_name VARCHAR(50) NOT NULL COMMENT 'Имя',
    age        INTEGER  NOT NULL    COMMENT 'Возраст'
);
COMMENT ON TABLE Person IS 'Человек';

CREATE TABLE IF NOT EXISTS House (
    id         INTEGER              COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL     COMMENT 'Служебное поле hibernate',
    address    VARCHAR(50) NOT NULL COMMENT 'Адрес'
);
COMMENT ON TABLE House IS 'Дом';

CREATE TABLE IF NOT EXISTS Person_House (
    person_id   INTEGER  NOT NULL COMMENT 'Уникальный идентификатор человека',
    house_id    INTEGER  NOT NULL COMMENT 'Уникальный идентификатор дома',

    PRIMARY KEY (person_id, house_id)
);
COMMENT ON TABLE Person_House IS 'join-таблица для связи человека и дома';

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House ADD FOREIGN KEY (house_id) REFERENCES House(id);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House ADD FOREIGN KEY (person_id) REFERENCES Person(id);