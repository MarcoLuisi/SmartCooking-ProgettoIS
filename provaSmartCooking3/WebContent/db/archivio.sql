DROP database if exists archivio;
create database archivio;
use archivio;

create table amministratore(
	email varchar(50) primary key,
    passwordAdmin varchar(20) not null
   
);


create table utente(
	email varchar(50) primary key,
    passwordUtente varchar(20) not null,
    nome varchar(20) not null,
    cognome varchar(20) not null,
    dataNascita date not null,
    telefono varchar(15) not null,
    inizioAbbonamento date,
    fineAbbonamento date
);


create table insegnante(
	id_insegnante int primary key,
    nome varchar(20) not null,
    cognome varchar(20) not null,
    ristorante varchar(30) 
);


create table video(
    id_video int primary key auto_increment,
	titolo varchar(65) not null,
    categoria varchar(20) not null,
    gratuito boolean not null,
    id_insegnante int,
    email_admin varchar(50),
    foreign key(id_insegnante) references insegnante(id_insegnante),
    foreign key(email_admin) references amministratore(email)
);

ALTER TABLE video ADD FULLTEXT(titolo);

