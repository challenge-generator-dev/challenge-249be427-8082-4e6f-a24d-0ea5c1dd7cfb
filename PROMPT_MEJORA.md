# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/prestamos/api/model/dto/LoanRequest.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/prestamos/api/model/dto/LoanResponse.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/prestamos/api/controller/LoanController.java` — `io.swagger.v3`: El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/prestamos/api/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/prestamos/api/controller/LoanControllerTest.java` — `com.fasterxml.jackson`: El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setId`: Se invoca `setId` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setAmount`: Se invoca `setAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setInterestRate`: Se invoca `setInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setTerm`: Se invoca `setTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setCreationDate`: Se invoca `setCreationDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setDueDate`: Se invoca `setDueDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `LoanRepository.save`: Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `LoanRepository.findAll`: Se invoca `findAll` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `LoanRepository.deleteById`: Se invoca `deleteById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getId`: Se invoca `getId` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getAmount`: Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getInterestRate`: Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getTerm`: Se invoca `getTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getCreationDate`: Se invoca `getCreationDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getDueDate`: Se invoca `getDueDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setId`: Se invoca `setId` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setAmount`: Se invoca `setAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setInterestRate`: Se invoca `setInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setTerm`: Se invoca `setTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setCreationDate`: Se invoca `setCreationDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setDueDate`: Se invoca `setDueDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `LoanRepository.save`: Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `LoanServiceImpl.createLoan`: Se invoca `createLoan` sobre `LoanServiceImpl`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `LoanRepository.findAll`: Se invoca `findAll` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.getAmount`: Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.getInterestRate`: Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.getTerm`: Se invoca `getTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Crear una API REST con persistencia en H2 y documentación con Swagger

### Reto
- Tema: creación de api rest con persistencia y documentación
- Seniority: junior-l2
- Tipo: practical
- Título: Implementación de una API REST en el dominio de gestión de préstamos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del modelo de datos y creación de la API — objetivo: Definir el modelo de datos para las solicitudes de préstamos y crear la API REST básica. — entregable (NO resolver): Modelo de datos definido y API REST básica creada con validaciones.
- Fase 2: Persistencia en H2 y manejo de errores — objetivo: Persistir las solicitudes de préstamos en una base de datos H2 y manejar los errores de validación. — entregable (NO resolver): Solicitudes de préstamos persistidas en H2 y API REST con manejo de errores de validación.
- Fase 3: Documentación con Swagger — objetivo: Documentar la API REST con Swagger para que sea fácil de usar y entender. — entregable (NO resolver): API REST documentada con Swagger.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.0</version>
        <relativePath/>
    </parent>

    <groupId>com.prestamos.api</groupId>
    <artifactId>prestamos-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>prestamos-api</name>
    <description>API REST para gestión de préstamos</description>

    <properties>
        <java.version>17</java.version>
        <springdoc-openapi-ui.version>2.5.0</springdoc-openapi-ui.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Base de datos H2 -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Documentación OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>${springdoc-openapi-ui.version}</version>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- Tests -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

// === ARCHIVO: src/main/java/com/prestamos/api/PrestamosApiApplication.java ===
package com.prestamos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prestamos.api.repository")
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = "com.prestamos.api.config")
public class PrestamosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrestamosApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public String demoDataInitializer() {
        return "Demo data initialization bean";
    }
}

// === ARCHIVO: src/main/resources/application.properties ===
# Configuración de Spring Boot
spring.application.name=prestamos-api

# Configuración de la base de datos H2
spring.datasource.url=jdbc:h2:mem:prestamosdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuración para mostrar SQL en consola
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Configuración de SpringDoc OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.operationsSorter=alpha
springdoc.swagger-ui.docExpansion=none

// === ARCHIVO: src/main/java/com/prestamos/api/repository/LoanRepository.java ===
package com.prestamos.api.repository;

import com.prestamos.api.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {
    Optional<Loan> findById(UUID id);
}

