-- Opgave 4 
-- Opgave 4.a Find alle studerende, som har f�et 12

SELECT DISTINCT S.navn
FROM Studerende S
INNER JOIN Eksamensfors�g E ON S.id = E.StuderendeId
WHERE E.karakter = 12

-- Opgave 4.b Find studerende som har best�et og aldrig har dumpet 
SELECT DISTINCT S.navn
-- Find alle studerende der har lavet mindst et eksamensfors�g
FROM Studerende S
INNER JOIN Eksamensfors�g E ON S.id = E.StuderendeId
-- P�n�r de studerende, som har �n eller flere karakterer <= 0
EXCEPT
SELECT DISTINCT  S.navn
FROM Studerende S
INNER JOIN Eksamensfors�g E ON S.id = E.StuderendeId
WHERE E.karakter <= 0 


-- Opgave 4.c Find gennemsnittet af best�ende eksamner 
-- Gennemsnittet bliver casted til et decimal tal
SELECT E.navn Navn, AVG(CAST(EF.karakter AS DECIMAL)) Gennemsnit
FROM Eksamen E
INNER JOIN Eksamensfors�g EF ON E.id = EF.eksamenId
INNER JOIN Studerende S ON S.id = EF.StuderendeId
WHERE EF.karakter > 0
GROUP BY E.navn

--Opgave 5
CREATE PROC UdskrivEksaminer
-- Parameter
@studerendeId int
AS
SELECT S.navn, karakter, E.navn eksamensnavn
FROM Studerende S
INNER JOIN Eksamensfors�g EF
ON S.id = EF.studerendeId
INNER JOIN Eksamen E
ON EF.eksamenId = E.id
-- V�lg kun de best�ede eksaminer (EF.karakter > 0)
WHERE EF.karakter > 0 AND S.id = @studerendeId

DROP PROC UdskrivEksaminer
EXEC UdskrivEksaminer 2

--Opgave 6
CREATE OR ALTER TRIGGER  navn ON Eksamensfors�g
INSTEAD OF INSERT
AS
	--Hent VALUES fra INSERT kaldet via inserted tabellen
	DECLARE @karakter AS int = (SELECT karakter FROM inserted)
	DECLARE @eksamenId AS int = (SELECT eksamenId FROM inserted)
	DECLARE @studerendeId AS int = (SELECT studerendeId FROM inserted)
BEGIN 
	-- If statement 
	IF EXISTS(
		-- Hent alle eksamensfors�g
		SELECT * FROM Eksamensfors�g EF
		-- Hent alle der opfylder f�lgende krav
		WHERE (
			EF.karakter >= 2 AND 
			EF.eksamenId = @eksamenId 
			AND EF.studerendeId = @studerendeId))
		
		-- Hvis der allerede findes en best�et eksamen, kast denne error
		BEGIN RAISERROR('Studerende har allerede best�et denne eksamen', 11,1)
		END
	ELSE
		BEGIN 
		-- Hvis der ikke findes en best�et eksamen i forvejen, k�r INSERT normalt
		INSERT INTO Eksamensfors�g VALUES(@karakter, @eksamenId, @studerendeId)
		END
END

INSERT INTO Eksamensfors�g VALUES(10, 1, 7)
SELECT * FROM Eksamensfors�g