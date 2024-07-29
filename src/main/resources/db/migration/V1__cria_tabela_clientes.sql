create table cliente (

    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone bigint not null,
    correntista boolean not null,
    saldo_cc float not null,
    ativo boolean not null,
    primary key(id)

)