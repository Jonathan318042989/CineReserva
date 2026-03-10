# CineReserva
API REST para gestionar el ciclo de vida de una compra de boletos de cine.

## Author
Martínez Camarillo Jonathan

# Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

# Como ejecutar el proyecto
- Clonar el repositorio
$ https://github.com/Jonathan318042989/CineReserva.git

- Dirigirse al directorio
$ cd CineReserva\cine-reserva\cine-reserva

- Levantar el proyecto con
$ mvn spring-boot:run

- Se tiene una base de datos levantada con Springboot, se accede en
http://localhost:8080/h2-console

    Se ejecuta un archivo sql para llenar la base de datos al momento de levantar el proyecto

- Configuración de conexión:

    JDBC URL: jdbc:h2:mem:cinema-db
    User: sa
    Password:



# Endpoints principales para pruebas

$ GET /movies

Devuelve todas las peliculas disponibles

$ GET /showtimes/{id}

Devuelve los horarios por película

$ POST /bookings/reserve

Para realizar una reservación

Ejemplo de body:

{
  "usuarioId": 1,
  "funcionId": 1,
  "butacaFuncionIds": [1,2]
}

Segundo ejemplo para ejemplo de concurrencia:

{
  "usuarioId": 2,
  "funcionId": 1,
  "butacaFuncionIds": [1]
}

$ POST /bookings/pay/{reservaId}?metodo=PAYPAL

Para realizar el pago de una reserva, se puede cambiar el metodo de pago al momento de realizar la petición (o sea, en tiempo de ejecución)
con los siguientes metodos:
(TARJETA_CREDITO, PAYPAL)

Ejemplos:

$ POST /bookings/pay/1?metodo=PAYPAL
$ POST /bookings/pay/2?metodo=TARJETA_CREDITO

# Decisiones de diseño

El proyecto se organizó por dominios funcionales (entidades):

- usuario
- pelicula
- sala
- funcion
- butaca
- reserva
- pago

- Se creo la entidad ButacaFuncion para manejar el estado de una butaca en determinada funcion

- Para evitar que dos usuarios reserven la misma butaca se valida el estado de la butaca antes de realizar la reserva, si no está libre
la butaca se lanza una excepción, el usuario solo recibe un mensaje de que la butaca ya está reservada

- Las reservas expiran si no se pagan a tiempo

- Para los métodos de pago se utiliza el patrón Strategy para poder implementar más métodos de pago de ser necesario

- Como spring boot no puede persistir directamente interfaces, se creó un MetodoPagoFactory para seleccionar el método y utilizar su lógica de pago

- Para el manejo de las reservas y los pagos, se creó el módulo booking, esta no es una entidad solo se encarga de coordinar el proceso completo desde la reserva de los asientos (bloqueo de estos) y confirmacion de la reserva incluyendo el pago. Conecta con usuario, funcion, butacafuncion, reserva y pago