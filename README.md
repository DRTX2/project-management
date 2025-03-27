# Project Management

This project allows the creation of boards, tasks, user assignment and comments. Also I change these requirements
through the development process.

## Architecture

📂 com.tuapp (Raíz del proyecto)
├── 📂 core (Dominio y lógica de negocio - NO depende de Spring)
│ ├── 📂 model → Entidades (User, Project, Task, etc.)
│ ├── 📂 ports → Interfaces (UserRepository, ProjectRepository, etc.)
│ ├── 📂 usecase → Casos de uso (UserService, ProjectService, etc.)
│
├── 📂 adapters (Infraestructura, conecta el dominio con el exterior)
│ ├── 📂 persistence → Implementaciones de repositorios (JPA, MongoDB, etc.)
│ ├── 📂 rest → Controladores REST (UserController, ProjectController, etc.)
│ ├── 📂 messaging → Integración con colas de mensajes (Kafka, RabbitMQ, etc.)
│ ├── 📂 external → APIs externas o servicios de terceros
│
├── 📂 config (Configuraciones de Spring y Beans)
│ ├── ApplicationConfig.java → Configuración general (Beans, Mappers, etc.)
│ ├── SecurityConfig.java → Configuración de seguridad (Spring Security, JWT, etc.)
│
├── 📂 app (Capa de Aplicación - Punto de entrada de Spring Boot)
│ ├── Application.java → Clase principal con @SpringBootApplication

## Entities

- User
    - ID
    - Name
      - Email
    - Password
    - Role
    - Date of registration
    - List of associated projects
- Project
    - Id
    - Name
    - Description
    - Owner(User)
    - Creation date
    - End date
    - List of associated boards
- Board
    - Id
    - Name
    - Description
    - Asociated project
    - List of Tasks
- List of Tasks
    - Id
    - Name
    - Board position
    - List of tasks
- Tasks
    - Id
    - Name
    - Description
    - State(pending, in progress, complete)
    - Priority
    - End Date
    - Assigned to ...(User)
    - List of Comments
- Comment
    - Id
    - Text
    - Author user
    - Creation date
    - Associated Task
- Notification
    - Id
    - Message
    - Type
    - Target user
    - Date of sending
- Label(etiqueta)
    - Id
    - Name
    - Color
    - List of associated tasks
- Attachment (Adjunto)
    - Id
    - Name
    - Url to the source file
    - File type
    - User who updated it
    - Related task
## TO DO

- entities for boards, tasks, users, and comments.
- the frontend using something like angular or react.
- Order to chatgpt more ideas



## GPT

Historial de Actividad (ActivityLog)

ID

Usuario que realizó la acción

Acción realizada (creó, editó, movió, etc.)

Entidad afectada (Tarea, Proyecto, etc.)

Timestamp

🔥 Relaciones clave:
Un Usuario puede tener múltiples Proyectos.

Un Proyecto puede tener múltiples Tableros.

Un Tablero tiene múltiples Listas de Tareas.

Una Lista de Tareas agrupa múltiples Tareas.

Una Tarea puede tener múltiples Comentarios, Etiquetas y Adjuntos.

Un Usuario puede ser asignado a múltiples Tareas.

Un Usuario recibe Notificaciones según la actividad en sus proyectos/tareas.

Con estas entidades, la plataforma cubriría lo esencial de un gestor de proyectos con tareas organizadas en tableros tipo Trello. ¿Quieres que profundicemos en alguna parte, como autenticación, control de acceso o lógica de negocio? 🚀






