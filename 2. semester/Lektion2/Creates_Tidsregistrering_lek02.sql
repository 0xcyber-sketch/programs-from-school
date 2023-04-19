EXEC sp_MSforeachtable @command1 = "DROP TABLE ?" -- Run through all drops

-- Man dropper i modsatte række følge
DROP TABLE TeamMedarbejder
DROP TABLE MedarbederOpgavetype
DROP TABLE Tidregstrering
DROP TABLE Opgave;
DROP TABLE Opgavetype
DROP TABLE Projekt;
DROP TABLE Medarbejder; 
DROP TABLE Team;







CREATE TABLE Team(
teamId INT PRIMARY KEY IDENTITY (1,1),
navn VARCHAR(20),
)

CREATE TABLE Medarbejder(
nr INT IDENTITY (1,1),
navn VARCHAR (20),
stillingsbetegnelse VARCHAR(30),
mobil VARCHAR(8)  
PRIMARY KEY (nr)
)

CREATE TABLE Projekt (
nr INT PRIMARY KEY  IDENTITY(1,1),
navn VARCHAR(30),
estimeretTimer INT,
deadline DATE,
teamId INT FOREIGN KEY REFERENCES Team(teamId)
)

CREATE TABLE Opgavetype(
opgavetypeId INT PRIMARY KEY IDENTITY(1,1), 
navn VARCHAR (20),
beskrivelse VARCHAR (300)
)

CREATE TABLE Opgave (
nr INT  PRIMARY KEY  IDENTITY(1,1),
beskrivelse VARCHAR(40),
prioritet CHAR(6) CHECK (prioritet IN ('høj', 'middel', 'lav')), 
forventetStart DATE,
deadline DATE,
statuss VARCHAR (20) CHECK (statuss in ('igang', 'færdig', 'ikke startet')),
projektNr INT FOREIGN KEY REFERENCES Projekt(nr),
opgavetypeId INT FOREIGN KEY REFERENCES Opgavetype(opgavetypeId)
)

CREATE TABLE Tidregstrering(
id INT IDENTITY(1,1) PRIMARY KEY,
startTid DATE,
slutTid DATE,
beskrivelseAfArbejdet VARCHAR (300),
datoRegistering DATE,
medarbejderNr INT FOREIGN KEY REFERENCES Medarbejder(nr),
opgaverNr INT FOREIGN KEY REFERENCES Opgave(nr)
)
-- Omformning skal køres efter de andre.
CREATE TABLE TeamMedarbejder(
teamId INT FOREIGN KEY REFERENCES Team(teamId),
nr INT FOREIGN KEY REFERENCES Medarbejder(nr),
PRIMARY KEY (teamId, nr)
)

CREATE TABLE MedarbederOpgavetype(
opgavetypeId INT FOREIGN KEY REFERENCES Opgavetype(opgavetypeId),
nr INT FOREIGN KEY REFERENCES Medarbejder(nr),
PRIMARY KEY (opgavetypeId, nr),
)