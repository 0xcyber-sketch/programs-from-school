-- Opgave 2

CREATE TABLE Studerende(
id int primary key identity(1,1),
navn varchar(20)
)

CREATE TABLE Uddannelse(
id int primary key identity(1,1),
navn varchar(20)
)

CREATE TABLE Eksamen(
id int primary key identity(1,1),
navn varchar(20),
uddannelsesId int foreign key references Uddannelse(id)
)

CREATE TABLE Eksamensforsøg(
id int primary key identity(1,1),
karakter int check (karakter = -3 or karakter = 0 or karakter = 2 or karakter = 4 or karakter = 7 or karakter = 10 or karakter = 12),
eksamenId int foreign key references Eksamen(id),
studerendeId int foreign key references Studerende(id)
)


