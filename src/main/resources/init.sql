create table usuario (
    id serial,
    nome_usuario varchar(255) not null unique,
    senha varchar(20) not null,
    foto text not null,
    descricao text not null,
    primary key(id)
);

create table postagem (
    id serial,
    id_usuario int not null,
    mensagem varchar(255) not null,
    primary key(id),
    foreign key(id_usuario) references usuario(id)
);

create table seguindo (
    id serial,
    id_usuario int not null,
    id_seguindo int not null,
    primary key(id),
    foreign key(id_usuario) references usuario(id),
    foreign key(id_seguindo) references usuario(id)
);

insert into usuario(nome_usuario, senha, foto, descricao) values ('natan', '123', 'saodpasodps', 'Jogo FIFA e domino!');
insert into usuario(nome_usuario, senha, foto, descricao) values ('jonas', '123', 'saodpasodps', 'Adoro uma cachaça!');
insert into usuario(nome_usuario, senha, foto, descricao) values ('rudan', '123', 'saodpasodps', 'Jogo boa hoje, jogo bola amanha, jogo bola pra sempre!');