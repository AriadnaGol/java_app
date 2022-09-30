create table bankomat (
    id          varchar(40), --UUID: 91f0834d-1591-414c-9710-63400e6d1407
    name        varchar(255),
    saldo       DECIMAL,
    miasto      varchar(255),
    ulica       varchar(255),
    czy_aktywny boolean,
    PRIMARY KEY (id)
);

create table konto_bankowe (
    id          varchar(255) primary key,
    imie        varchar(255),
    nazwisko    varchar(255),
    saldo       DECIMAL,
    data_ur     timestamp,
    miasto      varchar(255)
);
