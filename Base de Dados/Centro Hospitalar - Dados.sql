insert into Pessoa values ( 123456780,'José Serro','Rua das Conchas, nº22 Lisboa',  'joseserro@upskill.com' , 912345678 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456781,'Jorge Rafael','Rua das Conchas, nº23 Lisboa',  'jorgerafael@upskill.com' , 912345677 ,10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456782,'Antonio Brito','Rua das Conchas, nº24 Lisboa',  'antoniobrito@upskill.com' , 912345676 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456783,'João Antão','Rua das Conchas, nº25 Lisboa',  'joaoantao@upskill.com' , 912345675 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456784,'Daniel Fernandes','Rua das Conchas, nº26 Lisboa',  'jdanialfernades@upskill.com' , 912345674 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456785,'Pedro Romano','Rua das Conchas, nº27 Lisboa',  'pedroromano@upskill.com' , 912345673 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456786,'Daniel Sierralta', null ,  'danielsierralta@upskill.com' , 912345672 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456787,'Gabriel Warmann', null ,  'gabrielwarmann@upskill.com' , 912345671 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456788,'Thiago Hipolito', null ,  'thiagohipolito@upskill.com' , 912345670 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456789,'João Aires', null ,  'joaoaires@upskill.com' , 912345679 , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456790,'Quim Barreiros','Rua das Conchas, nº32 Lisboa',  'quimbarreiros@upskill.com' , null , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456791,'Tony Carreira','Rua das Conchas, nº34 Lisboa',  'tonycarreira@upskill.com' , null , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456792,'Ana Malhoa','Rua das Conchas, nº35 Lisboa',  'anamalhoa@upskill.com' , null , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456793,'Rosinha','Rua das Conchas, nº36 Lisboa',  'rosinha@upskill.com' , null , 10/02/87, 'mnbvcxz123');
insert into Pessoa values ( 123456794,'Rute Marlene','Rua das Conchas, nº37 Lisboa',  'rutemarlene@upskill.com' , null , 10/02/87, 'mnbvcxz123');

insert into Funcionario values ( 0001, 123456780, 001, 'Médico');
insert into Funcionario values ( 0002, 123456781, 001, 'Médico');
insert into Funcionario values ( 0003, 123456782, 001, 'Médico');
insert into Funcionario values ( 0004, 123456783, 002, 'Médico');
insert into Funcionario values ( 0005, 123456784, 002, 'Médico');
insert into Funcionario values ( 0006, 123456785, 002, 'Médico');
insert into Funcionario values ( 0007, 123456786, 001, 'Funcionario de Secretaria');
insert into Funcionario values ( 0008, 123456787, 001, 'Tecnico de Limpeza');
insert into Funcionario values ( 0009, 123456788, 002, 'Gestão Hospitalar');
insert into Funcionario values ( 0010, 123456789, 002, 'Morgue');

insert into Utente values ( 0000001, 123456790);
insert into Utente values ( 0000002, 123456791);
insert into Utente values ( 0000003, 123456792);
insert into Utente values ( 0000004, 123456793);
insert into Utente values ( 0000005, 123456794);

insert into Especialidade values ('Osteopatia');
insert into Especialidade values ('Cardiologia');
insert into Especialidade values ('Oncologia');
insert into Especialidade values ('Ginecologia');
insert into Especialidade values ('Radiologia');
insert into Especialidade values ('Fisioteratia');
insert into Especialidade values ('Geral');

insert into MedicoEspecialidade values ( 0001, 'Osteopatia');
insert into MedicoEspecialidade values ( 0002, 'Cardiologia');
insert into MedicoEspecialidade values ( 0002, 'Fisioteratia');
insert into MedicoEspecialidade values ( 0003, 'Geral');
insert into MedicoEspecialidade values ( 0004, 'Geral');
insert into MedicoEspecialidade values ( 0004, 'Ginecologia');
insert into MedicoEspecialidade values ( 0005, 'Geral');
insert into MedicoEspecialidade values ( 0006, 'Radiologia');

insert into Unidade values ( 001, 'Hospital do Mar', 'Rua do Mar, nº 31, Lisboa' );
insert into Unidade values ( 002, 'Hospital das Flores', 'Rua das Flores, nº 21, Lisboa' );
insert into Unidade values ( 003, 'Hospital do Mato', 'Rua do Mato, nº 11, Lisboa' );

