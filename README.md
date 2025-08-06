# 📘 Sistema de Gestión de Turnos (JDBC + Swagger)

Proyecto desarrollado en **Java puro** utilizando el patrón DAO con JDBC, junto con una simulación y documentación de API REST mediante **Swagger Core (OpenAPI 3)**. El sistema permite registrar usuarios, agendar turnos, listarlos, actualizarlos y eliminarlos, todo bajo una arquitectura en capas bien definida (DAO - Service - Controller).

---

## 🚀 Tecnologías

- **Java 21**
- **JDBC puro**
- **MySQL**
- **Swagger Core (OpenAPI 3)**
- **Maven**
- DAO Pattern
- Arquitectura en capas (DAO, Service, Controller)

---

## 📁 Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── com/
│           └── santi/
│               └── jdbc_swagger/
│                   ├── App.java
│                   ├── controllers/
│                   │   └── SimuladorAPI.java
│                   ├── dao/
│                   │   ├── UsuarioDAO.java
│                   │   ├── TurnoDAO.java
│                   │   ├── UsuarioDAOJDBC.java
│                   │   └── TurnoDAOJDBC.java
│                   ├── models/
│                   │   ├── Usuario.java
│                   │   └── Turno.java
│                   ├── services/
│                   │   ├── UsuarioService.java
│                   │   ├── UsuarioServiceImpl.java
│                   │   ├── TurnoService.java
│                   │   └── TurnoServiceImpl.java
│                   └── utils/
│                       └── ConexionBD.java
```

---

## 📚 Funcionalidades principales

- Registro de nuevos usuarios
- Agendamiento de turnos por usuario
- Consulta de turnos por usuario
- Edición y cancelación de turnos
- Eliminación de usuarios
- Simulación de API REST documentada con Swagger (anotaciones OpenAPI 3)

---

## 📄 Documentación de la API (Simulada con Swagger Core)

Controlador simulado: `SimuladorAPI.java`  
Se encuentra documentado con anotaciones de OpenAPI 3 (Swagger Core).

### Ejemplo de endpoints simulados:

- `POST /usuarios`: registrar un nuevo usuario
- `GET /usuarios`: listar todos los usuarios
- `DELETE /usuarios/{id}`: eliminar un usuario
- `POST /turnos`: agendar un turno
- `GET /turnos/{usuarioId}`: obtener turnos de un usuario
- `PUT /turnos/{id}`: actualizar turno
- `DELETE /turnos/{id}`: cancelar turno

> ⚠️ Nota: los endpoints son simulados, no están expuestos mediante un servidor web. Las anotaciones permiten generar la documentación con Swagger Core.

