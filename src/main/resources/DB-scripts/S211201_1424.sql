-- -----------------------------------------------------
-- AUTHOR: Mohamed Hesham
-- DATE: 1/12/2021
-- SHORT_DESC:
-- Create Vet-Clinic Database tables
-- -----------------------------------------------------

CREATE TABLE OWNER
(
    ID      INT          NOT NULL AUTO_INCREMENT,
    NAME    VARCHAR(50)  NOT NULL,
    EMAIL   VARCHAR(100) NOT NULL,
    PHONE   VARCHAR(11)  NOT NULL,
    GENDER  VARCHAR(6),
    ADDRESS VARCHAR(100),
    CONSTRAINT OWNER_PK PRIMARY KEY (ID),
    constraint OWNER_UNQ_FIELDS unique (NAME)
);


CREATE TABLE PET
(
    ID            INT         NOT NULL AUTO_INCREMENT,
    NAME          VARCHAR(50) NOT NULL,
    GENDER        VARCHAR(6),
    DATE_OF_BIRTH DATE,
    ANIMAL_KIND   VARCHAR(50),
    PHOTOS        VARCHAR(500),
    WEIGHT        DECIMAL(3, 2),
    OWNER_ID      INT         NOT NULL,
    CONSTRAINT PET_PK PRIMARY KEY (ID),
    CONSTRAINT PET_OWNER_FK FOREIGN KEY (OWNER_ID) REFERENCES OWNER (ID),
    constraint PET_UNQ_FIELDS unique (NAME)
);


CREATE TABLE CLINIC
(
    ID                   INT          NOT NULL AUTO_INCREMENT,
    NAME                 VARCHAR(50)  NOT NULL,
    ADDRESS              VARCHAR(100) NOT NULL,
    PHONE                VARCHAR(11)  NOT NULL,
    WORKING_DAYS_HOURS   VARCHAR(100),
    EMAIL                VARCHAR(100),
    SOCIAL_NETWORKS_URLS VARCHAR(500),
    CONSTRAINT CLINIC_PK PRIMARY KEY (ID),
    constraint CLINIC_UNQ_FIELDS unique (NAME)

);

CREATE TABLE DOCTOR
(
    ID        INT         NOT NULL AUTO_INCREMENT,
    NAME      VARCHAR(50) NOT NULL,
    PHONE     VARCHAR(11) NOT NULL,
    PHOTO     VARCHAR(100),
    BIO       VARCHAR(500),
    CLINIC_ID INT,
    CONSTRAINT DOCTOR_PK PRIMARY KEY (ID),
    CONSTRAINT DOCTOR_CLINIC_FK FOREIGN KEY (CLINIC_ID) REFERENCES CLINIC (ID),
    constraint DOCTOR_UNQ_FIELDS unique (NAME)
);

CREATE TABLE VISIT
(
    ID        INT  NOT NULL AUTO_INCREMENT,
    PET_ID    INT  NOT NULL,
    DOCTOR_ID INT  NOT NULL,
    CLINIC_ID INT  NOT NULL,
    DATE      DATE NOT NULL,
    CONSTRAINT VISIT_PK PRIMARY KEY (ID),
    CONSTRAINT VISIT_PET_FK FOREIGN KEY (PET_ID) REFERENCES PET (ID),
    CONSTRAINT VISIT_DOCTOR_FK FOREIGN KEY (DOCTOR_ID) REFERENCES DOCTOR (ID),
    CONSTRAINT VISIT_CLINIC_FK FOREIGN KEY (CLINIC_ID) REFERENCES CLINIC (ID)
);