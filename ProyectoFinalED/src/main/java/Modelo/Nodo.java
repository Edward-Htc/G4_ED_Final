        
package Modelo;

/**
 *
 * @author ramos
 */
public class Nodo{            
  Object elemento;    
  Nodo siguiente;

  public Nodo(Object x)
  {
    elemento = x;
    siguiente = null;
  }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
  
  
}
