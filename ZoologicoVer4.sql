-- ///////////////////////////////////////////////////
-- ES NECESARIO QUE CORRAN ESTA PARTE DEL PROGRAMA PARA CREA UN 
-- USUARIO COMUN EN LA BBDD DE TODOS
CREATE USER 'programador'@'localhost' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON * . * TO 'programador'@'localhost';
FLUSH PRIVILEGES;
-- /////////////////////////////////////////////////
-- LA SIGUIENTE INSTRUCCION SE TIENE QUE EJECUTAR SIEMPRE QUE SE EJECUTE LA BBDD POR PRIMERA VEZ 
-- ES DECIR CADA VEZ QUE ENCIENDES LA PC 
SET GLOBAL time_zone = '+8:00';

-- SCRIPT PARA CREAR LA BBDD
drop database Zoologico;
create database Zoologico;
use Zoologico;


CREATE TABLE Veterinario (
    VET_VeterinarioID INT NOT NULL AUTO_INCREMENT,
    VET_Nombre VARCHAR(15) NOT NULL,
    VET_Nombre2 VARCHAR(15),
    VET_Apellido1 VARCHAR(20) NOT NULL,
    VET_Apellido2 VARCHAR(20) NOT NULL,
    VET_Correo VARCHAR(20) NOT NULL,
    VET_Cedula VARCHAR(8) NOT NULL,
    VET_Telefono VARCHAR(10) NOT NULL,
    CONSTRAINT pk_VETERINARIO PRIMARY KEY (VET_VeterinarioID)
);

CREATE TABLE Cuidador (
    CUI_CuidadorId INT NOT NULL AUTO_INCREMENT,
    CUI_Nombre VARCHAR(15) NOT NULL,
    CUI_Nombre2 VARCHAR(15),
    CUI_Apellido1 VARCHAR(20) NOT NULL,
    CUI_Apellido2 VARCHAR(20) NOT NULL,
    CUI_Sueldo FLOAT NOT NULL CHECK (CUI_Sueldo >= 862.54
        AND CUI_Sueldo <= 10000),
    CONSTRAINT pk_CUIDADOR PRIMARY KEY (CUI_CuidadorID)
);

CREATE TABLE Clima (
    CLI_ClimaID INT NOT NULL AUTO_INCREMENT,
    CLI_Nombre VARCHAR(9) NOT NULL,
    CLI_Humedad_Min INT NOT NULL,
    CLI_Humedad_Max INT NOT NULL,
    CLI_Temp_Min INT NOT NULL,
    CLI_Temp_Max INT NOT NULL,
    CONSTRAINT CLI_nombre CHECK (CLI_nombre IN ('Arido' , 'Frio', 'Templado', 'Tropical')),
    CONSTRAINT pk_CLIMA PRIMARY KEY (CLI_ClimaID)
);

