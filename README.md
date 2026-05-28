# Sistema de Biblioteca 📚

Sistema de gestión de biblioteca desarrollado en Java con interfaz gráfica Swing.
Permite administrar materiales, usuarios y préstamos con persistencia en archivos CSV.

## Integrantes

| Nombre | Carnet |
|--------|--------|
| Jefferson Osberto Salazar Escobar | 0905-25-7843 |
| Giselle Ortiz Calvillo | 0905-25-14179 |
| José Javier Alay Méndez | 0905-25-11899 |

## Opción de proyecto

**Opción B** — Sistema de Biblioteca

## Requisitos

- JDK 21
- Eclipse IDE
- No requiere librerías externas

## Cómo clonar y ejecutar

### 1. Clonar el repositorio

**GitKraken**
1. Abre GitKraken
2. File → Clone Repo
3. Pega la URL: `https://github.com/Jefferson-Salazar/proyecto-biblioteca.git`
4. Elige la carpeta donde quieres guardarlo
5. Click en Clone the repo

### 2. Importar en Eclipse

1. Abre Eclipse
2. File → Import → Existing Projects into Workspace
3. Selecciona la carpeta del proyecto clonado
4. Click en Finish

### 3. Ejecutar

1. Abre `src/main/Main.java`
2. Click derecho → Run As → Java Application

## Decisiones de diseño

**Herencia y clases abstractas**
`Material` es clase abstracta con subclases `Libro` y `Revista`.
`Usuario` es clase abstracta con subclases `Estudiante` y `Docente`.
Cada subclase implementa sus propios métodos abstractos como
`diasPrestamoMaximo()`.

**Polimorfismo**
Las listas manejan `List<Material>` y `List<Usuario>` permitiendo
tratar Libros, Revistas, Estudiantes y Docentes de forma uniforme.

**Persistencia**
Se usa la clase `Persistencia` en el paquete `persistencia` para guardar
y cargar datos en archivos CSV (`materiales.csv`, `usuarios.csv`,
`prestamos.csv`). Los archivos se crean automáticamente en la
carpeta raíz del proyecto.

**Arquitectura**
Las listas centrales viven en `Main` y se pasan a cada ventana,
evitando duplicación de datos entre pantallas.
