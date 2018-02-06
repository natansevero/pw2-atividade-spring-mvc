create table usuario (
    id serial,
    nome_usuario varchar(255) not null unique,
    senha varchar(20) not null,
    foto bytea not null,
    primary key(id)
);

create table postagem (
    id serial,
    id_usuario int not null,
    mensagem varchar(255) not null,
    primary key(id),
    foreign key(id_usuario) references usuario(id)
);