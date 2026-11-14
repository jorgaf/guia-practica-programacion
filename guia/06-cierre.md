# 6 · Cierre

**Duración:** 20 minutos · **Meta:** mostrar lo logrado, reflexionar sobre el uso de asistentes de IA y llevarte un plan para seguir practicando.

| Min. | Paso |
|---|---|
| 6 | 6.1 Muestra tu ✔ |
| 8 | 6.2 Asistentes de IA: ¿ayudan o estorban? |
| 3 | 6.3 Retroalimentación |
| 3 | 6.4 Siguientes pasos |

---

## 6.1 Muestra tu ✔ (6 min)

Dos o tres parejas proyectan su repositorio `sucesion-pruebas` y cuentan en **un minuto**:

1. Su historia de commits: ¿qué cuenta?
2. Una prueba que escribieron: ¿qué comprueba?
3. Algo que falló y cómo lo resolvieron.

Recuerda lo que construiste hoy:

| Bloque | Lo que tienes ahora |
|---|---|
| Entorno | JDK, IntelliJ IDEA y Codespaces funcionando |
| Git y GitHub | Un repositorio `guia-practica` con tu historia de commits, `.gitignore` y una rama fusionada |
| Problema | La sucesión resuelta por piezas, con todo el código en `main` |
| Pruebas | Un repositorio `sucesion-pruebas` con tus pruebas y la marca ✔ de GitHub Actions |

---

## 6.2 Asistentes de IA: ¿ayudan o estorban? (8 min)

Los asistentes de IA (ChatGPT, Claude, Copilot, Gemini…) escriben código en segundos. La pregunta no es si usarlos, sino **cómo usarlos sin dejar de aprender**.

### Un experimento

Supón que le pides a un asistente el método `signo` de la sucesión y te responde esto:

```java
public static int signo(int i) {
    if (i % 2 == 0) {
        return 1;
    } else {
        return -1;
    }
}
```

Se ve limpio y compila. **Predice:** de la tabla de signos de `SucesionTest`, ¿qué filas fallarían?

| i | esperado | este código devuelve | ¿pasa? |
|---|---|---|---|
| 1 | −1 | | |
| 2 | 1 | | |
| 3 | 1 | | |
| 4 | −1 | | |
| 7 | 1 | | |

<details>
<summary>Ver respuesta</summary>

Fallan `i = 3` (devuelve −1), `i = 4` (devuelve 1) y `i = 7` (devuelve −1). El código alterna el signo en **cada** término; no entiende los **bloques** de 1, 2, 3, 4… Pasa justo los dos primeros casos, que son los que uno revisa a ojo.
</details>

**Moraleja:** el código generado puede verse correcto y estar mal. Tus pruebas lo detectaron en segundos, y tú puedes explicar **por qué** está mal, porque escribiste la pieza de signos en el bloque 4.

### Cuándo ayudan y cuándo estorban

| ✔ Te ayudan a aprender | ✘ Te impiden aprender |
|---|---|
| Explicar un mensaje de error que no entiendes | Pedir la solución completa de una tarea |
| Explicar un concepto con otro ejemplo | Copiar código que no podrías explicar |
| Revisar tu código y sugerir mejoras **después** de que lo escribiste | Pedir que te arregle todo sin leer qué cambió |
| Proponer casos de prueba que no se te ocurrieron | Confiar en el resultado sin probarlo |

### Tres reglas para hoy y para siempre

1. **Primero intenta tú.** Al menos 15 minutos de esfuerzo propio antes de preguntar.
2. **Si no puedes explicarlo, no lo uses.** Cada línea que entregas debe ser tuya en entendimiento.
3. **Verifica siempre.** Ejecuta, prueba y compara con valores conocidos, como hiciste hoy.

En las actividades calificadas de la asignatura, sigue además las normas de integridad académica de la universidad.

---

## 6.3 Retroalimentación (3 min)

Responde el formulario que compartirá el docente (código QR) o en el siguiente [enlace](https://v.gd/BJeOMM)

---

## 6.4 Siguientes pasos (3 min)

### Esta semana

- [ ] Si no lo terminaste, resuelve el **reto 5.7** (Fibonacci con `long`) y consigue la ✔.
- [ ] Si trabajaste solo en Codespaces, **instala el entorno en tu computador** con la [lista de preparación](00-preparacion.md).
- [ ] **Borra tus codespaces** en <https://github.com/codespaces> para no consumir la cuota.

### Para seguir practicando

- Usa **Git en cada tarea** de la asignatura: un repositorio por unidad y un commit por avance.
- Antes de dar por terminado un programa, escribe una tabla de **casos de prueba** con resultados esperados, como la de la sucesión.
- Solicita el **GitHub Student Developer Pack** (<https://education.github.com/pack>) y la licencia educativa de JetBrains con tu correo institucional.
- Crea tu **README de perfil** en GitHub: un repositorio con tu mismo nombre de usuario. Es la portada de tu portafolio.
- Repasa los apuntes de Java de la asignatura: los métodos, que hoy solo llamaste, los escribirás pronto.

**Gracias por venir.** Hoy trabajaste como trabaja un equipo de desarrollo: entorno configurado, código versionado, problema dividido en piezas y pruebas automáticas como árbitro.
