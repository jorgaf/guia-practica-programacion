# Antes de la jornada: lista de preparación

**Guía práctica de fundamentos de programación** · Cuenca, sábado 14 de noviembre de 2026

Esta lista te toma unos 40 minutos. Hazla en casa, con buena conexión: los instaladores pesan entre 200 MB y 1 GB, y el Wi-Fi del día lo compartiremos todos.

> Si algo no funciona, **no te preocupes**: trae tu computador igual. El primer bloque de la jornada sirve justamente para verificar y resolver problemas, y si tu equipo no colabora, trabajarás en la nube con GitHub Codespaces.

## Lo que necesitas llevar

- [ ] Computador portátil con **cargador** (Windows 10/11, macOS o Linux).
- [ ] Al menos **8 GB de RAM** (recomendado) y **5 GB libres** en disco.
- [ ] Permisos de **administrador** para instalar programas. Si tu equipo es del trabajo, confírmalo antes.
- [ ] Tu contraseña de GitHub, o acceso a tu correo y celular para recuperarla.

## Paso 1 · Crea tu cuenta de GitHub

1. Entra a <https://github.com/signup>.
2. Usa un **correo personal** que vayas a conservar después de graduarte. Luego puedes agregar tu correo institucional `@utpl.edu.ec` como correo secundario.
3. Elige un **nombre de usuario profesional**: será parte de tu portafolio (por ejemplo `alopez-dev`, no `elcrack2006`).
4. Recomendado: activa la **verificación en dos pasos (2FA)** en *Settings → Password and authentication* con una aplicación como Google Authenticator o Microsoft Authenticator.
5. Opcional: solicita el **GitHub Student Developer Pack** en <https://education.github.com/pack> con tu correo institucional. Te da más horas de Codespaces y otras herramientas gratis. La aprobación puede tardar algunos días.

## Paso 2 · Instala el JDK (Java Development Kit)

Primero identifica tu sistema:

| Tu equipo | Qué instalar | Dónde |
|---|---|---|
| Windows (x64) | **Eclipse Temurin JDK 27**, instalador `.msi` | <https://adoptium.net/temurin/releases/?version=27> |
| Mac con chip Apple (M1, M2, M3, M4…) | **Oracle JDK 27**, instalador `.dmg` *ARM64* | <https://www.oracle.com/java/technologies/downloads/> |
| Mac con procesador **Intel** | **Oracle JDK 25** (LTS), instalador `.dmg` *x64*. El JDK 27 ya no se publica para Mac Intel. | <https://www.oracle.com/java/technologies/downloads/#java25> |
| Linux | Temurin 27 desde el repositorio de Adoptium o con SDKMAN | <https://adoptium.net/installation/linux/> |

¿Cómo saber qué Mac tienes? Menú  → **Acerca de este Mac**. Si dice *Chip Apple M…* es Apple Silicon; si dice *Procesador Intel…* es Intel.

**Windows:** durante la instalación del `.msi`, en la pantalla *Custom Setup*, activa también **Set JAVA_HOME variable** (por defecto viene desactivada) y deja activado **Add to PATH**.

## Paso 3 · Instala IntelliJ IDEA

1. Descárgalo desde <https://www.jetbrains.com/idea/download/>.
2. Desde la versión 2025.3 existe **un solo instalador**: las funciones para Java son gratuitas sin suscripción.
3. Opcional: con tu correo institucional puedes pedir la **licencia educativa** de JetBrains en <https://www.jetbrains.com/community/education/#students> y desbloquear todas las funciones.

## Paso 4 · Instala Git

| Sistema | Cómo |
|---|---|
| Windows | Descarga **Git for Windows** desde <https://git-scm.com/download/win> y acepta las opciones por defecto (incluye *Git Credential Manager*, que usaremos para conectarnos a GitHub sin contraseñas ni tokens manuales). |
| macOS | En la Terminal ejecuta `xcode-select --install`, o `git --version` y acepta la instalación que te ofrece. |
| Linux | `sudo apt install git` (Debian/Ubuntu) o el gestor de tu distribución. |

## Paso 5 · Verifica

Abre una terminal **nueva** (en Windows: *Terminal* o *PowerShell*; en Mac: *Terminal*) y ejecuta:

```bash
java --version
javac --version
git --version
```

Debes ver algo parecido a:

```text
openjdk 27.0.x ...      (en Oracle JDK la línea empieza con "java 27.0.x")
...
javac 27.0.x
git version 2.x.x
```

(Los números exactos pueden variar. En Mac Intel verás `25.0.x`).

- [ ] `java --version` muestra 27 (o 25 en Mac Intel).
- [ ] `javac --version` responde.
- [ ] `git --version` responde.
- [ ] IntelliJ IDEA abre.
- [ ] Puedes iniciar sesión en GitHub.

Toma una captura de pantalla de la terminal con los tres comandos: te servirá si necesitas ayuda el día de la jornada.
