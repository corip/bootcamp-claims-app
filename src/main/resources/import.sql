insert products (name) values('Tarjeta');
insert products (name) values('Seguro');

insert problems (name,product_id) values ('Cobro no reconocido',1);
insert problems (name,product_id) values ('Bloqueo',1);
insert problems (name,product_id) values ('Pago',2);

insert into reasons (name,problem_id) values ('Fraude',1);
insert into reasons (name,problem_id) values ('Membresia',2);
insert into reasons (name,problem_id) values ('Membresia',3);

insert into channels (name) values ('channel prueba');

insert into claims (amount, channel_id, currency, customer_id, detail, product_id, status, sumary,problem_id,reason_id) 
values(100,1,'S/', 1,'Prueba','1','Registrado','prueba',1,1);
