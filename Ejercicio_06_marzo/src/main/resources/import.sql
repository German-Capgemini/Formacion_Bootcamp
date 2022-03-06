



INSERT INTO regiones (nombre) VALUES ('Rusia');
INSERT INTO regiones (nombre) VALUES ('España');
INSERT INTO regiones (nombre) VALUES ('EEUU');
INSERT INTO regiones (nombre) VALUES ('Dinamarca');

INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES (1,'Jorge','Martinez','jM@email.com',6214545,'2022-03-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES (2,'Pedro','Alvarez','pa@email.com',914545,'2022-03-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES (3,'Carlos','Menendez','jm@email.com',4242121,'2022-03-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES (4,'Marcos','Suarez','ms@email.com',921445,'2022-03-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES (4,'Javier','Tebas','jt@email.com',6214545,'2022-03-01');


INSERT INTO usuarios (username,password,enabled) VALUES('german','$2a$10$loogEpBhSfgxA6Jpqkpn.uLWy.rzT.3mrUkfnJoFsxtQXFndoypy2',1);
INSERT INTO usuarios (username,password,enabled) VALUES('admin','$2a$10$i4BlzWSfSzt0R8VQesXfaehUz6uSiTLEAaQbaFUuT5wQ0pzc3N8EW',1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id,role_id) VALUES(1,1);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES(2,2);
INSERT INTO usuarios_roles (usuario_id,role_id) VALUES(2,1);