# CRUD con Spring WebFlux, R2DBC PostgreSQL y Angular 19 Standalone

## Descripción
Este proyecto implementa un CRUD utilizando:
- **Backend:** Spring WebFlux con R2DBC y PostgreSQL en Java 21.
- **Frontend:** Angular 19 en modo standalone.

## Requisitos
### Backend
- Java 21
- Gradle
- PostgreSQL

### Frontend
- Node.js 18+
- Angular CLI

---

## Configuración del Backend

### 1. Clonar el repositorio
```sh
git clone https://github.com/jhonEdisonVargas96/crud-backend.git
cd backend
```

### 2. Configurar la base de datos
Crear una base de datos en PostgreSQL:
```sql
CREATE TABLE users (
                              id BIGSERIAL PRIMARY KEY,
                              first_name VARCHAR(255),
                              last_name VARCHAR(255),
                              rut NUMERIC,
                              dv VARCHAR(5),
                              birth_date DATE,
                              email_address VARCHAR(255),
                              password VARCHAR(255)
);
```
Configurar en `application.yml`:
```yaml
spring:
  r2dbc:
    url: r2dbc:postgresql://localhost:5432/users_db
    username: postgres
    password: tu_password
```

### 3. Ejecutar el backend con el perfil del properties

El backend estará disponible en `http://localhost:8080`.

---

## Configuración del Frontend

### 1. Clonar el frontend
```sh
cd crud-front
```

### 2. Instalar dependencias
```sh
npm install
```

### 3. Ejecutar Angular
```sh
ng serve
```

El frontend estará disponible en `http://localhost:4200`.

---

## Endpoints API (Spring WebFlux)

| Método | Endpoint        | Descripción |
|--------|---------------|-------------|
| GET    | `/users`      | Obtener todos los usuarios |
| GET    | `/users/{id}` | Obtener un usuario por ID |
| POST   | `/users`      | Crear un usuario |
| PUT    | `/users/{id}` | Actualizar un usuario |
| DELETE | `/users/{id}` | Eliminar un usuario |


## Tecnologías Utilizadas
### Backend
- Java 21
- Spring WebFlux
- R2DBC
- PostgreSQL

### Frontend
- Angular 19 Standalone
- Angular Material
- Bootstrap 5
- RxJS

## Autores
- Jhon Osorio

