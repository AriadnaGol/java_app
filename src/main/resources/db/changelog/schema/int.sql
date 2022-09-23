create table bankomat (
    id          varchar(40),
    name        varchar(255),
    saldo       decimal,
    miasto      varchar(255),
    ulica       varchar(255),
    czy_aktywny boolean,
    primary key (id)
  );

create table konto_bankowe (
    id          varchar(255) primary key,
    imie        varchar(255),
    nazwisko    varchar(255),
    saldo       decimal,
    data_ur     timestamp,
    miasto      varchar(255)
);
