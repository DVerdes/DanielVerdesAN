CREATE TABLE Item (
    ItemID INT PRIMARY KEY IDENTITY,
	Tipo VARCHAR(100),
    Nombre VARCHAR(100),
    Genero VARCHAR(100),
    Autor VARCHAR(255),
	Duracion INT,
    RutaPortada VARCHAR(100),
    Estreno INT,
    Sinopsis VARCHAR(100)  
);

CREATE TABLE Review (
    ReviewID INT PRIMARY KEY IDENTITY,
    ItemID INT,
    Usuario VARCHAR(100),
    Puntuacion INT,
	Contenido VARCHAR(50),
    FOREIGN KEY (ItemID) REFERENCES Item(ItemID)
);