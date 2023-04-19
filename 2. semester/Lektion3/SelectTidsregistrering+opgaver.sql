USE { Tidreg_opgaver }
[;]

-- % and _ Wildcards
SELECT * FROM Medarbejder WHERE navn LIKE 'A%'

SELECT * FROM Medarbejder WHERE navn LIKE '__a%'

SELECT * FROM Medarbejder WHERE medarbejderNr BETWEEN 10 AND 20

-- Opgave 2 
SELECT MIN(estimeretTimer) From Projekt

SELECT MAX(estimeretTimer) From Projekt

SELECT COUNT(*) From Projekt
SELECT COUNT(projektNr) From Projekt

SELECT SUM(estimeretTimer) FROM Projekt

SELECT AVG(estimeretTimer) FROM Projekt

SELECT SUM(estimeretTimer) / COUNT(*) FROM  Projekt

-- Opgave 3 . 2.1 

SELECT COUNT(*) From Projekt

-- 2.2 

SELECT navn Navn, COUNT(MedarbejderITeam.teamId) FROM Team INNER JOIN MedarbejderITeam ON Team.teamId = MedarbejderITeam.teamId GROUP BY navn

-- 2.3

SELECT navn Navn, SUM(estimeretTimer) Antal_Timer FROM Team INNER JOIN Projekt ON Team.teamId = Projekt.teamId GROUP BY navn

-- 2.4 

SELECT navn opgave_navn, COUNT(medarbejderNr) Antal_Opgaver FROM Opgavetype INNER JOIN MedarbejderOpgavetype ON Opgavetype.typeId = MedarbejderOpgavetype.typeId GROUP BY navn

-- 2.5
-- Skal den joines igen?? 
SELECT navn Navn, medarbejderNr Nr FROM  MedarbejderITeam INNER JOIN Team ON Team.teamId = MedarbejderITeam.teamId WHERE Team.teamId = 3  

-- 2.6 

SELECT stillingsbetegnelse Stilling, COUNT(medarbejderNr) Antal_ FROM Medarbejder GROUP BY stillingsbetegnelse

-- 17.01-21
-- Opgave 1 

SELECT P.projektNavn
FROM Projekt P
WHERE P.estimeretTimer = (SELECT MIN(estimeretTimer) FROM Projekt)

-- Opgave 2

SELECT MA.navn
FROM medarbejder MA
WHERE MA.medarbejderNr IN (SELECT T.medarbejderNr FROM Tidsregistrering T)

-- Opgave 3

SELECT M.navn FROM Medarbejder M INNER JOIN Tidsregistrering T ON M.medarbejderNr  = T.medarbejderNr 

-- Opgave 4

SELECT p.projektnavn, o.opgaveNr, o.statusPaaOpgave, m.navn
FROM Medarbejder M, Opgave O, Projekt P, Tidsregistrering T
WHERE M.medarbejderNr = T.medarbejderNr AND 
T.opgaveNr = O.opgaveNr AND
O.projektNr = P.projektNr

-- Opgave 5
SELECT DISTINCT  M.navn
FROM Medarbejder M, MedarbejderOpgavetype MOT, Opgavetype OT, Opgave O
WHERE M.medarbejderNr = MOT.medarbejderNr AND MOT.typeId = OT.typeId AND O.typeId = OT.typeId AND O.statusPaaOpgave = 'To do'

SELECT DISTINCT M.navn
FROM Medarbejder M, MedarbejderOpgavetype MOT, Opgave O
WHERE M.medarbejderNr = MOT.medarbejderNr AND MOT.typeId = O.typeId  AND O.statusPaaOpgave = 'To do'

-- Opgave 6 
-- Hvordan er opgaverne fordel i forhold tilderes status.Hvor mange opgaver er færdige, hvor mange opgaver er igang osv.
SELECT O.statusPaaOpgave, COUNT(O.projektNr) FROM Opgave O GROUP BY O.statusPaaOpgave

SELECT O.statusPaaOpgave
FROM Opgave O

