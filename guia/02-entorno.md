# 2 · Entorno de desarrollo

**Duración:** 45 minutos · **Meta:** al terminar, ejecutas el mismo programa Java en la nube (Codespaces), en la terminal de tu equipo y en IntelliJ IDEA.

| Min. | Paso |
|---|---|
| 5 | 2.1 Qué es un entorno de desarrollo |
| 10 | 2.2 Cuenta de GitHub y primer codespace |
| 10 | 2.3 El JDK en tu equipo |
| 10 | 2.4 IntelliJ IDEA |
| 5 | 2.5 Un vistazo a Zed |
| 5 | 2.6 Punto de control y retos rápidos |

---

## 2.1 Qué es un entorno de desarrollo

Un entorno de desarrollo tiene tres piezas:

| Pieza | Qué hace | Hoy usamos |
|---|---|---|
| **JDK** (*Java Development Kit*) | Compila y ejecuta Java. Incluye `javac` (compilador), `java` (lanzador y máquina virtual) y `jshell` (consola interactiva). | JDK 27 (o JDK 25 en Mac Intel) |
| **Editor o IDE** | Te ayuda a escribir: colores, autocompletado, errores en vivo, depuración y ejecución con un clic. | IntelliJ IDEA, el editor de Codespaces y, como demostración, Zed |
| **Terminal** | Te permite dar órdenes directas al sistema. Todo lo que hace el IDE lo puedes hacer aquí. | La del sistema y la integrada en el IDE |

### Cómo se ejecuta un programa Java

```text
 Hola.java  ──javac──▶  Hola.class  ──java (JVM)──▶  programa en ejecución
 (código fuente)        (bytecode)
```

- `javac` traduce tu código a **bytecode**, un formato que no depende del sistema operativo.
- La **JVM** (*Java Virtual Machine*) ejecuta ese bytecode en Windows, Mac o Linux. Por eso decimos: *escribe una vez, ejecuta en cualquier lugar*.
- Atajo moderno: `java Hola.java` compila en memoria y ejecuta en un solo paso. Ideal para aprender y para programas de un archivo.

### Versiones de Java

Java publica una versión nueva cada seis meses (marzo y septiembre). Algunas son **LTS** (*Long-Term Support*) y reciben actualizaciones durante años.

| Versión | Fecha | Tipo |
|---|---|---|
| Java 25 | septiembre 2025 | **LTS**. Aquí se volvieron definitivos los archivos compactos y la clase `IO`. |
| Java 26 | marzo 2026 | No LTS |
| **Java 27** | septiembre 2026 | No LTS, recibe actualizaciones hasta marzo de 2027 |

Para aprender usamos la versión más reciente; en un proyecto profesional se suele preferir la LTS. Todo lo que hagamos hoy funciona igual en Java 25 y en Java 27.

---

## 2.2 Cuenta de GitHub y primer codespace

**GitHub** es la plataforma donde los desarrolladores guardan y comparten su código. **GitHub Codespaces** te da un computador en la nube, ya configurado con Java, al que entras desde el navegador.

¿Por qué empezamos por la nube? Porque en 2 minutos todos tenemos el mismo entorno funcionando, sin importar el computador. Si la instalación local te da problemas, sigues trabajando aquí.

### Paso a paso

1. **Cuenta.** Si aún no la tienes, créala en <https://github.com/signup> (ver [lista de preparación](00-preparacion.md#paso-1--crea-tu-cuenta-de-github)) e inicia sesión.
2. **Abre el repositorio de la jornada:** `https://github.com/<usuario-docente>/guia-practica` (el docente compartirá el enlace exacto).
3. Crea **tu propia copia**: pulsa **Use this template → Create a new repository**.
   - **Owner:** tu usuario. **Repository name:** `guia-practica`.
   - **Visibility:** *Public* (formará parte de tu portafolio).
   - Pulsa **Create repository**. Ahora tienes un repositorio tuyo: lo usaremos el resto del día.
