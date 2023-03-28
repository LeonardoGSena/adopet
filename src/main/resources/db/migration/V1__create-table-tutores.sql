create table tutores (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone varchar(50) not null,
    cidade varchar(100) not null,
    sobre varchar(100) not null,

    primary key(id)
);
