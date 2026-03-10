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


-- Butacas para función 1 (Avengers 18:00)
INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (1, 1, 1, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (2, 2, 1, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (3, 3, 1, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (4, 4, 1, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (5, 5, 1, 'LIBRE', 0);


-- Butacas para función 2 (Avengers 21:00)
INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (6, 1, 2, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (7, 2, 2, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (8, 3, 2, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (9, 4, 2, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (10, 5, 2, 'LIBRE', 0);


-- Butacas para función 3 (Batman 20:00)
INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (11, 1, 3, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (12, 2, 3, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (13, 3, 3, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (14, 4, 3, 'LIBRE', 0);

INSERT INTO butaca_funcion (id, butaca_id, funcion_id, estado, version)
VALUES (15, 5, 3, 'LIBRE', 0);