package dominio;
import java.io.Serializable;
public abstract class Material implements Serializable {

	    // Atributos
	    private String codigo;
	    private String titulo;
	    private String autor;
	    private int anio;
	    private int totalCopias;
	    private int copiasDisponibles;

	    // Constructor 
	    public Material(String codigo, String titulo, String autor, int anio, int totalCopias) {
	        setCodigo(codigo);
	        setTitulo(titulo);
	        setAutor(autor);
	        setAnio(anio);
	        setTotalCopias(totalCopias);
	        this.copiasDisponibles = totalCopias; // al registrar, todas disponibles
	    }

	    // Métodos abstractos 
	    public abstract int diasPrestamoMaximo();
	    public abstract double calcularMulta(int diasRetraso);

	    // Métodos concretos de negocio
	    public boolean estaDisponible() {
	        return copiasDisponibles > 0;
	    }

	    public void prestar() {
	        if (!estaDisponible()) {
	            throw new IllegalStateException("No hay copias disponibles de: " + titulo);
	        }
	        copiasDisponibles--;
	    }

	    public void devolver() {
	        if (copiasDisponibles >= totalCopias) {
	            copiasDisponibles = totalCopias; 
	            return;
	        }
	        copiasDisponibles++;
	    }
	    //Getters
	    public String getCodigo()            { return codigo; }
	    public String getTitulo()            { return titulo; }
	    public String getAutor()             { return autor; }
	    public int    getAnio()              { return anio; }
	    public int    getTotalCopias()       { return totalCopias; }
	    public int    getCopiasDisponibles() { return copiasDisponibles; }

	    // Setters con validación 
	    public void setCodigo(String codigo) {
	        if (codigo == null || codigo.trim().isEmpty())
	            throw new IllegalArgumentException("El código no puede estar vacío.");
	        this.codigo = codigo.trim();
	    }

	    public void setTitulo(String titulo) {
	        if (titulo == null || titulo.trim().isEmpty())
	            throw new IllegalArgumentException("El título no puede estar vacío.");
	        this.titulo = titulo.trim();
	    }

	    public void setAutor(String autor) {
	        if (autor == null || autor.trim().isEmpty())
	            throw new IllegalArgumentException("El autor no puede estar vacío.");
	        this.autor = autor.trim();
	    }

	    public void setAnio(int anio) {
	        if (anio < 1000 || anio > 2100)
	            throw new IllegalArgumentException("Año inválido: " + anio);
	        this.anio = anio;
	    }

	    public void setTotalCopias(int totalCopias) {
	        if (totalCopias <= 0)
	            throw new IllegalArgumentException("Las copias deben ser mayor a 0.");
	        this.totalCopias = totalCopias;
	    }

	    // toString 
	    @Override
	    public String toString() {
	        return String.format("[%s] %s — %s (%d) | Disponibles: %d/%d",
	                codigo, titulo, autor, anio, copiasDisponibles, totalCopias);
	    }
}