-- (select count(hm.holdId) from HoldMedlemhmwhereh.holdId=hm.holdId)

-- Opgave 7 
-- Hvor mange projekter er der?
--Hvor mange opgave hørertil hvert projekt?
--Lav først query'en sådan du kun får de projekter hvor der opgaver til
--Derefter laves query'en sådan at alle projekterne er med.
--Også dem der ikke hartilknyttet nogleopgaverendnu.
-- Lav opgaven både som en subquery og med join

SELECT COUNT(P.projektNr)
FROM Projekt P

SELECT *
FROM Opgave

SELECT P.projektnavn, COUNT(O.projektNr) --'Antal Opgaver'
FROM Projekt P
INNER JOIN Opgave O
ON P.projektNr = O.projektNr
GROUP BY P.projektnavn


-- Alle 
SELECT P.projektnavn, (SELECT COUNT(O.opgaveNr) FROM Opgave O WHERE O.projektNr = P.projektNr) Antal
FROM Projekt P 

--JOIN
SELECT P.projektnavn, COUNT(O.projektNr) -- 'Antal Opgaver'
FROM Projekt P
LEFT JOIN Opgave O
ON P.projektNr = O.projektNr
GROUP BY P.projektnavn


-- Opgave 8
SELECT P.projektnavn, (SELECT COUNT(O.opgaveNr) FROM Opgave O WHERE O.projektNr = P.projektNr HAVING COUNT(O.opgaveNr) > 6) Antal
FROM Projekt P 

SELECT P.projektnavn, COUNT(O.projektNr) -- 'Antal Opgaver'
FROM Projekt P
LEFT JOIN Opgave O
ON P.projektNr = O.projektNr
GROUP BY P.projektnavn
HAVING COUNT(O.projektNr) > 6

-- 24.02.21

-- Opgave 1 
-- Antaget at vi ved at teamid 1 er team alpha 
SELECT Medarbejder.navn, Medarbejder.mobil
FROM Medarbejder
INNER JOIN  MedarbejderITeam MT ON  Medarbejder.medarbejderNr = MT.medarbejderNr

WHERE MT.teamId = 1
-- Hvis man ikke kender til det 
SELECT Medarbejder.navn, Medarbejder.mobil
FROM Medarbejder
INNER JOIN  MedarbejderITeam MT ON  Medarbejder.medarbejderNr = MT.medarbejderNr
INNER JOIN Team T On T.teamId = MT.teamId

WHERE T.navn = 'Team Alfa'
	
-- Opgave 2 
CREATE VIEW MedarbejderPÅTeam
As
SELECT Medarbejder.navn, Medarbejder.mobil, T.navn Team_Navn
FROM Medarbejder
INNER JOIN  MedarbejderITeam MT ON  Medarbejder.medarbejderNr = MT.medarbejderNr
INNER JOIN Team T On T.teamId = MT.teamId

-- Opgave 3
SELECT *
From MedarbejderPÅTeam
WHERE Team_Navn = 'Team Alfa'

-- Opgave 4
CREATE PROC FåMedarbejdere
@TeamNavn VARCHAR (10)
AS
SELECT *
From MedarbejderPÅTeam
WHERE Team_Navn = @TeamNavn

EXEC FåMedarbejdere 'Team ALFA'

DROP PROC FåMedarbejdere


-- Opgave 5 
CREATE PROC FindMedArbejderMed
@Char CHAR(1)
AS 
SELECT *
FROM Medarbejder M
WHERE m.navn LIKE @Char + '%'

EXEC FindMedArbejderMed 'D'

-- Opgave 6 

create table SlettedeMedarbejder(
medarbejderNr int primary key,
navn varchar(30),
stillingsbetegnelse varchar(30),
mobil char(10)
)

DROP TABLE SlettedeMedarbejder

