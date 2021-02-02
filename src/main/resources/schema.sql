DROP TABLE IF EXISTS HOMEWORK;
DROP TABLE IF EXISTS TIMETABLE;
DROP TABLE IF EXISTS LESSONS;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS(
                      ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      LOGIN VARCHAR(255) NOT NULL UNIQUE,
                      FIRST_NAME VARCHAR(40) NOT NULL,
                      LAST_NAME VARCHAR(40) NOT NULL,
                      PASSWORD VARCHAR(64) NOT NULL,
                      USER_GROUP ENUM('Admin', 'User') NOT NULL DEFAULT 'User'
);

INSERT INTO USERS VALUES ( 1, 'nnn', 'Andrey', 'Ivanov', 'hghghghg', 'Admin');
INSERT INTO USERS VALUES ( 2, 'aaa', 'Andrey', 'Ivanov', 'hghghghg', 'User');

CREATE TABLE LESSONS(
                        ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        NAME VARCHAR(20) NOT NULL,
                        WHOSE INTEGER NOT NULL,
                        CONSTRAINT UNIQUE_LESSON UNIQUE(NAME, WHOSE),
                        FOREIGN KEY (WHOSE) REFERENCES USERS(ID)
);

INSERT INTO LESSONS VALUES ( 1, 'Math', 1 );
INSERT INTO LESSONS VALUES ( 2, 'Comms', 2 );

CREATE TABLE TIMETABLE(
                          ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          DAY ENUM ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
                          TIME TIME NOT NULL,
                          LESSON INTEGER NOT NULL,
                          FOREIGN KEY (LESSON) REFERENCES LESSONS(ID)
);
INSERT INTO TIMETABLE VALUES ( 1, 'Monday', '10:00', 1 );
INSERT INTO TIMETABLE VALUES ( 2, 'Monday', '10:00', 2 );
INSERT INTO TIMETABLE VALUES ( 3, 'Monday', '10:30', 1 );
INSERT INTO TIMETABLE VALUES ( 4, 'Monday', '10:30', 2 );

CREATE TABLE HOMEWORK(
                         ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         TASK VARCHAR(255) NOT NULL,
                         DUE DATE NOT NULL,
                         SUBJECT INTEGER NOT NULL,
                         FOREIGN KEY (SUBJECT) REFERENCES LESSONS(ID)
);

INSERT INTO HOMEWORK VALUES ( 1, 'LIM', '2020-12-12', 1 );
INSERT INTO HOMEWORK VALUES ( 2, 'INT', '2020-12-12', 1 );
INSERT INTO HOMEWORK VALUES ( 3, 'TX', '2020-11-11', 2 );
INSERT INTO HOMEWORK VALUES ( 4, 'RX', '2020-11-11', 2 );