CREATE TABLE Homework
(
id 		INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name 	VARCHAR(40) NOT NULL,
description VARCHAR(200)
);
CREATE TABLE Lesson
(
id		INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name	VARCHAR(40) NOT NULL,
updatedAt TIMESTAMP DEFAULT NOW(),
homework_id INTEGER,
FOREIGN KEY (homework_id) REFERENCES Homework(id)
);
CREATE TABLE Schedule
(
id		INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name	VARCHAR(40) NOT NULL,
updatedAt TIMESTAMP DEFAULT NOW(),
lessons INTEGER,
FOREIGN KEY (lessons) REFERENCES lesson(id)
);
