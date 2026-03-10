INSERT INTO usuario (id, nombre, email)
VALUES (1, 'Juan Perez', 'juan@test.com');

INSERT INTO usuario (id, nombre, email)
VALUES (2, 'Maria Lopez', 'maria@test.com');

INSERT INTO pelicula (id, titulo, duracion, clasificacion)
VALUES (1, 'Avengers', 120, 'PG-13');

INSERT INTO pelicula (id, titulo, duracion, clasificacion)
VALUES (2, 'Batman', 140, 'PG-13');

INSERT INTO sala (id, nombre, capacidad)
VALUES (1, 'Sala 1', 20);

INSERT INTO sala (id, nombre, capacidad)
VALUES (2, 'Sala 2', 15);

INSERT INTO butaca (id, fila, numero, sala_id) VALUES (1, 'A', 1, 1);
INSERT INTO butaca (id, fila, numero, sala_id) VALUES (2, 'A', 2, 1);
INSERT INTO butaca (id, fila, numero, sala_id) VALUES (3, 'A', 3, 1);
INSERT INTO butaca (id, fila, numero, sala_id) VALUES (4, 'A', 4, 1);
INSERT INTO butaca (id, fila, numero, sala_id) VALUES (5, 'A', 5, 1);

INSERT INTO funcion (id, pelicula_id, sala_id, horario)
VALUES (1, 1, 1, '2026-03-15 18:00:00');

INSERT INTO funcion (id, pelicula_id, sala_id, horario)
VALUES (2, 1, 1, '2026-03-15 21:00:00');

INSERT INTO funcion (id, pelicula_id, sala_id, horario)
VALUES (3, 2, 2, '2026-03-15 20:00:00');

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado)
VALUES (1, 1, 1, 'LIBRE');

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado)
VALUES (2, 2, 1, 'LIBRE');

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado)
VALUES (3, 3, 1, 'LIBRE');

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado)
VALUES (4, 4, 1, 'LIBRE');

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado)
VALUES (5, 5, 1, 'LIBRE');