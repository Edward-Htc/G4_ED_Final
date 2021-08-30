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
public class TestCola {
    public static void main(String args[]) throws Exception{
        ColaPrioridadSolicitud c = new ColaPrioridadSolicitud(5);
        Solicitud s1 =new Solicitud(1234,"hola1",new Empleado("Kevin","Ramos Rivas","Administracion"),1);
        Solicitud s2 =new Solicitud(1245,"hola2",new Empleado("Pedro","Araujo","Recursos humanos"),2);
        Solicitud s3 =new Solicitud(1256,"hola3",new Empleado("Gustavo","Guerreros Jacobe","Logistica"),3);
        Solicitud s4 =new Solicitud(1231,"hola4",new Empleado("Alonso","Zenobio Pariasca","Marketing"),1);
        Solicitud s5 =new Solicitud(1238,"hola5",new Empleado("Eduardo","Reyna Ulloa","Logistica"),5);
        Solicitud s6 =new Solicitud(1225,"hola7",new Empleado("Samuel","Roman Cespedes","contabilidad"),1);
        Solicitud s7 =new Solicitud(1256,"hola8",new Empleado("Gustavo","Guerreros Jacobe","Logistica"),3);
        c.inserEnPrioridad(s1);
        c.inserEnPrioridad(s2);
        c.inserEnPrioridad(s3);
        c.inserEnPrioridad(s6);
        c.inserEnPrioridad(s4);
        c.inserEnPrioridad(s5);
        c.inserEnPrioridad(s7);
        System.out.println(c.mostrarListaPrioridad());
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
          System.out.println(c.quitarMin());
//        System.out.println("\n");
          System.out.println(c.quitarMin());  
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
          System.out.println(c.quitarMin());
//        c.quitarMin();
//        System.out.println("\n");
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
//        c.quitarMin();
//        System.out.println("\n");
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
//        c.quitarMin();
//        System.out.println("\n");
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
//        c.quitarMin();
//        System.out.println("\n");
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
//        c.quitarMin();
//        System.out.println("\n");
//        System.out.println("elemento minimo: \n"+c.elementoMin().toString());
//        c.quitarMin();
        
    }
    
}
