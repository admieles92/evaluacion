# Getting Started

### Swagger
http://localhost:8080/swagger-ui/index.html#/user-controller/register

### To Test
http://localhost:8080/swagger-ui/index.html#/user-controller/register

Metodo POST http://localhost:8080/api/register

Example:
{
  "name": "Andrea Del Pezo",
  "email": "andycarolina14@gmail.com",
  "password": "Abc123",
  "phones": [
    {
      "number": "1234",
      "citycode": "12",
      "contrycode": "1"
    },
    {
      "number": "5678",
      "citycode": "56",
      "contrycode": "5"
    }
  ]
}

### Result

#1
Code 
201

Response body

{
  "id": "580468df-dc60-4867-bf82-c74b93e81fda",
  "name": "Andrea Del Pezo",
  "email": "andycarolina14@gmail.com",
  "created": "2025-04-23T00:16:59.9178986",
  "updated": "2025-04-23T00:16:59.9178986",
  "lastLogin": "2025-04-23T00:16:59.9188958",
  "token": "ec2e5c8d-ed95-4a85-adfc-9903014458e0",
  "active": true
}

#2
400

Error: response status is 400

Response body

{
  "mensaje": "El correo ya registrado"
}

#3
400

Error: response status is 400

Response body

{
  "mensaje": "400 BAD_REQUEST \"Contraseña no cumple con el formato requerido\""
}