package Controlador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.Aplicante;
import Modelo.Pedido;

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
import Vista.IngresoDinero;
import Vista.MisPedidos;
import Vista.Noticias;
import Vista.PrimeraVista;
import Vista.RegistroAplicante;
import Vista.RegistroInicio;
import Vista.RegistroPedido;
import Vista.VistaSoporte;

public class Metodos implements ActionListener {

    private static final String PIZZA_SUPER_ROMA_₡12_500 = null;

    public final String HOST = "192.168.86.74";

    final int PUERTO = 5000;
    DataInputStream in;
    DataOutputStream out;

    RegistroPedido enlacePedido;
    RegistroInicio enlanceLogin;
    PrimeraVista enlaceVista;
    RegistroAplicante enlaceAplicante;
    EstadoPedido enlaceEstadoPedido;
    MisPedidos enlaceMisPedidos;
    IngresoDinero enlaceDinero;
    Noticias enlaceNoticias;
    VistaSoporte enlaceSoporte;

    public Metodos(VistaSoporte enlaceSoporte) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceDinero = null;
        this.enlaceSoporte = enlaceSoporte;

    }

    public Metodos(IngresoDinero enlaceDinero) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceDinero = enlaceDinero;
        this.enlaceNoticias = null;
        this.enlaceSoporte = null;

    }

    public Metodos(RegistroPedido enlacePedido) {
        this.enlacePedido = enlacePedido;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceNoticias = null;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;

    }

    public Metodos(RegistroInicio enlaceLogin) {
        this.enlacePedido = null;
        this.enlanceLogin = enlaceLogin;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;
        this.enlaceNoticias = null;

    }

    public Metodos(PrimeraVista enlaceVista) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = enlaceVista;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceNoticias = null;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;
    }

    public Metodos(RegistroAplicante enlaceAplicante) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = enlaceAplicante;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;
        this.enlaceNoticias = null;
    }

    public Metodos(EstadoPedido enlaceEstadoPedido) {

        this.enlaceNoticias = null;
        this.enlacePedido = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = enlaceEstadoPedido;
        this.enlaceMisPedidos = null;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;

    }

    public Metodos(MisPedidos enlaceMisPedidos) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = enlaceMisPedidos;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;
        this.enlaceNoticias = null;

    }

    public Metodos(Noticias enlaceNoticias) {
        this.enlacePedido = null;
        this.enlanceLogin = null;
        this.enlaceVista = null;
        this.enlaceAplicante = null;
        this.enlaceEstadoPedido = null;
        this.enlaceMisPedidos = null;
        this.enlaceNoticias = enlaceNoticias;
        this.enlaceDinero = null;
        this.enlaceSoporte = null;

    }

    public void actionPerformed(ActionEvent e) {

        /*
         * if (enlacePedido != null && e.getSource() == enlacePedido.botonEnviar) {
         * 
         * String nombre = enlacePedido.areaNombre.getText().trim();
         * 
         * 
         * 
         * 
         * 
         * try {
         * 
         * Socket sc = new Socket(HOST, PUERTO);
         * 
         * in = new DataInputStream(sc.getInputStream());
         * 
         * out = new DataOutputStream(sc.getOutputStream());
         * out.writeUTF(nombre);
         * String mensaje = in.readUTF();
         * System.out.println(mensaje);
         * sc.close();
         * 
         * } catch (IOException ex) {
         * Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         * 
         * }
         * 
         * }
         */

        if (enlaceVista != null && e.getSource() == enlaceVista.botonRegistroEmpleado) {

            RegistroAplicante registroAplicante = new RegistroAplicante();
            registroAplicante.setVisible(true);
            enlaceVista.dispose();

        }

        if (enlaceAplicante != null && e.getSource() == enlaceAplicante.botonEnviar) {

            String nombreAplicante = enlaceAplicante.nombre_txt.getText().trim();
            String cedulaAplicante = enlaceAplicante.cedula_txt.getText().trim();
            String correoAplicante = enlaceAplicante.correo_txt.getText().trim();
            String numero = enlaceAplicante.numero_txt.getText().trim();

            if (nombreAplicante.isEmpty() || cedulaAplicante.isEmpty() || correoAplicante.isEmpty()
                    || numero.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Debes de rellenar todos los espacios");

            } else if (!nombreAplicante.isEmpty() || !cedulaAplicante.isEmpty() || !correoAplicante.isEmpty()
                    || !numero.isEmpty()) {

            }

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

        if (enlaceVista != null && e.getSource() == enlaceVista.botonEstadoPedido) {

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

        if (enlaceMisPedidos != null && e.getSource() == enlaceMisPedidos.botonVolver) {

            PrimeraVista primeraVista = new PrimeraVista();
            primeraVista.usuario.setText(enlanceLogin.areaNombre.getText());
            primeraVista.setVisible(true);
            enlaceMisPedidos.dispose();
        }

        if (enlaceVista != null && e.getSource() == enlaceVista.botonMisPedidos) {

            MisPedidos misPedidos = new MisPedidos();
            misPedidos.setVisible(true);
            enlaceVista.dispose();
        }

        if (enlaceVista != null && e.getSource() == enlaceVista.botonRealizarPedido) {

            RegistroPedido registroPedido = new RegistroPedido();
            registroPedido.setVisible(true);
            enlaceVista.dispose();

        }
        if (enlaceVista != null && e.getSource() == enlaceVista.botonBilletera) {
            IngresoDinero ingresoDinero = new IngresoDinero();
            ingresoDinero.setVisible(true);
            enlaceVista.dispose();

        }
        if (enlacePedido != null && e.getSource() == enlacePedido.botonCancelar) {
            PrimeraVista vistaR = new PrimeraVista();
            vistaR.usuario.setText(enlanceLogin.areaNombre.getText());
            vistaR.setVisible(true);
            enlacePedido.dispose();

        }
        if (enlaceDinero != null && e.getSource() == enlaceDinero.botonCancelar) {
            PrimeraVista vistaA = new PrimeraVista();
            vistaA.usuario.setText(enlanceLogin.areaNombre.getText());
            vistaA.setVisible(true);
            enlaceDinero.dispose();

        }

        if (enlaceDinero != null && e.getSource() == enlaceDinero.botonAceptar) {

            

    }


        if (enlaceVista != null && e.getSource() == enlaceVista.botonSoporte) {
            VistaSoporte enlaceSoporte = new VistaSoporte();
            enlaceSoporte.setVisible(true);
            enlaceVista.dispose();

        }
        if (enlaceSoporte != null && e.getSource() == enlaceSoporte.botonCancelar) {
            PrimeraVista vistaA = new PrimeraVista();
            vistaA.usuario.setText(enlanceLogin.areaNombre.getText());
            vistaA.setVisible(true);
            enlaceSoporte.dispose();

        }

        if (enlaceVista != null && e.getSource() == enlaceVista.botonNoticias) {

            Noticias noticias = new Noticias();
            noticias.setVisible(true);
            enlaceVista.dispose();

        }

        if (enlaceNoticias != null && e.getSource() == enlaceNoticias.botonVolver) {

            PrimeraVista primeraVista = new PrimeraVista();
            primeraVista.usuario.setText(enlanceLogin.areaNombre.getText());
            primeraVista.setVisible(true);
            enlaceNoticias.dispose();
        }

        if (enlacePedido != null && e.getSource() == enlacePedido.botonEnviar) {

            boolean entradaPromocion1 = enlacePedido.SuperRoma.isSelected();
            boolean entradaPromocion2 = enlacePedido.JamonQueso.isSelected();
            boolean entradaPromocion3 = enlacePedido.margarita.isSelected();
            String entradaNombre = enlacePedido.areaNombre.getText().trim();
            String entradaDirecion = enlacePedido.areaDireccion.getText().trim();
            String cantidadSeleccionda = (String) enlacePedido.cantidadPromo.getSelectedItem();
            String metodoPagoSeleccionado = (String) enlacePedido.tipoPago.getSelectedItem();

            if (entradaNombre.isEmpty() && entradaDirecion.isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Por favor, especifíca tu nombre y dirección para darnos nuestra mejor atención");
            } else {

                try {

                    if (enlacePedido.SuperRoma.isSelected()) {

                        String promocion1 = enlacePedido.SuperRoma.isSelected() ? PIZZA_SUPER_ROMA_₡12_500
                                : PIZZA_SUPER_ROMA_₡12_500;

                        GuardarPedido(promocion1, entradaNombre, entradaDirecion, metodoPagoSeleccionado,
                                cantidadSeleccionda);

                        JOptionPane.showMessageDialog(null, "Pedido realizado con éxito");

                    }

                } catch (Exception ex) {

                }
            }

        }

    }

    // Metodos para guardar elementos al arrayList
    public void GuardarAplicante(String cedula, String nombre, String correo, String postulacion, String provincia,
            int numero) {

        Main.listaAplicantes.add(new Aplicante(cedula, nombre, correo, postulacion, provincia, numero));
    }

    public void GuardarPedido(String promocion, String nombre, String direccion, String metodoPago,
            String cantidadSeleccionda) {

        Main.listaPedidos.add(new Pedido(promocion, nombre, direccion, metodoPago, cantidadSeleccionda));
    }
}
