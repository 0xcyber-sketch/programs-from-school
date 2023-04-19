USE { Lektion3 }
[;]

-- Løsning A 

CREATE TABLE Nedarving_A(
-- Superclass Beboelse 
kvm INT PRIMARY KEY,
adresse VARCHAR(30),
-- SUB 1 Lejlighed
sal INT NOT NULL,
antalVærelser INT,
-- Sub 2 Hus
grundKVM INT NOT NULL,
carPort VARCHAR(30),

typee VARCHAR(15) 
)

-- Løsning B
-- sub 1
CREATE TABLE Nedarving_b1(
kvm INT PRIMARY KEY,
adresse VARCHAR(30),
sal INT NOT NULL,
antalVærelser INT
)
-- sub 2
CREATE TABLE Nedarving_b2(
kvm INT PRIMARY KEY,
adresse VARCHAR(30),
grundKVM INT NOT NULL,
carPort VARCHAR(30),
)

-- Løsning c

CREATE TABLE Super(
kvm INT PRIMARY KEY,
adresse VARCHAR(30),
)

CREATE TABLE Sub_1(
sal INT NOT NULL,
antalVærelser INT,
kvm INT FOREIGN KEY REFERENCES Super(kvm)

)

CREATE TABLE Sub_2(
grundKVM INT NOT NULL,
carPort VARCHAR(30),
kvm INT FOREIGN KEY REFERENCES Super(kvm
)