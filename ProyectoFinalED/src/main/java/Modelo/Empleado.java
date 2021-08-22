
package Modelo;

/**
 *
 * @author ramos
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private String area;
    
    public Empleado(String nombre,String apellido,String area){
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getArea() {
        return area;
    }
    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nApellido: "+apellido+"\nArea: "+area;
    }
    
}
