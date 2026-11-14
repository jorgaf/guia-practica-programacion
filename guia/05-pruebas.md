# 5 · Pruebas unitarias con JUnit

**Duración:** 50 minutos · **Meta:** usas un proyecto con la sucesión organizada en métodos, ejecutas sus pruebas, **escribes las tuyas** siguiendo un patrón y consigues la marca verde ✔ de GitHub Actions.

| Min. | Paso |
|---|---|
| 5 | 5.1 De un archivo a un proyecto |
| 8 | 5.2 Tu copia del proyecto |
| 5 | 5.3 Anatomía de una prueba |
| 5 | 5.4 Ejecuta y rompe |
| 15 | 5.5 Escribe tus pruebas |
| 7 | 5.6 Push y GitHub Actions |
| 5 | 5.7 Reto: el desbordamiento |

---

## 5.1 De un archivo a un proyecto

Tu `Sumatoria.java` del bloque 4 tiene todo dentro de `main`. Funciona, pero para saber si **una** pieza está bien hay que ejecutar todo y revisar a ojo.

En el proyecto de este bloque, la **misma lógica** está separada en **métodos**: bloques de código con nombre que reciben un dato y devuelven un resultado.

| Pieza del bloque 4 | Método | Ejemplo |
|---|---|---|
| A · primos desde 5 | `Sucesion.primo(i)` | `primo(4)` → `13` |
| B · Fibonacci desde 1 | `Sucesion.fibonacci(i)` | `fibonacci(6)` → `8` |
| C · signos en bloques | `Sucesion.signo(i)` | `signo(2)` → `1` |
| D · exponente | `Sucesion.exponente(i)` | `exponente(1)` → `2` |
| término | `Sucesion.termino(i)` | `termino(1)` → `-25.0` |
| sumatoria | `Sucesion.sumatoria(n)` | `sumatoria(2)` → `318.0` |

**No necesitas saber escribir métodos** para este bloque: solo vas a **llamarlos**, igual que llamas a `Math.pow(2, 3)` o a `IO.println`.

Una **prueba unitaria** es un pequeño programa que llama a un método con un dato conocido y comprueba **automáticamente** que el resultado es el esperado. **JUnit** es la herramienta estándar de Java para escribirlas, y **Maven** organiza el proyecto, descarga JUnit y ejecuta las pruebas.

```text
sucesion-pruebas/
├── pom.xml                         ← Maven: qué versión de Java y qué librerías (JUnit)
├── src/main/java/fp/Sucesion.java  ← la lógica
├── src/main/java/fp/Main.java      ← el programa
└── src/test/java/fp/SucesionTest.java  ← las pruebas (aquí trabajas)
```

Observa también que en un proyecto el código vive dentro de **clases** (`public class Sucesion { ... }`). Los archivos compactos son ideales para aprender y para programas pequeños; los proyectos grandes se organizan en clases.

---

## 5.2 Tu copia del proyecto (8 min)

Repite lo que hiciste en los bloques 2 y 3, ahora sin ayuda:

1. Abre `https://github.com/jorgaf/sucesion-pruebas` → **Use this template → Create a new repository** → nombre `sucesion-pruebas`, **Public** → **Create repository**.
2. Elige **una** forma de trabajar:

| Opción | Pasos |
|---|---|
| **Codespaces** | Primero **borra** el codespace de `guia-practica` en <https://github.com/codespaces> (para cuidar tu cuota). Luego, en tu nuevo repositorio: **Code → Codespaces → Create codespace on main**. |
| **IntelliJ IDEA** | **File → New → Project from Version Control** → pega la URL de tu repositorio → **Clone**. Si pregunta, confía en el proyecto (**Trust Project**) y espera a que Maven termine de descargar las dependencias (barra inferior). |

3. Ejecuta el programa para comprobar que todo funciona:

```bash
java src/main/java/fp/Main.java
```

En IntelliJ también puedes abrir `Main.java` y pulsar ▶.

---

## 5.3 Anatomía de una prueba (5 min)

Abre `src/test/java/fp/SucesionTest.java`. Todas las pruebas siguen el mismo patrón:

