package dominio;

public class Libro extends Material{


	    private String isbn;
	    private String editorial;

	    public Libro(String codigo, String titulo, String autor, int anio,
	                 int totalCopias, String isbn, String editorial) {
	        super(codigo, titulo, autor, anio, totalCopias);
	        this.isbn      = isbn;
	        this.editorial = editorial;
	    }


	    public String getIsbn()      { return isbn; }
	    public String getEditorial() { return editorial; }

	    @Override
	    public String toString() {
	        return "Libro | " + super.toString();
	    }
}