insert into Vaga values ( 0000001, 0001, 'Osteopatia', 03/05/84, 16.15);
insert into Vaga values ( 0000002, 0002, 'Cardiologia', 03/05/84, 16.15);
insert into Vaga values ( 0000003, 0002, 'Fisioteratia', 03/05/84, 16.15);
insert into Vaga values ( 0000004, 0003, 'Geral', 03/05/84, 16.15);
insert into Vaga values ( 0000005, 0004, 'Geral', 03/05/84, 16.15);
insert into Vaga values ( 0000006, 0004, 'Ginecologia', 03/05/84, 16.15);
insert into Vaga values ( 0000007, 0005, 'Geral', 03/05/84, 16.15);
insert into Vaga values ( 0000008, 0006, 'Radiologia', 03/05/84, 16.15);

insert into Vaga values ( 1000001, 0001, 'Osteopatia', 03/05/84, 12.15);
insert into Vaga values ( 1000002, 0002, 'Cardiologia', 03/05/84, 12.15);
insert into Vaga values ( 1000003, 0002, 'Fisioteratia', 03/05/84, 12.15);
insert into Vaga values ( 1000004, 0003, 'Geral', 03/05/84, 12.15);
insert into Vaga values ( 1000005, 0004, 'Geral', 03/05/84, 12.15);
insert into Vaga values ( 1000006, 0004, 'Ginecologia', 03/05/84, 12.15);
insert into Vaga values ( 1000007, 0005, 'Geral', 03/05/84, 12.15);
insert into Vaga values ( 1000008, 0006, 'Radiologia', 03/05/84, 12.15);

insert into Vaga values ( 0000009, 0001, 'Osteopatia', 04/05/84, 16.15);
insert into Vaga values ( 0000010, 0002, 'Cardiologia', 04/05/84, 16.15);
insert into Vaga values ( 0000011, 0002, 'Fisioteratia', 04/05/84, 16.15);
insert into Vaga values ( 0000012, 0003, 'Geral', 04/05/84, 16.15);
insert into Vaga values ( 0000013, 0004, 'Geral', 04/05/84, 16.15);
insert into Vaga values ( 0000014, 0004, 'Ginecologia', 04/05/84, 16.15);
insert into Vaga values ( 0000015, 0005, 'Geral', 04/05/84, 16.15);
insert into Vaga values ( 0000016, 0006, 'Radiologia', 04/05/84, 16.15);

insert into Vaga values ( 1000009, 0001, 'Osteopatia', 04/05/84, 12.15);
insert into Vaga values ( 1000010, 0002, 'Cardiologia', 04/05/84, 12.15);
insert into Vaga values ( 1000011, 0002, 'Fisioteratia', 04/05/84, 12.15);
insert into Vaga values ( 1000012, 0003, 'Geral', 04/05/84, 12.15);
insert into Vaga values ( 1000013, 0004, 'Geral', 04/05/84, 12.15);
insert into Vaga values ( 1000014, 0004, 'Ginecologia', 04/05/84, 12.15);
insert into Vaga values ( 1000015, 0005, 'Geral', 04/05/84, 12.15);
insert into Vaga values ( 1000016, 0006, 'Radiologia', 04/05/84, 12.15);

insert into Vaga values ( 0000017, 0001, 'Osteopatia', 05/05/84, 16.15);
insert into Vaga values ( 0000018, 0002, 'Cardiologia', 05/05/84, 16.15);
insert into Vaga values ( 0000019, 0002, 'Fisioteratia', 05/05/84, 16.15);
insert into Vaga values ( 0000020, 0003, 'Geral', 05/05/84, 16.15);
insert into Vaga values ( 0000021, 0004, 'Geral', 05/05/84, 16.15);
insert into Vaga values ( 0000022, 0004, 'Ginecologia', 05/05/84, 16.15);
insert into Vaga values ( 0000023, 0005, 'Geral', 05/05/84, 16.15);
insert into Vaga values ( 0000024, 0006, 'Radiologia', 05/05/84, 16.15);

