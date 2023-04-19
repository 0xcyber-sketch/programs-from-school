USE { Lektion7 } 
[;]
--INSERT lektion 7 


INSERT INTO Skuespiller VALUES 
('Emil', '2010'),
( 'Mikkel', '1995'),
( 'Magnus G', '1997'),
('Ivar', '1995'),
( 'Furkan', '1997'),
( 'Jacob', '1997'),
( 'Michael', '1963'),
( 'Tim', '1990'),
( 'Bare Magnus', '1993'),
( 'HC', '1996')

INSERT INTO serie VALUES('Jaws', 'universal studios')
INSERT INTO serie VALUES('Big bang theory', 'paramore studios')
INSERT INTO serie VALUES('Big bankl theory', 'paramore studios')

INSERT INTO Sæson VALUES
('2012-03-04', '2013-01-02', 1, 1),
('2013-03-04', '2014-01-02', 2, 1),
('2017-03-04', '2018-01-02', 1, 2),
('2018-04-04', '2019-01-02', 2, 2)


INSERT INTO Episode VALUES 
( 1, 50, 'I', 1),
( 2, 52, 'II', 1),
( 3, 49, 'III', 1),
( 4, 40, 'IV', 1),
( 5, 60, 'V', 1),
( 1, 55, 'VI', 2),
( 2, 54, 'VII', 2),
( 3, 53, 'VIII', 2),
( 4, 59, 'IX', 2),
( 5, 79, 'X', 2),
( 1, 120, 'Vennerne mødes', 3),
( 2, 110, 'Familien mødes', 3),
( 3, 101, 'Fjenderne mødes', 3),
( 4, 103, 'Heltene mødes', 3),
( 5, 104, 'Frøerne mødes', 3),
( 1, 120, 'Trænerne mødes', 4),
( 2, 133, 'Kvinderne mødes', 4),
( 3, 135, 'Mændene mødes', 4),
( 4, 144, 'Hundene mødes',4),
( 5, 210, 'De andre mødes', 4)



INSERT INTO SkuespillerEpisode VALUES
(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3), (4, 1),
(4, 2), (4, 3), (5, 1), (5, 2), (5, 3), (6, 1), (6, 2), (6, 3), (7, 1), (7, 2),
(7, 4), (8, 1), (8, 5), (8, 4), (9, 1), (9, 5), (9, 4), (10, 1), (10, 2), (10, 6),
(11, 4), (11, 5), (11, 6), (12, 4), (12, 5), (12, 6), (13, 4), (13, 5), (13, 6), (14, 4),
(14, 5), (14, 6), (15, 1), (15, 2), (15, 3), (16, 1), (16, 2), (16, 3), (17, 4), (17, 5),
(17, 6), (18, 4), (18, 7), (18, 8), (19, 4), (19, 9), (19, 10), (20, 4), (20, 1), (20, 8)

-- Opgave 9 test
UPDATE Skuespiller SET navn = 'Hej' WHERE Skuespiller.id = 2;