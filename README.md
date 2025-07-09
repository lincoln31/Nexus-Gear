# Nexus-Gear
# Nexus Gear: E-commerce de Microservicios

<!-- Reemplaza estos badges con los tuyos cuando configures el CI/CD. Puedes generarlos en shields.io -->
![Build Status]()
![Code Coverage]()
![License]()

**Nexus Gear** es una plataforma de e-commerce completamente funcional, diseñada y construida desde cero como un proyecto de portafolio para demostrar habilidades avanzadas en arquitectura de software, desarrollo full-stack y prácticas de DevOps. La plataforma se especializa en la venta de hardware y periféricos de alta gama para entusiastas de la tecnología.

### ✨ [Ver la Demo en Vivo]() ✨

<!-- ¡IMPORTANTE! Actualiza este enlace tan pronto como tengas el primer despliegue. Un enlace funcional es crucial. -->

---

## 🚀 Características Principales

*   **Arquitectura de Microservicios:** El backend está desacoplado en servicios independientes (`Usuarios y Autenticación`, `Productos`, `Órdenes`) que se comunican de forma síncrona (REST) y asíncrona.
*   **Autenticación y Autorización Segura:** Implementación de JWT (JSON Web Tokens) con roles de usuario (`Cliente`, `Admin`).
*   **Catálogo de Productos Detallado:** Gestión completa de productos con categorías, especificaciones técnicas y galería de imágenes.
*   **Carrito de Compras Persistente:** Los usuarios pueden añadir productos a su carrito, que persiste entre sesiones.
*   **Flujo de Checkout Simulado:** Proceso de pago completo que interactúa con una pasarela de pagos externa simulada.
*   **Panel de Administración:** Interfaz para que los administradores gestionen productos, vean órdenes y administren usuarios.

---

## 🛠️ Stack Tecnológico

Una selección de tecnologías modernas y robustas para construir una aplicación escalable y mantenible.

| Área                | Tecnología                                                                                                                                                            |
| ------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Frontend**        | ![React](https://img.shields.io/badge/-React-61DAFB?logo=react&logoColor=white) ![TypeScript](https://img.shields.io/badge/-TypeScript-3178C6?logo=typescript&logoColor=white) ![TailwindCSS](https://img.shields.io/badge/-TailwindCSS-38B2AC?logo=tailwind-css&logoColor=white) |
| **Backend**         | ![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white) ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-6DB33F?logo=spring&logoColor=white)                                                                          |
| **Base de Datos & Cache** | ![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-4169E1?logo=postgresql&logoColor=white) ![Redis](https://img.shields.io/badge/-Redis-DC382D?logo=redis&logoColor=white)                                                                |
| **DevOps**          | ![Docker](https://img.shields.io/badge/-Docker-2496ED?logo=docker&logoColor=white) ![GitHub Actions](https://img.shields.io/badge/-GitHub%20Actions-2088FF?logo=github-actions&logoColor=white) ![Kubernetes](https://img.shields.io/badge/-Kubernetes-326CE5?logo=kubernetes&logoColor=white) |

---

## 🏛️ Arquitectura del Sistema

El sistema está diseñado siguiendo el **Modelo C4** para visualizar la arquitectura de software en diferentes niveles de abstracción.

### Nivel 1: Diagrama de Contexto del Sistema

Muestra cómo la plataforma Nexus Gear encaja en su entorno con usuarios y sistemas externos.

![Diagrama de Contexto C1](docs/diagrams/C1_Context_Diagram.png)
<!-- Asegúrate de que la ruta a tu imagen sea correcta -->

### Nivel 2: Diagrama de Contenedores

Hace zoom en el sistema para mostrar los principales bloques de construcción (aplicaciones, bases de datos, etc.).

![Diagrama de Contenedores C2](docs/diagrams/C2_Container_Diagram.png)
<!-- Asegúrate de que la ruta a tu imagen sea correcta -->

---

## 🏁 Cómo Empezar (Setup Local)

Sigue estos pasos para levantar el entorno completo en tu máquina local.

### Prerrequisitos

*   [Git](https://git-scm.com/)
*   [Java JDK 17 o superior](https://www.oracle.com/java/technologies/downloads/)
*   [Node.js v18 o superior](https://nodejs.org/)
*   [Docker y Docker Compose](https://www.docker.com/products/docker-desktop/)

### Pasos de Instalación

1.  **Clona el repositorio:**
    ```bash
    git clone https://github.com/TU_USUARIO/TU_REPO.git
    cd TU_REPO
    ```

2.  **Levanta la Infraestructura Base (Base de Datos y Caché):**
    Este comando iniciará los contenedores de PostgreSQL y Redis en segundo plano (`-d`).
    ```bash
    docker-compose up -d
    ```
    Puedes verificar que están corriendo con `docker ps`.

3.  **Ejecuta los Microservicios de Backend:**
    Necesitarás una terminal separada para cada microservicio.

    *   **Terminal 1: Iniciar `product-service`**
        ```bash
        cd Backend/product-service
        mvn spring-boot:run
        ```
        El servicio estará disponible en `http://localhost:8081`.

    *   **Terminal 2: Iniciar `order-service`**
        ```bash
        cd Backend/order-service
        mvn spring-boot:run
        ```
        El servicio estará disponible en `http://localhost:8082`.

    *   *(Próximamente: Iniciar `user-auth-service`)*

4.  **Ejecuta la Aplicación Frontend:**
    En una nueva terminal, inicia la aplicación de React.

    *   **Terminal 3: Iniciar Frontend**
        ```bash
        cd frontend
        npm install # Solo la primera vez
        npm run dev
        ```
        La aplicación web estará disponible en `http://localhost:5173`.

5.  **¡Listo para Desarrollar!**
    Ahora tienes todo el stack corriendo localmente. Abre `http://localhost:5173` en tu navegador para ver la aplicación.

## 🧪 Ejecutar Pruebas

La calidad del software es una prioridad. El proyecto incluye un conjunto de pruebas unitarias y de integración.

*   **Para ejecutar las pruebas del backend (Java/Spring):**
    ```bash
    # Navega al directorio del microservicio
    cd backend/product-service
    # Ejecuta los tests
    mvn test
    ```

*   **Para ejecutar las pruebas del frontend (React):**
    ```bash
    # Navega al directorio del frontend
    cd frontend
    # Ejecuta los tests
    npm test
    ```

---

## 🗺️ Roadmap y Mejoras Futuras

Este proyecto es una base sólida con potencial para crecer. Algunas de las futuras mejoras planeadas son:

-   [ ] **Integración Real de Pagos:** Implementar la API de Stripe para procesar pagos reales.
-   [ ] **Comunicación Asíncrona:** Usar RabbitMQ o Kafka para la comunicación entre servicios (ej. cuando se crea una orden, se envía un evento).
-   [ ] **Observabilidad:** Integrar un stack de monitoreo con Prometheus, Grafana y Loki.
-   [ ] **Sistema de Reseñas:** Permitir a los usuarios dejar reseñas y calificaciones en los productos.

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

---

## 👤 Contacto

**[Tu Nombre]**

*   **GitHub:** [lincol31](https://github.com/lincoln31)
*   **LinkedIn:** [linkedin.com](https://www.linkedin.com/in/juanestebancollazosvalencia31)
