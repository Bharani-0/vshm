# Vehicle Service History Manager (VSHM)

This repository now contains a clean full-stack starter architecture for a **Vehicle Service History Manager**:

- `backend/` → Spring Boot REST API (MVC), MySQL-ready, JWT auth, role-based access
- `frontend/` → React + Vite dashboard UI scaffold with responsive sidebar/cards/tables

## Backend highlights

- Modular package structure (`controller`, `service`, `repository`, `entity`, `security`, `exception`, `dto`)
- Entity relationships:
    - `User (1) -> (N) Vehicle`
    - `Vehicle (1) -> (N) ServiceRecord`
- JWT-based registration and login
- Role-based endpoint protection (`USER`, `ADMIN`)
- Input validation via Jakarta Validation
- Centralized exception handling with consistent API errors
- User and admin dashboards
- Service reminder APIs (upcoming + overdue)

## Frontend highlights

- Professional sidebar navigation layout
- Dashboard cards and data tables
- Mobile responsive CSS
- Action buttons aligned to common CRUD operations
- Ready for API wiring with Axios

## Suggested industry-level improvements

1. Add refresh tokens + token revocation list for session security.
2. Introduce Liquibase/Flyway for versioned DB migrations.
3. Add MapStruct for entity-dto mapping consistency.
4. Use Spring Data Specifications for admin search/filtering.
5. Implement audit logging with `createdBy`, `updatedBy`, and security events.
6. Add OpenAPI/Swagger docs for all endpoints.
7. Add containerization (`Dockerfile`, `docker-compose` with MySQL).
8. Add integration tests with Testcontainers.
9. Introduce pagination and sorting for admin data tables.
10. Add observability stack: Micrometer + Prometheus + Grafana.
