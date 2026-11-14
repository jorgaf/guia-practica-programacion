# 3 · Git y GitHub

**Duración:** 30 minutos · **Meta:** registras cambios en tu repositorio desde Codespaces y desde tu computador, usas `.gitignore` y una rama, y te autenticas en GitHub **sin escribir contraseñas ni tokens**.

| Min. | Paso |
|---|---|
| 3 | 3.1 Git y GitHub en 3 ideas |
| 8 | 3.2 Tu primer ciclo en Codespaces |
| 4 | 3.3 `.gitignore`: lo que no se sube |
| 6 | 3.4 Ramas: trabajar sin romper `main` |
| 8 | 3.5 En tu computador: clonar y autenticarte |
| 1 | 3.6 ¿Y los tokens? (lectura) |

---

## 3.1 Git y GitHub en 3 ideas

1. **Git** es un programa que guarda la **historia** de tu proyecto. Cada punto de la historia es un **commit**: una foto de tus archivos con un mensaje que explica qué cambió.
2. **GitHub** es un sitio web que guarda una copia de tu repositorio en la nube (el **remoto**, llamado `origin`). Te permite compartir, colaborar y respaldar. Git funciona sin GitHub; GitHub no tiene sentido sin Git.
3. Un cambio pasa por **tres lugares** antes de llegar a GitHub:

```text
 tus archivos  ──git add──▶  preparación  ──git commit──▶  historia local  ──git push──▶  GitHub
 (editas aquí)               (staging)                     (tu equipo)                   (origin)
```

`git status` te dice en todo momento dónde está cada archivo. Úsalo sin miedo: solo mira, no cambia nada.

---

## 3.2 Tu primer ciclo en Codespaces

Abre el codespace de **tu** repositorio `guia-practica` (lo creaste en el bloque 2). En Codespaces, Git ya sabe quién eres y ya está conectado a GitHub: no hay que configurar nada.

1. Crea la carpeta `practica` y dentro el archivo `SobreMi.java`:

```java
void main() {
    IO.println("Nombre: Ana Pérez");
    IO.println("Carrera: Tecnologías de la Información");
}
```

2. Ejecútalo: `java practica/SobreMi.java`.
3. Ahora sigue el ciclo en la terminal, **leyendo la salida de cada comando**:

```bash
git status                                  # SobreMi.java aparece en rojo: Git lo ve, pero no lo sigue
git add practica/SobreMi.java               # lo pasas a preparación
git status                                  # ahora aparece en verde
git commit -m "Agregar programa SobreMi"    # foto con mensaje
git log --oneline                           # tu commit aparece arriba
git push                                    # lo envías a GitHub
```

4. Abre tu repositorio en GitHub y recarga la página: aparece la carpeta `practica` y tu mensaje de commit.

### Buenos mensajes de commit

Escribe el mensaje como una orden, con **verbo en infinitivo**, diciendo **qué** cambia:

| ✔ Bien | ✘ Evitar |
|---|---|
| `Agregar programa SobreMi` | `cambios` |
| `Corregir cálculo del promedio` | `ya funciona!!!` |
| `Mostrar carrera y ciclo` | `asdf` |

> **Predice, ejecuta, rompe.** Ejecuta `git commit -m "Prueba"` **sin** hacer `git add` antes. ¿Qué responde Git? ¿Por qué?

---

## 3.3 `.gitignore`: lo que no se sube

Un repositorio guarda **código fuente**, no archivos que se generan automáticamente.

1. Compila tu programa a la antigua: `javac practica/SobreMi.java`
2. Ejecuta `git status`: aparece `practica/SobreMi.class`. Es bytecode generado: no debe subirse.
3. Crea en la **raíz** del repositorio un archivo llamado exactamente `.gitignore`:

```gitignore
# Archivos compilados de Java
*.class

# Carpetas que generan Maven e IntelliJ
target/
out/
.idea/
*.iml

# Archivos del sistema operativo
.DS_Store
Thumbs.db
```

4. Ejecuta `git status` otra vez: el `.class` desapareció y aparece `.gitignore`.
5. Registra el cambio:

```bash
git add .gitignore
git commit -m "Agregar .gitignore para Java"
git push
```

