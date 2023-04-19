INSERT INTO Team values
('HEJSA'),
('Team 2')

INSERT INTO Medarbejder values
('HC', 'CEO', '24624252')

INSERT INTO Projekt values 
('Rengøring 1', 6, '2019-10-03', 2)

INSERT INTO Opgavetype values
('rengøring', 'Gør rent i studiet')

INSERT INTO Opgave values
('Vask gulv', 'middel',GETDATE(), '2021-12-31', 'igang', 1,1 )

INSERT INTO Tidregstrering values 
(GETDATE(), '2021-12-21', 'JOB DONE', GETDATE(), 1, 1)

INSERT INTO TeamMedarbejder values 
(1,1)
INSERT INTO MedarbederOpgavetype values
(1,1)




SELECT * FROM Team
SELECT * FROM Medarbejder
SELECT * FROM Projekt
SELECT * FROM Opgavetype
SELECT * FROM Opgave
SELECT * FROM Tidregstrering
SELECT * FROM TeamMedarbejder
SELECT * FROM MedarbederOpgavetype