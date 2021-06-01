# Personas
Almacenar personas con su tarjeta de crédito

http://personas-env.eba-5v8mkrzj.us-east-2.elasticbeanstalk.com/

## Instalación y ejecución local

clon de git https://github.com/MariaIsabelRinconGuzman/Personas.git

Utilice Eclipse 2020-12 (4.18.0)
JDK 1.8
Gradle 6.8.3
JWT (Token de acceso)

Para importar el proyecto, importe como Proyecto Gradle y para Ejecutar el proyecto, busque la clase principal PersonasApplication.java y Ejecutar como, Aplicación Java.
Este proyecto se ejecuta en el puerto 5000

La base de datos está configurada en el archivo \ src \ main \ resources \ application.properties

Genere el .jar con Gradle Task, ejecute la tarea Build y el .jar generado está en \ build \ libs \

## Instalación y ejecución en AWS

La base de datos es MySQL en console.aws.amazon.com/rds/

El entorno en AWS donde se implementará la aplicación es en console.aws.amazon.com/elasticbeanstalk/home?region=us-east-2#/environments, entorno de servidor web
Plataforma: Java, Ramificación de plataforma: Java 8 que se ejecuta en Amazon Linux de 64 bits, con versión predeterminada, Código de aplicación: Aplicación de muestra
Y configuró usuario y contraseña para la base de datos inicial creada.

A continuación, cuando la condición es correcta, carga e implementa el jar generado con Gradle localmente, finalmente puede probar la aplicación con la url con el sufijo elasticbeanstalk.com.

Usar collection de Postman para probar los servicios Personas.postman_collection.json