Lo necesitarás en el bloque 5: Maven genera la carpeta `target/` y no queremos subirla.

---

## 3.4 Ramas: trabajar sin romper `main`

Una **rama** es una línea de trabajo paralela. `main` es la versión estable; las ideas nuevas se prueban en otra rama y, cuando funcionan, se **fusionan** (*merge*).

```text
main     ●──────●─────────────●   (merge)
                 \           /
mejorar-sobremi   ●─────────●
```

```bash
git switch -c mejorar-sobremi      # crea la rama y te cambias a ella
```

Agrega a `SobreMi.java` una línea con tu ciclo, por ejemplo `IO.println("Ciclo: 2");`, ejecútalo y registra el cambio:

```bash
git add practica/SobreMi.java
git commit -m "Mostrar ciclo de estudio"
git push -u origin mejorar-sobremi   # la primera vez, -u crea la rama en GitHub
```

En GitHub, abre el selector de ramas (botón `main`): ahora existen dos. Fusiona la rama en `main`:

```bash
git switch main                    # vuelves a main: ¿qué pasó con tu línea nueva? Mira el archivo
git merge mejorar-sobremi          # traes los cambios de la rama
git push
git log --oneline --graph --all    # la historia completa
```

> **Predice.** Antes de ejecutar `git switch main`, ¿la línea `Ciclo` seguirá en el archivo? Compruébalo.

En equipos reales, la fusión se hace en GitHub con un **pull request**, donde otra persona revisa el código antes de aceptarlo. Lo verás en ciclos posteriores.

---

## 3.5 En tu computador: clonar y autenticarte

**Clonar** es descargar una copia completa del repositorio, con toda su historia.

### Paso 1 · Identifícate ante Git (solo la primera vez)

En la terminal de tu equipo:

```bash
git config --global user.name "Ana Pérez"
git config --global user.email "tu-correo@ejemplo.com"     # el mismo correo de GitHub
git config --global init.defaultBranch main
```

> ¿Prefieres no publicar tu correo en la historia? En GitHub, **Settings → Emails**, copia tu dirección `...@users.noreply.github.com` y úsala aquí.

### Paso 2 · Conecta tu equipo con GitHub (sin tokens)

| Tu sistema | Qué hacer |
|---|---|
| **Windows** | Nada por ahora. *Git Credential Manager* (incluido en Git for Windows) abrirá el navegador la primera vez que hagas `push`. Inicia sesión y autoriza. |
| **macOS y Linux** | Instala GitHub CLI: Mac con el instalador `.pkg` de <https://cli.github.com> (o `brew install gh`); Linux según <https://github.com/cli/cli#installation>. Luego ejecuta `gh auth login` y responde como en el recuadro. |

```text
$ gh auth login
? Where do you use GitHub?                         GitHub.com
? What is your preferred protocol for Git operations on this host?   HTTPS
? Authenticate Git with your GitHub credentials?    Yes
? How would you like to authenticate GitHub CLI?    Login with a web browser
! First copy your one-time code: ABCD-1234
Press Enter to open https://github.com/login/device in your browser...
```

Pega el código en el navegador y autoriza. Verifica con `gh auth status`.

### Paso 3 · Clona y trabaja en IntelliJ IDEA

1. En GitHub, en tu repositorio: **Code → HTTPS →** copia la URL (`https://github.com/<tu-usuario>/guia-practica.git`).
2. En IntelliJ: **File → New → Project from Version Control** (en la pantalla de bienvenida: **Clone Repository**). Pega la URL y pulsa **Clone**.
   - Equivalente en terminal: `git clone https://github.com/<tu-usuario>/guia-practica.git`
3. Agrega a `SobreMi.java` una línea con tu ciudad y ejecútalo con ▶.
4. Abre la ventana **Commit** (`Ctrl + K` / `⌘ + K`): verás el archivo modificado, igual que en `git status`. Marca el archivo, escribe el mensaje `Mostrar ciudad de origen` y pulsa **Commit and Push…** (o haz el push después con `Ctrl + Shift + K` / `⌘ + ⇧ + K`).
5. Comprueba en GitHub que el commit llegó.

Fíjate en que IntelliJ hace exactamente los mismos pasos que hiciste en la terminal: `add`, `commit` y `push`. El IDE solo les pone botones.