// === ARCHIVO: src/main/java/com/prestamos/api/model/dto/LoanRequest.java ===
package com.prestamos.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "DTO para la creación y actualización de préstamos")
public class LoanRequest {
    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser positivo")
    @Schema(description = "Monto del préstamo", example = "1000.00")
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés no puede ser nula")
    @DecimalMin(value = "0.0", message = "La tasa de interés debe ser mayor o igual a 0")
    @DecimalMax(value = "100.0", message = "La tasa de interés debe ser menor o igual a 100")
    @Schema(description = "Tasa de interés del préstamo", example = "5.5")
    private BigDecimal interestRate;

    @NotNull(message = "El plazo no puede ser nulo")
    @Min(value = 1, message = "El plazo debe ser al menos 1")
    @Schema(description = "Plazo del préstamo en meses", example = "12")
    private Integer term;
}

// === ARCHIVO: src/main/java/com/prestamos/api/model/dto/LoanResponse.java ===
package com.prestamos.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Schema(description = "DTO para la respuesta de préstamos")
public class LoanResponse {
    @Schema(description = "Identificador único del préstamo", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Monto del préstamo", example = "1000.00")
    private BigDecimal amount;

    @Schema(description = "Tasa de interés del préstamo", example = "5.5")
    private BigDecimal interestRate;

    @Schema(description = "Plazo del préstamo en meses", example = "12")
    private Integer term;

    @Schema(description = "Fecha de creación del préstamo", example = "2023-10-01")
    private LocalDate creationDate;

    @Schema(description = "Fecha de vencimiento del préstamo", example = "2024-10-01")
    private LocalDate dueDate;
}

// === ARCHIVO: src/main/java/com/prestamos/api/model/entity/Loan.java ===
package com.prestamos.api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "El monto del préstamo es obligatorio")
    @Positive(message = "El monto debe ser mayor que cero")
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @NotNull(message = "La tasa de interés es obligatoria")
    @DecimalMin(value = "0.0", message = "La tasa de interés no puede ser menor a 0")
    @DecimalMax(value = "100.0", message = "La tasa de interés no puede ser mayor a 100")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate;

    @NotNull(message = "El plazo es obligatorio")
    @Min(value = 1, message = "El plazo debe ser al menos 1 mes")
    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDate.now();
        dueDate = creationDate.plusMonths(term);
    }

    public void updateFromRequest(BigDecimal newAmount, BigDecimal newInterestRate, Integer newTerm) {
        this.amount = newAmount;
        this.interestRate = newInterestRate;
        this.term = newTerm;
        this.dueDate = this.creationDate.plusMonths(this.term);
    }
}

// === ARCHIVO: src/main/java/com/prestamos/api/controller/LoanController.java ===
package com.prestamos.api.controller;

