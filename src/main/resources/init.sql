/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  natan
 * Created: 05/02/2018
 */

create table usuario (
    id serial,
    nome_usuario varchar(255) not null unique,
    senha varchar(20) not null,
    foto bytea not null,
    primary key(id)
)

create table postagem (
    id serial,
    id_usuario int not null,
    mensagem varchar(255) not null,
    primary key(id),
    foreign key(id_usuairo) references usuario(id)
)