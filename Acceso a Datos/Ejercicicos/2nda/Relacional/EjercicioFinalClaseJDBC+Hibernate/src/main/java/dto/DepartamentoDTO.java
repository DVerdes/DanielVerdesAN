package dto;

public class DepartamentoDTO {

    private int id ;
    private String nombre ;
    private String ubicacion ;
    private String email;
    private String telefono;
    private int numEmpleados;

    public DepartamentoDTO() {
    }

    public DepartamentoDTO(String nombre, String ubicacion, String email, String telefono, int numEmpleados) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
        this.numEmpleados = numEmpleados;
    }

    public DepartamentoDTO(String nombre, String ubicacion, String email, String telefono) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
    }

    public DepartamentoDTO(int id, String nombre, String ubicacion, String email, String telefono) {

        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "DepartamentoDTO{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numEmpleados=" + numEmpleados +
                '}';
    }
}
