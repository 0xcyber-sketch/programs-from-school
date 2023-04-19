INSERT INTO Klub VALUES
('KIF', 'Kirkeby IF'),
('ABK', 'Aarslev BK'),
('SU', 'SUB Ullerslev'),
('TFB', 'Tåsinge FB'),
('FCB', 'FC Broby')



insert into Hold values
(1, 'U12 Piger', 11, 'KIF'),
(2, '2. Holdet', 14, 'KIF'),
(3, 'U14 Drenge', 13, 'ABK'),
(4, 'U10 Piger', 14, 'ABK'),
(5, '1. Holdet', 9, 'ABK'),
(6, '2. Holdet', 14, 'SU'),
(7, 'U8 Drenge', 7, 'SU'),
(8, '2. Holdet', 9, 'TFB'),
(9, 'U10 Piger', 11, 'TFB'),
(10, '1. Holdet', 14, 'TFB'),
(11, 'U14 Drenge', 7, 'FCB'),
(12, 'U12 Piger', 8, 'FCB')


insert into Medlem values
(1, 'Peter', 35),
(2, 'Jens', 8),
(3, 'Ulla', 9),
(4, 'Kim', 10),
(5, 'Fin', 12),
(6, 'Bente', 14),
(7, 'Pia', 15),
(8, 'Karen', 28),
(9, 'Lise', 27)


insert into Medlem values
(10, 'Ole', 10),
(11, 'Niels', 11),
(12, 'Åse', 7),
(13, 'Tina', 16),
(14, 'Lene', 19),
(15, 'Erik', 12),
(16, 'Ron', 14),
(17, 'Ryan', 15),
(18, 'Arie', 18),
(19, 'Andres', 56)


insert into Medlem values
(20, 'Arne', 14),
(21, 'Bob', 21),
(22, 'Alice', 7),
(23, 'Bo', 10),
(24, 'Dennis', 18),
(25, 'Allan', 16),
(26, 'Rikke', 14),
(27, 'Pernille', 45),
(28, 'Rasmus', 42),
(29, 'Hans', 13)

insert into HoldMedlem values
(10,1),
(7,2),
(9,3),
(7,4),
(11,5),
(1,6),
(5,7),
(5,8),
(5,9)

insert into HoldMedlem values
(7,10),
(7,11),
(9,12),
(6,13),
(6,14),
(11,15),
(11,16),
(10,17),
(10,18),
(10,19)

insert into HoldMedlem values
(11,20),
(2,21),
(4,22),
(7,23),
(2,24),
(2,25),
(8,26),
(8,27),
(11,28),
(11,29)

-- Opgaver 12-02-21
SELECT holdNavn, antal FROM Hold

SELECT holdNavn, antal FROM Hold WHERE klubId = 'ABK' 

SELECT * FROM Medlem WHERE alder > 20 -- Vælg alle over 20

UPDATE Medlem SET alder=11 WHERE alder=10 -- Update

INSERT INTO Medlem values (30, 'Klaus', 20)

INSERT INTO HoldMedlem values (9, 30)

DELETE FROM Medlem Where navn = 'Klaus'


SELECT COUNT(Holdnavn) FROM Hold

SELECT navn, alder FROM Medlem WHERE alder =  (SELECT MIN(alder) FROM Medlem)

SELECT h.holdnavn, (SELECT COUNT(hm.holdID) FROM holdmedlem hm WHERE h.holdId = hm.holdId) AS antal FROM hold h;

SELECT h.holdId, h.holdnavn, COUNT(hm.holdId) as antal FROM hold h
LEFT JOIN holdmedlem hm
ON h.holdId = hm.holdId 
GROUP BY h.holdId, h.holdNavn;

SELECT DISTINCT Klub.navn FROM Klub INNER JOIN Hold ON Hold.KlubId = Klub.KlubId WHERE antal > 10;

SELECT klub.navn FROM klub WHERE EXISTS (SELECT Hold.holdNavn, antal FROM Hold WHERE Hold.KlubId = Klub.KlubId AND antal >10);

-- 24-02-21

-- SELECT m.navn FROM medlem

CREATE PROC MedlemmerPaaHolde
@id int
AS 
SELECT m.navn
FROM Medlem m
INNER JOIN HoldMedlem hm
ON m.medlemsId = hm.medlemsId
WHERE hm.holdId = @id

DROP PROC MedlemmerPaaHolde
EXEC MedlemmerPaaHolde, 2


DROP PROC MedlemmerPaaHolde
EXEC MedlemmerPaaHolde 3 


SELECT M.medlemsId, M.navn, K.navn, H.holdNavn
FROM Medlem M, HoldMedlem HM, Hold H, Klub K

-- View
-- Være opmærksom på at to kolloner må ikke hedde det samme i views
CREATE VIEW AlleMedlemmer
AS
SELECT M.medlemsId, M.navn, K.navn, H.holdNavn
FROM Medlem M, HoldMedlem HM, Hold H, Klub K



-- data 
insert into Medlem values
(50, 'Karl', 56)

insert into HoldMedlem values
(1, 50),
(2, 50)

-- trigger
CREATE TRIGGER SletMedlem ON Medlem
INSTEAD OF DELETE
AS
DELETE FROM HoldMedlem
WHERE medlemsId = (SELECT medlemsId FROM DELETED)
DELETE FROM Medlem
WHERE medlemsId = (SELECT medlemsId FROM DELETED)


DROP TRIGGER SletMedlem

DELETE FROM Medlem
WHERE medlemsId = 50