CREATE TRIGGER TilføjTilSlettedeMedarbejder ON Medarbejder
INSTEAD OF DELETE 
AS
declare @medarbejderNr AS int
DECLARE @navn AS VARCHAR(30)
DECLARE @stillingsbetegnelse AS VARCHAR(30)
DECLARE @mobil AS CHAR(10)
set @medarbejderNr = (select medarbejderNr from Deleted)
set @navn = (select navn from Deleted)
set @stillingsbetegnelse = (select stillingsbetegnelse from Deleted)
set @mobil = (select mobil from Deleted)

INSERT INTO SlettedeMedarbejder  VALUES 
(@medarbejderNr, @navn , @stillingsbetegnelse, @mobil)


-- Kønnere løsning 
create trigger SletMedarbejder on Medarbejder
instead of Delete 
as
insert into
SlettedeMedarbejder
Select * from 
Deleted
-- Tak Gruppe 4 (HC OG Anders)


DELETE FROM Medarbejder
WHERE medarbejderNr = 12

SELECT * FROM SlettedeMedarbejder

-- Opgave 7 

SELECT *
FROM Medarbejder M
EXCEPT SELECT * FROM SlettedeMedarbejder SM

-- Opgave 8

CREATE VIEW OpgaverMedTidreg
AS
SELECT O.opgaveNr, O.deadline, P.projektnavn, M.navn
FROM Opgave O
INNER JOIN Projekt P ON O.projektNr = P.projektNr
INNER JOIN Tidsregistrering T ON O.opgaveNr = T.opgaveNr
INNER JOIN Medarbejder M ON M.medarbejderNr = T.medarbejderNr

-- Opgave 9 
CREATE PROC TidsregForMedarbejder
@Medarbejder VARCHAR(30)
AS
SELECT  O.opgaveNr, P.projektnavn,  O.deadline, T.datoRegistering
FROM Opgave O
INNER JOIN Projekt P ON O.projektNr = P.projektNr
INNER JOIN Tidsregistrering T ON O.opgaveNr = T.opgaveNr
INNER JOIN Medarbejder M ON M.medarbejderNr = T.medarbejderNr
WHERE M.navn = @Medarbejder

DROP PROC TidsregForMedarbejder

EXEC TidsregForMedarbejder 'Jennifer Lawrence'

-- Opgave 10
CREATE PROC SumTidsregForMedarbejder
@Medarbejder VARCHAR(30)
AS
SELECT SUM(DATEDIFF(hh, T.starttid,  T.sluttid))  -- Tids forskel
FROM Medarbejder M
INNER JOIN Tidsregistrering T ON M.medarbejderNr = T.opgaveNr
WHERE M.navn = @Medarbejder

EXEC SumTidsregForMedarbejder 'Jennifer Lawrence'



DROP PROC SumTidsregForMedarbejder


-- Opgave 11 

CREATE TRIGGER PrintTidsForskel ON Tidsregistrering
AFTER INSERT
AS
DECLARE @TidsForskel AS VARCHAR(20)
-- Set @TidsForskel = (SELECT (DATEDIFF(n,I.starttid, I.sluttid)) FROM INSERTED I) 
Set @TidsForskel = (SELECT CAST((DATEDIFF(MINUTE,(I.starttid), (I.sluttid)))/60 AS DECIMAL(6,2)) FROM INSERTED I) 


-- (SELECT DATEDIFF(hh,I.starttid, I.starttid) FROM INSERTED I)
PRINT('' + @TidsForskel + ' Timers forskel på start og stop') -- Brug '' før hvis det ikke er en char

-- PRINT 
INSERT INTO Tidsregistrering values 
('8:30', '16:00', 'Godt arbejde', '2019-08-04', 1, 1)

DROP TRIGGER  PrintTidsForskel


-- 03.03.21
-- Opgave 4 
CREATE PROC FåNavnOgMobil
AS
@id INT
SELECT M.navn, M.mobil FROM Medarbejder M

DROP PROC FåNavnOgMobil
SELECT M.medarbejderNr FROM Medarbejder M 
WHERE M.medarbejderNr = id

DROP PROC FåMedarbejdere
