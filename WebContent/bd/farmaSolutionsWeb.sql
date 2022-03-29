-- >>>>>>>>>>>>>>>>>>>>>>> Segunda Versión <<<<<<<<<<<<<<<<

-- borra la bd si existe
DROP DATABASE IF EXISTS farmaSolutionsWeb;
-- creamos la bd
CREATE DATABASE farmaSolutionsWeb;
-- activamos la bd
USE farmaSolutionsWeb;


create table tb_tipo(
id_tipo	 int not null primary key,
des_tipo varchar(20)
);

CREATE TABLE tb_usuarios(
codigo  int auto_increment,
nombre varchar(15) not null,
apellido varchar(25) not null,
usuario  char(45) NOT NULL,
clave    char(6),
fnacim  date  not null,
id_tipo  int DEFAULT 3,
primary key (codigo),
foreign key (id_tipo) references tb_tipo(id_tipo)
);

create table tb_proveedores(
cod_prov int auto_increment,
nombre_pro varchar(30) not null,
telefono varchar (20) not null,
direccion varchar(30) not null,
correo varchar(30) not null,
descripcion varchar (100) not null,
primary key (cod_prov)
);

create table tb_categorias(
idtipo		int not null primary key,
descripcion varchar(45)
);

create table tb_productos(
idprod      char(6) not null,
descripcion varchar(45) not null,
stock		int not null,
precio		decimal(8,2) not null,
idtipo		int not null,
cod_prov int not null,
fcha_registro date  not null,
fcha_vencimiento date  not null,
primary key (idprod), 
foreign key (idtipo) references tb_categorias(idtipo),
foreign key (cod_prov) references tb_proveedores(cod_prov)
);

create table tb_cab_boleta(
num_bol      char(5) not null,
fch_bol    date,
cod_cliente  int not null,
primary key (num_bol),
foreign key (cod_cliente) references tb_usuarios(codigo)
);

create table tb_det_boleta(
num_bol     char(5) not null,
idprod      char(6) not null,
cantidad    int,
preciovta   decimal(8,2),
primary key (num_bol,idprod),
foreign key (num_bol) references tb_cab_boleta(num_bol),
foreign key (idprod) references tb_productos(idprod)
);

select * from tb_det_boleta;
select * from tb_cab_boleta;

-- >>>>>>>>>>>>>>>>>>>>>>> TABLA TIPOS <<<<<<<<<<<<<<<<
insert into tb_tipo values (1, 'Administrador');
insert into tb_tipo values (2, 'trabajador');
insert into tb_tipo values (3, 'usuario');

-- >>>>>>>>>>>>>>>>>>>>>>> TABLA USUARIOS <<<<<<<<<<<<<<<<
insert into tb_usuarios values(1001, 'Admin ', 'Admin', 'ADM001@farmasolutions.com','farma1','1996-01-30',1);
insert into tb_usuarios values(null, 'Jean  ', 'Yaya Carbajal', 'EMP002@farmasolutions.com','farma3','1993-02-09',2);
insert into tb_usuarios values(null, 'Nayelli  ', 'Illescas Huacho', 'EMP004@farmasolutions.com','farma5','1999-04-09',2);
insert into tb_usuarios values (null,'Carlos', 'Quispe','USER1@farmasolutions.com', 'user01','1975-01-18', 3);
insert into tb_usuarios values (null,'Juan', 'Rodriguez','USER2@farmasolutions.com', 'user02','1980-07-12', 3);
insert into tb_usuarios values (null,'Luz', 'Peña','USER3@farmasolutions.com', 'user03','1982-05-25', 3);
insert into tb_usuarios values (null,'Carmen', 'Guerrero','USER4@farmasolutions.com', 'user04','1965-04-19', 3);


-- >>>>>>>>>>>>>>>>>>>>>>> TABLA CATEGORIAS <<<<<<<<<<<<<<<<
insert into tb_categorias values (1, 'Pastillas');
insert into tb_categorias values (2, 'Jarabe');
insert into tb_categorias values (3, 'Cremas');
insert into tb_categorias values (4, 'Tocador');
insert into tb_categorias values (5, 'Cuidado');
insert into tb_categorias values (6, 'Otros');


-- >>>>>>>>>>>>>>>>>>>>>>> TABLA PROVEEDORES <<<<<<<<<<<<<<<<
insert into tb_proveedores values (50001, 'Artesa', '945124878','Av. Los Aires 485','atesa@artesa.com','Proveedora de medicamentos');
insert into tb_proveedores values (50002, 'Perfection', '4716784','Av. Palermo 485','perfection@perfection.com','Proveedora de Productos de belleza');
insert into tb_proveedores values (50003, 'Cafini', '944812781','Av. Los Girasoles 485','cafini@cafini.com','Proveedora de Productos variados');


