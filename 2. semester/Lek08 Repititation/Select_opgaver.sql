USE { Lektion7 } 
[;]

-- Select Query 
-- Opgave 3 -- Opgave 3 Hvorfor kan den ikke laves med joins??? 




CREATE PROC SkuespillerNavnFraSerie
@titel VARCHAR(30)
AS
SELECT DISTINCT SP.navn
FROM Serie se
INNER JOIN S�son s� ON se.id = s�.serieId
INNER JOIN Episode e ON s�.id = e.s�sonId
INNER JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
INNER JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id
WHERE se.titel = @titel 

-- Big bang theory, Jaws
EXECUTE SkuespillerNavnFraSerie 'Big bang theory'
DROP PROC SkuespillerNavnFraSerie

SELECT * FROM SERIE se
RIGHT JOIN S�son s� ON se.id = s�.serieId
RIGHT JOIN Episode e ON s�.id = e.s�sonId
RIGHT JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
RIGHT JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id

-- L�sning uden joins
SELECT DISTINCT        s.navn
FROM                 Skuespiller s, SkuespillerEpisode se, Episode e, S�son s2, Serie s3
WHERE                s.id = se.SkuespillerId
AND                    se.EpisodeId = e.id
AND                 e.S�sonId = s2.id
AND                 s2.SerieId = s3.id
AND                    s3.titel = 'Big bang theory'

-- Opgave 4


SELECT se.titel, ( COUNT( DISTINCT SP.id))
FROM Serie se
LEFT JOIN S�son s� ON se.id = s�.serieId
LEFT JOIN Episode e ON s�.id = e.s�sonId
LEFT JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
LEFT JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id
GROUP BY se.titel

-- Opgave 5 

CREATE VIEW SkuespillerNavnView
AS
SELECT DISTINCT SP.navn navn, s�.s�sonnummer s�sonnummer, se.titel titel
FROM  Serie se
INNER JOIN S�son s� ON se.id = s�.serieId
INNER JOIN Episode e ON s�.id = e.s�sonId
INNER JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
INNER JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id



DROP VIEW SkuespillerNavnView

SELECT * FROM SkuespillerNavnView s WHERE s.s�sonnummer = 2 AND s.titel = 'Jaws'

-- Opgave 6 


CREATE PROC SkuespillerNavnFraSerie2
@titel VARCHAR(30),
@s�son INT
AS
SELECT   s.navn navn
FROM  SkuespillerNavnView s
WHERE s.s�sonnummer = @s�son AND s.titel = @titel

EXECUTE SkuespillerNavnFraSerie2 'Jaws', 2

-- Opgave 7 
CREATE VIEW SerieL�ngde
AS
SELECT se.titel, s�.s�sonnummer, SUM(e.l�ngde) AS l�ngde
FROM Serie se
INNER JOIN S�son s� ON se.id = s�.serieId
INNER JOIN Episode e ON s�.id = e.s�sonId
INNER JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
INNER JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id
GROUP BY se.titel, s�.s�sonnummer

DROP VIEW            FindSeasonLeangdeView

CREATE VIEW         FindSeasonLeangdeView
AS
SELECT                s.titel, s2.s�sonnummer, SUM(e.l�ngde) AS l�ngde
FROM                 Serie s 
INNER JOIN            S�son s2 
ON                    s.id = s2.SerieId 
INNER JOIN             Episode e 
ON                    s2.id = e.S�sonId 
INNER JOIN             SkuespillerEpisode se 
ON                    e.id = se.EpisodeId 
INNER JOIN             Skuespiller s3 
ON                    se.SkuespillerId = s3.id 
GROUP BY             s.titel, s2.s�sonnummer 

SELECT * FROM SerieL�ngde
SELECT * From Serie

-- Opgave 8

CREATE PROC FindL�ngde2
@serie VARCHAR(30),
@s�son INT
AS
SELECT la.l�ngde
FROM FindSeasonLeangdeView la
WHERE la.titel = @serie AND la.s�sonnummer = @s�son

EXECUTE FindL�ngde2 'Jaws', 1
DROP PROC FindL�ngde2

-- Opgave 9 

CREATE TRIGGER updateNavn ON Skuespiller
AFTER UPDATE
AS
DECLARE @gammel VARCHAR(30) 
SET @gammel = (Select navn FROM Deleted)
DECLARE @nyt VARCHAR(30) 
SET @nyt = (Select navn FROM Inserted)

Print @gammel + ' ' + @nyt

-- Opgave 10 

CREATE PROC findF�llesSkuespillere
@Serie1 VARCHAR(30),
@Serie2 VARCHAR(30)
AS
SELECT s.navn navn
FROM SkuespillerNavnView s
WHERE s.titel = @Serie1
INTERSECT 
SELECT s2.navn navn
FROM SkuespillerNavnView s2
WHERE s2.titel = @Serie2

DROP PROC findF�llesSkuespillere
EXECUTE findF�llesSkuespillere 'Jaws', 'Jaws'

-- Opgave 12

CREATE PROC FindAlderP�Skuespiller
@navn VARCHAR(30)
AS
SELECT  DATEDIFF (YEAR,  s.f�dsels�r, GETDATE()) AS alder
FROM Skuespiller s 
WHERE  s.navn = @navn

EXECUTE FindAlderP�Skuespiller 'Michael'
DROP PROC FindAlderP�Skuespiller
