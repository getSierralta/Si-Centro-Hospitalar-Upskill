create table Pessoa 
(
    NumContribuinte      integer       not null,
    Nome                 varchar(50)   not null,
    Morada               varchar(100),
    Email                varchar(50)   not null,
    Telemóvel            integer,
    DataNacimento        date          not null,
    PalavraPasse         varchar(15)   not null,
    primary key (NumContribuinte)
);

create table Funcionario 
(
    NumFuncionario       integer       not null,
    NumContribuinte      integer       not null,
    Cargo                varchar(50)   not null,
    primary key (NumFuncionario)
);

create table Utente 
(
    NumUtente            integer       not null,
    NumContribuinte      integer       not null,
    primary key (NumUtente)
);

create table MedicoEspecialidade 
(
    IdMedico             integer       not null,
    IdEspecialidade      varchar(50),
    primary key (IdMedico, IdEspecialidade)
);

create table Especialidade 
(
    IdEspecialidade      varchar(50)   not null,
    primary key (IdEspecialidade)
);

create table Unidade
(
    IdUnidade            integer       not null,
	Nome                 varchar(50)   not null,
    Morada               varchar(100)  not null,
    primary key (IdUnidade)
);

create table Vaga 
(
    IdVaga               integer       not null,
    IdMedico             integer       not null,
    IdEspecialidade      varchar(50)   not null,
    DataVaga             date          not null,
    HoraVaga             time          not null,
    primary key (IdVaga)
);

create table Marcaçao 
(
    IdVaga               integer       not null,
    NumUtente            integer       not null,
    Estado               varchar(20)   not null,
    Comentario           varchar(100), 
    primary key (IdVaga, NumUtente)
);

create table Consulta 
(
    IdConsulta           integer       not null,
    IdVaga               integer       not null,
    NumUtente            integer       not null,
    HoraChegada          time,
    HoraInicio           time,
    HoraTermino          time,
    Custo                integer,
    primary key (IdConsulta)
);

create table Receita 
(
    IdReceita            integer       not null,
    IdConsulta           integer       not null,
    Medicamento          varchar(100)  not null,
    Dosagem              varchar(100),
    CustoAproximado      integer,
    DataVencimento       date,
    primary key (IdConsulta)
);

alter table Funcionario
   add foreign key NumContribuinte (NumContribuinte)
      references Pessoa (NumContribuinte)
      on update restrict
      on delete restrict;
      
alter table Funcionario
   add foreign key IdUnidade (IdUnidade)
      references Unidade (IdUnidade)
      on update restrict
      on delete restrict;
      
alter table Utente
   add foreign key NumContribuinte (NumContribuinte)
      references Pessoa (NumContribuinte)
      on update restrict
      on delete restrict;
      
alter table MedicoEspecialidade
   add foreign key IdMedico (IdMedico)
      references Funcionario (NumFuncionario)
      on update restrict
      on delete restrict;
      
alter table MedicoEspecialidade
   add foreign key IdEspecialidade (IdEspecialidade)
      references Especialidade (IdEspecialidade)
      on update restrict
      on delete restrict;
      
alter table Vaga
   add foreign key IdMedico (IdMedico)
      references MedicoEspecialidade (IdMedico)
      on update restrict
      on delete restrict;
      
alter table Vaga
   add foreign key IdEspecialidade (IdEspecialidade)
      references MedicoEspecialidade (IdEspecialidade)
      on update restrict
      on delete restrict;
      
alter table Marcaçao
   add foreign key IdVaga (IdVaga)
      references Vaga (IdVaga)
      on update restrict
      on delete restrict;
      
alter table Marcaçao
   add foreign key NumUtente (NumUtente)
      references Utente (NumUtente)
      on update restrict
      on delete restrict;
      
alter table Consulta
   add foreign key IdVaga (IdVaga)
      references Marcação (IdVaga)
      on update restrict
      on delete restrict;
      
alter table Consulta
   add foreign key NumUtente (NumUtente)
      references Marcação (NumUtente)
      on update restrict
      on delete restrict;
      
alter table Receita
   add foreign key IdConsulta (IdConsulta)
      references Consulta (IdConsulta)
      on update restrict
      on delete restrict;
  



