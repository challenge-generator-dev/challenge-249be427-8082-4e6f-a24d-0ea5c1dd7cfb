# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de una API REST en el dominio de gestión de préstamos**.

| | |
|---|---|
| Tema | creación de api rest con persistencia y documentación |
| Nivel | junior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.3 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.3.0
- org.springframework.boot:spring-boot-starter-data-jpa 3.3.0
- com.h2database:h2 2.2.224
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.5.0
- org.projectlombok:lombok n/a
- org.springframework.boot:spring-boot-starter-validation 3.3.0
- org.springframework.boot:spring-boot-starter-test 3.3.0

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición del modelo de datos y creación de la API**: Modelo de datos definido y API REST básica creada con validaciones.
- **Fase 2 — Persistencia en H2 y manejo de errores**: Solicitudes de préstamos persistidas en H2 y API REST con manejo de errores de validación.
- **Fase 3 — Documentación con Swagger**: API REST documentada con Swagger.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (32)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/prestamos/api/model/dto/LoanRequest.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/prestamos/api/model/dto/LoanResponse.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.media.Schema pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/prestamos/api/controller/LoanController.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.annotations.Operation pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/prestamos/api/config/OpenApiConfig.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/prestamos/api/controller/LoanControllerTest.java` — `com.fasterxml.jackson`
      El import com.fasterxml.jackson.databind.ObjectMapper pertenece a com.fasterxml.jackson, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setId`
      Se invoca `setId` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setAmount`
      Se invoca `setAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setInterestRate`
      Se invoca `setInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setTerm`
      Se invoca `setTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setCreationDate`
      Se invoca `setCreationDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.setDueDate`
      Se invoca `setDueDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `LoanRepository.save`
      Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `LoanRepository.findAll`
      Se invoca `findAll` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `LoanRepository.deleteById`
      Se invoca `deleteById` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getId`
      Se invoca `getId` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getAmount`
      Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getInterestRate`
      Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getTerm`
      Se invoca `getTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getCreationDate`
      Se invoca `getCreationDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/prestamos/api/service/LoanServiceImpl.java` — `Loan.getDueDate`
      Se invoca `getDueDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setId`
      Se invoca `setId` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setAmount`
      Se invoca `setAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setInterestRate`
      Se invoca `setInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setTerm`
      Se invoca `setTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setCreationDate`
      Se invoca `setCreationDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.setDueDate`
      Se invoca `setDueDate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `LoanRepository.save`
      Se invoca `save` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `LoanServiceImpl.createLoan`
      Se invoca `createLoan` sobre `LoanServiceImpl`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `LoanRepository.findAll`
      Se invoca `findAll` sobre `LoanRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.getAmount`
      Se invoca `getAmount` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.getInterestRate`
      Se invoca `getInterestRate` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/prestamos/api/service/LoanServiceTest.java` — `Loan.getTerm`
      Se invoca `getTerm` sobre `Loan`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (15)

- `pom.xml`
- `src/main/java/com/prestamos/api/PrestamosApiApplication.java`
- `src/main/resources/application.properties`
- `src/main/java/com/prestamos/api/repository/LoanRepository.java`
- `src/main/java/com/prestamos/api/model/dto/LoanRequest.java`
- `src/main/java/com/prestamos/api/model/dto/LoanResponse.java`
- `src/main/java/com/prestamos/api/model/entity/Loan.java`
- `src/main/java/com/prestamos/api/controller/LoanController.java`
- `src/main/java/com/prestamos/api/service/LoanService.java`
- `src/main/java/com/prestamos/api/exception/LoanValidationException.java`
- `src/main/java/com/prestamos/api/exception/GlobalExceptionHandler.java`
- `src/main/java/com/prestamos/api/service/LoanServiceImpl.java`
- `src/main/java/com/prestamos/api/config/OpenApiConfig.java`
- `src/test/java/com/prestamos/api/controller/LoanControllerTest.java`
- `src/test/java/com/prestamos/api/service/LoanServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/prestamos/api`
- `src/main/java/com/prestamos/api/controller`
- `src/main/java/com/prestamos/api/service`
- `src/main/java/com/prestamos/api/repository`
- `src/main/java/com/prestamos/api/model/dto`
- `src/main/java/com/prestamos/api/model/entity`
- `src/main/java/com/prestamos/api/exception`
- `src/main/java/com/prestamos/api/config`
- `src/main/resources`
- `src/test/java/com/prestamos/api`

## Verificacion

```bash
mvn clean compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Brecha que el reto ataca: Crear una API REST con persistencia en H2 y documentación con Swagger

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