```java
@Test                                         // 1. marca: "esto es una prueba"
@DisplayName("El cuarto primo de la sucesión es 13")   // 2. nombre legible
void cuartoPrimo() {                          // 3. nombre del método de prueba
    assertEquals(13, Sucesion.primo(4));      // 4. ESPERADO, luego lo que DEVUELVE el método
}
```

**`assertEquals(esperado, real)`** compara los dos valores: si son iguales, la prueba pasa (verde); si no, falla (rojo) y te dice qué esperaba y qué obtuvo.

### Con decimales: la tolerancia

```java
assertEquals(-25.0, Sucesion.sumatoria(1), 0.0001);
//            esperado  real                tolerancia
```

¿Recuerdas `0.1 + 0.2` en `jshell`? Los `double` no son exactos, así que se comparan con una **tolerancia**: la prueba pasa si la diferencia es menor que `0.0001`.

### Varias pruebas en una tabla

La prueba de signos usa `@ParameterizedTest`: el mismo código se ejecuta con cada fila de la tabla `@CsvSource`.

```java
@ParameterizedTest(name = "signo({0}) = {1}")
@CsvSource({
    "1, -1",
    "2,  1",
    ...
})
void signos(int i, int esperado) {
    assertEquals(esperado, Sucesion.signo(i));
}
```

---

## 5.4 Ejecuta y rompe (5 min)

### Ejecuta

| Dónde | Cómo |
|---|---|
| Terminal (Codespaces) | `mvn test` |
| IntelliJ | Clic derecho en `SucesionTest.java` → **Run 'SucesionTest'**, o ▶ junto a `class SucesionTest` |

Resultado esperado en la terminal:

