
USE { Lektion7 } 
[;]
-- Create 
DROP TABLE Skuespiller
DROP TABLE Sæson
DROP TABLE Episode
DROP TABLE SkuespillerEpisode
DROP TABLE Serie

CREATE TABLE Skuespiller (
id INT IDENTITY(1,1) PRIMARY KEY,
navn VARCHAR(30),
fødselsår DATE
)

CREATE TABLE Serie(
id INT IDENTITY(1,1) PRIMARY KEY,
titel VARCHAR(30),
pruduktionselvskab VARCHAR(30)
)

CREATE TABLE Sæson(
id INT IDENTITY(1,1) PRIMARY KEY,
premiere DATE,
final DATE,
sæsonnummer INT,
serieId INT FOREIGN  KEY  REFERENCES Serie(id)
)

CREATE TABLE Episode (
id INT IDENTITY(1,1) PRIMARY KEY,
nummer INT, 
længde INT,
title VARCHAR(30),
sæsonId INT FOREIGN  KEY  REFERENCES Sæson(id)


)


CREATE TABLE SkuespillerEpisode (
EpisodeId INT FOREIGN  KEY  REFERENCES Episode(id),
SkuespillerId INT FOREIGN  KEY  REFERENCES Skuespiller(id)

)








