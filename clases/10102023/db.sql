drop schema if exists 'prueba';
create schema if not exists 'prueba' DEFAULT CHARACTER SET ut8 COLLATE ut8_spanish2_ci;
use 'prueba';
create table 'usuarios'(
    'nombre' text not null,
    'direccion' text not null,
    'telefono' varchar(15) not null,
    'correo' text not null,
    'nombre_usuario' text not null,
    'password' varchar (25) not null,
    'fecha_registro' datetime not null DEFAULT current_timestamp on update,
    'permisos' int (11) not null DEFAULT '1',
    'ID' int(11) not null auto_increment,
    primary key ('id')
)ENGINE=InnoDB ;