-- >>>>>>>>>>>>>>>>>>>>>>> TABLA PRODUCTOS <<<<<<<<<<<<<<<<
insert into tb_productos values ('P00001','Algodón',100,1.85,6,50003,'2020-01-15','2025-01-15');
insert into tb_productos values ('P00002','Desodorante',100,9.0,5,50002,'2020-01-15','2021-01-15');
insert into tb_productos values ('P00003','Perfumes',80,15.0,4,50002, '2020-01-15','2022-01-15');
insert into tb_productos values ('P00004','Gel',120,10.0,5,50002,'2020-01-15','2023-01-15');
insert into tb_productos values ('P00005','Nastiflu',120,1.0,3,50001,'2020-01-15','2021-01-15');
insert into tb_productos values ('P00006','Toallas Húmedas',80,2.8,5,50002,'2020-01-15','2022-01-15');
insert into tb_productos values ('P00007','Dentífrico',55,2.8,4,50001,'2020-01-15','2021-01-15');
insert into tb_productos values ('P00008','Hilo Dental',60,5.0,4,50001,'2020-01-15','2022-01-15');
insert into tb_productos values ('P00009','Tinte',40,15.5,1,50001,'2020-01-15','2024-01-15');
insert into tb_productos values ('P00010','Asepxia',20,5.5,2,50003,'2020-01-15','2022-01-15');
insert into tb_productos values ('P00011','Cepillo',40,3.5,4,50002,'2020-01-15','2024-01-15');
insert into tb_productos values ('P00012','Amoxicilina',100,1.5,5,50003,'2020-01-15','2025-01-15');
insert into tb_productos values ('P00013','Alcohol',49,5.5,1,50003,'2020-01-15','2025-01-15');
insert into tb_productos values ('P00014','Suplemento',50,50.99,5,50002,'2020-01-15','2025-01-15');
insert into tb_productos values ('P00015','Rasurador',40,4.5,4,50001,'2020-01-15','2023-01-15');
insert into tb_productos values ('P00016','Aspirina',29,1.5,6,50001,'2020-01-15','2022-01-15');
insert into tb_productos values ('P00017','Calcio Forte',10,30.0,5,50001,'2020-01-15','2021-01-15');
insert into tb_productos values ('P00018','Mascarilla',100,1.5,5,50001,'2020-01-15','2021-01-15');
insert into tb_productos values ('P00019','Ginedazol',10,10.0,5,50001,'2020-01-15','2021-01-15');
insert into tb_productos values ('P00020','Jarabe',10,5.5,2,50001,'2020-01-15','2021-01-15');

-- ---------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>----------

-- use farmaSolutionsWeb;
-- select * from tb_tipo;
-- select * from tb_Usuarios;
-- select * from tb_Productos;

-- >>>>>>>>>>>>>>>>>>>>>PROCEDIMIENTOS ALMACENADOS<<<<<<<<<<<<<<<<<


-- >>>> LISTADOXTIPO <<<<
DROP PROCEDURE IF EXISTS usp_listadoxtipo;
DELIMITER $$
create procedure usp_listadoxtipo(xtipo int)
begin
	select codigo, concat (nombre , ' ' ,apellido) as 'Nombre Completo',t.des_tipo as 'Descripcion'
 from tb_Usuarios  as u
 inner join tb_tipo as t
 on u.id_tipo=t.id_tipo
 where t.id_tipo=xtipo;
end $$
delimiter ;

-- call usp_listadoxtipo(2);


DROP PROCEDURE IF EXISTS usp_validaAcceso;
DELIMiTER $$
create procedure usp_validaAcceso (usr char(45), pas char(6))
begin
select * from tb_Usuarios where usuario = usr and clave = pas;
end$$
DELIMiTER ;

-- select * from tb_Usuarios;
-- call usp_validaAcceso ('ADM001@farmasolutions.com', 'farma1');


DROP PROCEDURE IF EXISTS usp_actualizarUsuario;
-- Procedimiento almacenado para actualizar Usuario
delimiter $$
create procedure usp_actualizarUsuario(cod int, nomb varchar(15), ape varchar(25), clv char(6), fna date)
begin
update tb_usuarios
set nombre=nomb, apellido=ape, clave=clv, fnacim=fna
where codigo = cod;
end $$
delimiter ;


DROP PROCEDURE IF EXISTS usp_actualizarProveedor;
-- Procedimiento almacenado para actualizar Proveedor
delimiter $$
create procedure usp_actualizarProveedor(cod int, nomb varchar(30), tel varchar(20), dir char(30), corr char(30), des char(100))
begin
update tb_proveedores
set nombre_pro=nomb, telefono=tel, direccion=dir, correo=corr, descripcion=des
where cod_prov = cod;
end $$
delimiter ;

-- insert into tb_proveedores values (null, 'Coca', '00000','Av. Los Planetas 485','coca@cola.com','Proveedora de Productos variados');
-- select * from tb_proveedores;


-- insert into tb_productos values ('P00019','Prueba',10,0.99,5,50001,'2020-01-15','2021-01-15');

DROP PROCEDURE IF EXISTS usp_actualizarProducto;
-- Procedimiento almacenado para actualizar Producto
delimiter $$
create procedure usp_actualizarProducto(cod char(6), nomb varchar(45), sto int, prec double, tipo int, proved int, reg date , ven date)
begin
update tb_productos
set descripcion=nomb, stock=sto, precio=prec, idtipo=tipo, cod_prov=proved,fcha_registro=reg ,fcha_vencimiento=ven
where idprod = cod;
end $$
delimiter ;

-- select * from tb_productos;


DROP PROCEDURE IF EXISTS usp_consultaNombreProveedor;
delimiter $$
create  procedure usp_consultaNombreProveedor (nombre varchar(30) )
begin
select * from tb_Proveedores p
where p.nombre_pro = nombre;
end $$


---


