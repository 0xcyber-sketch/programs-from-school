
USE { Lektion7 } 
[;]
-- Create 
DROP TABLE Skuespiller
DROP TABLE S�son
DROP TABLE Episode
DROP TABLE SkuespillerEpisode
DROP TABLE Serie

CREATE TABLE Skuespiller (
id INT IDENTITY(1,1) PRIMARY KEY,
navn VARCHAR(30),
f�dsels�r DATE
)

CREATE TABLE Serie(
id INT IDENTITY(1,1) PRIMARY KEY,
titel VARCHAR(30),
pruduktionselvskab VARCHAR(30)
)

CREATE TABLE S�son(
id INT IDENTITY(1,1) PRIMARY KEY,
premiere DATE,
final DATE,
s�sonnummer INT,
serieId INT FOREIGN  KEY  REFERENCES Serie(id)
)

CREATE TABLE Episode (
id INT IDENTITY(1,1) PRIMARY KEY,
nummer INT, 
l�ngde INT,
title VARCHAR(30),
s�sonId INT FOREIGN  KEY  REFERENCES S�son(id)


)


CREATE TABLE SkuespillerEpisode (
EpisodeId INT FOREIGN  KEY  REFERENCES Episode(id),
SkuespillerId INT FOREIGN  KEY  REFERENCES Skuespiller(id)

)








