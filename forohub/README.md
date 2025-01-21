# HackHub - Foro API Rest

Este es un proyecto de una API Rest diseñada para gestionar foros, donde los usuarios pueden crear temas, responder a temas existentes, crear cursos, gestionar usuarios y autenticarse en la plataforma. La API está construida utilizando Spring Boot, JDK 17 y MySQL. Además, se implementa la autenticación y autorización mediante JWT con el apoyo de Spring Security.

## Tecnologías utilizadas

- **Spring Boot**: Framework principal para construir la API Rest.
- **JDK 17**: Lenguaje de programación Java utilizado para desarrollar la aplicación.
- **MySQL**: Base de datos relacional para almacenar la información de los foros, usuarios, temas y cursos.
- **Spring Security**: Framework para la autenticación y autorización en la aplicación.
- **JWT (JSON Web Tokens)**: Método de autenticación basado en tokens para garantizar la seguridad de las solicitudes.

## Funcionalidades

- **Gestión de temas**: Los usuarios pueden crear nuevos temas en el foro, ver temas existentes y responder a ellos.
- **Respuestas a temas**: Los usuarios pueden agregar respuestas a los temas, creando conversaciones dentro del foro.
- **Creación de cursos**: Los administradores pueden crear cursos que serán accesibles a los usuarios.
- **Gestión de usuarios**: Los usuarios pueden registrarse y actualizar su información.
- **Autenticación**: Los usuarios pueden iniciar sesión utilizando su correo electronico y contraseña. Se utiliza JWT para gestionar la sesión de forma segura.
- **Autorización**: Dependiendo de los roles de los usuarios (por ejemplo, usuario normal o administrador), se pueden realizar diferentes acciones en la plataforma.

## Instalación

Para ejecutar este proyecto en tu máquina local, sigue los pasos a continuación:

### Requisitos previos

- JDK 17
- MySQL
- Maven

### Pasos para la instalación

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/foro-api-rest.git
   cd foro-api-rest
