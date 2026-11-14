# 4 · Resolver un problema: la sucesión

**Duración:** 70 minutos · **Trabajo:** en pareja · **Meta:** descubrir las reglas de una sucesión, programarla por piezas con todo el código en `main` y calcular la sumatoria de los n primeros términos.

| Min. | Paso |
|---|---|
| 5 | 4.1 El reto |
| 12 | 4.2 Detectives: desarma la sucesión |
| 5 | 4.3 Puesta en común |
| 30 | 4.4 Programar por piezas |
| 15 | 4.5 Integración y verificación |
| 3 | 4.6 Commit y push |

---

## 4.1 El reto

Escribe un programa que pida **n** y calcule la **sumatoria de los n primeros términos** de:

$$
S = -\left(\frac{5}{1}\right)^2 + \left(\frac{7}{1}\right)^3 + \left(\frac{11}{2}\right)^{5} - \left(\frac{13}{3}\right)^{7} - \left(\frac{17}{5}\right)^{10} - \left(\frac{19}{8}\right)^{14} + \left(\frac{23}{13}\right)^{20} + \left(\frac{29}{21}\right)^{29} + \left(\frac{31}{34}\right)^{43} + \left(\frac{37}{55}\right)^{65} - \dots
$$

En cada vuelta del ciclo el programa hace **dos tareas**:

1. **Generar** el término `i`.
2. **Acumular:** `suma = suma + termino`.

Si n = 2, solo se suman los dos primeros: $S_2 = -25 + 343 = 318$.

---

## 4.2 Detectives: desarma la sucesión (12 min)

Con tu pareja, copia la tabla en un papel y separa cada término en sus partes:

| i | signo | numerador | denominador | exponente |
|---|---|---|---|---|
| 1 | − | 5 | 1 | 2 |
| 2 | + | 7 | 1 | 3 |
| 3 | | | | |
| 4 | | | | |
| … | | | | |
| 10 | | | | |

Respondan:

1. ¿Qué tienen en común los **numeradores**? ¿Por qué no aparecen el 2 ni el 3?
2. ¿Cómo se obtiene cada **denominador** a partir de los dos anteriores?
3. Resta **exponente − denominador** en cada término. ¿Qué serie aparece?
4. ¿Cuántos **signos iguales** seguidos hay cada vez?
5. Una regla se acepta cuando **predice** un término que no está escrito. ¿Cuál es el término 11?

<details>
<summary>Pistas (ábrelas solo si se bloquean más de 3 minutos)</summary>

- **Numeradores:** 5, 7, 11, 13… ¿qué divisores tienen?
- **Denominadores:** 1, 1, 2, 3, 5, 8… suma los dos anteriores.
- **Exponentes:** exponente − denominador = 1, 2, 3, 4… ¿Te recuerda a la posición `i`?
- **Signos:** agrúpalos así: `− | + + | − − − | + + + + | …`
</details>

---

## 4.3 Puesta en común

| i | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|---|---|---|---|---|---|---|---|---|---|---|
| numerador: **primo desde 5** | 5 | 7 | 11 | 13 | 17 | 19 | 23 | 29 | 31 | 37 |
| denominador: **Fibonacci desde 1** | 1 | 1 | 2 | 3 | 5 | 8 | 13 | 21 | 34 | 55 |
| exponente: **i + Fibonacci** | 2 | 3 | 5 | 7 | 10 | 14 | 20 | 29 | 43 | 65 |
| signo: **bloques de 1, 2, 3, 4…** | − | + | + | − | − | − | + | + | + | + |

$$
t_i = \text{signo}_i \cdot \left(\frac{\text{primo}_i}{\text{Fibonacci}_i}\right)^{\,i \,+\, \text{Fibonacci}_i}
$$

El exponente **no es una serie nueva**: es la suma de dos que ya tenemos (la posición `i` y Fibonacci). Por eso una sola variable `fibo` sirve para el denominador y para el exponente.

---

## 4.4 Programar por piezas (30 min)

Trabajarás en tu repositorio `guia-practica`, en una carpeta nueva `sucesion/`. Cada pieza es un archivo compacto que funciona solo. Al terminar cada pieza, haz **un commit** (lo aprendiste en el bloque 3).

**En pareja:** cada uno escribe en su computador, pero piensan juntos. Antes de ejecutar, comparen lo que esperan ver; si sus salidas difieren, busquen juntos la diferencia.

### El contrato de nombres

Todas las piezas terminarán dentro del **mismo** ciclo, así que usamos los mismos nombres:

```java
for (int i = 1; i <= n; i++) {
    // A) primo       → int primo
    // D) término     → int exponente, double termino, double suma
    // B) Fibonacci   → int fibo, int siguienteFibo
    // C) signo       → int signo (1 o -1), int contSignos, int tamBloque
}
```

### Niveles

| Nivel | Piezas | Para quién |
|---|---|---|
| **1** | A y B | Si es tu primer programa con ciclos anidados |
| **2** | A, B y C | Si ya dominas `for` y `while` |
| **3** | A, B, C e integración (D) | Si ya terminaste el nivel 2, o eres de 2.º o 3.er ciclo |

