package dominio;

public class Revista extends Material{

	    private int numeroEdicion;

	    public Revista(String codigo, String titulo, String autor, int anio,
	                   int totalCopias, int numeroEdicion) {
	        super(codigo, titulo, autor, anio, totalCopias);
	        this.numeroEdicion = numeroEdicion;
	    }

	    @Override
	    public int diasPrestamoMaximo() {
	        return 7; // 1 semana
	    }

	    @Override
	    public double calcularMulta(int diasRetraso) {
	        if (diasRetraso <= 0) return 0;
	        return diasRetraso * 1.00; // Q1.00 por día
	    }

	    public int getNumeroEdicion() { return numeroEdicion; }

	    @Override
	    public String toString() {
	        return "Revista | " + super.toString();
	    }
}