CREATE TABLE Habitat (
    HAB_HabitatID INT NOT NULL AUTO_INCREMENT,
    HAB_ClimaID INT,
    HAB_CuidadorID INT,
    HAB_Nombre VARCHAR(20) NOT NULL,
    HAB_Disponibilidad VARCHAR(11) NOT NULL,
    CONSTRAINT pk_HABITAT PRIMARY KEY (HAB_HabitatID),
    CONSTRAINT HAB_disponibilidad CHECK (HAB_disponibilidad IN ('disponible' , 'ocupado')),
    CONSTRAINT fk_REGISTRA_CLIMA FOREIGN KEY (HAB_ClimaID)
        REFERENCES Clima (CLI_ClimaID)
        ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_HABITAT_CUIDADOR FOREIGN KEY (HAB_CuidadorID)
        REFERENCES Cuidador (CUI_CuidadorID)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Registra (
    RHA_RegistroID INT NOT NULL AUTO_INCREMENT,
    RHA_HabitatID INT,
    RHA_Temperatura FLOAT NOT NULL CHECK (RHA_Temperatura >= 0
        AND RHA_Temperatura <= 100),
    RHA_Humedad FLOAT NOT NULL CHECK (RHA_Humedad >= 0 AND RHA_Humedad <= 100),
    RHA_Fecha_registro DATETIME NOT NULL,
    CONSTRAINT pk_REGISTRA PRIMARY KEY (RHA_RegistroID),
    CONSTRAINT fk_REGISTRA_HABITAT FOREIGN KEY (RHA_HabitatID)
        REFERENCES Habitat (HAB_HabitatID)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE Animal (
    ANI_AnimalID INT NOT NULL AUTO_INCREMENT,
    ANI_CuidadorID INT,
    ANI_HabitatID INT NOT NULL,
    ANI_Nombre VARCHAR(20) NOT NULL,
    ANI_Alimentacion VARCHAR(20) NOT NULL,
    ANI_Anyo_cautiverio INT NOT NULL,
    ANI_Especie VARCHAR(15) NOT NULL,
    ANI_Sexo VARCHAR(1) NOT NULL,
    ANI_Edad INT NOT NULL,
    ANI_Peso FLOAT NOT NULL,
    ANI_Observaciones VARCHAR(50) NOT NULL,
    CONSTRAINT ANI_sexo CHECK (ANI_sexo IN ('H' , 'M')),
    CONSTRAINT pk_ANIMAL PRIMARY KEY (ANI_AnimalID),
    CONSTRAINT fk_ANIMAL_CUIDADOR FOREIGN KEY (ANI_CuidadorID)
        REFERENCES Cuidador (CUI_CuidadorID)
        ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_ANIMAL_HABITAT FOREIGN KEY (ANI_HabitatID)
        REFERENCES Habitat (HAB_HabitatID)
        ON UPDATE CASCADE
);

CREATE TABLE Procedencia_Foranea (
    FOR_AnimalID INT NOT NULL,
    FOR_Nom_zoo VARCHAR(20) NOT NULL,
    FOR_Fecha_traslado DATE NOT NULL,
    CONSTRAINT pk_PROCENDECIA_FORANEA PRIMARY KEY (FOR_AnimalID),
    CONSTRAINT fk_FORANEA_ANIMAL FOREIGN KEY (FOR_AnimalID)
        REFERENCES Animal (ANI_AnimalID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Procedencia_Rescate (
    RES_AnimalID INT NOT NULL,
    RES_Edad_rescate INT NOT NULL,
    RES_Condicion VARCHAR(5) NOT NULL,
    RES_Fecha_rescate DATE NOT NULL,
    CONSTRAINT RES_condicion CHECK (RES_condicion IN ('buena' , 'mala')),
    CONSTRAINT pk_PROCEDENCIA_FORANEA PRIMARY KEY (RES_AnimalID),
    CONSTRAINT fk_RESCATE_ANIMAL FOREIGN KEY (RES_AnimalID)
        REFERENCES Animal (ANI_AnimalID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Procedencia_Local (
    LOC_AnimalID INT NOT NULL,
    LOC_VeterinarioID INT NOT NULL,
    LOC_Fecha_nacimiento DATE NOT NULL,
    LOC_Peso_nacimiento FLOAT NOT NULL,
    CONSTRAINT pk_PROCEDENCIA_LOCAL PRIMARY KEY (LOC_AnimalID),
    CONSTRAINT fk_LOCAL_ANIMAL FOREIGN KEY (LOC_AnimalID)
        REFERENCES Animal (ANI_AnimalID)
        ON DELETE CASCADE,
    CONSTRAINT fk_LOCAL_VETERINARIO FOREIGN KEY (LOC_VeterinarioID)
        REFERENCES Veterinario (VET_VeterinarioID)
);

CREATE TABLE Registro_ONG (
    REG_ActividadID INT NOT NULL,
    REG_Aprobacion VARCHAR(12) NOT NULL,
    REG_Ong_nombre VARCHAR(20) NOT NULL,
    REG_Nombre_actividad VARCHAR(15) NOT NULL,
    REG_Desc_actividad VARCHAR(300) NOT NULL,
    REG_Fecha_solicitud DATE NOT NULL,
    REG_Hora_apertura TIME NOT NULL,
    REG_Hora_cierre TIME NOT NULL,
    REG_HabitatID INT NOT NULL,
    CONSTRAINT pk_REG_ACTIVIDAD PRIMARY KEY (REG_ActividadID),
    CONSTRAINT fk_ONG_HABITAT FOREIGN KEY (REG_HabitatID)
        REFERENCES Habitat (HAB_HabitatID)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE ONG_Realiza (
    REA_ActividadID INT NOT NULL,
    REA_Dia VARCHAR(10) NOT NULL,
    CONSTRAINT REA_dia CHECK (REA_dia IN ('martes',
        'miercoles',
        'jueves',
        'viernes',
        'sabado',
        'domingo')),
    CONSTRAINT fk_REALIZA_REGISTRO FOREIGN KEY (REA_ActividadID)
        REFERENCES Registro_ONG (REG_ActividadID) 
		ON DELETE CASCADE
);


CREATE TABLE Revisa_Animal (
    REV_id INT NOT NULL AUTO_INCREMENT,
    REV_VeterinarioID INT NOT NULL,
    REV_AnimalID INT NOT NULL,
    REV_Fecha_Revision DATE NOT NULL,
    CONSTRAINT pk_REVISA_ANIMAL PRIMARY KEY (REV_id),
    CONSTRAINT fk_REVISA_VETERINARIO FOREIGN KEY (REV_VeterinarioID)
        REFERENCES Veterinario (VET_VeterinarioID),
    CONSTRAINT fk_REVISA_ANIMAL FOREIGN KEY (REV_AnimalID)
        REFERENCES Animal (ANI_AnimalID)
);

-- ///////////////////////////////////////////////////
-- VISTAS DE LA BASE DE DATOS ---

create view ultimaVisita as 
select max(REV_id) as IDRevision, REV_Fecha_Revision VET_nombre, VET_Apellido1, VET_Apellido2, ANI_nombre  from Revisa_Animal
inner join Veterinario
on Veterinario.VET_VeterinarioID = Revisa_Animal.REV_VeterinarioID
inner join Animal
on Animal.ANI_AnimalID = Revisa_Animal.REV_AnimalID;

select * from ultimaVisita;
-- //////////////////////////////////////////////////////

-- //////////////////////////////////////////////////////
-- PROCEDIMIENTOS ALMACENADOS

delimiter $$
create procedure ultimaVisita() begin 
select max(REV_id) as IDRevision, VET_nombre, VET_Apellido1, VET_Apellido2, ANI_nombre  from Revisa_Animal
inner join nombreveterinario 
on nombreveterinario.VET_VeterinarioID = Revisa_Animal.REV_VeterinarioID
inner join nombreAnimal
on nombreAnimal.ANI_AnimalID = Revisa_Animal.REV_AnimalID;
end$$
delimiter ;

call ultimaVisita();


-- /////////////////////////////////
-- CREACION DEL TRIGGER PARA HABITAT
delimiter $$
create trigger disponibilidad_habitat after insert on Registro_ONG
	for each row 
    begin
    set @aux:= (select REG_HabitatId from Registro_ONG inner join Habitat
    on Registro_ONG.REG_HabitatID = Habitat.HAB_HabitatId where Habitat.HAB_Disponibilidad != 'ocupado');
    update Habitat set HAB_Disponibilidad = 'ocupado' 
    where HAB_HabitatId = @aux; 
    end
;
$$

drop trigger disponibilidad_habitat;

-- //////////
-- TRIGGER EN CASO DE QUE SE ELIME ALGUN REGISTRO DE REGISTRO_ONG
delimiter $$
create trigger eliminar_disponibilidad_habitat after delete on Registro_ONG
	for each row
	begin
    set @aux:= (select REG_HabitatId from Registro_ONG inner join Habitat
    on Registro_ONG.REG_HabitatID = Habitat.HAB_HabitatId where Habitat.HAB_Disponibilidad = 'ocupado');
    update Habitat set HAB_Disponibilidad = 'disponible' 
    where HAB_HabitatId = @aux; 
	end
;
$$

drop trigger eliminar_disponibilidad_habitat;

-- DATOS NECESSARIOS QUE NO PUEDEN SER REGISTRADOS EN LA APLICACION 

insert into clima values (1,'Arido',0,5,40,45),
(2,'Frio',0,2,0,5),
(3,'Templado',10,15,20,25),
(4,'Tropical',50,60,30,35);

insert into Cuidador values (1,'Mario','Albert','Dominguez','Junco',1000.50);

insert into Habitat values (1,4,1,'leones','disponible');
insert into Habitat values (2,4,1,'aves','disponible');

insert into Veterinario values(1,'Rodrigo','Angeles','Garcia','Zenon','rodangel@gmail.com','CED12345','5519038167');
select max(ANI_AnimalID) as id from Animal;



-- Pruebas
select *from Registro_ONG;
select *from Habitat


