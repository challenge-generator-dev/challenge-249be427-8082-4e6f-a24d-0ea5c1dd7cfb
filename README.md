# Implementación de una API REST en el dominio de gestión de préstamos

En el dominio de la gestión de préstamos, el banco necesita una API REST para gestionar las solicitudes de préstamos. La API debe permitir la creación, lectura, actualización y eliminación de solicitudes de préstamos. Cada solicitud debe persistir en una base de datos H2 y debe estar documentada con Swagger. Los préstamos tienen un monto, una tasa de interés y un plazo. La API debe validar que el monto sea positivo, la tasa de interés esté entre 0 y 100, y el plazo sea un número entero positivo. Además, la API debe manejar errores de validación y devolver mensajes de error descriptivos.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | creación de api rest con persistencia y documentación |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición del modelo de datos y creación de la API

**Objetivo:** Definir el modelo de datos para las solicitudes de préstamos y crear la API REST básica.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Definir el modelo de datos para las solicitudes de préstamos, incluyendo los campos necesarios y las validaciones.
- Crear la API REST con los endpoints necesarios para crear, leer, actualizar y eliminar solicitudes de préstamos.
- Asegurar que la API valide los campos de entrada según las reglas definidas.

**Entregable:** Modelo de datos definido y API REST básica creada con validaciones.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las reglas de negocio para las solicitudes de préstamos.
- Piensa en cómo estructurar la API para que sea intuitiva y fácil de usar.

</details>

### Fase 2: Persistencia en H2 y manejo de errores

**Objetivo:** Persistir las solicitudes de préstamos en una base de datos H2 y manejar los errores de validación.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Configurar la persistencia de las solicitudes de préstamos en una base de datos H2.
- Manejar los errores de validación y devolver mensajes de error descriptivos.
- Asegurar que la API maneje correctamente los errores de persistencia.

**Entregable:** Solicitudes de préstamos persistidas en H2 y API REST con manejo de errores de validación.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar los errores de persistencia y devolver mensajes de error útiles.
- Piensa en cómo mejorar la experiencia del usuario en caso de errores.

</details>

### Fase 3: Documentación con Swagger

**Objetivo:** Documentar la API REST con Swagger para que sea fácil de usar y entender.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configurar Swagger para documentar la API REST.
- Asegurar que la documentación incluya los endpoints, los parámetros de entrada y los mensajes de error.
- Verificar que la documentación sea clara y completa.

**Entregable:** API REST documentada con Swagger.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo hacer que la documentación sea clara y fácil de entender.
- Piensa en cómo mejorar la experiencia del usuario con la documentación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una solicitud de préstamo y cuáles son sus atributos?
- **paraQueSirve**: ¿Para qué sirve la API REST en el dominio de gestión de préstamos?
- **comoSeUsa**: ¿Cómo se usa la API REST para crear, leer, actualizar y eliminar solicitudes de préstamos?
- **erroresComunes**: ¿Cuáles son los errores comunes al validar las solicitudes de préstamos y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de la API REST en términos de estructura, validaciones y manejo de errores?

## Criterios de Evaluacion

- Definir correctamente el modelo de datos para las solicitudes de préstamos.
- Crear la API REST con los endpoints necesarios y validaciones.
- Persistir las solicitudes de préstamos en una base de datos H2 y manejar los errores de validación.
- Documentar la API REST con Swagger de manera clara y completa.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
