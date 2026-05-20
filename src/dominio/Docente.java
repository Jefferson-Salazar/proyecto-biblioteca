package dominio;

public class Docente extends Usuario {
	

	    private String departamento;

	    public Docente(String nombre, String apellido, String carnet,
	                   String telefono, String correo,
	                   String departamento) {

	        super(nombre, apellido, carnet, telefono, correo);

	        this.departamento = departamento;
	    }

	    // Getter
	    public String getDepartamento() {
	        return departamento;
	    }

	    // Setter
	    public void setDepartamento(String departamento) {
	        this.departamento = departamento;
	    }

	    // Mostrar datos
	    @Override
	    public void mostrarDatos() {

	        super.mostrarDatos();

	        System.out.println("Departamento: " + departamento);
	    }
	}


