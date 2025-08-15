# Programación Funcional en Java con Lambdas y Streams

Este repositorio proporciona un conjunto de ejemplos en **Java** pensados para practicar la **programación funcional** con expresiones **lambda**, **funciones de orden superior** y operaciones con **Streams**.  
El proyecto está organizado como un módulo Maven (`fundamentos`) y contiene varias clases y ejercicios que muestran cómo aplicar estos conceptos en diferentes contextos.

## Estructura del proyecto

```
fundamentos/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── ru_learning/
                ├── code_challenge/
                ├── interfaces/
                ├── lambda_applications/
                └── util/
```

## Tecnologías

- Java 17
- Maven
- Estilo funcional con lambdas y streams
- Patrones de diseño (como Strategy con lambdas)

## Ejemplos destacados

### 🔢 `FibonacciEx.java`
Generación de la sucesión de Fibonacci usando `Stream.iterate()` y lambdas.

### 🧠 `CodeChallenge.java`
Ejercicios para verificar si un número es impar, primo o palíndromo usando una interfaz funcional `PerformOperation` y expresiones lambda.

### 📊 `CollectorsEX.java`
Uso de `Collectors.groupingBy`, `partitioningBy`, `averagingDouble`, etc., sobre listas de videojuegos (`Videogame`) agrupados por consola, rating, entre otros.

### 🔎 `StreamsEX.java`
Filtrado y transformación de datos usando `map`, `filter`, `sorted`, `distinct` y `limit`.

### 🧩 `StrategyPatternWithLambdas.java`
Implementación del patrón de estrategia usando lambdas como reemplazo de clases anónimas.

### 🧵 `ThreadsAndLambdas.java`
Ejecución de hilos (`Runnable`) utilizando expresiones lambda.

### ✅ `ValidatorApp.java`
Validación de datos a partir de una lista de reglas (`ValidationRules`) implementadas con lambdas.

### 💾 `interfaces/DatabaseService.java`, `MongoBD.java`, `EmployeeDB.java`, etc.
Demostración de uso de interfaces funcionales para simular distintas implementaciones de bases de datos.

## Cómo ejecutar

1. Clona el repositorio:

```bash
git clone https://github.com/OscarRuiz21/progra_funcional_lambdas_streams.git
cd progra_funcional_lambdas_streams/fundamentos
```

2. Compila el proyecto:

```bash
mvn clean compile
```

3. Ejecuta una clase con `exec:java` de Maven o directamente desde tu IDE:

```bash
mvn exec:java -Dexec.mainClass="ru_learning.code_challenge.CodeChallenge"
```

> Asegúrate de cambiar `exec.mainClass` al nombre completo de la clase que desees probar.

## Autor

Desarrollado por [Oscar Ruiz](https://github.com/OscarRuiz21)

---

> Este proyecto es con fines educativos y está enfocado en la práctica de conceptos funcionales en Java. Ideal para estudiantes o desarrolladores que quieren afianzar su comprensión del paradigma funcional.