import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
@Tag(name = "Gestión de Préstamos", description = "API REST para la gestión de solicitudes de préstamos")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @Operation(summary = "Crear un nuevo préstamo", description = "Registra una nueva solicitud de préstamo en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Préstamo creado exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(
            @Valid @RequestBody LoanRequest request) {
        LoanResponse created = loanService.createLoan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Obtener un préstamo por ID", description = "Recupera los detalles de un préstamo específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Préstamo encontrado",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class))),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponse> getLoanById(
            @Parameter(description = "UUID del préstamo", required = true) @PathVariable UUID id) {
        LoanResponse loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @Operation(summary = "Listar todos los préstamos", description = "Obtiene una lista de todos los préstamos registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de préstamos obtenida exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class)))
    })
    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        List<LoanResponse> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @Operation(summary = "Actualizar un préstamo", description = "Modifica los datos de un préstamo existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Préstamo actualizado exitosamente",
                     content = @Content(schema = @Schema(implementation = LoanResponse.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                     content = @Content(schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<LoanResponse> updateLoan(
            @Parameter(description = "UUID del préstamo", required = true) @PathVariable UUID id,
            @Valid @RequestBody LoanRequest request) {
        LoanResponse updated = loanService.updateLoan(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar un préstamo", description = "Elimina un préstamo del sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Préstamo eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Préstamo no encontrado",
                     content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(
            @Parameter(description = "UUID del préstamo", required = true) @PathVariable UUID id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}

// === ARCHIVO: src/main/java/com/prestamos/api/service/LoanService.java ===
package com.prestamos.api.service;

import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import java.util.List;
import java.util.UUID;

public interface LoanService {

    LoanResponse createLoan(LoanRequest request);

    LoanResponse getLoanById(UUID id);

    List<LoanResponse> getAllLoans();

    LoanResponse updateLoan(UUID id, LoanRequest request);

    void deleteLoan(UUID id);
}

// === ARCHIVO: src/main/java/com/prestamos/api/exception/LoanValidationException.java ===
package com.prestamos.api.exception;

import java.util.Map;
import java.util.HashMap;

public class LoanValidationException extends RuntimeException {
    private final String errorCode;
    private final String fieldName;
    private final Object rejectedValue;
    private final Map<String, Object> details;

    public LoanValidationException(String message, String errorCode, String fieldName) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.rejectedValue = null;
        this.details = new HashMap<>();
    }

    public LoanValidationException(String message, String errorCode, String fieldName, Object rejectedValue) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
        this.details = new HashMap<>();
    }

    public LoanValidationException(String message, String errorCode, String fieldName, Object rejectedValue, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
        this.details = new HashMap<>();
    }

    public LoanValidationException(String message, String errorCode, Map<String, Object> details) {
        super(message);
        this.errorCode = errorCode;
        this.fieldName = null;
        this.rejectedValue = null;
        this.details = details != null ? details : new HashMap<>();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void addDetail(String key, Object value) {
        this.details.put(key, value);
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoanValidationException[")
          .append("errorCode=").append(errorCode);
        if (fieldName != null) {
            sb.append(", fieldName=").append(fieldName);
        }
        if (rejectedValue != null) {
            sb.append(", rejectedValue=").append(rejectedValue);
        }
        sb.append("]: ").append(super.getMessage());
        return sb.toString();
    }

    public String getFormattedMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        if (fieldName != null && rejectedValue != null) {
            sb.append(" - Campo: ").append(fieldName)
              .append(", Valor rechazado: ").append(rejectedValue);
        } else if (fieldName != null) {
            sb.append(" - Campo afectado: ").append(fieldName);
        }
        return sb.toString();
    }
}

// === ARCHIVO: src/main/java/com/prestamos/api/exception/GlobalExceptionHandler.java ===
package com.prestamos.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanValidationException.class)
    public ResponseEntity<Map<String, Object>> handleLoanValidationException(
            LoanValidationException ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Error");
        response.put("message", ex.getFormattedMessage());
        response.put("errorCode", ex.getErrorCode());
        
        Map<String, Object> details = new HashMap<>();
        if (ex.getFieldName() != null) {
            details.put("field", ex.getFieldName());
        }
        if (ex.getRejectedValue() != null) {
            details.put("rejectedValue", ex.getRejectedValue());
        }
        if (!ex.getDetails().isEmpty()) {
            details.putAll(ex.getDetails());
        }
        response.put("details", details);
        response.put("path", request.getDescription(false).replace("uri=", ""));
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Error");
        
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        response.put("message", errorMessage);
        response.put("errorCode", "VALIDATION_FAILED");
        
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );
        response.put("fieldErrors", fieldErrors);
        response.put("path", request.getDescription(false).replace("uri=", ""));
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Bad Request");
        response.put("message", ex.getMessage());
        response.put("errorCode", "INVALID_ARGUMENT");
        response.put("path", request.getDescription(false).replace("uri=", ""));
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(
            Exception ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Internal Server Error");
        response.put("message", "An unexpected error occurred");
        response.put("errorCode", "INTERNAL_ERROR");
        response.put("path", request.getDescription(false).replace("uri=", ""));
        
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// === ARCHIVO: src/main/java/com/prestamos/api/service/LoanServiceImpl.java ===
package com.prestamos.api.service;

import com.prestamos.api.exception.LoanValidationException;
import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.model.entity.Loan;
import com.prestamos.api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public LoanResponse saveLoan(LoanRequest request) {
        validateLoanRequest(request);
        
        Loan loan = new Loan();
        loan.setId(UUID.randomUUID());
        loan.setAmount(request.getAmount().setScale(2, RoundingMode.HALF_UP));
        loan.setInterestRate(request.getInterestRate().setScale(2, RoundingMode.HALF_UP));
        loan.setTerm(request.getTerm());
        loan.setCreationDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusMonths(request.getTerm()));
        
        Loan savedLoan = loanRepository.save(loan);
        return mapToResponse(savedLoan);
    }

    @Override
    public Optional<LoanResponse> getLoanById(UUID id) {
        if (id == null) {
            throw new LoanValidationException(
                "El ID del préstamo no puede ser nulo",
                "INVALID_ID",
                "id",
                null
            );
        }
        return loanRepository.findById(id).map(this::mapToResponse);
    }

    @Override
    public List<LoanResponse> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LoanResponse updateLoan(UUID id, LoanRequest request) {
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isEmpty()) {
            throw new LoanValidationException(
                "Préstamo no encontrado con ID: " + id,
                "LOAN_NOT_FOUND",
                "id",
                id
            );
        }
        
        validateLoanRequest(request);
        
        Loan loan = existingLoan.get();
        loan.setAmount(request.getAmount().setScale(2, RoundingMode.HALF_UP));
        loan.setInterestRate(request.getInterestRate().setScale(2, RoundingMode.HALF_UP));
        loan.setTerm(request.getTerm());
        loan.setDueDate(LocalDate.now().plusMonths(request.getTerm()));
        
        Loan updatedLoan = loanRepository.save(loan);
        return mapToResponse(updatedLoan);
    }

    @Override
    public void deleteLoan(UUID id) {
        if (id == null) {
            throw new LoanValidationException(
                "El ID del préstamo no puede ser nulo",
                "INVALID_ID",
                "id",
                null
            );
        }
        
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isEmpty()) {
            throw new LoanValidationException(
                "Préstamo no encontrado con ID: " + id,
                "LOAN_NOT_FOUND",
                "id",
                id
            );
        }
        
        loanRepository.deleteById(id);
    }

    private void validateLoanRequest(LoanRequest request) {
        if (request.getAmount() == null) {
            throw new LoanValidationException(
                "El monto del préstamo es obligatorio",
                "MISSING_AMOUNT",
                "amount",
                null
            );
        }
        
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new LoanValidationException(
                "El monto del préstamo debe ser positivo",
                "INVALID_AMOUNT",
                "amount",
                request.getAmount()
            );
        }
        
        if (request.getAmount().compareTo(new BigDecimal("1000000")) > 0) {
            throw new LoanValidationException(
                "El monto del préstamo no puede exceder 1,000,000",
                "AMOUNT_TOO_LARGE",
                "amount",
                request.getAmount()
            );
        }
        
        if (request.getInterestRate() == null) {
            throw new LoanValidationException(
                "La tasa de interés es obligatoria",
                "MISSING_INTEREST_RATE",
                "interestRate",
                null
            );
        }
        
        if (request.getInterestRate().compareTo(BigDecimal.ZERO) < 0 || 
            request.getInterestRate().compareTo(new BigDecimal("100")) > 0) {
            throw new LoanValidationException(
                "La tasa de interés debe estar entre 0 y 100",
                "INVALID_INTEREST_RATE",
                "interestRate",
                request.getInterestRate()
            );
        }
        
        if (request.getTerm() == null) {
            throw new LoanValidationException(
                "El plazo del préstamo es obligatorio",
                "MISSING_TERM",
                "term",
                null
            );
        }
        
        if (request.getTerm() <= 0) {
            throw new LoanValidationException(
                "El plazo del préstamo debe ser un número entero positivo",
                "INVALID_TERM",
                "term",
                request.getTerm()
            );
        }
        
        if (request.getTerm() > 360) {
            throw new LoanValidationException(
                "El plazo del préstamo no puede exceder 360 meses",
                "TERM_TOO_LARGE",
                "term",
                request.getTerm()
            );
        }
    }

    private LoanResponse mapToResponse(Loan loan) {
        LoanResponse response = new LoanResponse();
        response.setId(loan.getId());
        response.setAmount(loan.getAmount());
        response.setInterestRate(loan.getInterestRate());
        response.setTerm(loan.getTerm());
        response.setCreationDate(loan.getCreationDate());
        response.setDueDate(loan.getDueDate());
        return response;
    }
}

