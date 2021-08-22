
package Modelo;

/**
 *
 * @author ramos
 */
public class Solicitud {
    private int id;
    private String mensaje;
    private Empleado empleado;
    private int prioridad;
    public Solicitud(int id,String mensaje,Empleado empleado,int prioridad){
        this.id = id;
        this.mensaje = mensaje;
        this.empleado = empleado;
        this.prioridad =prioridad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public String toString(){
        return "Prioridad: "+prioridad+"\nid: "+id+"\nMensaje: "+mensaje+"\nEmpleado: "+empleado.toString();
    }
    
}
