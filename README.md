# basic-oauth2
Ejemplo sencillo de oauth2 grant_type: authorization_code
![image](https://user-images.githubusercontent.com/34213812/236286050-431fb847-1e2b-44ab-9ba0-411d889a7367.png)

## API
#### Obtener todas las empresas

```http
  GET http://localhost:8081/api/v1/empresas
```

#### Obtener las ultimas tres empresas

```http
  GET http://localhost:8081/api/v1/empresas/last
```

#### Crear Empresa

```http
  POST http://localhost:8081/api/v1/empresas
```
```bash
{
    "ruc": "2544545411423420",
    "razonSocial": "Empresa B",
    "direccion": "2D de Mayo",
    "estado": 1
}
```
## Oauth2

Todos los servicios necesitan token para solicitar/registrar recursos

- ss-auth: Servicio para obtener token con username:password -> fico:fico

- ss-resource: Servicios de Empresa ->  Necesitan token 

### Flujo oauth2

- Levantar servicios ss-auth y ss-resource
- Ir a la siguiente direccion
```bash
http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=https://springone.io/authorized&code_challenge=QYPAZ5NU8yvtlQ9erXrUYR-T5AGCjCF47vN-KsaI2A8&code_challenge_method=S256
```
- Autenticarse con fico:fico. Despues de iniciar sesion, en la url te retornara un code(copiar)

![image](https://user-images.githubusercontent.com/34213812/236283050-70a29ba8-792f-4359-b9bb-900ddf0dca31.png)
![image](https://user-images.githubusercontent.com/34213812/236283169-f67cfa36-fc04-4718-80ee-0d01fd84e220.png)

- Despues de iniciar sesion, copiar code en parametro code y solicitar request a la siguiente url con metodo POST
```bash
http://localhost:8080/oauth2/token?client_id=client&redirect_uri=https://springone.io/authorized&grant_type=authorization_code&code=LOtJ0zAvJH8lZJv8jDZ0UinDCiD4c6YoBxHJX0hCKLxjFXF-CI5IdpP3AsnPAnsQ9cCbCl6W33_mhXtYk3zJANLn4TSxVpKPzI3_DtyfaPe1UP1XdlvjvyKoHEKcWZ4R&code_verifier=qPsH306-ZDDaOE8DFzVn05TkN3ZZoVmI_6x4LsVglQI
```

![image](https://user-images.githubusercontent.com/34213812/236283694-e66bafbb-4865-4b36-bb59-8b8a8733610c.png)
![image](https://user-images.githubusercontent.com/34213812/236284328-de0010f5-dc3c-434a-94dc-1599fadef748.png)

- access_token es el token para usarse para los servicios de empresa
![image](https://user-images.githubusercontent.com/34213812/236284672-d0b05cc2-ee2e-418e-8ea6-b2d369675a94.png)

En auth2-fico.postman_collection.json. Esta las colecciones de las consultas.

### Referencias
 - [Oauth2](https://www.youtube.com/watch?v=nNVlewjKQEQ)
  - [SpringSecurity](https://www.youtube.com/@laurspilca)
