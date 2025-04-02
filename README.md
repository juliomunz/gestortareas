# 📋 Gestor de Tareas

Proyecto CRUD desarrollado con Java 17 y Spring Boot 3.4.4, que permite gestionar proyectos y tareas asociadas. Incluye validaciones, manejo de errores personalizado, documentación Swagger y está completamente dockerizado para facilitar su ejecución en cualquier entorno.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- PostgreSQL
- Hibernate Validator
- Swagger (Springdoc OpenAPI)
- Docker & Docker Compose

---

## 🛠️ Requisitos

- Java 17
- Maven 3.8+
- Docker

---

## 🐳 Ejecutar el proyecto con Docker

1. Clona el repositorio:

```bash
git clone https://github.com/juliomunz/gestortareas.git
cd gestortareas
```

2. Genera el `.jar`:

```bash
./mvnw clean package -DskipTests
```

3. Levanta los servicios:

docker-compose up --build


La aplicación quedará disponible en:

- API: [http://localhost:8080](http://localhost:8080)
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📦 Estructura del proyecto

```plaintext
├── src/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── exception/
│   └── config/
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
├── .gitignore
└── README.md
```

---

## 🔌 Endpoints principales

### 📁 Proyectos

- `POST /api/proyectos` — Crear un proyecto
- `GET /api/proyectos` — Listar proyectos
- `GET /api/proyectos/{id}` — Obtener por ID
- `PUT /api/proyectos/{id}` — Actualizar
- `DELETE /api/proyectos/{id}` — Eliminar

### 📝 Tareas

- `POST /api/tareas` — Crear una tarea
- `GET /api/tareas` — Listar tareas
- `GET /api/tareas/{id}` — Obtener por ID
- `GET /api/tareas/proyecto/{idProyecto}` — Tareas por proyecto
- `PUT /api/tareas/{id}` — Actualizar
- `DELETE /api/tareas/{id}` — Eliminar

---

## ❗ Manejo de errores personalizados

- `404 Not Found` cuando no se encuentra un recurso
- `400 Bad Request` con validaciones como:
```json
{
  "mensaje": "Error de validación",
  "errores": {
    "nombre": "El nombre del proyecto es obligatorio."
  }
}
```

---

⚠️ **Importante**

Antes de construir la imagen con Docker, asegúrate de que el archivo `.dockerignore` **no esté excluyendo la carpeta `target/`**, ya que es necesario copiar el `.jar` generado.

Recomendado:

1. Ejecuta: `./mvnw clean package -DskipTests`
2. Comenta temporalmente esta línea en `.dockerignore`:

## 🙌 Autor

Julio Muñoz Cortés
Desarrollador de software  
[github.com/juliomunz](https://github.com/juliomunz)

---