insert into Vaga values ( 1000017, 0001, 'Osteopatia', 05/05/84, 12.15);
insert into Vaga values ( 1000018, 0002, 'Cardiologia', 05/05/84, 12.15);
insert into Vaga values ( 1000019, 0002, 'Fisioteratia', 05/05/84, 12.15);
insert into Vaga values ( 1000020, 0003, 'Geral', 05/05/84, 12.15);
insert into Vaga values ( 1000021, 0004, 'Geral', 05/05/84, 12.15);
insert into Vaga values ( 1000022, 0004, 'Ginecologia', 05/05/84, 12.15);
insert into Vaga values ( 1000023, 0005, 'Geral', 05/05/84, 12.15);
insert into Vaga values ( 1000024, 0006, 'Radiologia', 05/05/84, 12.15);

insert into Marcaçao values ( 1000004, 0000001, 'Cancelada', 'Reagendada');
insert into Marcaçao values ( 1000005, 0000002, 'Aguarda Confirmação', null);
insert into Marcaçao values ( 1000006, 0000004, 'Confirmada', null);
insert into Marcaçao values ( 1000007, 0000004, 'Cancelada', 'Aguarda remarcação');
insert into Marcaçao values ( 1000008, 0000005, 'Confirmada', null);

insert into Marcaçao values ( 0000009, 0000005, 'Cancelada', 'Contactar cliente');
insert into Marcaçao values ( 0000010, 0000004, 'Cancelada', 'Contactar cliente novamente');
insert into Marcaçao values ( 0000011, 0000003, 'Confirmada', null);
insert into Marcaçao values ( 0000012, 0000002, 'Aguarda Confirmação', null);
insert into Marcaçao values ( 0000013, 0000001, 'Confirmada', null);

insert into Marcaçao values ( 1000012, 0000005, 'Confirmada', null);
insert into Marcaçao values ( 1000013, 0000004, 'Aguarda Confirmação', null);
insert into Marcaçao values ( 1000014, 0000003, 'Confirmada', null);
insert into Marcaçao values ( 1000015, 0000002, 'Aguarda Confirmação', null);
insert into Marcaçao values ( 1000016, 0000001, 'Confirmada', null);

insert into Marcaçao values ( 0000017, 0000001, 'Confirmada', null);
insert into Marcaçao values ( 0000018, 0000002, 'Aguarda Confirmação', null);
insert into Marcaçao values ( 0000019, 0000003, 'Confirmada', null);
insert into Marcaçao values ( 0000020, 0000004, 'Confirmada', null);
insert into Marcaçao values ( 0000024, 0000005, 'Cancelada', null);

insert into Consulta values ( 800001, 1000006, 0000004, 12.00, 12.15, 12.45, 45.00);
insert into Consulta values ( 800002, 1000008, 0000005, 12.05, 12.15, 12.42, 55.00);
insert into Consulta values ( 800003, 0000011, 0000003, 16.00, 16.15, 16.45, 45.00);
insert into Consulta values ( 800004, 0000013, 0000001, 15.55, 16.15, 16.40, 40.00);
insert into Consulta values ( 800005, 1000012, 0000005, 12.00, 12.15, 12.45, 45.00);
insert into Consulta values ( 800006, 1000014, 0000003, 12.10, 12.15, 12.40, 55.00);
insert into Consulta values ( 800007, 1000016, 0000001, 12.07, 12.15, 12.35, 35.00);
insert into Consulta values ( 800008, 0000019, 0000003, 16.00, 16.15, 16.45, 42.00);
insert into Consulta values ( 800009, 0000020, 0000004, 16.00, 16.15, 16.45, 25.00);

insert into Receita values ( 70001, 800001, 'Paracetamol', null , 4.00, 03/06/84);
insert into Receita values ( 70002, 800002, 'Ibuprufeno', null , 5.00, 03/06/84);
insert into Receita values ( 70003, 800003, 'Paracetamol', null , 4.00, 03/06/84);
insert into Receita values ( 70004, 800004, 'Ibuprufeno', null , 5.00, 03/06/84);
insert into Receita values ( 70005, 800005, 'Paracetamol', null , 4.00, 03/06/84);
insert into Receita values ( 70006, 800006, 'Ibuprufeno', null , 5.00, 03/06/84);
















