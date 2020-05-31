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
-- alter table Veterinario modify VET_Correo varchar(50) not null;
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
    REG_Hora_apertura TIME NOT NULL CHECK (REG_Hora_apertura >= cast('11:00:00'as time) AND REG_Hora_apertura < cast('16:00:00' as time)) ,
    REG_Hora_cierre TIME NOT NULL CHECK (REG_Hora_cierre > cast('11:00:00' as time) AND REG_Hora_cierre <= cast('16:00:00' as time)) ,
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


create view ultimaVisita as 
select  VET_nombre, VET_Apellido1, VET_Apellido2, ANI_nombre, REV_Fecha_Revision  from Revisa_Animal
inner join Veterinario
on Veterinario.VET_VeterinarioID = Revisa_Animal.REV_VeterinarioID
inner join Animal
on Animal.ANI_AnimalID = Revisa_Animal.REV_AnimalID
order by REV_id DESC LIMIT 1;

-- //////////////////////////////////////////////////////////////////////////

create view ultimoRegistro as
select RHA_temperatura, RHA_humedad, HAB_nombre, RHA_Fecha_Registro from Registra
inner join Habitat
on Habitat.HAB_HabitatID = Registra.RHA_HabitatID
order by RHA_RegistroID DESC LIMIT 1;

-- //////////////////////////////////////////////////////////////////////////

create view ultimaActividad as
select REG_Nombre_Actividad,REG_Ong_nombre, REG_HabitatID, HAB_nombre from Registro_ONG 
inner join Habitat
on Habitat.HAB_HabitatID = Registro_ONG.REG_HabitatID
order by `REG_actividadID` DESC LIMIT 1;

-- //////////////////////////////////////////////////////////////////////////

create view verAnimales as 
select ANI_AnimalID, CUI_nombre as Cuidador, HAB_nombre as Habitat, ANI_Nombre, ANI_Alimentacion, ANI_Anyo_cautiverio, ANI_Especie, ANI_Sexo, ANI_Edad, ANI_Peso, ANI_Observaciones from animal
inner join cuidador
on cuidador.CUI_CuidadorID = ANI_CuidadorID
inner join Habitat
on habitat.HAB_HabitatID = ANI_HabitatID;

-- ///////////////////////////////////////////////////////////////////////

create view Actividades as
select reg_aprobacion, reg_ong_nombre, reg_nombre_actividad, reg_desc_actividad, reg_fecha_solicitud, reg_hora_apertura, reg_hora_cierre, hab_nombre from registro_ong
inner join habitat on registro_ong.reg_habitatid = habitat.hab_habitatid;

-- ///////////////////////////////////////////////////////////////////////

create view cuidadoresDisponibles as
select * from Cuidador
where CUI_CuidadorId NOT IN
(select HAB_CuidadorID
 from habitat
 where HAB_CuidadorId);
 
 -- //////////////////////////////////////////////////////////////////////

create view verHabitats as 
select HAB_nombre, Cui_nombre, Cui_apellido1,cli_nombre, hab_habitatId from Habitat
inner join clima
on clima.CLI_climaId = HAB_ClimaId
inner join cuidador
on cuidador.CUI_CuidadorId = HAB_CuidadorId;

-- /////////////////////////////////////////////////////////////////////////

create view VisitasMedicas as
select vet_nombre, vet_nombre2,vet_apellido1, vet_apellido2, ani_nombre, ani_especie, ani_peso, rev_observaciones, rev_fecha_revision, vet_veterinarioid from revisa_animal
inner join veterinario on revisa_animal.rev_veterinarioid = vet_veterinarioid
inner join animal on revisa_animal.rev_animalid = animal.ani_animalid;
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

--
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
-- drop procedure filtroVeterinarioVisitas;
-- call filtroVeterinarioVisitas(1);

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

-- select * from registra;
-- call verRegistrosHabitats('aves');
-- call filtroAnimalesEspecie('jirafa');
-- call filtroAnimales('leones');

-- call filtroEspecieVisitas('jirafa');
-- call filtroFechasRevision('2000-05-01');

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

							
                            

INSERT INTO Cuidador (CUI_Nombre,CUI_Nombre2,CUI_Apellido1,CUI_Apellido2,CUI_Sueldo) VALUES ('Mario','Albert','Dominguez','Junco',1000.50), 
																						    ('Luis','Angel','Vazquez','Padilla',2000.50), 
                                                                                            ('Rosa','Jazmin','Portillo','Sanchez',5000.50),
																							("Katelyn","Nicholas","Conway","Becker",1423),
                                                                                            ("Ferris","Gil","Gay","Hale",6481),
                                                                                            ("Burton","Levi","Holden","Mays",3415),
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

insert into Habitat values (1,4,1,'leones','disponible'),
						   (2,3,2,'aves','disponible'),
                           (3,4,3,'reptiliario','disponible'),
                           (4,4,1,'anfibios','disponible');


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

insert into Registra values (1,1,35.5,40.5,'2000-05-21'),
						    (3,1,35.5,40.5,'2000-05-25 10:50:51');
insert into Registra values (2,3,5.5,20.5,'2000-05-21'),
						    (4,2,20.5,50.65,'2000-05-25 10:50:51');
insert into Animal values (1,1,1,'Alex','Carne','2000','Leon','M',15,120.5,'En buen estado'),
						  (2,2,1,'Gloria','Vegetales','2000','Hippopotamo','H',15,200.5,'En buen estado'),
                          (3,3,1,'Melman','Vegetales','2000','Jirafa','M',15,200.5,'En buen estado'),
                          (4,3,4,'Cabo','Peces','2000','Pingúinos','M',15,200.5,'En buen estado');
                          
insert into procedencia_foranea values (1,'Madagascar','2000-01-01'),
									   (2,'Madagascar','2000-01-01'),
                                       (3,'Madagascar','2000-01-01'),
                                       (4,'Abtartida','2002-05-15');

insert into Revisa_Animal values (1,1,1,'En buen estado','2000-05-01');
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
select * from ong_realiza;

select * from animal;
select *from revisa_animal;
select *from registro_ong;
select *from habitat;
select * from visitasmedicas;

select * from ultimavisita;
select * from Veterinario;	
select * from Animal;	 
select * from verAnimales;	

select * from verHabitats;
select * from Habitat;
select * from registra;
select * from cuidador;

select * from clima;
select * from Actividades;



delete from animal where ANI_animalid = 1;
delete from veterinario where vet_veterinarioid = 1;
delete from cuidador where cui_cuidadorid = 1;

                                                                                                                    
                                                                                                                       
                                                                             