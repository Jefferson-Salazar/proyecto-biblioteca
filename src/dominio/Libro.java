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

	    @Override
	    public int diasPrestamoMaximo() {
	        return 14; // 2 semanas
	    }

	    @Override
	    public double calcularMulta(int diasRetraso) {
	        if (diasRetraso <= 0) return 0;
	        return diasRetraso * 2.50; // Q2.50 por día
	    }

	    public String getIsbn()      { return isbn; }
	    public String getEditorial() { return editorial; }

	    @Override
	    public String toString() {
	        return "Libro | " + super.toString();
	    }
}
