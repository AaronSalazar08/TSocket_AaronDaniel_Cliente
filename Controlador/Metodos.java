package Controlador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import Vista.PrimeraVista;
import Vista.RegistroAplicante;
import Vista.RegistroInicio;
import Vista.RegistroPedido;

public class Metodos implements ActionListener {

    public final String HOST = "192.168.86.55";

    final int PUERTO = 5000;
    DataInputStream in;
    DataOutputStream out;

    RegistroPedido enlacePedido ;
    RegistroInicio enlanceLogin;
    PrimeraVista enlaceVista ;
    RegistroAplicante enlaceAplicante;

    

    

    public Metodos(RegistroPedido enlacePedido) {
        this.enlacePedido = enlacePedido;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;

    }

    public Metodos(RegistroInicio enlaceLogin) {
        this.enlacePedido = null;
        this.enlanceLogin = enlaceLogin;
        this.enlaceVista = null;
        this.enlaceAplicante = null;

    }

    public Metodos(PrimeraVista enlaceVista) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = enlaceVista;
        this.enlaceAplicante = null;
    }

    public Metodos(RegistroAplicante enlaceAplicante) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = enlaceAplicante;
    }

    public void actionPerformed(ActionEvent e) {

        if (enlacePedido != null && e.getSource() == enlacePedido.botonEnviar) {

            String nombre = enlacePedido.areaNombre.getText().trim();

            try{
              
    
                Socket sc = new Socket(HOST, PUERTO);
               
                in = new DataInputStream(sc.getInputStream());
               
                out = new DataOutputStream(sc.getOutputStream());
                out.writeUTF(nombre);
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                sc.close();
                
             
            }catch(
            IOException ex){
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        


            }

        }

        if(enlaceVista != null && e.getSource() == enlaceVista.botonRegistroEmpleado){

         RegistroAplicante registroAplicante = new RegistroAplicante();
         registroAplicante.setVisible(true);
         enlaceVista.dispose();

        }




    }
}