> **Trabajas en dos lugares** (codespace y computador). Antes de empezar en cualquiera de ellos, trae los cambios más recientes con `git pull` (en IntelliJ: `Ctrl + T` / `⌘ + T`).

---

## 3.6 ¿Y los tokens?

Desde 2021, GitHub **no acepta tu contraseña** para operaciones de Git desde la terminal. En su lugar pide un **token**: una clave larga, con permisos limitados y fecha de caducidad.

- Hoy **no creaste ningún token a mano**: Codespaces, Git Credential Manager y `gh auth login` lo crean por ti, lo guardan de forma segura en el sistema y lo renuevan.
- Si algún día necesitas uno (*Personal Access Token*, en **Settings → Developer settings**), elige el tipo *fine-grained*, dale permiso **solo** sobre los repositorios necesarios y una caducidad corta.
- Un token es como una contraseña: **nunca** lo pegues en el código, en un commit, en un chat ni en una captura de pantalla. Si se filtra, **revócalo** de inmediato en la misma página.

---

## Punto de control

- [ ] Hice al menos un commit y push desde Codespaces.
- [ ] Mi repositorio tiene un `.gitignore` y no contiene archivos `.class`.
- [ ] Creé la rama `mejorar-sobremi` y la fusioné en `main`.
- [ ] Cloné mi repositorio en mi computador (o, si no instalé nada, sigo en Codespaces).
- [ ] Hice un commit y push desde IntelliJ sin escribir contraseñas.

### Retos rápidos

- **Nivel 1.** Corrige un error de ortografía de tu `SobreMi.java` y haz un commit con un buen mensaje.
- **Nivel 2.** Crea la rama `agregar-pasatiempos`, agrega una línea, súbela y fusiónala en `main`. Al terminar, borra la rama con `git branch -d agregar-pasatiempos`.
- **Nivel 3.** Modifica un archivo **sin** hacer commit y ejecuta `git diff`. ¿Qué muestra? Luego deshaz el cambio con `git restore <archivo>`. ¿En qué se diferencia de borrar la línea a mano?

---

## Resumen de comandos

| Comando | Para qué |
|---|---|
| `git status` | Ver el estado de tus archivos (úsalo siempre) |
| `git add <archivo>` | Pasar cambios a preparación |
| `git commit -m "mensaje"` | Guardar una foto en la historia |
| `git push` | Enviar commits a GitHub |
| `git pull` | Traer commits desde GitHub |
| `git log --oneline` | Ver la historia resumida |
| `git clone <url>` | Copiar un repositorio a tu equipo |
| `git switch -c <rama>` | Crear una rama y cambiarte a ella |
| `git switch <rama>` | Cambiar de rama |
| `git merge <rama>` | Traer los cambios de otra rama a la actual |
| `git diff` | Ver qué cambiaste y aún no está en preparación |
| `git restore <archivo>` | Descartar cambios no registrados |

## Problemas frecuentes

| Síntoma | Causa probable | Solución |
|---|---|---|
| `Author identity unknown` | Git no sabe tu nombre ni tu correo. | Ejecuta los `git config --global` del paso 1. |
| `nothing added to commit` | Olvidaste el `git add`. | `git add <archivo>` y vuelve a hacer commit. |
| `! [rejected] main -> main (fetch first)` | GitHub tiene commits que tú no tienes (trabajaste en otro lugar). | `git pull` y luego `git push`. |
| `Permission denied` o error `403` al hacer push | Tu equipo guardó la sesión de **otra** cuenta de GitHub. | Mac/Linux: `gh auth status` y `gh auth login`. Windows: *Administrador de credenciales → Credenciales de Windows* → borra la entrada de `github.com` y vuelve a hacer push. |
| `fatal: not a git repository` | La terminal no está dentro de la carpeta del repositorio. | `cd guia-practica` |
| Se abrió un editor extraño (Vim) al hacer commit o merge | Faltó `-m` o Git pide confirmar el mensaje del merge. | Escribe `:wq` y pulsa Enter. |
| `.gitignore` no ignora un archivo | El archivo ya estaba registrado antes de crear `.gitignore`. | `git rm --cached <archivo>` y haz commit. |
