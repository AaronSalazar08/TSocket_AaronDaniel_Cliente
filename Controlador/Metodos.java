package Controlador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import Vista.EstadoPedido;
import Vista.PrimeraVista;
import Vista.RegistroAplicante;
import Vista.RegistroInicio;
import Vista.RegistroPedido;

public class Metodos implements ActionListener {

    public final String HOST = "192.168.86.55";

    final int PUERTO = 5000;
    DataInputStream in;
    DataOutputStream out;

    RegistroPedido enlacePedido;
    RegistroInicio enlanceLogin;
    PrimeraVista enlaceVista;
    RegistroAplicante enlaceAplicante;
    EstadoPedido enlaceEstadoPedido;

    public Metodos(RegistroPedido enlacePedido) {
        this.enlacePedido = enlacePedido;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;

    }

    public Metodos(RegistroInicio enlaceLogin) {
        this.enlacePedido = null;
        this.enlanceLogin = enlaceLogin;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;

    }

    public Metodos(PrimeraVista enlaceVista) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = enlaceVista;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
    }

    public Metodos(RegistroAplicante enlaceAplicante) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = enlaceAplicante;
        this.enlaceEstadoPedido = null;
    }
    public Metodos(EstadoPedido enlaceEstadoPedido) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = enlaceEstadoPedido;
        
    }

    public void actionPerformed(ActionEvent e) {

        if (enlacePedido != null && e.getSource() == enlacePedido.botonEnviar) {

            String nombre = enlacePedido.areaNombre.getText().trim();

            try {

                Socket sc = new Socket(HOST, PUERTO);

                in = new DataInputStream(sc.getInputStream());

                out = new DataOutputStream(sc.getOutputStream());
                out.writeUTF(nombre);
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                sc.close();

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

        if (enlaceVista != null && e.getSource() == enlaceVista.botonRegistroEmpleado) {

            RegistroAplicante registroAplicante = new RegistroAplicante();
            registroAplicante.setVisible(true);
            enlaceVista.dispose();

        }

        if (enlaceAplicante != null && e.getSource() == enlaceAplicante.botonVolver) {

            PrimeraVista primeraVista = new PrimeraVista();
            primeraVista.usuario.setText(enlanceLogin.areaNombre.getText());
            primeraVista.setVisible(true);
            enlaceAplicante.dispose();
        }

        if (enlaceVista != null && e.getSource() == enlaceVista.botoonApagar) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Deseas salir del Programa?", "confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                enlaceVista.dispose();
            }

        }

        if (enlaceVista != null && e.getSource() == enlaceVista.iconoUsuario) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Deseas cerrar sesión?", "confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(null, "Cerrando Sesión...");
                RegistroInicio registroInicio = new RegistroInicio();
                registroInicio.setVisible(true);
                enlaceVista.dispose();
            }

        }

        if (enlanceLogin != null && e.getSource() == enlanceLogin.botonEntrar) {

            String nombre = enlanceLogin.areaNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese su nombre de Usuario");
            } else {

                JOptionPane.showMessageDialog(null, "Bienvenido " + enlanceLogin.areaNombre.getText());

                PrimeraVista primeraVista = new PrimeraVista();
                primeraVista.usuario.setText(enlanceLogin.areaNombre.getText());
                primeraVista.setVisible(true);
                enlanceLogin.dispose();

            }

        }

        if(enlaceVista != null && e.getSource() == enlaceVista.botonVerPedido){

            EstadoPedido estadoPedido = new EstadoPedido();
            estadoPedido.setVisible(true);
            enlaceVista.dispose();
        }

        if (enlaceEstadoPedido != null && e.getSource() == enlaceEstadoPedido.botonVolver) {

            PrimeraVista primeraVista = new PrimeraVista();
            primeraVista.usuario.setText(enlanceLogin.areaNombre.getText());
            primeraVista.setVisible(true);
            enlaceEstadoPedido.dispose();
        }

       
    }
}