Todos verán la integración completa en la sección 4.5.

---

### Pieza A · Primos desde 5 · `sucesion/PiezaPrimos.java`

Lee `n` y muestra los **n primeros primos empezando en 5**, uno por cada vuelta de `for (int i = 1; i <= n; i++)`.

1. Antes del `for`: `int primo = 4;` (el último número «usado»).
2. En cada vuelta, **busca el siguiente**: incrementa `primo` mientras **no** sea primo.
3. Un número es primo si ningún `d` entre 2 y `primo - 1` lo divide (`primo % d == 0`).
4. ¿Por qué buscas con `while` y no con `for`? ¿Sabes cuántos números probarás?

```text
$ java sucesion/PiezaPrimos.java
n: 10
5 7 11 13 17 19 23 29 31 37
```

```bash
git add sucesion/PiezaPrimos.java
git commit -m "Agregar pieza de primos desde 5"
```

---

### Pieza B · Fibonacci desde 1 · `sucesion/PiezaFibonacci.java`

Lee `n` y muestra los **n primeros números de Fibonacci**, empezando en 1.

1. Antes del `for`: `int fibo = 1, siguienteFibo = 1;`
2. En cada vuelta, **primero** imprime `fibo`.
3. **Después** prepara el siguiente: `aux = fibo + siguienteFibo`, luego `fibo` ← `siguienteFibo` y `siguienteFibo` ← `aux`.
4. ¿Para qué sirve `aux`? Prueba sin ella y compara.

```text
$ java sucesion/PiezaFibonacci.java
n: 10
1 1 2 3 5 8 13 21 34 55
```

Commit: `Agregar pieza de Fibonacci desde 1`

---

### Pieza C · Signos en bloques · `sucesion/PiezaSignos.java`

Lee `n` y muestra el **signo** de cada posición, de 1 a n.

1. Antes del `for`: `int signo = -1;`, `int contSignos = 0;`, `int tamBloque = 1;`
2. En cada vuelta, **primero** imprime `+` o `-` según `signo`.
3. **Después** cuenta el signo: `contSignos++`.
4. Si `contSignos == tamBloque`: intercambia el signo (`signo = -signo`), agranda el bloque (`tamBloque++`) y reinicia el contador.

```text
$ java sucesion/PiezaSignos.java
n: 15
- + + - - - + + + + - - - - -
```

Commit: `Agregar pieza de signos en bloques`

---

### Integración (nivel 3) · `sucesion/Sumatoria.java`

Une las tres piezas en un solo `for` y agrega la pieza D:

1. Copia **todas las declaraciones** de las piezas antes del `for`, y agrega `double suma = 0;`.
2. Dentro del `for`, en este orden:
   - **A** al inicio: busca el primo de esta posición.
   - **D** en el medio: `int exponente = i + fibo;`, luego `double termino = signo * Math.pow((double) primo / fibo, exponente);` y acumula.
   - **B** y **C** al final: preparan los valores de la **siguiente** vuelta.
3. Después del `for`, muestra `S` con 4 decimales: `IO.println("S = %.4f".formatted(suma));`

¿Por qué el primo se calcula **antes** del término, pero Fibonacci y el signo se actualizan **después**?

---

## 4.5 Integración y verificación (15 min)

El docente ensambla las piezas en vivo con lo que aportan las parejas. Compara tu programa con estos valores:

| n | S esperada |
|---|---|
| 1 | −25.0000 |
| 2 | 318.0000 |
| 3 | 5350.8438 |
| 5 | −229778.5261 |
| 8 | −309531.8480 |
| 9 | −309531.8291 |
| 10 o más | −309531.8291 |

Si tu resultado no coincide, agrega dentro del `for` una línea para **ver los valores** y compárala con la tabla de 4.3:

```java
IO.println(i + " " + primo + " " + fibo + " " + exponente + " " + signo);
```

### Preguntas para pensar

1. ¿Por qué desde el término 9 los términos son casi 0 y la suma prácticamente ya no cambia? (Pista: compara numerador y denominador).
2. ¿Por qué `primo` empieza en 4 y no en 5?
3. ¿Qué pasa en Fibonacci si no usas `aux`?
4. ¿Hace falta proteger la división para cero en esta sucesión? ¿Por qué?
5. Ejecuta con `n = 50`. ¿Qué ocurre desde el término 47? (Recuerda lo que viste en `jshell` con `Integer.MAX_VALUE + 1`.) Lo resolveremos en el bloque 5.

---

## 4.6 Commit y push

```bash
git add sucesion/
git commit -m "Integrar piezas en la sumatoria"
git push
```

Abre tu repositorio en GitHub y revisa la historia (**Commits**): un commit por pieza cuenta cómo construiste la solución.

### ¿Qué viene?

Tu `main` funciona, pero es largo: todo está mezclado en un solo bloque. ¿Cómo comprobarías que **solo** la pieza de signos está bien, sin ejecutar todo el programa? En el bloque 5 veremos la misma lógica organizada en **métodos**, y por qué eso permite **probarla automáticamente**.
