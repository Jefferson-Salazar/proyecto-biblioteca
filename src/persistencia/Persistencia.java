package persistencia;

import dominio.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Persistencia {

    private static final String ARCHIVO_MATERIALES = "materiales.csv";
    private static final String ARCHIVO_USUARIOS   = "usuarios.csv";
    private static final String ARCHIVO_PRESTAMOS  = "prestamos.csv";

    //GUARDAR MATERIALES

    public static void guardarMateriales(List<Material> listaMateriales) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO_MATERIALES))) {
            escritor.println("tipo,codigo,titulo,autor,anio,totalCopias,copiasDisponibles,extra1,extra2");

            for (Material material : listaMateriales) {
                if (material instanceof Libro libro) {
                    escritor.printf("Libro,%s,%s,%s,%d,%d,%d,%s,%s%n",
                        quitarComas(libro.getCodigo()),
                        quitarComas(libro.getTitulo()),
                        quitarComas(libro.getAutor()),
                        libro.getAnio(),
                        libro.getTotalCopias(),
                        libro.getCopiasDisponibles(),
                        quitarComas(libro.getIsbn()),
                        quitarComas(libro.getEditorial()));

                } else if (material instanceof Revista revista) {
                    escritor.printf("Revista,%s,%s,%s,%d,%d,%d,%d,%s%n",
                        quitarComas(revista.getCodigo()),
                        quitarComas(revista.getTitulo()),
                        quitarComas(revista.getAutor()),
                        revista.getAnio(),
                        revista.getTotalCopias(),
                        revista.getCopiasDisponibles(),
                        revista.getNumeroEdicion(),
                        "");
                }
            }
        } catch (IOException error) {
            System.err.println("Error al guardar materiales: " + error.getMessage());
        }
    }

    //CARGAR MATERIALES

    public static void cargarMateriales(List<Material> listaMateriales) {
        File archivoCsv = new File(ARCHIVO_MATERIALES);
        if (!archivoCsv.exists()) return;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoCsv))) {
            lector.readLine(); // primera línea es el encabezado, se omite

            String lineaActual;
            while ((lineaActual = lector.readLine()) != null) {
                String[] columnas = lineaActual.split(",", -1);
                if (columnas.length < 7) continue;

                String tipoMaterial      = columnas[0];
                String codigo            = columnas[1];
                String titulo            = columnas[2];
                String autor             = columnas[3];
                int    anioPublicacion   = Integer.parseInt(columnas[4]);
                int    totalCopias       = Integer.parseInt(columnas[5]);
                int    copiasDisponibles = Integer.parseInt(columnas[6]);

                if ("Libro".equals(tipoMaterial) && columnas.length >= 9) {
                    String isbn      = columnas[7];
                    String editorial = columnas[8];
                    Libro libroRecuperado = new Libro(codigo, titulo, autor, anioPublicacion,
                                                      totalCopias, isbn, editorial);
                    sincronizarCopiasDisponibles(libroRecuperado, copiasDisponibles);
                    listaMateriales.add(libroRecuperado);

                } else if ("Revista".equals(tipoMaterial) && columnas.length >= 8) {
                    int numeroEdicion = Integer.parseInt(columnas[7]);
                    Revista revistaRecuperada = new Revista(codigo, titulo, autor, anioPublicacion,
                                                            totalCopias, numeroEdicion);
                    sincronizarCopiasDisponibles(revistaRecuperada, copiasDisponibles);
                    listaMateriales.add(revistaRecuperada);
                }
            }
        } catch (IOException error) {
            System.err.println("Error al cargar materiales: " + error.getMessage());
        }
    }

    //GUARDAR USUARIOS
    public static void guardarUsuarios(List<Usuario> listaUsuarios) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            escritor.println("tipo,nombre,apellido,carnet,telefono,correo,extra1,extra2");

            for (Usuario usuario : listaUsuarios) {
                if (usuario instanceof Estudiante estudiante) {
                    escritor.printf("Estudiante,%s,%s,%s,%s,%s,%s,%d%n",
                        quitarComas(estudiante.getNombre()),
                        quitarComas(estudiante.getApellido()),
                        quitarComas(estudiante.getCarnet()),
                        quitarComas(estudiante.getTelefono()),
                        quitarComas(estudiante.getCorreo()),
                        quitarComas(estudiante.getCarrera()),
                        estudiante.getSemestre());

                } else if (usuario instanceof Docente docente) {
                    escritor.printf("Docente,%s,%s,%s,%s,%s,%s,%s%n",
                        quitarComas(docente.getNombre()),
                        quitarComas(docente.getApellido()),
                        quitarComas(docente.getCarnet()),
                        quitarComas(docente.getTelefono()),
                        quitarComas(docente.getCorreo()),
                        quitarComas(docente.getDepartamento()),
                        "");
                }
            }
        } catch (IOException error) {
            System.err.println("Error al guardar usuarios: " + error.getMessage());
        }
    }

    //CARGAR USUARIOS
    public static void cargarUsuarios(List<Usuario> listaUsuarios) {
        File archivoCsv = new File(ARCHIVO_USUARIOS);
        if (!archivoCsv.exists()) return;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoCsv))) {
            lector.readLine(); // primera línea es el encabezado, se omite

            String lineaActual;
            while ((lineaActual = lector.readLine()) != null) {
                String[] columnas = lineaActual.split(",", -1);
                if (columnas.length < 6) continue;

                String tipoUsuario = columnas[0];
                String nombre      = columnas[1];
                String apellido    = columnas[2];
                String carnet      = columnas[3];
                String telefono    = columnas[4];
                String correo      = columnas[5];

                if ("Estudiante".equals(tipoUsuario) && columnas.length >= 8) {
                    String carrera   = columnas[6];
                    int    semestre  = Integer.parseInt(columnas[7]);
                    listaUsuarios.add(new Estudiante(nombre, apellido, carnet,
                                                     telefono, correo, carrera, semestre));

                } else if ("Docente".equals(tipoUsuario) && columnas.length >= 7) {
                    String departamento = columnas[6];
                    listaUsuarios.add(new Docente(nombre, apellido, carnet,
                                                  telefono, correo, departamento));
                }
            }
        } catch (IOException error) {
            System.err.println("Error al cargar usuarios: " + error.getMessage());
        }
    }

    //GUARDAR PRÉSTAMOS

    public static void guardarPrestamos(List<Prestamo> listaPrestamos) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(ARCHIVO_PRESTAMOS))) {
            escritor.println("idPrestamo,carnetUsuario,codigoMaterial,fechaPrestamo,yaFueDevuelto");

            for (Prestamo prestamo : listaPrestamos) {
                escritor.printf("%s,%s,%s,%s,%b%n",
                    quitarComas(prestamo.getId()),
                    quitarComas(prestamo.getUsuario().getCarnet()),
                    quitarComas(prestamo.getMaterial().getCodigo()),
                    quitarComas(prestamo.getFechaPrestamo()),
                    prestamo.isDevuelto());
            }
        } catch (IOException error) {
            System.err.println("Error al guardar préstamos: " + error.getMessage());
        }
    }

    //CARGAR PRÉSTAMOS
    public static void cargarPrestamos(List<Prestamo> listaPrestamos,
            List<Material> listaMateriales,
            List<Usuario> listaUsuarios) {

File archivoCsv = new File(ARCHIVO_PRESTAMOS);
if (!archivoCsv.exists()) return;

try (BufferedReader lector = new BufferedReader(new FileReader(archivoCsv))) {

lector.readLine();

String lineaActual;

while ((lineaActual = lector.readLine()) != null) {

String[] columnas = lineaActual.split(",", -1);

if (columnas.length < 5) continue;

String idPrestamo     = columnas[0];
String carnetUsuario  = columnas[1];
String codigoMaterial = columnas[2];
String fechaPrestamo  = columnas[3];
boolean devuelto = Boolean.parseBoolean(columnas[4]);
Usuario usuarioEncontrado =
buscarUsuarioPorCarnet(listaUsuarios, carnetUsuario);

Material materialEncontrado =
buscarMaterialPorCodigo(listaMateriales, codigoMaterial);

Prestamo prestamoRecuperado = new Prestamo(
idPrestamo,
usuarioEncontrado,
materialEncontrado,
fechaPrestamo
);

if (devuelto) {
    prestamoRecuperado.devolver();
}

listaPrestamos.add(prestamoRecuperado);
        }

       } catch (IOException error) {

       System.err.println(
       "Error al cargar préstamos: " + error.getMessage());

}
}
    //MÉTODOS PRIVADOS DE APOYO

    /**
     * Elimina comas de un texto para que no rompan el formato CSV.
     * Las reemplaza por punto y coma.
     */
    private static String quitarComas(String texto) {
        if (texto == null) return "";
        return texto.replace(",", ";");
    }

    /**
     * El constructor de Material siempre pone copiasDisponibles = totalCopias.
     * Este método reduce las copias disponibles para que coincidan
     * con el valor real guardado en el CSV (cuando hay préstamos activos).
     */
    private static void sincronizarCopiasDisponibles(Material material, int copiasDisponiblesReales) {
        int copiasPrestadasActualmente = material.getTotalCopias() - copiasDisponiblesReales;
        for (int prestamo = 0; prestamo < copiasPrestadasActualmente; prestamo++) {
            material.prestar();
        }
    }

    /**
     * Busca un usuario en la lista usando su número de carnet.
     * Devuelve null si no lo encuentra.
     */
    private static Usuario buscarUsuarioPorCarnet(List<Usuario> listaUsuarios, String carnetBuscado) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCarnet().equals(carnetBuscado)) return usuario;
        }
        return null;
    }

    /**
     * Busca un material en la lista usando su código único.
     * Devuelve null si no lo encuentra.
     */
    private static Material buscarMaterialPorCodigo(List<Material> listaMateriales, String codigoBuscado) {
        for (Material material : listaMateriales) {
            if (material.getCodigo().equals(codigoBuscado)) return material;
        }
        return null;
    }
}