4. En **tu** repositorio pulsa **Code → pestaña Codespaces → Create codespace on main**.
5. Espera de 1 a 3 minutos. Se abre un editor (Visual Studio Code en el navegador) con los archivos de la jornada.
6. Abre la terminal: menú ☰ → **Terminal → New Terminal** (o `` Ctrl + ` ``).
7. Verifica y ejecuta:

```bash
java --version
java ejemplos/Hola.java
```

Resultado esperado:

```text
openjdk 27.0.x ...
¿Cómo te llamas? Ana
¡Hola, Ana! Tu entorno Java está listo.
```

### Cuida tu cuota gratuita

| Dato | Valor |
|---|---|
| Uso gratuito al mes (cuenta GitHub Free) | 120 horas de cómputo y 15 GB de almacenamiento |
| Consumo de la máquina básica (2 núcleos) | 2 horas de cuota por cada hora real, es decir, **unas 60 horas al mes** |
| Se detiene solo tras | 30 minutos sin actividad |

- Al terminar, **detén** el codespace: <https://github.com/codespaces> → `···` → **Stop codespace**.
- Si ya no lo necesitas, **bórralo** (*Delete*): un codespace detenido sigue ocupando almacenamiento.
- Con el GitHub Student Developer Pack la cuota sube.

> **Predice, ejecuta, rompe.** En `ejemplos/Hola.java` borra el `;` del final de la línea `IO.println(...)` y vuelve a ejecutar. ¿Qué línea señala el error? ¿Qué te dice el mensaje? Corrígelo.

---

## 2.3 El JDK en tu equipo

Si completaste la [lista de preparación](00-preparacion.md), solo verifica. Si no, instálalo ahora según esta tabla:

| Tu equipo | Instala | Notas |
|---|---|---|
| Windows (x64) | **Eclipse Temurin 27**, `.msi` · <https://adoptium.net/temurin/releases/?version=27> | En *Custom Setup* activa **Set JAVA_HOME variable** y deja **Add to PATH**. |
| Mac Apple Silicon (M1–M4) | **Oracle JDK 27**, `.dmg` ARM64 · <https://www.oracle.com/java/technologies/downloads/> | Doble clic en el `.dmg` y sigue el asistente. |
| Mac Intel | **Oracle JDK 25** (LTS), `.dmg` x64 · misma página, pestaña *JDK 25* | Ni Oracle ni Adoptium publican el JDK 27 para Mac Intel. |
| Linux | **Temurin 27** · <https://adoptium.net/installation/linux/> | También puedes usar SDKMAN: `sdk list java` y luego `sdk install java <identificador>`. |

### Verifica

Abre una terminal **nueva** (las que ya estaban abiertas no ven los cambios):

```bash
java --version
javac --version
```

### Tu primer programa sin IDE

1. Crea una carpeta `fp-jornada` en tu escritorio.
2. Dentro, con cualquier editor de texto, crea `Hola.java`:

```java
void main() {
    String nombre = IO.readln("¿Cómo te llamas? ");
    IO.println("¡Hola, " + nombre + "! Tu entorno Java está listo.");
}
```

3. En la terminal, entra a la carpeta y ejecuta:

```bash
cd Desktop/fp-jornada      # en Windows: cd Desktop\fp-jornada
java Hola.java
```

Observa lo que **no** tuvimos que escribir: `public class`, `public static void main(String[] args)`, `System.out`, `import`. Son los **archivos fuente compactos** de Java moderno: escribes solo lo esencial.

| Antes (Java clásico) | Ahora (Java 25+) |
|---|---|
| `public class Hola {` | — |
| `public static void main(String[] args) {` | `void main() {` |
| `System.out.println("Hola");` | `IO.println("Hola");` |
| `Scanner sc = new Scanner(System.in);` … | `IO.readln("Mensaje: ")` |

### `jshell`: Java sin archivos

`jshell` evalúa expresiones al instante. Es perfecto para experimentar.

```bash
jshell
```

**Predice** el resultado de cada línea antes de pulsar Enter, y anótalo:

```java
7 / 2
7.0 / 2
"Cuenca".length()
Math.sqrt(144)
Integer.MAX_VALUE + 1
0.1 + 0.2
```

Sal con `/exit`. ¿Cuántas acertaste? Las dos últimas sorprenden a casi todos: las retomaremos al hablar de pruebas.

<details>
<summary>Ver resultados</summary>

```text
7 / 2                  ==> 3            división entera: descarta decimales
7.0 / 2                ==> 3.5          si un operando es double, el resultado es double
"Cuenca".length()      ==> 6
Math.sqrt(144)         ==> 12.0
Integer.MAX_VALUE + 1  ==> -2147483648  desbordamiento: el int "da la vuelta"
0.1 + 0.2              ==> 0.30000000000000004   los double no son exactos
```
</details>

---

## 2.4 IntelliJ IDEA

Un IDE (*Integrated Development Environment*) reúne editor, compilador, ejecución, depurador y Git en una sola herramienta. IntelliJ IDEA es el más usado para Java. Desde la versión 2025.3 tiene un solo instalador y las funciones para Java son gratuitas.

### Crea un proyecto

1. **New Project** → **Java**.
2. **Name:** `fp-jornada`. **Build system:** *IntelliJ* (en el bloque de pruebas usaremos Maven).
3. **JDK:** elige el que instalaste. Si no aparece, abre la lista y pulsa **Download JDK…**: IntelliJ lo descarga por ti.
4. Desmarca **Add sample code** y pulsa **Create**.
5. Clic derecho en `src` → **New → File** → `Hola.java`. Copia el programa del paso anterior.
6. Pulsa el triángulo verde ▶ junto a `void main()`.

### Atajos que te ahorran tiempo

| Acción | Windows / Linux | Mac |
|---|---|---|
| Ejecutar el archivo actual | `Ctrl + Shift + F10` | `Ctrl + Shift + R` |
| Ver soluciones a un error (bombilla) | `Alt + Enter` | `⌥ + Enter` |
| Autocompletar | `Ctrl + Espacio` | `Ctrl + Espacio` |
| Dar formato al código | `Ctrl + Alt + L` | `⌘ + ⌥ + L` |
| Buscar cualquier cosa | `Shift` dos veces | `⇧` dos veces |
| Terminal integrada | `Alt + F12` | `⌥ + F12` |

> **Predice, ejecuta, rompe.** Escribe `IO.printn("Hola");` (falta una *l*). Antes de ejecutar: ¿qué hace IntelliJ? Coloca el cursor sobre el error y pulsa `Alt + Enter`. Compara esa experiencia con el mensaje que da `java` en la terminal.

---

## 2.5 Un vistazo a Zed (demostración)

[Zed](https://zed.dev) es un editor de código moderno, muy rápido y ligero, disponible para macOS, Linux y Windows. Es una buena opción para equipos con poca memoria o para quien prefiere un editor minimalista.

- El soporte de Java llega con la extensión **Java** (panel de extensiones → buscar `java`). Por dentro usa el servidor de lenguaje *Eclipse JDT LS*, que necesita un JDK 21 o superior instalado.
- Ofrece autocompletado, errores en vivo, ejecución y depuración. En Windows, la ejecución con un clic requiere configuración adicional.
- La terminal integrada (`` Ctrl + ` ``) te permite usar `java Hola.java` como siempre.

**Recomendación para hoy:** trabaja con IntelliJ IDEA o Codespaces. Explora Zed en casa si te interesa.

---

## 2.6 Punto de control

Coloca tu nota **verde** cuando marques todo:

- [ ] Tengo cuenta de GitHub e inicié sesión.
- [ ] Tengo mi propio repositorio `guia-practica`, creado desde la plantilla.
- [ ] Ejecuté `Hola.java` en un codespace de mi repositorio.
- [ ] `java --version` en mi equipo muestra 27 (o 25 en Mac Intel). *Si no lo logré, sigo en Codespaces.*
- [ ] Ejecuté `Hola.java` desde la terminal con `java Hola.java`.
- [ ] Probé `jshell`.
- [ ] Ejecuté `Hola.java` en IntelliJ IDEA.
- [ ] Detuve mi codespace al terminar.

### Retos rápidos (si terminaste antes)

Escríbelos en archivos compactos y ejecútalos con `java Archivo.java`. Las soluciones están en `ejemplos/`.

- **Nivel 1 · `Edad.java`.** Pide el nombre y el año de nacimiento, y muestra la edad que cumple este año. Pista: `Year.now().getValue()` da el año actual y `Integer.parseInt(texto)` convierte texto en número.
- **Nivel 2 · `Promedio.java`.** Lee tres notas sobre 10 y muestra el promedio con dos decimales y si **aprueba** (promedio ≥ 7, es decir, 70 %). Pista: `Double.parseDouble(texto)` y `"%.2f".formatted(valor)`.
- **Nivel 3 · Explica.** En `jshell`, ¿por qué `Integer.MAX_VALUE + 1` da un número negativo? ¿Qué pasa con `Long.MAX_VALUE + 1`? ¿Y con `Math.addExact(Integer.MAX_VALUE, 1)`? ¿Cuál preferirías en un sistema bancario y por qué?

---

## Problemas frecuentes

| Síntoma | Causa probable | Solución |
|---|---|---|
| `'java' no se reconoce como un comando…` (Windows) o `command not found` | La terminal no encuentra el JDK en el `PATH`. | Abre una terminal **nueva**. Si sigue, reinstala con **Add to PATH** activado o revisa *Variables de entorno → Path*. |
| `java --version` muestra otra versión (8, 17, 21…) | Hay otro JDK antes en el `PATH`. | Windows: en *Variables de entorno* sube la ruta del JDK 27. Mac: `/usr/libexec/java_home -V` lista los JDK instalados. |
| `error: unnamed classes are a preview feature…` o errores raros con `void main()` e `IO` | Estás usando un JDK anterior al 25. | Verifica con `java --version`. |
| IntelliJ marca `void main()` o `IO` en rojo | El proyecto usa un JDK o *language level* antiguo. | **File → Project Structure → Project**: SDK 27 (o 25) y *Language level* 25 o superior. |
| Las tildes o la `ñ` se ven mal en la terminal de Windows | Codificación de la consola. | Usa *Windows Terminal* o ejecuta `chcp 65001` antes del programa. |
| El codespace no inicia o dice *You are out of monthly free usage…* | Cuota mensual usada, codespaces antiguos que ocupan almacenamiento, o el repositorio pertenece a una organización. | Revisa <https://github.com/codespaces> y borra los que no uses. Verifica que el repositorio esté en **tu** usuario. Si sigue, trabaja en pareja y avisa al docente. |
| No aparece el botón **Use this template** | No iniciaste sesión o abriste otro enlace. | Inicia sesión y abre el enlace que compartió el docente. |

## Para seguir aprendiendo

- Apuntes de Java de la asignatura (libro del docente).
- JEP 512, archivos fuente compactos y métodos `main` de instancia: <https://openjdk.org/jeps/512>
- Documentación de GitHub Codespaces: <https://docs.github.com/es/codespaces>
- Guía de IntelliJ IDEA para principiantes: <https://www.jetbrains.com/help/idea/getting-started.html>
- Java en Zed: <https://zed.dev/docs/languages/java>