// === ARCHIVO: src/main/java/com/prestamos/api/config/OpenApiConfig.java ===
package com.prestamos.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.port:8080}")
    private String serverPort;

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:" + serverPort);
        server.setDescription("Servidor de desarrollo local");

        Contact contact = new Contact();
        contact.setName("Equipo de Desarrollo");
        contact.setEmail("desarrollo@prestamos.com");
        contact.setUrl("https://prestamos.com");

        License license = new License();
        license.setName("Apache 2.0");
        license.setUrl("https://www.apache.org/licenses/LICENSE-2.0.html");

        Info info = new Info();
        info.setTitle("API de Gestión de Préstamos");
        info.setVersion("1.0.0");
        info.setDescription("""
                API REST para la gestión de solicitudes de préstamos bancarios.
                
                Permite realizar operaciones CRUD sobre préstamos con las siguientes características:
                
                - **Monto**: Valor numérico positivo que representa la cantidad solicitada
                - **Tasa de interés**: Porcentaje entre 0 y 100
                - **Plazo**: Número entero positivo de cuotas
                
                La API valida todos los campos antes de persistir en la base de datos.
                """);
        info.setContact(contact);
        info.setLicense(license);

        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(info);
        openAPI.setServers(List.of(server));

        return openAPI;
    }
}

