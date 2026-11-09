# 1 · Bienvenida

**Guía práctica de fundamentos de programación**
Carreras de Tecnologías de la Información y de Redes y Analítica de Datos · UTPL
Cuenca, 14 de noviembre de 2026 · 4 horas

## Propósito

Esta jornada te acerca a la forma en que se desarrolla software en la práctica profesional. En 4 horas, con tu propio computador, vas a:

1. **Configurar** un entorno de desarrollo Java moderno, en tu equipo y en la nube.
2. **Gestionar** tu código con Git y GitHub.
3. **Resolver** un problema de programación acorde a tu nivel, en pareja.
4. **Comprobar** tu solución con pruebas unitarias automatizadas.

## Lo que te llevas

Al terminar tendrás **un repositorio propio en GitHub** con tu solución y sus pruebas, y una marca verde ✔ que indica que GitHub ejecutó tus pruebas y todas pasaron. Ese repositorio es la evidencia de tu participación y el primer elemento de tu portafolio.

## Agenda

| Hora | Bloque | Qué haremos |
|---|---|---|
| 0:00 – 0:15 | **1 · Bienvenida** | Presentación, diagnóstico rápido y reglas de juego |
| 0:15 – 1:00 | **2 · Entorno** | Cuenta de GitHub, Codespaces, JDK, `jshell`, IntelliJ IDEA y un vistazo a Zed |
| 1:00 – 1:30 | **3 · Git y GitHub** | Repositorio, commits, push y autenticación sin contraseñas |
| 1:30 – 1:40 | Pausa | Café |
| 1:40 – 2:50 | **4 · Resolver un problema** | Programación en pareja con retos de tres niveles |
| 2:50 – 3:40 | **5 · Pruebas unitarias** | JUnit, ciclo rojo-verde y GitHub Actions |
| 3:40 – 4:00 | **6 · Cierre** | Demostraciones, retroalimentación y siguientes pasos |

## Diagnóstico rápido (5 minutos)

Responde levantando la mano o en el formulario que comparta el docente. No hay respuestas buenas ni malas: sirve para formar parejas equilibradas.

1. ¿En qué ciclo y carrera estás?
2. ¿Has escrito y ejecutado un programa en Java por tu cuenta?
3. ¿Tienes cuenta de GitHub? ¿Has hecho un `commit` alguna vez?
4. ¿Has escrito alguna prueba automática de tu código?
5. ¿Pudiste completar la [lista de preparación](00-preparacion.md)? (sí / a medias / no)

## Cómo vamos a trabajar

- **Practicar antes que memorizar.** Cada concepto aparece porque lo necesitamos para hacer algo. La teoría justa, el resto en el teclado.
- **Predice, ejecuta, rompe.** Antes de ejecutar algo, predice qué pasará. Después ejecútalo. Luego cámbialo a propósito para ver cómo falla. Los errores son información, no fracasos.
- **Trabajo en pareja.** En el bloque 4, una persona escribe (*driver*) y la otra revisa y sugiere (*navigator*). Cambian de rol cada 15 minutos.
- **Mentores de mesa.** Si estás en 2.º o 3.er ciclo, te pediremos que ayudes a quienes tienes cerca durante la instalación y Git. Explicar es la mejor forma de aprender.
- **Señales.** Coloca una nota adhesiva sobre la tapa de tu computador:
  - **Verde**: terminé el paso y estoy bien.
  - **Roja**: necesito ayuda. Alguien pasará por tu puesto; mientras tanto, sigue leyendo la guía.
- **Asistentes de IA.** Hoy aprendemos a hacerlo nosotros. Puedes consultar a una IA para entender un mensaje de error, pero no para que escriba la solución. Al final hablaremos de cuándo ayudan y cuándo estorban.

## Materiales

Todo está en el repositorio de la jornada, organizado por bloques:

```text
guia-practica/
├── guia/
│   ├── 00-preparacion.md
│   ├── 01-bienvenida.md      ← estás aquí
│   ├── 02-entorno.md
│   └── ...
├── ejemplos/                  programas de cada bloque
└── .devcontainer/             configuración de Codespaces
```
