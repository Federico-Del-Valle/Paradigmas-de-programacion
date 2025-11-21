public class Hotel {
    private int id;
    private String nombre;
    private String ciudad;
    private double precio;

    // Constructor
    public Hotel(int id, String nombre, String ciudad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

