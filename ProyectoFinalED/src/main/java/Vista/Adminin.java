
package Vista;

import javax.swing.table.DefaultTableModel;
import Modelo.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Adminin extends javax.swing.JFrame {
    DefaultTableModel modelo;
    ColaPrioridadSolicitud solicitudes = new ColaPrioridadSolicitud(5);
    File base_solicitudes = new File("d:\\solicitudes.txt");
    static Solicitud soli;
    int filas;
    
    
    public Adminin() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        modelo.addColumn("id_solicitud");
        modelo.addColumn("Priridad");
        modelo.addColumn("Emisor");
        modelo.addColumn("Area");
        //modelo.addColumn("VistaPreia");
        this.jTable.setModel(modelo);
        
        Scanner sc = null;
        try {
            sc = new Scanner(base_solicitudes);
            String cadena,nom="",ape="",area="",msj="";
            
            int id =0,prioridad=0;
            cadena = "";
            
            while(sc.hasNext()){
                msj = "";
                cadena = sc.nextLine();
                id = Integer.parseInt(cadena);
                cadena = sc.nextLine();
                prioridad = Integer.parseInt(cadena);
                cadena = sc.nextLine();
                nom = cadena;
                cadena = sc.nextLine();
                ape = cadena;
                cadena = sc.nextLine();
                area = cadena;
                cadena = sc.nextLine();
                while(cadena.compareTo("") != 0){
                    msj += cadena;
                    cadena = sc.nextLine();
                }
                
                if(cadena != null){
                    Solicitud solic = new Solicitud(id, msj,new Empleado(nom, ape, area), prioridad);
                    solicitudes.inserEnPrioridad(solic);
                }              
            }
            sc.close();       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Adminin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Adminin.class.getName()).log(Level.SEVERE, null, ex);
        }  
 
        filas = 0;
  
        for (int i = 1; i <= solicitudes.getMaxPrioridad(); i++) {
            String[] valores = new String[4];
            Nodo aux = solicitudes.getTabla()[i].getFrente();
            while(aux != null){
                Solicitud s = (Solicitud) aux.getElemento();
                
                valores[0] = String.valueOf(s.getId());
                valores[2] = s.getEmpleado().getNombre() + s.getEmpleado().getApellido();
                valores[3] = s.getEmpleado().getArea();
                switch(i){
                    case 1:
                        valores[1] = "Muy Alta"; 
                        break;
                    case 2:
                        valores[1] = "Alta"; 
                        break;
                    case 3:
                        valores[1] = "Media"; 
                        break;
                    case 4:
                        valores[1] = "Baja"; 
                        break;
                    case 5:
                        valores[1] = "Muy Baja"; 
                        break;    
                }
                
                modelo.insertRow(filas,valores);
                
                aux = aux.getSiguiente();
                filas++;
            }
        }   
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton_Verificar = new javax.swing.JButton();
        jButton_salir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(55, 66, 97));

        jPanel1.setBackground(new java.awt.Color(55, 66, 97));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Solicitud", "Prioridad", "Emisor", "Area", "VistaPrevia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButton_Verificar.setBackground(new java.awt.Color(209, 10, 72));
        jButton_Verificar.setFont(new java.awt.Font("Yu Gothic Medium", 3, 18)); // NOI18N
        jButton_Verificar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Verificar.setText("Verificar");
        jButton_Verificar.setBorderPainted(false);
        jButton_Verificar.setMargin(new java.awt.Insets(5, 14, 2, 14));
        jButton_Verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VerificarActionPerformed(evt);
            }
        });

        jButton_salir.setBackground(new java.awt.Color(209, 10, 72));
        jButton_salir.setFont(new java.awt.Font("Yu Gothic Medium", 3, 18)); // NOI18N
        jButton_salir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_salir.setText("Salir");
        jButton_salir.setBorderPainted(false);
        jButton_salir.setMargin(new java.awt.Insets(5, 14, 2, 14));
        jButton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Verificar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Verificar)
                    .addComponent(jButton_salir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(209, 10, 72));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Solicitudes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(78, 78, 78))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
            //Creo que no son necesarios textfield,al momento de presionar Verificar se verificaria la primera solicitud xq si
            //Selecciona como que lo de prioridades pierde valor al menos o eso opino
            
            
            
            //LOS JTEXTFIELD SON LOS QUE SE CREARAN AL COSTADO DEL JTABLE PARA JALAR LA INFO QUE SE SELECCIONE CON EL MOUSE DEL JTABLE
            
//            jTextField_id_solicitud.setText((String) jTable.getValueAt(fila, 1));
//            jTextField_Priridad.setText((String) jTable.getValueAt(fila, 2));
//            jTextField.Emisor.setName((String) jTable.getValueAt(fila,3));
//            jTextField_Area.setText(String.valueOf(jTable.getValueAt(fila, 4)));
//            jTextField_VistaPreia.setText(String.valueOf(jTable.getValueAt(fila, 5)));
//                 
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton_VerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VerificarActionPerformed
  
        //soli = solicitudes.quitarMin();
        soli = solicitudes.quitarMin();
        filas--;
        modelo.removeRow(0);
        VentanaMensaje vm = new VentanaMensaje();
        vm.setVisible(true);
        
    }//GEN-LAST:event_jButton_VerificarActionPerformed

    private void jButton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salirActionPerformed
        // TODO add your handling code here:
        if(!solicitudes.colaPrioridadVacia()){
            BufferedWriter reinicio;
            try {
                reinicio = new BufferedWriter(new FileWriter(base_solicitudes));
                reinicio.write("");
                reinicio.close();
            } catch (IOException ex) {
                Logger.getLogger(Adminin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                FileWriter escritura = new FileWriter(base_solicitudes);
                PrintWriter solis = new PrintWriter(escritura);
            
                for(int i=1;i<=solicitudes.getMaxPrioridad();i++){
                    Nodo aux_escribir = solicitudes.getTabla()[i].getFrente();
                
                    while(aux_escribir != null){
                        Solicitud sol = (Solicitud)aux_escribir.getElemento();
                    
                        solis.println(sol.getId());
                        solis.println(sol.getPrioridad());
                        solis.println(sol.getEmpleado().getNombre());
                        solis.println(sol.getEmpleado().getApellido());
                        solis.println(sol.getEmpleado().getArea());
                        solis.println(sol.getMensaje());
                        solis.println(""); 
                        
                        aux_escribir = aux_escribir.getSiguiente();
                    }
                }
                solis.close();
            
            } catch (IOException ex) {
                Logger.getLogger(VentanaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            solicitudes.vaciarColaPrioridadVacia();           
                
        }else{
            base_solicitudes.delete();
        }
        
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_jButton_salirActionPerformed

    public static Solicitud getSoli() {
        return soli;
    }

    public void setSoli(Solicitud soli) {
        this.soli = soli;
    }
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Verificar;
    private javax.swing.JButton jButton_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables


   
}



