package dominio;

public abstract class Usuario {

	    protected String nombre;
	    protected String apellido;
	    protected String carnet;
	    protected String telefono;
	    protected String correo;

	    // Constructor
	    public Usuario(String nombre, String apellido, String carnet,
	                   String telefono, String correo) {

	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.carnet = carnet;
	        this.telefono = telefono;
	        this.correo = correo;
	    }

	    // Getters
	    public String getNombre() {
	        return nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public String getCarnet() {
	        return carnet;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    // Setters
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public void setCarnet(String carnet) {
	        this.carnet = carnet;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    // Mostrar datos
	    public void mostrarDatos() {

	        System.out.println("Nombre: " + nombre);
	        System.out.println("Apellido: " + apellido);
	        System.out.println("Carnet: " + carnet);
	        System.out.println("Telefono: " + telefono);
	        System.out.println("Correo: " + correo);
	    }
	}