```text
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

En IntelliJ verás cada prueba con su nombre legible y una marca verde.

### Rompe (predice, ejecuta, rompe)

1. En `Sucesion.java`, método `primo`, cambia `int numero = 4;` por `int numero = 2;`.
2. **Antes de ejecutar**, predice con tu pareja: ¿qué pruebas fallarán? ¿Y cuáles seguirán pasando?
3. Ejecuta las pruebas y lee el mensaje de una prueba que falle:

```text
expected: <5> but was: <3>
```

4. **Deshaz el cambio** (`git restore src/main/java/fp/Sucesion.java`) y vuelve a ejecutar: todo en verde.

Así trabajan los equipos profesionales: si alguien cambia el código y rompe algo, **las pruebas lo detectan** en segundos, sin revisar a ojo.

---

## 5.5 Escribe tus pruebas (15 min)

Al final de `SucesionTest.java` está la sección **TU TURNO**. Escribe una prueba por cada fila de esta tabla, **copiando el patrón** de las pruebas de ejemplo:

| Nivel | Qué probar | Valor esperado |
|---|---|---|
| 1 | `Sucesion.primo(10)` | `37` |
| 1 | `Sucesion.fibonacci(10)` | `55` |
| 1 | `Sucesion.exponente(10)` | `65` |
| 1 | `Sucesion.termino(2)` | `343.0` (con tolerancia) |
| 2 | `Sucesion.sumatoria(2)` | `318.0` |
| 2 | `Sucesion.sumatoria(3)` | `5350.8438` |
| 2 | `Sucesion.sumatoria(5)` | `-229778.5261` |
| 2 | `Sucesion.sumatoria(8)` | `-309531.8480` |
| 2 | Agrega a la tabla de signos las filas de `i = 6`, `i = 10` y `i = 11` | *calcúlalos con la tabla del bloque 4* |

Ejemplo para la primera fila:

```java
@Test
@DisplayName("El décimo primo de la sucesión es 37")
void decimoPrimo() {
    assertEquals(37, Sucesion.primo(10));
}
```

Reglas:

- Cada prueba necesita un **nombre de método distinto** (`decimoPrimo`, `fibonacciDeDiez`…).
- Ejecuta las pruebas **después de cada una** que escribas: avanza en verde.
- Si una prueba falla, revisa primero **tu valor esperado**: ¿lo copiaste bien de la tabla?

Cuando tengas varias en verde, registra el avance:

```bash
git add src/test/java/fp/SucesionTest.java
git commit -m "Agregar pruebas de primos, Fibonacci y sumatoria"
```

---

## 5.6 Push y GitHub Actions (7 min)

**GitHub Actions** ejecuta tus pruebas en un servidor de GitHub cada vez que haces `push`. La configuración está en `.github/workflows/pruebas.yml`. Ábrelo y lee los pasos: descargar el código, instalar Java 27 y ejecutar `mvn test`.

1. Haz `git push` (o **Commit and Push** en IntelliJ).
2. En GitHub, abre tu repositorio → pestaña **Actions**. Verás la ejecución **Pruebas** en curso (círculo amarillo).
3. Después de 1 o 2 minutos aparece:
   - ✔ **verde**: todas las pruebas pasaron en una máquina limpia.
   - ✘ **roja**: alguna falló. Entra en la ejecución → **Ejecutar las pruebas** y busca `FAILURE` o `expected`.
4. En la página principal de tu repositorio, la marca aparece junto a tu último commit.

**Esta marca verde ✔ es la meta del día.** Toma una captura de pantalla.

> ¿Por qué ejecutar las pruebas en GitHub si ya pasan en mi computador? Porque en un equipo cada persona tiene su propio computador, configurado distinto. El servidor es el **árbitro neutral**: el código solo se acepta si pasa ahí.

---

## 5.7 Reto nivel 3: el desbordamiento

En el bloque 4 viste que con `n = 50` la suma se vuelve `Infinity` o `NaN` desde el término 47. Ahora lo vas a demostrar con una prueba y lo vas a corregir. Es el ciclo **rojo → verde** que usan los profesionales:

1. **Rojo.** Escribe una prueba que espere el valor correcto de Fibonacci 50:

```java
@Test
@DisplayName("Fibonacci(50) no se desborda")
void fibonacciDeCincuenta() {
    assertEquals(12586269025L, Sucesion.fibonacci(50));   // la L indica un número long
}
```

Ejecútala: falla. ¿Qué valor obtuvo en su lugar? ¿Por qué es negativo?

2. **Verde.** En `Sucesion.java`, haz que Fibonacci use `long` en lugar de `int`. Pista: cambia el tipo de retorno de `fibonacci` y el de sus variables. El compilador te dirá qué más debes cambiar (lee el error con calma).
3. Ejecuta **todas** las pruebas: la nueva y las anteriores deben pasar.
4. Agrega una prueba más: `Sucesion.sumatoria(50)` debe dar `-309531.8291`.
5. Commit (`Usar long en Fibonacci para evitar desbordamiento`), push y verifica la ✔.

---

## Punto de control

- [ ] Creé mi repositorio `sucesion-pruebas` desde la plantilla.
- [ ] Ejecuté las pruebas y las vi en verde.
- [ ] Rompí el código, vi las pruebas en rojo y lo restauré.
- [ ] Escribí al menos 4 pruebas propias.
- [ ] Hice push y tengo la marca verde ✔ en GitHub Actions.

## Problemas frecuentes

| Síntoma | Causa probable | Solución |
|---|---|---|
| `mvn: command not found` en mi computador | Maven no está instalado (no hace falta). | Ejecuta las pruebas desde IntelliJ, que trae Maven incluido, o usa Codespaces. |
| IntelliJ marca en rojo `@Test` o `assertEquals` | Maven aún no descarga JUnit. | Espera a que termine la barra inferior, o abre la pestaña **Maven** y pulsa ⟳ (*Reload*). |
| `release version 25 not supported` | El proyecto se está compilando con un JDK anterior al 25. | **File → Project Structure → SDK**: elige 27 (o 25). |
| `method ... is already defined` | Dos pruebas con el mismo nombre de método. | Cambia el nombre de una. |
| La prueba con decimales falla por muy poco | Falta la tolerancia, o el valor esperado tiene pocos decimales. | Usa `assertEquals(esperado, real, 0.0001)` y copia los 4 decimales. |
| En **Actions** no aparece nada | Aún no hiciste push, o el repositorio es un fork. | Haz push. El repositorio debe crearse con **Use this template**, no con *Fork*. |
| ✘ roja en Actions, pero en mi computador todo pasa | Olvidaste hacer commit de algún archivo. | `git status`: ¿hay cambios sin registrar? |

## Para seguir aprendiendo

- Guía de usuario de JUnit: <https://docs.junit.org/current/user-guide/>
- Introducción a GitHub Actions: <https://docs.github.com/es/actions>
- Siguiente paso: escribir la prueba **antes** que el código (*Test-Driven Development*).
