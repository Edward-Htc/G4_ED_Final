/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ramos
 */
public class ColaLista
{
  protected Nodo frente;
  protected Nodo fin;
    // constructor: crea cola vacía
    public ColaLista(){
      frente = fin = null;
    }
    // insertar: pone elemento por el final
    public void insertar(Object elemento){
        Nodo a;
        a = new Nodo(elemento);
        if (colaVacia())
        {
          frente = a;
        }
        else
        {
          fin.siguiente = a;
        }
        fin = a;
    }
    // quitar: sale el elemento frente
    public Object quitar() //throws Exception
    { 
      Object aux = null;
      if (!colaVacia() && frente != fin)
      {
        aux = frente.elemento;
        frente = frente.siguiente;
      }
      else if(!colaVacia() && frente == fin){
          aux = frente.elemento;
          frente = null;
          fin = null;
      }
      //else 
        //throw new Exception("No se puede eliminar de una cola vacía");
      return aux;
    }
    // libera todos los nodos de la cola
    public void borrarCola()
    {
      for (; frente != null;)
      { 
        frente = frente.siguiente;
      }
      System.gc();
    } 
    // acceso al primero de la cola
    public Object frenteCola()// throws Exception
    {
        /*
      if (colaVacia())
      {
        throw new Exception("Error: cola vacía");
      } */
      return (frente.elemento);
    }
    // verificación del estado de la cola
    public boolean colaVacia()
    {
      return (frente == null);
    }
    
    public String mostrarCola(){
        String colaLista = "";
        Nodo aux = frente;
        while(aux!=null){
            colaLista = colaLista + aux.elemento+"\n";
            aux = aux.siguiente;
        }
        return colaLista;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
    
    

  }