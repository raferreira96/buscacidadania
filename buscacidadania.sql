create database buscacidadania;

use buscacidadania;

create user 'buscacidadania'@'%' identified by '@pass#!';
grant all privileges on buscacidadania.* to 'buscacidadania'@'%';
flush privileges;

create table tb_tipousuario(
    tpu_id int not null primary key auto_increment,
    tpu_descricao varchar(25) not null
);

insert into tb_tipousuario values
    (NULL, 'Administrador'),
    (NULL, 'Assistente Social'),
    (NULL, 'Voluntário(a)'),
    (NULL, 'Justiça');

create table tb_tipolocal(
    tpl_id int not null primary key auto_incremenet,
    tpl_descricao varchar(20) not null
);

insert into tb_tipolocal values
    (NULL, 'CRAS'),
    (NULL, 'ONG'),
    (NULL, 'JUSTIÇA');

create table tb_locais(
    loc_id int not null primary key auto_increment,
    loc_descricao varchar(50) not null,
    loc_endereco varchar(60) not null,
    loc_tplid int not null,
    foreign key (loc_tplid) references tb_tipolocal (tpl_id)
);

insert into tb_locais values
    (NULL, 'CRAS - NOVA CIDADE', 'R. CARVALHO LEAL, 57, NOVA CIDADE', 1),
    (NULL, 'CRAS - SÃO RAIMUNDO', 'R. DOS BOBOS, 0, SÃO RAIMUNDO', 1),
    (NULL, 'ONG - BOM SONO', 'R. TAMANDARIM, 4556, CENTRO', 2),
    (NULL, 'ONG - BONS CORAÇÕES', 'AV. GETÚLIO VARGAS, 761, ADRIANÓPOLIS', 2),
    (NULL, 'CRAS - COMPENSA', 'AV. CICERO SOARES, 87, COMPENSA', 1),
    (NULL, 'ONG - ANJOS DA RUA', 'R. MARIA MADALENA, 211, APARECIDA', 2),
    (NULL, 'JUSTIÇA - TRF5', 'R. ALGUM LUGAR, 468, CENTRO', 3);

create table tb_usuarios(
    usu_id int not null primary key auto_increment,
    usu_username varchar(25) not null unique,
    usu_password varchar(32) not null,
    usu_nome varchar(60) not null,
    usu_cpf varchar(11) not null unique,
    usu_email varchar(60) not null unique,
    usu_tpuid int not null,
    usu_locid int not null,
    foreign key (usu_tpuid) references tb_tipousuario (tpu_id),
    foreign key (usu_locid) references tb_locais (loc_id)
);

insert into tb_usuarios values
    (NULL, 'admin', 'admin', 'Administrador', '11122233344', 'admin@buscacidadania.com.br', 1, 7),
    (NULL, 'assistente', 'assistente', 'Assistente Social', '22233344455', 'assistentesocial@buscacidadania.com.br', 2, 1),
    (NULL, 'voluntario', 'voluntario', 'Voluntário', '33344455566', 'voluntario@buscacidadania.com.br', 3, 3),
    (NULL, 'justica', 'justica', 'Justiça Federal', '77788899900', 'justica@buscacidadania.com.br', 4, 7);

create table tb_cidadaos(
    cid_id int not null primary key auto_increment,
    cid_bio varchar(13) not null unique,
    cid_nome varchar(60) not null,
    cid_datanasc date not null,
    cid_foto varchar(40)
);

create table tb_registros(
    reg_id int not null primary key auto_increment,
    reg_data datetime not null,
    reg_cidid int not null,
    reg_locid int not null,
    reg_useid int not null,
    foreign key (reg_cidid) references tb_cidadaos(cid_id),
    foreign key (reg_locid) references tb_locais(loc_id),
    foreign key (reg_useid) references tb_usuarios(use_id)
);

create table tb_guardas(
    gua_id int not null primary key auto_increment,
    gua_usuid int not null,
    gua_cidid int not null,
    foreign key (gua_usuid) references tb_usuarios(usu_id),
    foreign key (gua_cidid) references tb_cidadaos(cid_id)
);

create table tb_tiponotificacao(
    tpn_id int not null primary key auto_increment,
    tpn_descricao varchar(50) not null
);

create table tb_notificacoes(
    not_id int not null primary key auto_increment,
    not_descricao text not null,
    not_data datetime not null,
    not_tpnid int not null,
    not_cidid int not null,
    not_usuid int not null,
    foreign key (not_usuid) references tb_usuarios(usu_id),
    foreign key (not_tpnid) references tb_tiponotificacao(tpn_id),
    foreign key (not_cidid) references tb_cidadaos(cid_id)
);