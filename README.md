# evaluacion
Evaluación: JAVA

# User API - Spring Boot + JWT + H2

Este proyecto es una API RESTful para el registro de usuarios, implementado con Spring Boot y autenticación JWT. Almacena datos en memoria usando H2 y expone endpoints protegidos mediante token.

---

## ✅ Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Security
- JWT (jjwt)
- JPA (Hibernate)
- H2 (base en memoria)
- Maven
- Swagger OpenAPI

---

## 🚀 Cómo ejecutar

Clona el proyecto y ejecuta:

```bash
./mvnw spring-boot:run

## 🔗 Accesos rápidos

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **Consola H2**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - JDBC URL: `jdbc:h2:mem:usersdb`
  - Usuario: `sa`
  - Clave: *(dejar en blanco)*

---

## 🔐 Login

```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "clave123"
}
```

La respuesta incluye un token JWT como este:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## ✅ Registro de usuario (requiere token)

```http
POST /api/register
Authorization: Bearer <token>

{
  "name": "Juan Pérez",
  "email": "juan@mail.com",
  "password": "Passw0rd",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "contrycode": "57"
    }
  ]
}
```

---

## 🧪 Validaciones

- Contraseña debe cumplir con: al menos una mayúscula, una minúscula, un número y mínimo 6 caracteres.
- Email único.
- Validación JWT.

---

## 🧱 Script de creación de base de datos (`schema.sql`)

Incluido en `src/main/resources/schema.sql` para referencia, aunque la base se genera automáticamente con JPA.

---
## 🧭 Diagrama de la solución

Incluido en el archivo [`diagrama.png`](diagrama.png):

![Diagrama](diagrama.png)

---

## 📂 Estructura del proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com.smartJob.userApi.user
│   └── resources/
│       ├── application.properties
│       └── schema.sql
```

---

## ✍️ Autor

Desarrollado por Andrea Del Pezo Mieles como parte de una prueba técnica.
