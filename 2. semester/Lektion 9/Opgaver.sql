USE [Lek09RelationelAlgebra]

-- Opgave 1

SELECT s.sname _Name
FROM Sailors S
INNER JOIN Reserves R ON S.said = R.said
WHERE R.bid = 103

Select S.sname From Sailors S, Reserves R where s.said=R.said and R.bid=103

-- Opgave 2

SELECT  B.color
FROM Sailors S
INNER JOIN Reserves R ON S.said = R.said
INNER JOIN Boats B ON R.bid = B.bid
WHERE S.sname = 'Lubber'

-- Opgave 3
SELECT DISTINCT S.said, S.sname, S.rating
FROM Sailors S
LEFT JOIN Reserves R ON S.said = R.said
LEFT JOIN Boats B ON R.bid = B.bid
WHERE S.rating >= 8 OR R.bid = 103

select said from Sailors where rating >7 union select said from Reserves where bid =103


-- Opgave 4 
SELECT S.said, S.sname
FROM Sailors S
EXCEPT
SELECT S.said, S.sname
FROM Sailors S
LEFT JOIN Reserves R ON S.said = R.said
LEFT JOIN Boats B ON R.bid = B.bid
WHERE B.color = 'red'


-- Opgave 5
SELECT S.said, S.sname
FROM Sailors S
WHERE s.age > 20
EXCEPT
SELECT S.said, S.sname
FROM Sailors S
INNER JOIN Reserves R ON S.said = R.said
INNER JOIN Boats B ON R.bid = B.bid
WHERE B.color != 'red' 

-- Opgave 6

SELECT S.said
FROM Sailors S
WHERE S.rating > (SELECT MAX(S.rating) FROM Sailors S WHERE S.sname = 'Horatio')





-- Opgave 7 
SELECT S.said
FROM Sailors S
WHERE S.rating > (SELECT MAX(S.rating) FROM Sailors S WHERE S.sname = 'Horatio')

-- Opgave 8
SELECT S.said
FROM Sailors S
WHERE S.rating = (SELECT MAX(S.rating) FROM Sailors S)



-- Opgave 9

SELECT S.said, S.sname, B.bid
FROM Sailors S
INNER JOIN Reserves R ON S.said = R.said
INNER JOIN Boats B ON R.bid = B.bid
WHERE B.color = 'red' 




