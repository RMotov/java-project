CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER PRIMARY KEY AUTO_INCREMENT   COMMENT 'Уникальный идентификатор',
    version    INTEGER DEFAULT (0) NOT NULL         COMMENT 'Служебное поле hibernate',
    name       VARCHAR(50) NOT NULL                 COMMENT 'Наименование организации',
    full_name  VARCHAR(100)  NOT NULL               COMMENT 'Полное наименование организации',
    inn        INTEGER NOT NULL                     COMMENT 'ИНН',
    kpp        INTEGER UNIQUE NOT NULL              COMMENT 'КПП',
    address    VARCHAR(100) NOT NULL                COMMENT 'Адрес организации',
    phone      VARCHAR(12)                          COMMENT 'Телефон организации',
    is_active  INTEGER DEFAULT (1) NOT NULL         COMMENT 'Признак активности: 0 = не активен; 1 = активен.'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE INDEX IF NOT EXISTS IX_Organization_Name_Inn_Is_active ON Organization (name,inn,is_active);

CREATE TABLE IF NOT EXISTS Office (
    id              INTEGER PRIMARY KEY AUTO_INCREMENT       COMMENT 'Уникальный идентификатор',
    version         INTEGER DEFAULT (0) NOT NULL             COMMENT 'Служебное поле hibernate',
    organization_id INTEGER NOT NULL                         COMMENT 'Идентификатор организации офиса',
    name            VARCHAR(50) NOT NULL                     COMMENT 'Наименование офиса',
    address         VARCHAR(100) NOT NULL                    COMMENT 'Адрес офиса',
    phone           VARCHAR(12) NOT NULL                     COMMENT 'Телефон офиса',
    is_active       INTEGER DEFAULT (1) NOT NULL             COMMENT 'Признак активности: 0 = не активен; 1 = активен.'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE INDEX IF NOT EXISTS IX_Office_Organization_id ON Office (organization_id);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);
CREATE INDEX IF NOT EXISTS IX_Office_Organization_id_Name_Phone_Is_active ON Office (organization_id, name, phone, is_active);

CREATE TABLE IF NOT EXISTS Doc (
    code        INTEGER PRIMARY KEY     COMMENT 'Код ДУЛ',
    name        VARCHAR(40) NOT NULL    COMMENT 'Наименование ДУЛ'
);
COMMENT ON TABLE Doc IS 'Справочник ДУЛ';

CREATE TABLE IF NOT EXISTS Country (
    code        INTEGER PRIMARY KEY     COMMENT 'Код страны',
    name        VARCHAR(40) NOT NULL    COMMENT 'Наименование страны'
);
COMMENT ON TABLE Country IS 'Справочник стран';

CREATE TABLE IF NOT EXISTS User (
    id                  INTEGER                         COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER DEFAULT (0) NOT NULL    COMMENT 'Служебное поле hibernate',
    office_id           INTEGER NOT NULL                COMMENT 'Идентификатор офиса',
    first_name          VARCHAR(20) NOT NULL            COMMENT 'Имя',
    second_name         VARCHAR(20)                     COMMENT 'Фамилия',
    middle_name         VARCHAR(20)                     COMMENT 'Отчество',
    position            VARCHAR(50) NOT NULL            COMMENT 'Позиция пользователя',
    phone               VARCHAR(12)                     COMMENT 'Телефон пользователя',
    doc_code            VARCHAR(50) NOT NULL            COMMENT 'Имя документа удостоверяющего личность',
    doc_number          INTEGER                         COMMENT 'Номер документа удостоверяющего личность',
    doc_date            DATE                            COMMENT 'Дата выдачи документа удостоверяющего личность',
    citizenship_code    INTEGER NOT NULL                COMMENT 'Код гражданства',
    is_identified       INTEGER DEFAULT (1) NOT NULL    COMMENT 'Признак идентификации: 0 = не активен; 1 = активен.'
);
COMMENT ON TABLE User IS 'Пользователь';

CREATE INDEX IX_User_Office_id_First_name_Second_name_Middle_name_Position_Doc_code_Citizenship_code
ON User (office_id,
         first_name,
         second_name,
         middle_name,
         position,
         doc_code,
         citizenship_code);

CREATE INDEX IX_User_Office_id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);
CREATE INDEX IX_User_Doc_code ON User (doc_code);
ALTER TABLE User ADD FOREIGN KEY (doc_code) REFERENCES Doc(code);
CREATE INDEX IX_User_Citizenship_code ON User (citizenship_code);
ALTER TABLE User ADD FOREIGN KEY (citizenship_code) REFERENCES Country(code);