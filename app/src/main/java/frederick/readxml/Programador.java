package frederick.readxml;

public class Programador {

    String nombre;
    String apellido;
    String cedula;
    String cargo;

    public Programador(){}

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setNombre(String s) {
        this.nombre = s;
    }

    public void setApellido(String a) {
        this.apellido = a;
    }

    public void setCedula(String c) {
        this.cedula = c;
    }

    public void setCargo(String c) {
        this.cargo = c;
    }


}
