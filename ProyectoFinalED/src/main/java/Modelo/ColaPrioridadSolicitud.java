
package Modelo;

/**
 *
 * @author ramos
 */
public class ColaPrioridadSolicitud
  {
    protected ColaLista[] tabla;
    protected int maxPrioridad;
    
    public ColaPrioridadSolicitud(int n)
    {
        maxPrioridad = n;
        tabla = new ColaLista[maxPrioridad + 1];
        for (int i = 0; i <= maxPrioridad; i++)
          tabla[i] = new ColaLista();
    }
    public void inserEnPrioridad(Solicitud t)throws Exception
    {
      int p = t.getPrioridad();
      if (p >= 0 && p <= maxPrioridad)
      {
        tabla[p].insertar(t);
      }
      else{
        throw new Exception("Tarea con prioridad fuera de rango");
      }
    }
    //devuelve el elemento prioritario pero no lo quita
    public Solicitud elementoMin()//throws Exception
    {
      int i = 0;
      int indiceCola = -1; 
      // búsqueda de la primera cola no vacía 
      do {
        if (!tabla[i].colaVacia()){
          indiceCola = i;
          i = maxPrioridad +1;  // termina el bucle 
        }
        else{
          i++;
        }
      }while (i <= maxPrioridad);
  
      //if (indiceCola != -1){
        return (Solicitud) tabla[indiceCola].frenteCola();
      //}
     // else{
        //throw new Exception("Cola de prioridades vacía");
      }
    //devuelve el elemento prioritario pero lo quita
    public Solicitud quitarMin() //throws Exception
    {
      int i = 0;
      int indiceCola = -1; 
      // búsqueda de la primera cola no vacía 
      do {
        if (!tabla[i].colaVacia())
        {
          indiceCola = i;
          i = maxPrioridad +1;// termina el bucle 
        }
        else{
          i++;
        }
      }while (i <= maxPrioridad);
  
      //if(indiceCola != -1){
        return (Solicitud) tabla[indiceCola].quitar();
      //}
      //else{
        //throw new Exception("Cola de prioridades vacía");
      //}
    }
    //nos devueleve un valor booleano
    //nos dice si la cola de prioridad esta vacia o no
    public boolean colaPrioridadVacia(){
      int i = 0;
      while (tabla[i].colaVacia() && i < maxPrioridad)
        i++;
      return tabla[i].colaVacia();
    }
    
    public void vaciarColaPrioridadVacia(){
        int i=0;
        while(i<= maxPrioridad){
            tabla[i].borrarCola();
            i++;
        }
    }
    
    public String mostrarListaPrioridad(){
        String  listaPrioridad = "";
        for (ColaLista tabla1 : tabla) {
            listaPrioridad = listaPrioridad + tabla1.mostrarCola() ;
        }
        return listaPrioridad;
    }

    public int getMaxPrioridad() {
        return maxPrioridad;
    }

    public void setMaxPrioridad(int maxPrioridad) {
        this.maxPrioridad = maxPrioridad;
    }

    public ColaLista[] getTabla() {
        return tabla;
    }

    public void setTabla(ColaLista[] tabla) {
        this.tabla = tabla;
    }
    
    
    
    
  }