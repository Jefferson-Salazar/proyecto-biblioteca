package dominio;

public class Estudiante extends Usuario {
	

	    private String carrera;
	    private int semestre;

	    public Estudiante(String nombre, String apellido, String carnet,
	                       String telefono, String correo,
	                       String carrera, int semestre) {

	        super(nombre, apellido, carnet, telefono, correo);

	        this.carrera = carrera;
	        this.semestre = semestre;
	    }

	    // Getters
	    public String getCarrera() {
	        return carrera;
	    }

	    public int getSemestre() {
	        return semestre;
	    }

	    // Setters
	    public void setCarrera(String carrera) {
	        this.carrera = carrera;
	    }

	    public void setSemestre(int semestre) {
	        this.semestre = semestre;
	    }

	    // Mostrar datos
	    @Override
	    public void mostrarDatos() {

	        super.mostrarDatos();

	        System.out.println("Carrera: " + carrera);
	        System.out.println("Semestre: " + semestre);
	    }
	}

