USE { Lektion7 } 
[;]

-- Select Query 
-- Opgave 3 -- Opgave 3 Hvorfor kan den ikke laves med joins??? 




CREATE PROC SkuespillerNavnFraSerie
@titel VARCHAR(30)
AS
SELECT DISTINCT SP.navn
FROM Serie se
INNER JOIN Sæson sæ ON se.id = sæ.serieId
INNER JOIN Episode e ON sæ.id = e.sæsonId
INNER JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
INNER JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id
WHERE se.titel = @titel 

-- Big bang theory, Jaws
EXECUTE SkuespillerNavnFraSerie 'Big bang theory'
DROP PROC SkuespillerNavnFraSerie

SELECT * FROM SERIE se
RIGHT JOIN Sæson sæ ON se.id = sæ.serieId
RIGHT JOIN Episode e ON sæ.id = e.sæsonId
RIGHT JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
RIGHT JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id

-- Løsning uden joins
SELECT DISTINCT        s.navn
FROM                 Skuespiller s, SkuespillerEpisode se, Episode e, Sæson s2, Serie s3
WHERE                s.id = se.SkuespillerId
AND                    se.EpisodeId = e.id
AND                 e.SæsonId = s2.id
AND                 s2.SerieId = s3.id
AND                    s3.titel = 'Big bang theory'

-- Opgave 4


SELECT se.titel, ( COUNT( DISTINCT SP.id))
FROM Serie se
LEFT JOIN Sæson sæ ON se.id = sæ.serieId
LEFT JOIN Episode e ON sæ.id = e.sæsonId
LEFT JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
LEFT JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id
GROUP BY se.titel

-- Opgave 5 

CREATE VIEW SkuespillerNavnView
AS
SELECT DISTINCT SP.navn navn, sæ.sæsonnummer sæsonnummer, se.titel titel
FROM  Serie se
INNER JOIN Sæson sæ ON se.id = sæ.serieId
INNER JOIN Episode e ON sæ.id = e.sæsonId
INNER JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
INNER JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id



DROP VIEW SkuespillerNavnView

SELECT * FROM SkuespillerNavnView s WHERE s.sæsonnummer = 2 AND s.titel = 'Jaws'

-- Opgave 6 


CREATE PROC SkuespillerNavnFraSerie2
@titel VARCHAR(30),
@sæson INT
AS
SELECT   s.navn navn
FROM  SkuespillerNavnView s
WHERE s.sæsonnummer = @sæson AND s.titel = @titel

EXECUTE SkuespillerNavnFraSerie2 'Jaws', 2

-- Opgave 7 
CREATE VIEW SerieLængde
AS
SELECT se.titel, sæ.sæsonnummer, SUM(e.længde) AS længde
FROM Serie se
INNER JOIN Sæson sæ ON se.id = sæ.serieId
INNER JOIN Episode e ON sæ.id = e.sæsonId
INNER JOIN SkuespillerEpisode SKE ON e.id = SKE.EpisodeId
INNER JOIN Skuespiller SP ON SKE.SkuespillerId = SP.id
GROUP BY se.titel, sæ.sæsonnummer

DROP VIEW            FindSeasonLeangdeView

CREATE VIEW         FindSeasonLeangdeView
AS
SELECT                s.titel, s2.sæsonnummer, SUM(e.længde) AS længde
FROM                 Serie s 
INNER JOIN            Sæson s2 
ON                    s.id = s2.SerieId 
INNER JOIN             Episode e 
ON                    s2.id = e.SæsonId 
INNER JOIN             SkuespillerEpisode se 
ON                    e.id = se.EpisodeId 
INNER JOIN             Skuespiller s3 
ON                    se.SkuespillerId = s3.id 
GROUP BY             s.titel, s2.sæsonnummer 

SELECT * FROM SerieLængde
SELECT * From Serie

-- Opgave 8

CREATE PROC FindLængde2
@serie VARCHAR(30),
@sæson INT
AS
SELECT la.længde
FROM FindSeasonLeangdeView la
WHERE la.titel = @serie AND la.sæsonnummer = @sæson

EXECUTE FindLængde2 'Jaws', 1
DROP PROC FindLængde2

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

CREATE PROC findFællesSkuespillere
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

DROP PROC findFællesSkuespillere
EXECUTE findFællesSkuespillere 'Jaws', 'Jaws'

-- Opgave 12

CREATE PROC FindAlderPåSkuespiller
@navn VARCHAR(30)
AS
SELECT  DATEDIFF (YEAR,  s.fødselsår, GETDATE()) AS alder
FROM Skuespiller s 
WHERE  s.navn = @navn

EXECUTE FindAlderPåSkuespiller 'Michael'
DROP PROC FindAlderPåSkuespiller
