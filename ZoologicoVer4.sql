-- ///////////////////////////////////////////////////
-- ES NECESARIO QUE CORRAN ESTA PARTE DEL PROGRAMA PARA CREA UN 
-- USUARIO COMUN EN LA BBDD DE TODOS
CREATE USER 'programador'@'localhost' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON * . * TO 'programador'@'localhost';
FLUSH PRIVILEGES;
-- /////////////////////////////////////////////////
-- LA SIGUIENTE INSTRUCCION SE TIENE QUE EJECUTAR SIEMPRE QUE SE EJECUTE LA BBDD POR PRIMERA VEZ 
-- ES DECIR CADA VEZ QUE ENCIENDES LA PC 
SET GLOBAL time_zone = '-6:00';

-- SCRIPT PARA CREAR LA BBDD
create database Zoologico;
use Zoologico;

CREATE TABLE Veterinario (
    VET_VeterinarioID INT NOT NULL AUTO_INCREMENT,
    VET_Nombre VARCHAR(15) NOT NULL,
    VET_Nombre2 VARCHAR(15),
    VET_Apellido1 VARCHAR(20) NOT NULL,
    VET_Apellido2 VARCHAR(20) NOT NULL,
    VET_Correo VARCHAR(50) NOT NULL,
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
        ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE Animal (
    ANI_AnimalID INT NOT NULL AUTO_INCREMENT,
    ANI_CuidadorID INT,
    ANI_HabitatID INT NOT NULL,
    ANI_Nombre VARCHAR(20) NOT NULL,
    ANI_Alimentacion VARCHAR(20) NOT NULL,
    ANI_Anyo_cautiverio INT NOT NULL,
    ANI_Especie VARCHAR(40) NOT NULL,
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
        ON UPDATE CASCADE ON DELETE CASCADE
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
        ON DELETE CASCADE
);

CREATE TABLE Registro_ONG (
    REG_ActividadID INT NOT NULL,
    REG_Aprobacion VARCHAR(12) NOT NULL,
    REG_Ong_nombre VARCHAR(20) NOT NULL,
    REG_Nombre_actividad VARCHAR(15) NOT NULL,
    REG_Desc_actividad VARCHAR(300) NOT NULL,
    REG_Fecha_solicitud DATE NOT NULL,
    REG_Hora_apertura TIME NOT NULL CHECK (REG_Hora_apertura >= CAST('11:00:00' AS TIME)
        AND REG_Hora_apertura < CAST('16:00:00' AS TIME)),
    REG_Hora_cierre TIME NOT NULL CHECK (REG_Hora_cierre > CAST('11:00:00' AS TIME)
        AND REG_Hora_cierre <= CAST('16:00:00' AS TIME)),
    REG_HabitatID INT NOT NULL,
    CONSTRAINT REG_Aprobacion CHECK (REG_Aprobacion IN ('Aprobado' , 'No Aprobado')),
    CONSTRAINT pk_REG_ACTIVIDAD PRIMARY KEY (REG_ActividadID),
    CONSTRAINT fk_ONG_HABITAT FOREIGN KEY (REG_HabitatID)
        REFERENCES Habitat (HAB_HabitatID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE ONG_Realiza (
    REA_ActividadID INT NOT NULL,
    REA_Dia VARCHAR(10) NOT NULL,
    CONSTRAINT REA_dia CHECK (REA_dia IN ('martes' , 'miercoles',
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
    REV_Observaciones VARCHAR(50) NOT NULL,
    REV_Fecha_Revision DATE NOT NULL,
    CONSTRAINT pk_REVISA_ANIMAL PRIMARY KEY (REV_id),
    CONSTRAINT fk_REVISA_VETERINARIO FOREIGN KEY (REV_VeterinarioID)
        REFERENCES Veterinario (VET_VeterinarioID)
        ON DELETE NO ACTION,
    CONSTRAINT fk_REVISA_ANIMAL FOREIGN KEY (REV_AnimalID)
        REFERENCES Animal (ANI_AnimalID)
        ON DELETE NO ACTION
);



-- ///////////////////////////////////////////////////
-- ////////  VISTAS DE LA BASE DE DATOS  /////////////
-- ///////////////////////////////////////////////////


CREATE VIEW ultimaVisita AS
    SELECT 
        VET_nombre,
        VET_Apellido1,
        VET_Apellido2,
        ANI_nombre,
        REV_Fecha_Revision
    FROM
        Revisa_Animal
            INNER JOIN
        Veterinario ON Veterinario.VET_VeterinarioID = Revisa_Animal.REV_VeterinarioID
            INNER JOIN
        Animal ON Animal.ANI_AnimalID = Revisa_Animal.REV_AnimalID
    ORDER BY REV_id DESC
    LIMIT 1;

-- //////////////////////////////////////////////////////////////////////////

CREATE VIEW ultimoRegistro AS
    SELECT 
        RHA_temperatura, RHA_humedad, HAB_nombre, RHA_Fecha_Registro
    FROM
        Registra
            INNER JOIN
        Habitat ON Habitat.HAB_HabitatID = Registra.RHA_HabitatID
    ORDER BY RHA_RegistroID DESC
    LIMIT 1;

-- //////////////////////////////////////////////////////////////////////////

CREATE VIEW ultimaActividad AS
    SELECT 
        REG_Nombre_Actividad,
        REG_Ong_nombre,
        REG_HabitatID,
        HAB_nombre
    FROM
        Registro_ONG
            INNER JOIN
        Habitat ON Habitat.HAB_HabitatID = Registro_ONG.REG_HabitatID
    ORDER BY `REG_actividadID` DESC
    LIMIT 1;

-- //////////////////////////////////////////////////////////////////////////

CREATE VIEW verAnimales AS
    SELECT 
        ANI_AnimalID,
        CUI_nombre AS Cuidador,
        HAB_nombre AS Habitat,
        ANI_Nombre,
        ANI_Alimentacion,
        ANI_Anyo_cautiverio,
        ANI_Especie,
        ANI_Sexo,
        ANI_Edad,
        ANI_Peso,
        ANI_Observaciones
    FROM
        animal
            INNER JOIN
        cuidador ON cuidador.CUI_CuidadorID = ANI_CuidadorID
            INNER JOIN
        Habitat ON habitat.HAB_HabitatID = ANI_HabitatID;

-- ///////////////////////////////////////////////////////////////////////

CREATE VIEW Actividades AS
    SELECT 
        reg_aprobacion,
        reg_ong_nombre,
        reg_nombre_actividad,
        reg_desc_actividad,
        reg_fecha_solicitud,
        reg_hora_apertura,
        reg_hora_cierre,
        hab_nombre
    FROM
        registro_ong
            INNER JOIN
        habitat ON registro_ong.reg_habitatid = habitat.hab_habitatid;

-- ///////////////////////////////////////////////////////////////////////

CREATE VIEW cuidadoresDisponibles AS
    SELECT 
        *
    FROM
        Cuidador
    WHERE
        CUI_CuidadorId NOT IN (SELECT 
                HAB_CuidadorID
            FROM
                habitat
            WHERE
                HAB_CuidadorId);
 
 -- //////////////////////////////////////////////////////////////////////

CREATE VIEW verHabitats AS
    SELECT 
        HAB_nombre,
        Cui_nombre,
        Cui_apellido1,
        cli_nombre,
        hab_habitatId
    FROM
        Habitat
            INNER JOIN
        clima ON clima.CLI_climaId = HAB_ClimaId
            INNER JOIN
        cuidador ON cuidador.CUI_CuidadorId = HAB_CuidadorId;

-- /////////////////////////////////////////////////////////////////////////

CREATE VIEW VisitasMedicas AS
    SELECT 
        vet_nombre,
        vet_nombre2,
        vet_apellido1,
        vet_apellido2,
        ani_nombre,
        ani_especie,
        ani_peso,
        rev_observaciones,
        rev_fecha_revision,
        vet_veterinarioid
    FROM
        revisa_animal
            INNER JOIN
        veterinario ON revisa_animal.rev_veterinarioid = vet_veterinarioid
            INNER JOIN
        animal ON revisa_animal.rev_animalid = animal.ani_animalid;
-- drop view VisitasMedicas;

-- ///////////////////////////////////////////////////
-- //////////  PROCEDIMIENTOS ALMACENADOS  ///////////
-- ///////////////////////////////////////////////////

DELIMITER //
CREATE PROCEDURE filtroAnimales
(IN con CHAR(30))
BEGIN
  SELECT * FROM verAnimales
  WHERE Habitat = con;
END //
DELIMITER ;

-- ///////////////////////////////////////////////////

DELIMITER //
CREATE PROCEDURE filtroAnimalesEspecie
(IN con CHAR(30))
BEGIN
  SELECT * FROM verAnimales
  WHERE ANI_Especie = con;
END //
DELIMITER ;

-- ///////////////////////////////////////////////////

DELIMITER //
CREATE PROCEDURE filtroAnimalesProcedencia
(IN con INT)
BEGIN
  if con = 1 then
	SELECT * FROM verAnimales
	inner join Procedencia_Local
    on Procedencia_Local.LOC_AnimalID = verAnimales.ANI_AnimalId;
  elseif con = 2 then 
	SELECT * FROM verAnimales
	inner join Procedencia_Foranea
    on Procedencia_Foranea.FOR_AnimalID = verAnimales.ANI_AnimalId;
  else 
	SELECT * FROM verAnimales
	inner join Procedencia_Rescate
    on Procedencia_Rescate.RES_AnimalID = verAnimales.ANI_AnimalId;
  end if;  
END //
DELIMITER ;

-- ///////////////////////////////////////////////////

DELIMITER //
CREATE PROCEDURE verRegistrosHabitats
(IN con CHAR(30))
BEGIN
  SELECT RHA_temperatura, RHA_Humedad, RHA_Fecha_registro FROM Habitat
  inner join Registra
  on registra.RHA_HabitatId = Habitat.HAB_HabitatId
  WHERE HAB_nombre = con;
END //
DELIMITER ;

-- ///////////////////////////////////////////////////

delimiter //
create procedure filtroDiasActividad (in dia varchar(10))
begin
	select reg_aprobacion, reg_ong_nombre, reg_nombre_actividad, reg_desc_actividad, reg_fecha_solicitud, reg_hora_apertura, reg_hora_cierre, hab_nombre from ong_realiza 
    inner join registro_ong on ong_realiza.rea_actividadid = registro_ong.reg_actividadid
    inner join habitat on registro_ong.reg_habitatid = habitat.hab_habitatid
	where ong_realiza.rea_dia = dia;
end //
delimiter ;   

-- ///////////////////////////////////////////////////

delimiter //
create procedure filtroHabitatActividad (in habitat varchar(20))
begin
	select *from Actividades
	where hab_nombre = habitat;
end //
delimiter ;   

-- ///////////////////////////////////////////////////

delimiter //
create procedure filtroEspecieVisitas (in  especie varchar(15))
	 begin
		select * from VisitasMedicas
        where ani_especie = especie;
	end //
delimiter ;

-- ///////////////////////////////////////////////////

delimiter //
create procedure filtroFechasRevision (in fecha date)
	begin
     select *from VisitasMedicas
     where rev_fecha_revision = fecha;
	end //
delimiter ;
-- drop procedure filtroFechasRevision;


delimiter //
create procedure filtroVeterinarioVisitas (in id int)
	 begin
		select * from VisitasMedicas
        where vet_veterinarioid = id;
	end //
delimiter ;

-- ///////////////////////////////////////////////////

delimiter //
create procedure filtroStatus (in estado varchar(12))
begin
	select *from Actividades
    where reg_aprobacion = estado;
end //
delimiter ;
-- drop procedure filtrostatus;

-- ////////////////////////////////////

delimiter //
create procedure validacionRegistro(in idHab int)
begin 
	select CLI_humedad_min, cli_humedad_max, cli_temp_min, cli_temp_max from habitat
    inner join clima
    on clima.cli_climaId = hab_ClimaId
    where hab_habitatID = idHab;
    end //
    delimiter ;


-- ///////////////////////////////////////////////////

-- ///////////////////////////////////////////////////
-- //////////////////  TRIGGERS   ////////////////////
-- ///////////////////////////////////////////////////

-- CREACION DEL TRIGGER PARA HABITAT
delimiter //
create trigger disponibilidad_habitat after insert on Registro_ONG
	for each row 
    begin
    if new.reg_aprobacion = 'Aprobado' then
    update Habitat set HAB_Disponibilidad = 'ocupado' 
    where HAB_HabitatId = new.reg_habitatid; 
    end if;
    end ; //
    delimiter ;

-- drop trigger disponibilidad_habitat;

-- ///////////////////////////////////////////////////
-- TRIGGER EN CASO DE QUE SE ELIME ALGUN REGISTRO DE REGISTRO_ONG
delimiter //
create trigger eliminar_disponibilidad_habitat after delete on Registro_ONG
	for each row
	begin
    set @aux:= old.reg_habitatid;
    update Habitat set HAB_Disponibilidad = 'disponible'
    where HAB_HabitatId = @aux;
	end ;  //
    delimiter ;
    -- drop trigger eliminar_disponibilidad_habitat;
    
-- //////////////////////////////////////////////////
-- TRIGGER PARA ACTUALIZAR LAS OBSERVACIONES DEL ANIMAL
delimiter //
create trigger vistaMedicaObservaciones after insert on Revisa_Animal
for each row 
begin 
update Animal set ani_observaciones = new.rev_observaciones
where ani_animalid= new.rev_animalid;
end; //
delimiter ;
-- drop trigger vistaMedicaObservaciones;

-- ///////////////////////////////////////////////////



-- ////////////////////////////////////////////////////////////////////////////
-- ////////////////////// ALTAS PARA PROBAR PROGRAMA //////////////////////////
-- ////////////////////////////////////////////////////////////////////////////
insert into clima values (1,'Arido',0,5,40,45),
						 (2,'Frio',0,2,0,5),
						 (3,'Templado',10,15,20,25),
						 (4,'Tropical',50,60,30,35);


INSERT INTO Cuidador (CUI_Nombre,CUI_Nombre2,CUI_Apellido1,CUI_Apellido2,CUI_Sueldo) VALUES ('Uri',null,'Hernandez','Garcia',1000.50), 
																						    ('Luis',null,'Vazquez','Padilla',2000.50), 
                                                                                            ('Rosa','Jazmin','Portillo','Sanchez',5000.50),
																							("Lilia","Montserrat","Fuentes","Navarrete",1423),
                                                                                            ("Enrique","Javier","Joaquin","Hidalgo",6481),
                                                                                            ("Rebeca",null,"Torres","Bautista",3415),
                                                                                            ("Bree","Marsden","Olsen","Michael",4356),
                                                                                            ("Iona","Sawyer","Davenport","Booth",2255),
                                                                                            ("Germaine","Denton","Dunlap","Weaver",2201),
                                                                                            ("Genevieve","Lance","Hampton","Wagner",4059),
                                                                                            ("Quamar","Ivana","Ramsey","Morris",8929),
                                                                                            ("Tamara","Ivor","Robles","Summers",3164),
                                                                                            ("Hilel","Larissa","Faulkner","Frye",5733),
                                                                                            ("Hedwig","Piper","Payne","Bruce",4213),
                                                                                            ("Rose","Mannix","Gonzales","Gonzales",5565),
                                                                                            ("Chandler","Kaseem","Richmond","Hayden",7281),
                                                                                            ("Hall","Doris","Hess","Hampton",9522),
                                                                                            ("Kelsey","Vera","Porter","Price",3996),
                                                                                            ("Sylvester","Echo","Miranda","Hess",9130),
                                                                                            ("Lara","Daquan","Townsend","Jimenez",6067),
                                                                                            ("Hayden","Cody","Head","Buckley",2486),
                                                                                            ("Illiana","Lane","Walker","Stokes",4145),
                                                                                            ("Ella","Donna","Russo","Warren",7342),
                                                                                            ("Alexis","Alfreda","Walls","Garcia",6725),
                                                                                            ("Ulric","Shellie","Huber","Mccarthy",3816),
                                                                                            ("Odessa","Celeste","Stephens","Owens",7828),
                                                                                            ("Ainsley","Mercedes","Johnson","Mcconnell",3452),
                                                                                            ("Jena","Nigel","Vinson","Campbell",5552),
                                                                                            ("Judith","Selma","Baxter","Crane",906),
                                                                                            ("Chandler","Cherokee","Valencia","Boyd",1288),
                                                                                            ("Kaden","Leandra","Kinney","Mclaughlin",4347),
                                                                                            ("Martina","Ignacia","Rios","Nieves",5346),
                                                                                            ("Merrill","Nell","Chase","Mathews",9355),
                                                                                            ("Kaseem","Jonas","Kelley","Pittman",8875),
                                                                                            ("Matthew","Althea","Battle","Mercer",8597),
                                                                                            ("Teegan","Beau","Jarvis","Rosario",3730),
                                                                                            ("Germaine","Victoria","Bell","Stevenson",6408),
                                                                                            ("Violet","Kylee","Jacobson","Durham",3335),
                                                                                            ("Kimberly","Dennis","Hendrix","Carver",9217),
                                                                                            ("Yvonne","Quinn","Maynard","Wise",6630),
                                                                                            ("Vanna","Brielle","Smith","Booth",1657),
                                                                                            ("Reuben","Zorita","Guthrie","Stephens",6232),
                                                                                            ("Mia","Ferris","Knowles","Spencer",2414),
                                                                                            ("Lani","Veronica","Berry","Blake",5109),
                                                                                            ("Lewis","Halee","David","Kennedy",6113),
                                                                                            ("Perry","Olga","Monroe","Duran",3126),
                                                                                            ("May","Magee","Cox","Bradford",1088),
                                                                                            ("Britanni","Norman","Gay","Frost",1150),
                                                                                            ("Rooney","Vernon","Rose","Gross",1794),
                                                                                            ("Marcia","Tatiana","Mccoy","Thomas",4024),
                                                                                            ("Anjolie","Shelly","Tucker","Ford",5271),
                                                                                            ("Cole","Myra","Scott","Andrews",1868),
                                                                                            ("Karleigh","Mufutau","Johnson","Beard",1677);

insert into Habitat values (1,1,1,'Desierto','disponible'),
						   (2,1,2,'Pastizales','disponible'),
                           (3,4,3,'Franja Costera','disponible'),
                           (4,2,1,'Tundra Aviario','disponible'),
                           (5,3,1,'Bosque Templado','disponible'),
                           (6,4,1,'Bosque Tropical','disponible');



INSERT INTO Veterinario (VET_Nombre,VET_Nombre2,VET_Apellido1,VET_Apellido2,VET_Correo,VET_Cedula,VET_Telefono) VALUES ('Rodrigo','Angeles','Garcia','Zenon','rodangel@gmail.com','CED12345','5519038167'),
																													   ('Leo','Alfonso','Ramirez','Gonzales','leo@gmail.com','CED12347','5519548761'),
                                                                                                                       ('Carlo','Alberto','Ramirez','Gonzalez','algo@gmail.com','CED12477','5519548761'),
																													   ("Alfreda","Isaac","Floyd","Watson","semper.pretium@nec.com","24541958","1608120935"),
																													   ("Bethany","Margaret","Horne","Vincent","Lorem@lacusvestibulum.org","22300296","1666081599"),
                                                                                                                       ("Wynne","Xantha","Frost","Mendoza","sem.eget@etliberoProin.com","48049576","1614012735"),
                                                                                                                       ("Cairo","Jolie","Rowland","Figueroa","eu.dui@mauris.com","39764612","1695050206"),
                                                                                                                       ("Cameron","Ivory","Parks","Duke","egestas@sitamet.co.uk","54633442","1655120419"),
                                                                                                                       ("Lane","Stacey","Pena","Payne","sagittis.lobortis.mauris@auctorvitaealiquet.edu","32318036","1639051292"),
                                                                                                                       ("Patrick","Hayes","Mayo","Coffey","cursus.a.enim@Phasellus.org","28172415","1659082516"),
                                                                                                                       ("Kirsten","Aidan","Cohen","Rich","Nam.ac.nulla@sitamet.com","89904333","1628090612"),
                                                                                                                       ("Kimberly","Lewis","Peterson","Hickman","laoreet@loremfringilla.com","98587547","1696082198"),
                                                                                                                       ("Jena","Vielka","Haney","Mack","purus.gravida@imperdietnecleo.com","22770389","1685090981"),
                                                                                                                       ("Conan","Miriam","Blankenship","Wong","augue.porttitor.interdum@Fuscefeugiat.ca","05142153","1680122441"),
																													   ("Jesse","Erin","Huff","Gill","et.rutrum.non@nonloremvitae.co.uk","27637123","1617060917"),
                                                                                                                       ("Desiree","Alika","Fields","Rutledge","Aliquam.erat.volutpat@nibh.co.uk","65931407","1658122892"),
                                                                                                                       ("Aimee","Roth","Trujillo","Dawson","vestibulum.lorem@lorem.net","01434972","1603041373"),
                                                                                                                       ("Ursa","Eaton","Gilbert","Huber","Proin.vel.nisl@semegestasblandit.co.uk","21648916","1657060808"),
                                                                                                                       ("Kylan","Addison","Harmon","Curry","molestie.orci.tincidunt@rhoncus.org","93213236","1635030941"),
                                                                                                                       ("Ivana","Odette","Pacheco","Cunningham","ante.ipsum@ante.org","38746861","1627101723"),
                                                                                                                       ("Deborah","Shea","Anderson","Delaney","non@vitaesodales.net","81916443","1686052695"),
                                                                                                                       ("Nathaniel","Iona","Solomon","Price","egestas.urna.justo@interdum.co.uk","51494547","1610022445"),
                                                                                                                       ("Beverly","Mari","Reese","Alford","magna.a.neque@urna.com","05466330","1608100517"),																												
                                                                                                                       ("Reese","Patrick","Elliott","Strickland","Integer@ametdiameu.org","22209029","1617050108"),
																													   ("Noble","Curran","Day","Ruiz","quam.vel@acnulla.net","45204312","1629011189"),
                                                                                                                       ("Justine","Sandra","Kelly","Allen","odio.a.purus@egetmetuseu.co.uk","68059283","1623061981"),
                                                                                                                       ("Francesca","Mallory","Mcintosh","Hutchinson","Aliquam.tincidunt.nunc@leoVivamus.co.uk","71898573","1685031944"),
                                                                                                                       ("Katelyn","Moana","Fitzpatrick","Peck","facilisis@commodoipsum.co.uk","22989133","1603070391"),
                                                                                                                       ("Valentine","Paloma","Bell","Knight","adipiscing.elit@Nuncmaurissapien.com","30910132","1669020389"),
                                                                                                                       ("Tiger","Jaquelyn","Hayden","Mendoza","dolor@eutellus.ca","12701135","1661061336"),
                                                                                                                       ("Jackson","Briar","Vazquez","Harper","congue.elit@dui.co.uk","59528994","1658120589"),
                                                                                                                       ("Emerald","Sandra","Gay","Bird","sem.egestas.blandit@erosNamconsequat.com","16306422","1610052775"),
                                                                                                                       ("Keaton","Galena","Lindsay","Meadows","Nulla.facilisis.Suspendisse@magnis.org","04395440","1678100880"),
                                                                                                                       ("Kieran","Callie","Langley","Wyatt","tempus.risus@Aliquamtinciduntnunc.org","59497997","1697013077"),
																													   ("Brendan","Kellie","Rodriquez","Frye","Donec@eratinconsectetuer.net","53540570","1631071467"),
                                                                                                                       ("Evan","Brynne","Harper","Steele","euismod.et@nisl.ca","86330373","1687022899"),
                                                                                                                       ("Nolan","Joel","Palmer","Zamora","auctor.vitae@euaccumsansed.edu","50377878","1676022715"),
                                                                                                                       ("Denise","Melyssa","Hardin","Phillips","arcu.Morbi@Mauris.org","21626007","1651121167"),
                                                                                                                       ("Ciaran","Yoshi","Gaines","Alvarez","in.consequat@nec.org","02272023","1665083012"),
                                                                                                                       ("Beatrice","Orla","Cervantes","Thomas","eu.dui@enim.org","39479813","1605072220"),
                                                                                                                       ("Pearl","Elmo","Dixon","Chambers","sit@variusNamporttitor.com","35781162","1674040279"),
                                                                                                                       ("Thor","Mia","Conley","Cooley","sagittis.lobortis.mauris@maurisipsum.net","84527408","1636101503"),
                                                                                                                       ("Ivy","Carson","White","Walters","sit.amet@magnaSuspendisse.edu","13587674","1694119353"),																													("Irma","Reese","Hicks","Rutledge","dictum.eu.placerat@eliterat.org","74384273","1606012241"),
																													   ("Jerry","Chancellor","Prince","Cote","primis.in.faucibus@nec.ca","19471357","1695111414"),
                                                                                                                       ("Penelope","Kenneth","Small","Copeland","pede.blandit@viverraDonectempus.net","67313994","1604121492"),
                                                                                                                       ("Tashya","Isaiah","Miles","Morales","lorem@velitjustonec.ca","03827167","1626040437"),
                                                                                                                       ("Cole","Noble","Cotton","Buck","Proin.vel@mollisDuissit.co.uk","25347194","1668030740"),
                                                                                                                       ("Wang","Graham","Abbott","Mosley","vitae@felis.com","10450092","1654112904"),
                                                                                                                       ("Uma","Howard","Finch","Oliver","ornare.facilisis@ametconsectetueradipiscing.co.uk","66601365","1644032401"),
                                                                                                                       ("Tatiana","Breanna","Bray","Williamson","neque.vitae@eu.co.uk","01053446","1654012747"),
                                                                                                                       ("Charles","Talon","Juarez","Preston","metus.urna@quamCurabitur.edu","31801746","1643020185"),
                                                                                                                       ("Velma","Porter","Cabrera","Camacho","pede.nonummy@ipsumdolorsit.org","43624111","1622072799");   

insert into Registra values (1,1,41.52,1.58,'2020-05-01'),
						    (2,1,42.1,1.9,'2020-05-02'),
							(3,1,41.80,2.05,'2020-05-03'),
						    (4,1,42.12,1.56,'2020-05-04'),
                            (5,1,41.12,1.58,'2020-05-05'),
                            (6,1,42.36,1.36,'2020-05-06'),
                            (7,1,42.10,1.1,'2020-05-07'),
                            (8,1,41.26,2.38,'2020-05-08'),
                            (9,1,42.31,1.85,'2020-05-09'),
                            (10,1,41.23,1.12,'2020-05-10'),
                            (11,2,43.56,4.32,'2020-05-01'),
                            (12,2,43.98,4.69,'2020-05-02'),
                            (13,2,44.1,3.97,'2020-05-03'),
                            (14,2,43.85,4.56,'2020-05-04'),
                            (15,2,43.12,4.89,'2020-05-05'),
                            (16,2,43.93,4.10,'2020-05-06'),
                            (17,2,42.91,3.91,'2020-05-07'),
                            (18,2,43.52,4.12,'2020-05-08'),
                            (19,2,43.28,4.36,'2020-05-09'),
                            (20,2,41.95,3.89,'2020-05-10'),
                            (21,3,32.5,52.36,'2020-05-01'),
                            (22,3,32.67,52.48,'2020-05-02'),
                            (23,3,32.85,52.72,'2020-05-03'),
                            (24,3,32.23,52.12,'2020-05-04'),
                            (25,3,32.12,52.45,'2020-05-05'),
                            (26,3,31.85,52.10,'2020-05-06'),
                            (27,3,31.94,52.89,'2020-05-07'),
                            (28,3,33.10,51.98,'2020-05-08'),
                            (29,3,33.14,51.96,'2020-05-09'),
                            (30,3,32.45,52.47,'2020-05-10'),
                            (31,4,0.25,1.21,'2000-05-01'),
                            (32,4,0.38,1.24,'2000-05-02'),
                            (33,4,0.84,1.38,'2000-05-03'),
                            (34,4,0.45,1.45,'2000-05-04'),
                            (35,4,0.41,1.95,'2000-05-05'),
                            (36,4,0.12,1.74,'2000-05-06'),
                            (37,4,1.12,1.64,'2000-05-07'),
                            (38,4,1.24,1.39,'2000-05-08'),
                            (39,4,1.21,1.64,'2000-05-09'),
                            (40,4,0.28,1.21,'2000-05-10'),
                            (41,5,23.54,12.65,'2000-05-01'),
                            (42,5,23.87,12.12,'2000-05-02'),
                            (43,5,23.45,12.79,'2000-05-03'),
                            (44,5,23.69,12.63,'2000-05-04'),
                            (45,5,23.10,12.36,'2000-05-05'),
                            (46,5,23.16,12.46,'2000-05-06'),
                            (47,5,23.96,12.79,'2000-05-07'),
                            (48,5,23.54,12.36,'2000-05-08'),
                            (49,5,23.46,12.78,'2000-05-09'),
                            (50,5,24.10,11.78,'2000-05-10'),
                            (51,6,34.58,53.23,'2000-05-01'),
                            (52,6,34.57,53.47,'2000-05-02'),
                            (53,6,34.46,53.96,'2000-05-03'),
                            (54,6,34.30,53.36,'2000-05-04'),
                            (55,6,34.97,53.46,'2000-05-05'),
                            (56,6,34.36,53.98,'2000-05-06'),
                            (57,6,34.26,53.46,'2000-05-07'),
                            (58,6,34.19,53.53,'2000-05-08'),
                            (59,6,33.99,53.89,'2000-05-09'),
                            (60,6,33.50,53.99,'2000-05-10');

insert into Animal values (1,1,1,'Agui','Roedores','2005','Aguila Real','M',15,3.6,'En buen estado'),
						  (2,1,1,'Celeste','Roedores','2005','Aguila Real','H',15,7,'En buen estado'),
                          (3,2,2,'Kevin','Raices','2000','Canguro Gris','M',15,55.60,'En buen estado'),
                          (4,2,2,'Aurora','Raices','2000','Canguro Gris','H',15,40.84,'En buen estado'),
                          (5,3,2,'Fitch','Raices','2000','Canguro Rojo','M',15,45.86,'En buen estado'),
                          (6,3,2,'Mel','Raices','2000','Canguro Rojo','H',15,40.84,'En buen estado'),
                          (7,4,1,'Diego','Roedores','2000','Caracal','M',15,12.60,'En buen estado'),
                          (8,4,1,'Ela','Roedores','2000','Caracal','H',15,10.50,'En buen estado'),
                          (9,5,1,'Ryan','Carroña','2000','Condor de California','M',15,10.5,'En buen estado'),
                          (10,5,1,'Lola','Carroña','2000','Condor de California','H',15,9.8,'En buen estado'),
                          (11,6,2,'Hector','Carroña','2000','Hiena Moteada','M',15,45.62,'En buen estado'),
                          (12,6,2,'Lisa','Carroña','2000','Hiena Moteada','H',15,58.80,'En buen estado'),
                          (13,7,3,'Moto Moto','Hierbas','2000','Hipopotamo','M',15,1752.50,'En buen estado'),
                          (14,7,3,'Gloria','Hierbas','2000','Hipopotamo','H',15,1449.50,'En buen estado'),
                          (15,8,5,'Hawi','Carne','2000','Jaguar','M',15,95.84,'En buen estado'),
                          (16,8,5,'Eli','Carne','2000','Jaguar','H',15,63.78,'En buen estado'),
                          (17,9,2,'Melman','Ramas de Arbol','2000','Jirafa','M',15,800,'En buen estado'),
                          (18,9,2,'Deleine','Ramas de Arbol','2000','Jirafa','H',15,750.62,'En buen estado'),
                          (19,10,6,'Yulien','Fruta','2000','Lemur','M',15,2.30,'En buen estado'),
                          (20,10,6,'Lisa','Fruta','2000','Lemur','H',15,1.89,'En buen estado'),
                          (21,11,2,'Alex','Carne','2000','León Africano','M',15,190.50,'En buen estado'),
                          (22,11,2,'Claire','Carne','2000','León Africano','H',15,135.5,'En buen estado'),
                          (23,12,4,'Leo','Carne','2000','Leopardo de las Nieves','M',15,32.41,'En buen estado'),
                          (24,12,4,'Parda','Carne','2000','Leopardo de las Nieves','H',15,28.96,'En buen estado'),
                          (25,13,2,'Valto','Carne','2000','Lobo Mexicano','M',15,35.69,'En buen estado'),
                          (26,13,2,'Lao','Carne','2000','Lobo Mexicano','H',15,27.81,'En buen estado'),
                          (27,14,6,'Oran','Fruta','2000','Orangután','M',15,85.65,'En buen estado'),
                          (28,14,6,'Beth','Fruta','2000','Orangután','H',15,71.23,'En buen estado'),
                          (29,15,4,'Winnie','Miel','2000','Oso Pardo','M',15,589.52,'En buen estado'),
                          (30,15,4,'Poo','Miel','2000','Oso Pardo','H',15,501.23,'En buen estado'),
                          (31,16,5,'Po','Bambú','2000','Panda Gigante','M',15,88.69,'En buen estado'),
                          (32,16,5,'Lima','Bambú','2000','Panda Gigante','H',15,71.51,'En buen estado'),
                          (33,17,4,'Cobalski','Guachinango','2000','Pingüino','M',15,22.46,'En buen estado'),
                          (34,18,4,'Ela','Guachinango','2000','Pingüino','H',15,18.79,'En buen estado'),
                          (35,18,6,'Tapi','Hojas','2000','Tapir','M',15,169.81,'En buen estado'),
                          (36,19,6,'Carla','Hojas','2000','Tapir','H',15,151.14,'En buen estado'),
                          (37,19,2,'Tepo','Semillas','2000','Teporingo','M',15,0.6,'En buen estado'),
                          (38,20,2,'Tepa','Semillas','2000','Teporingo','H',15,0.56,'En buen estado'),
                          (39,20,5,'Tigger','Peces','2000','Tigre de Bengala','M',15,220,'En buen estado'),
                          (40,20,5,'Tigresa','Peces','2000','Tigre de Bengala','H',15,140.56,'En buen estado');
                          
 
insert into procedencia_foranea values (1,'Madagascar','2000-01-01'),
									   (2,'Madagascar','2000-01-01'),
                                       (3,'Madagascar','2000-01-01'),
                                       (4,'Madagascar','2002-05-15'),
                                       (5,'Central Park','2002-05-15'),
                                       (6,'Central Park','2002-05-15'),
                                       (7,'Central Park','2002-05-15'),
                                       (8,'Central Park','2002-05-15'),
                                       (9,'Howboken','2002-05-15'),
                                       (10,'Howboken','2002-05-15'),
                                       (11,'Howboken','2002-05-15'),
                                       (12,'Howboken','2002-05-15'),
                                       (13,'Howboken','2002-05-15'),
                                       (14,'Howboken','2002-05-15');
                                       
insert into procedencia_local values (15,1,'2005-10-26',78.5),                                       
									 (16,2,'2005-10-26',78.5),
                                     (17,3,'2005-10-26',78.5),
                                     (18,4,'2005-10-26',78.5),
                                     (19,5,'2005-10-26',78.5),
                                     (20,6,'2005-10-26',78.5),
                                     (21,7,'2005-10-26',78.5),
                                     (22,8,'2005-10-26',78.5),
                                     (23,9,'2005-10-26',78.5),
                                     (24,10,'2005-10-26',78.5),
                                     (25,11,'2005-10-26',78.5),
                                     (26,12,'2005-10-26',78.5),
                                     (27,13,'2005-10-26',78.5),
                                     (28,14,'2005-10-26',78.5),
                                     (29,15,'2005-10-26',78.5),
                                     (30,16,'2005-10-26',78.5);
                                     
insert into procedencia_rescate values (31,2,'Buena','2007-12-10'),
									   (32,2,'Buena','2007-12-10'),
                                       (33,2,'Buena','2007-12-10'),
                                       (34,2,'Buena','2007-12-10'),
                                       (35,2,'Buena','2007-12-10'),
                                       (36,2,'Buena','2007-12-10'),
                                       (37,2,'Buena','2007-12-10'),
                                       (38,2,'Buena','2007-12-10'),
                                       (39,2,'Buena','2007-12-10'),
                                       (40,2,'Buena','2007-12-10');
                                
                                       

insert into Revisa_Animal values (1,1,1,'En buen estado','2020-01-01'),
								 (2,1,2,'En buen estado','2020-01-01'),
                                 (3,2,3,'En buen estado','2020-01-02'),
                                 (4,2,4,'En buen estado','2020-01-02'),
                                 (5,3,5,'En buen estado','2020-01-03'),
                                 (6,3,6,'En buen estado','2020-01-03'),
                                 (7,4,7,'En buen estado','2020-01-04'),
                                 (8,4,8,'En buen estado','2020-01-04'),
                                 (9,5,9,'En buen estado','2020-01-05'),
                                 (10,5,10,'En buen estado','2020-01-05'),
                                 (11,6,11,'En buen estado','2020-01-06'),
                                 (12,6,12,'En buen estado','2020-01-06'),
                                 (13,7,13,'En buen estado','2020-01-07'),
                                 (14,7,14,'En buen estado','2020-01-07'),
                                 (15,8,15,'En buen estado','2020-01-08'),
                                 (16,8,16,'En buen estado','2020-01-08'),
                                 (17,9,17,'En buen estado','2020-01-10'),
                                 (18,9,18,'En buen estado','2020-01-10'),
                                 (19,10,19,'En buen estado','2020-01-11'),
                                 (20,10,20,'En buen estado','2020-01-11'),
                                 (21,11,21,'En buen estado','2020-01-12'),
                                 (22,11,22,'En buen estado','2020-01-12'),
                                 (23,12,23,'En buen estado','2020-01-13'),
                                 (24,12,24,'En buen estado','2020-01-13'),
                                 (25,13,25,'En buen estado','2020-01-14'),
                                 (26,13,26,'En buen estado','2020-01-14'),
                                 (27,14,27,'En buen estado','2020-01-15'),
                                 (28,14,28,'En buen estado','2020-01-15'),
                                 (30,15,29,'En buen estado','2020-01-16'),
                                 (31,15,30,'En buen estado','2020-01-16'),
                                 (32,16,31,'En buen estado','2020-01-17'),
                                 (33,16,32,'En buen estado','2020-01-17'),
                                 (34,17,33,'En buen estado','2020-01-18'),
                                 (35,17,34,'En buen estado','2020-01-18'),
                                 (36,18,35,'En buen estado','2020-01-19'),
                                 (37,18,36,'En buen estado','2020-01-19'),
                                 (38,19,37,'En buen estado','2020-01-20'),
                                 (39,19,38,'En buen estado','2020-01-20'),
                                 (40,20,39,'En buen estado','2020-01-21'),
                                 (41,20,40,'En buen estado','2020-01-21'),
                                 (42,21,1,'En buen estado','2020-01-22'),
                                 (43,21,2,'En buen estado','2020-01-22'),
                                 (44,22,3,'En buen estado','2020-01-23'),
                                 (45,22,4,'En buen estado','2020-01-23'),
                                 (46,23,5,'En buen estado','2020-01-24'),
                                 (47,23,6,'En buen estado','2020-01-24'),
                                 (48,24,7,'En buen estado','2020-01-25'),
                                 (49,24,8,'En buen estado','2020-01-25'),
                                 (50,25,9,'En buen estado','2020-01-26');
                                 
insert into registro_ong values (1,'Aprobado','Mexico Hacia Delante','Lectura','twitear poesia','2020-05-22','11:00:00','16:00:00',4),
							    (2,'Aprobado','Juntos tu y Yo','Cineteca','Proyectar Peliculas','2020-05-22','11:50:50','16:00:00',1),
								(3,'Aprobado','Por Mexico','Biblioteca','Cuenta Cuentos','2020-05-22','11:50:50','16:00:00',2),
								(4,'Aprobado','Mexico Libre','Ron','Beber y twitear','2020-05-22','11:50:50','16:00:00',3);
insert into ong_realiza values (1,'martes'),
							   (1,'viernes'),
							   (2,'martes'),
							   (2,'miercoles'),
                               (3,'jueves'),
                               (3,'viernes'),
                               (4,'martes'),
                               (4,'domingo');


                                                                                                                    
                                                                                                                       
                                                                             