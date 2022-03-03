
INSERT INTO departamentos (nombre, ubicacion) VALUES ('Contabilidad', 'Madrid');
INSERT INTO departamentos (nombre, ubicacion) VALUES ('Laboral', 'Barcelona');
INSERT INTO departamentos (nombre, ubicacion) VALUES ('Finanzas', 'Sevilla');
INSERT INTO departamentos (nombre, ubicacion) VALUES ('Logistica', 'Valencia');

INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ('67875654T', 'Pedro', 2000, 987678765, 1);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ('56473987Y', 'Marcos', 2100, 987678567, 2);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ('23434543V', 'Javier', 1000, 985234543, 3);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ('23874389B', 'Sabrina', 900, 985234432, 4);
INSERT INTO empleados (dni, nombre, salario, telefono, departamento_id) VALUES ('12323432C', 'Estefania', 1600, 985123322, 1);

INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ('98898788X', 'Jorge', 3000, 987678765, 1);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ('76655666V', 'Cristian', 4000, 987678765, 2);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ('88776778W', 'Alejandro', 2500, 987678765, 3);
INSERT INTO jefes (dni, nombre, salario, telefono, departamento_id) VALUES ('87781122Z', 'Mateo', 3500, 987678765, 2);

INSERT INTO usuario_cliente (nombre, password) VALUES ('user', 'user');
INSERT INTO usuario_cliente (nombre, password) VALUES ('admin', 'admin');

