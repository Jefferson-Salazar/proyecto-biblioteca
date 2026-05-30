package dominio;

public class Revista extends Material{

	    private int numeroEdicion;

	    public Revista(String codigo, String titulo, String autor, int anio,
	                   int totalCopias, int numeroEdicion) {
	        super(codigo, titulo, autor, anio, totalCopias);
	        this.numeroEdicion = numeroEdicion;
	    }


	    public int getNumeroEdicion() { return numeroEdicion; }

	    @Override
	    public String toString() {
	        return "Revista | " + super.toString();
	    }
}
