package dominio;


public class Prestamo  {


    private String id;
    private Usuario usuario;
    private Material material;
    private String fechaPrestamo;
    private boolean devuelto;
    
    public Prestamo(String id, Usuario usuario, Material material, String fechaPrestamo) {
        this.id = id;
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.devuelto = false;
    }
    
    public String getId() {
        return id;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
    
    public boolean isDevuelto() {
        return devuelto;
    }
    
    public void devolver() {
        this.devuelto = true;
        this.material.devolver();
    }
}