// === ARCHIVO: src/test/java/com/prestamos/api/controller/LoanControllerTest.java ===
package com.prestamos.api.controller;


import com.prestamos.api.exception.LoanValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoanController.class)
class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LoanService loanService;

    private UUID loanId;
    private LoanRequest loanRequest;
    private LoanResponse loanResponse;

    @BeforeEach
    void setUp() {
        loanId = UUID.randomUUID();
        loanRequest = new LoanRequest();
        loanRequest.setAmount(new BigDecimal("10000.00"));
        loanRequest.setInterestRate(new BigDecimal("12.5"));
        loanRequest.setTerm(12);

        loanResponse = new LoanResponse();
        loanResponse.setId(loanId);
        loanResponse.setAmount(new BigDecimal("10000.00"));
        loanResponse.setInterestRate(new BigDecimal("12.5"));
        loanResponse.setTerm(12);
        loanResponse.setCreationDate(LocalDate.now());
        loanResponse.setDueDate(LocalDate.now().plusMonths(12));
    }

    @Test
    @DisplayName("Crear préstamo - caso exitoso")
    void testCreateLoan_Success() throws Exception {
        when(loanService.createLoan(any(LoanRequest.class))).thenReturn(loanResponse);

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loanRequest)));

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(loanId.toString()))
                .andExpect(jsonPath("$.amount").value(10000.00))
                .andExpect(jsonPath("$.interestRate").value(12.5))
                .andExpect(jsonPath("$.term").value(12));
    }

    @Test
    @DisplayName("Obtener préstamo por ID - caso exitoso")
    void testGetLoanById_Success() throws Exception {
        when(loanService.getLoanById(loanId)).thenReturn(Optional.of(loanResponse));

        ResultActions result = mockMvc.perform(get("/api/loans/{id}", loanId));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(loanId.toString()))
                .andExpect(jsonPath("$.amount").value(10000.00));
    }

    @Test
    @DisplayName("Obtener préstamo por ID - no encontrado")
    void testGetLoanById_NotFound() throws Exception {
        when(loanService.getLoanById(loanId)).thenReturn(Optional.empty());

        ResultActions result = mockMvc.perform(get("/api/loans/{id}", loanId));

        result.andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Listar todos los préstamos - caso exitoso")
    void testGetAllLoans_Success() throws Exception {
        when(loanService.getAllLoans()).thenReturn(java.util.List.of(loanResponse));

        ResultActions result = mockMvc.perform(get("/api/loans"));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(loanId.toString()));
    }

    @Test
    @DisplayName("Actualizar préstamo - caso exitoso")
    void testUpdateLoan_Success() throws Exception {
        when(loanService.updateLoan(eq(loanId), any(LoanRequest.class))).thenReturn(Optional.of(loanResponse));

        ResultActions result = mockMvc.perform(put("/api/loans/{id}", loanId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loanRequest)));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(loanId.toString()));
    }

    @Test
    @DisplayName("Eliminar préstamo - caso exitoso")
    void testDeleteLoan_Success() throws Exception {
        doNothing().when(loanService).deleteLoan(loanId);

        ResultActions result = mockMvc.perform(delete("/api/loans/{id}", loanId));

        result.andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Crear préstamo con monto inválido - bad request")
    void testCreateLoan_InvalidAmount() throws Exception {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("-1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(12);

        when(loanService.createLoan(any(LoanRequest.class)))
                .thenThrow(new com.prestamos.api.exception.LoanValidationException("El monto debe ser positivo"));

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)));

        result.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Crear préstamo con tasa de interés inválida - bad request")
    void testCreateLoan_InvalidInterestRate() throws Exception {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("150"));
        invalidRequest.setTerm(12);

        when(loanService.createLoan(any(LoanRequest.class)))
                .thenThrow(new com.prestamos.api.exception.LoanValidationException("La tasa de interés debe estar entre 0 y 100"));

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)));

        result.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Crear préstamo con plazo inválido - bad request")
    void testCreateLoan_InvalidTerm() throws Exception {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(0);

        when(loanService.createLoan(any(LoanRequest.class)))
                .thenThrow(new com.prestamos.api.exception.LoanValidationException("El plazo debe ser un número entero positivo"));

        ResultActions result = mockMvc.perform(post("/api/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)));

        result.andExpect(status().isBadRequest());
    }
}

// === ARCHIVO: src/test/java/com/prestamos/api/service/LoanServiceTest.java ===
package com.prestamos.api.service;

import com.prestamos.api.exception.LoanValidationException;
import com.prestamos.api.model.dto.LoanRequest;
import com.prestamos.api.model.dto.LoanResponse;
import com.prestamos.api.model.entity.Loan;
import com.prestamos.api.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    private UUID loanId;
    private LoanRequest loanRequest;
    private Loan loan;

    @BeforeEach
    void setUp() {
        loanId = UUID.randomUUID();
        loanRequest = new LoanRequest();
        loanRequest.setAmount(new BigDecimal("10000.00"));
        loanRequest.setInterestRate(new BigDecimal("12.5"));
        loanRequest.setTerm(12);

        loan = new Loan();
        loan.setId(loanId);
        loan.setAmount(new BigDecimal("10000.00"));
        loan.setInterestRate(new BigDecimal("12.5"));
        loan.setTerm(12);
        loan.setCreationDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusMonths(12));
    }

    @Test
    @DisplayName("Crear préstamo - caso exitoso")
    void testCreateLoan_Success() {
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        LoanResponse result = loanService.createLoan(loanRequest);

        assertNotNull(result);
        assertEquals(loanId, result.getId());
        assertEquals(new BigDecimal("10000.00"), result.getAmount());
        assertEquals(new BigDecimal("12.5"), result.getInterestRate());
        assertEquals(12, result.getTerm());
        verify(loanRepository, times(1)).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - monto negativo lanza excepción")
    void testCreateLoan_NegativeAmount_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("-1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El monto debe ser positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - monto cero lanza excepción")
    void testCreateLoan_ZeroAmount_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(BigDecimal.ZERO);
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El monto debe ser positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - tasa de interés negativa lanza excepción")
    void testCreateLoan_NegativeInterestRate_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("-5"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("La tasa de interés debe estar entre 0 y 100", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - tasa de interés mayor a 100 lanza excepción")
    void testCreateLoan_InterestRateOver100_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("150"));
        invalidRequest.setTerm(12);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("La tasa de interés debe estar entre 0 y 100", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - plazo cero lanza excepción")
    void testCreateLoan_ZeroTerm_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(0);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El plazo debe ser un número entero positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Crear préstamo - plazo negativo lanza excepción")
    void testCreateLoan_NegativeTerm_ThrowsException() {
        LoanRequest invalidRequest = new LoanRequest();
        invalidRequest.setAmount(new BigDecimal("1000"));
        invalidRequest.setInterestRate(new BigDecimal("10"));
        invalidRequest.setTerm(-6);

        LoanValidationException exception = assertThrows(
                LoanValidationException.class,
                () -> loanService.createLoan(invalidRequest)
        );

        assertEquals("El plazo debe ser un número entero positivo", exception.getMessage());
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Obtener préstamo por ID - caso exitoso")
    void testGetLoanById_Success() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.of(loan));

        Optional<LoanResponse> result = loanService.getLoanById(loanId);

        assertTrue(result.isPresent());
        assertEquals(loanId, result.get().getId());
        verify(loanRepository, times(1)).findById(loanId);
    }

    @Test
    @DisplayName("Obtener préstamo por ID - no encontrado")
    void testGetLoanById_NotFound() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.empty());

        Optional<LoanResponse> result = loanService.getLoanById(loanId);

        assertFalse(result.isPresent());
        verify(loanRepository, times(1)).findById(loanId);
    }

    @Test
    @DisplayName("Listar todos los préstamos - caso exitoso")
    void testGetAllLoans_Success() {
        when(loanRepository.findAll()).thenReturn(List.of(loan));

        List<LoanResponse> results = loanService.getAllLoans();

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals(loanId, results.get(0).getId());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Listar todos los préstamos - lista vacía")
    void testGetAllLoans_EmptyList() {
        when(loanRepository.findAll()).thenReturn(List.of());

        List<LoanResponse> results = loanService.getAllLoans();

        assertNotNull(results);
        assertTrue(results.isEmpty());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Actualizar préstamo - caso exitoso")
    void testUpdateLoan_Success() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.of(loan));
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        Optional<LoanResponse> result = loanService.updateLoan(loanId, loanRequest);

        assertTrue(result.isPresent());
        assertEquals(loanId, result.get().getId());
        verify(loanRepository, times(1)).findById(loanId);
        verify(loanRepository, times(1)).save(any(Loan.class));
    }

    @Test
    @DisplayName("Actualizar préstamo - no encontrado")
    void testUpdateLoan_NotFound() {
        when(loanRepository.findById(loanId)).thenReturn(Optional.empty());

        Optional<LoanResponse> result = loanService.updateLoan(loanId, loanRequest);

        assertFalse(result.isPresent());
        verify(loanRepository, times(1)).findById(loanId);
        verify(loanRepository, never()).save(any(Loan.class));
    }

    @Test
    @DisplayName("Eliminar préstamo - caso exitoso")
    void testDeleteLoan_Success() {
        doNothing().when(loanRepository).deleteById(loanId);

        loanService.deleteLoan(loanId);

        verify(loanRepository, times(1)).deleteById(loanId);
    }

    @Test
    @DisplayName("Validar que la fecha de vencimiento se calcula correctamente")
    void testDueDateCalculation() {
        when(loanRepository.save(any(Loan.class))).thenAnswer(invocation -> {
            Loan savedLoan = invocation.getArgument(0);
            savedLoan.setId(loanId);
            savedLoan.setCreationDate(LocalDate.now());
            return savedLoan;
        });

        LoanResponse result = loanService.createLoan(loanRequest);

        assertNotNull(result.getDueDate());
        assertEquals(result.getCreationDate().plusMonths(12), result.getDueDate());
    }

    @Test
    @DisplayName("Verificar que se guarda la entidad con los valores correctos")
    void testSaveLoanWithCorrectValues() {
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        loanService.createLoan(loanRequest);

        ArgumentCaptor<Loan> loanCaptor = ArgumentCaptor.forClass(Loan.class);
        verify(loanRepository).save(loanCaptor.capture());

        Loan savedLoan = loanCaptor.getValue();
        assertEquals(new BigDecimal("10000.00"), savedLoan.getAmount());
        assertEquals(new BigDecimal("12.5"), savedLoan.getInterestRate());
        assertEquals(12, savedLoan.getTerm());
    }
}
```
