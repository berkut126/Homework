/*
 *
 * Copyright (c) 2021 Andrey Ivanov <berkut126@gmail.com>
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
CREATE DATABASE $(SqlDatabase);
USE $(SqlDatabase);

CREATE TABLE Lessons(

                        LessonNumber INT UNIQUE PRIMARY KEY auto_increment,
                        LessonName varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null,
                        Day ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday') not null,
                        LessonStart time not null

)CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ENGINE=InnoDB;

CREATE TABLE People(

                       ID INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
                       Login VARCHAR(100) CHARACTER SET utf8mb4 COLLATE  utf8mb4_general_ci NOT NULL UNIQUE,
                       HASH VARCHAR(100) CHARACTER SET utf8mb4 COLLATE  utf8mb4_general_ci NOT NULL

) CHARACTER SET utf8mb4 COLLATE  utf8mb4_general_ci ENGINE=InnoDB;

CREATE TABLE Logins(

                       Success tinyint(1) NOT NULL DEFAULT 0,
                       REMOTE_ADDRESS VARCHAR(39) CHARACTER SET ascii collate ascii_general_ci NOT NULL,
                       X_FORWARDED_FOR VARCHAR(39) CHARACTER SET ascii collate ascii_general_ci NOT NULL,
                       ID INT NOT NULL,
                       FOREIGN KEY (ID) REFERENCES People(ID)

) CHARACTER SET utf8mb4 COLLATE  utf8mb4_general_ci ENGINE=InnoDB;

CREATE TABLE Homework(

                         Lesson varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null unique,
                         Homework varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null unique default '',
                         ByID INT not null,
                         DateOfInsert DATE not null default CURRENT_TIMESTAMP(),
                         FOREIGN KEY (ByID) references people(ID)

) CHARACTER SET utf8mb4 COLLATE  utf8mb4_general_ci ENGINE=InnoDB;

CREATE USER $(SqlUser)@'localhost' IDENTIFIED BY $(SqlPassword);
GRANT SELECT,INSERT,UPDATE,DELETE ON $(SqlDatabase).* to $(SqlUser)@'localhost';