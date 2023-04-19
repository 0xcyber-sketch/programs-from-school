-- Drop / Delete
DROP TABLE testTabel;


-- Create
CREATE TABLE testTabel(
id int primary key,
floatNumber decimal(6,2),
town Varchar(20) check (town in ('Los Angeles', 'New York')),
att4 CHAR(3) NOT NULL,
att5 TINYINT,
dato DATE,
boolean CHAR(1) CHECK (boolean in (0,1)),
bitt BIT NOT NULL,
tal INTEGER check (tal > 5) 
);

-- Select data
SELECT * FROM testTabel

-- Insert data
INSERT INTO  testTabel VALUES
(1, 3.665427, 'New York' , 'A45', 255, '2021-10-02', 1, 0, 6),
(2, 5.2, 'New York', 'EAS', 8, GETDATE(), 1, 2, 209)

-- INSERT INTO testTAbel (boolean, tal) VALUES

SELECT id, dato FROM testTabel WHERE id > 1
WAITFOR DELAY '00:00:10:00' -- Sleep
SELECT id, dato FROM testTabel 
ORDER BY id DESC
