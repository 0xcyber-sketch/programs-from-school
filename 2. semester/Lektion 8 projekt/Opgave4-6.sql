-- Opgave 4 
-- Opgave 4.a Find alle studerende, som har fået 12

SELECT DISTINCT S.navn
FROM Studerende S
INNER JOIN Eksamensforsøg E ON S.id = E.StuderendeId
WHERE E.karakter = 12

-- Opgave 4.b Find studerende som har bestået og aldrig har dumpet 
SELECT DISTINCT S.navn
-- Find alle studerende der har lavet mindst et eksamensforsøg
FROM Studerende S
INNER JOIN Eksamensforsøg E ON S.id = E.StuderendeId
-- Pånær de studerende, som har én eller flere karakterer <= 0
EXCEPT
SELECT DISTINCT  S.navn
FROM Studerende S
INNER JOIN Eksamensforsøg E ON S.id = E.StuderendeId
WHERE E.karakter <= 0 


-- Opgave 4.c Find gennemsnittet af bestående eksamner 
-- Gennemsnittet bliver casted til et decimal tal
SELECT E.navn Navn, AVG(CAST(EF.karakter AS DECIMAL)) Gennemsnit
FROM Eksamen E
INNER JOIN Eksamensforsøg EF ON E.id = EF.eksamenId
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
INNER JOIN Eksamensforsøg EF
ON S.id = EF.studerendeId
INNER JOIN Eksamen E
ON EF.eksamenId = E.id
-- Vælg kun de beståede eksaminer (EF.karakter > 0)
WHERE EF.karakter > 0 AND S.id = @studerendeId

DROP PROC UdskrivEksaminer
EXEC UdskrivEksaminer 2

--Opgave 6
CREATE OR ALTER TRIGGER  navn ON Eksamensforsøg
INSTEAD OF INSERT
AS
	--Hent VALUES fra INSERT kaldet via inserted tabellen
	DECLARE @karakter AS int = (SELECT karakter FROM inserted)
	DECLARE @eksamenId AS int = (SELECT eksamenId FROM inserted)
	DECLARE @studerendeId AS int = (SELECT studerendeId FROM inserted)
BEGIN 
	-- If statement 
	IF EXISTS(
		-- Hent alle eksamensforsøg
		SELECT * FROM Eksamensforsøg EF
		-- Hent alle der opfylder følgende krav
		WHERE (
			EF.karakter >= 2 AND 
			EF.eksamenId = @eksamenId 
			AND EF.studerendeId = @studerendeId))
		
		-- Hvis der allerede findes en bestået eksamen, kast denne error
		BEGIN RAISERROR('Studerende har allerede bestået denne eksamen', 11,1)
		END
	ELSE
		BEGIN 
		-- Hvis der ikke findes en bestået eksamen i forvejen, kør INSERT normalt
		INSERT INTO Eksamensforsøg VALUES(@karakter, @eksamenId, @studerendeId)
		END
END

INSERT INTO Eksamensforsøg VALUES(10, 1, 7)
SELECT * FROM Eksamensforsøg