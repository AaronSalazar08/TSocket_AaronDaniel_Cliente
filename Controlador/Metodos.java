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
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
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

public class Metodos{

    public final String HOST = "192.168.86.55";

    public final int PUERTO = 5000;
    DataInputStream in;
    DataOutputStream out;
    private Socket socket;

    ObjectOutputStream outObjeto;
    ObjectInputStream inObjeto;

    private RegistroPedido enlacePedido;
    private RegistroInicio enlanceLogin;
    private PrimeraVista enlaceVista;
    private RegistroAplicante enlaceAplicante;
    private EstadoPedido enlaceEstadoPedido;
    private MisPedidos enlaceMisPedidos;
    private IngresoDinero enlaceDinero;
    private Noticias enlaceNoticias;
    private VistaSoporte enlaceSoporte;

    public Metodos(RegistroPedido enlacePedido, RegistroInicio enlanceLogin, PrimeraVista enlaceVista,
            RegistroAplicante enlaceAplicante, EstadoPedido enlaceEstadoPedido, MisPedidos enlaceMisPedidos,
            IngresoDinero enlaceDinero, Noticias enlaceNoticias, VistaSoporte enlaceSoporte) {
        this.enlacePedido = enlacePedido;
        this.enlanceLogin = enlanceLogin;
        this.enlaceVista = enlaceVista;
        this.enlaceAplicante = enlaceAplicante;
        this.enlaceEstadoPedido = enlaceEstadoPedido;
        this.enlaceMisPedidos = enlaceMisPedidos;
        this.enlaceDinero = enlaceDinero;
        this.enlaceNoticias = enlaceNoticias;
        this.enlaceSoporte = enlaceSoporte;
    }

    public void principalApedidos() {

        enlacePedido.setVisible(true);
        enlaceVista.setVisible(false);
    }

    public void pedidosAprincipal() {

        enlaceVista.setVisible(true);
        enlacePedido.setVisible(false);
    }

    public void principalAmispedidos() {

        enlaceMisPedidos.setVisible(true);
        enlaceVista.setVisible(false);
    }

    public void mispedidosAprincipal() {

        enlaceVista.setVisible(true);
        enlaceMisPedidos.setVisible(false);
    }

    public void principalAEstado() {

        enlaceVista.setVisible(false);
        enlaceEstadoPedido.setVisible(true);
    }

    public void estadoAprincipal() {

        enlaceEstadoPedido.setVisible(false);
        enlaceVista.setVisible(true);
    }

    public void principalAnoticias() {

        enlaceVista.setVisible(false);
        enlaceNoticias.setVisible(true);
    }

    public void noticiasAprincipal() {

        enlaceNoticias.setVisible(false);
        enlaceVista.setVisible(true);
    }

    public void principalAsolicitudes() {

        enlaceVista.setVisible(false);
        enlaceAplicante.setVisible(true);
    }

    public void solicitudesAprincipal() {

        enlaceAplicante.setVisible(false);
        enlaceVista.setVisible(true);
    }

    public void principalAbuzon() {

        
        enlaceSoporte.setVisible(true);
        enlaceVista.setVisible(false);
    }

    public void buzonAprincipal() {

        enlaceSoporte.setVisible(false);
        enlaceVista.setVisible(true);
    }

    public void principalAdinero() {

        enlaceVista.setVisible(false);
        enlaceDinero.setVisible(true);
    }

    public void dineroAprincipal() {

        enlaceDinero.setVisible(false);
        enlaceVista.setVisible(true);
    }

    public void CerrarPrograma() {

        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Deseas salir del Programa?", "confirmacion",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Saliendo del programa...");

            enlaceVista.dispose();
        }
    }

    public void loginAprincipal() {

        String nombre = enlanceLogin.areaNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese su nombre de Usuario");
        } else {

            JOptionPane.showMessageDialog(null, "Bienvenido " + enlanceLogin.areaNombre.getText());
            
           enlanceLogin.setVisible(false);
           enlaceVista.setVisible(true);
           enlaceVista.usuario.setText(nombre);
          

        }

    }

    public void CerrarSesion() {

        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Deseas cerrar sesión?", "confirmacion",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Cerrando Sesión...");
            enlanceLogin.setVisible(true);
            enlaceVista.dispose();
        }
    }

    public void EnviarPedidoServer() {
        try {
            boolean entradaPromocion1 = enlacePedido.SuperRoma.isSelected();
            boolean entradaPromocion2 = enlacePedido.JamonQueso.isSelected();
            boolean entradaPromocion3 = enlacePedido.margarita.isSelected();
            String entradaNombre = enlacePedido.areaNombre.getText().trim();
            String entradaDireccion = enlacePedido.areaDireccion.getText().trim();
            String cantidadSeleccionda = String.valueOf(enlacePedido.cantidadPromo.getSelectedItem());
            String metodoPagoSeleccionado = (String) enlacePedido.tipoPago.getSelectedItem();
    
            if (entradaNombre.isEmpty() || entradaDireccion.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Por favor, especifíca tu nombre y dirección para darnos nuestra mejor atención");
                return;
            }
    
            if (entradaPromocion1) {
                String promocion1 = "Pizza Super Roma - ₡12 500";
                GuardarPedido(promocion1, entradaNombre, entradaDireccion, metodoPagoSeleccionado,
                        cantidadSeleccionda);
            } else if (entradaPromocion2) {
                String promocion2 = "Pizza Clásica Italiana - ₡9 500";
                GuardarPedido(promocion2, entradaNombre, entradaDireccion, metodoPagoSeleccionado,
                        cantidadSeleccionda);
            } else if (entradaPromocion3) {
                String promocion3 = "Margarita por Venecia - ₡15 000";
                GuardarPedido(promocion3, entradaNombre, entradaDireccion, metodoPagoSeleccionado,
                        cantidadSeleccionda);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una promoción.");
                return;
            }
    
            EnviarPedido();
            JOptionPane.showMessageDialog(null, "Pedido realizado con éxito");
            enlaceVista.setVisible(true);
            enlacePedido.setVisible(false);
    
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al realizar el pedido: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public void EnviarAplicanteServer() {

        String entradaNombre = enlaceAplicante.nombre_txt.getText().trim();
        String entradaCedula = enlaceAplicante.cedula_txt.getText().trim();
        String entradaCorreo = enlaceAplicante.correo_txt.getText().trim();
        String entradaTelefono = enlaceAplicante.numero_txt.getText().trim();
        String puesto = String.valueOf(enlaceAplicante.puestoTrabajo.getSelectedItem());
        String provincia = String.valueOf(enlaceAplicante.provincia.getSelectedItem());

        if (entradaNombre.isEmpty() || entradaCedula.isEmpty() || entradaCorreo.isEmpty()
                || entradaTelefono.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, especifíca tus datos para poder atender tu solicitud de la mejor manera");
        } else if (!entradaNombre.isEmpty() && !entradaCedula.isEmpty() && !entradaCorreo.isEmpty()
                && !entradaTelefono.isEmpty()) {

            int telefono;
            try {

                telefono = Integer.parseInt(entradaTelefono);

                GuardarAplicante(entradaCedula, entradaNombre, entradaCorreo, puesto,
                        provincia, telefono);
                EnviarAplicante();
                JOptionPane.showMessageDialog(null, "Solicitud realizada con éxito");
                enlaceVista.setVisible(true);
                enlaceAplicante.setVisible(false);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null, "Numero invalido");

            }
        }
    }

    // MetodoS para guardar elementos al arrayList
    public void GuardarAplicante(String cedula, String nombre, String correo, String postulacion, String provincia,
            int numero) {

        Main.listaAplicantes.add(new Aplicante(cedula, nombre, correo, postulacion, provincia, numero));
    }

    public void GuardarPedido(String promocion, String nombre, String direccion, String metodoPago,
            String cantidadSeleccionda) {

        Main.listaPedidos.add(new Pedido(promocion, nombre, direccion, metodoPago, cantidadSeleccionda));
    }

    public void MostrarPedidos() {

        for (int contador = 0; contador < Main.listaPedidos.size(); contador++) {

            Pedido pedidos = Main.listaPedidos.get(contador);

            enlaceMisPedidos.misPedidos.append("\nNombre: " + pedidos.getNombre() + "\n");
            enlaceMisPedidos.misPedidos.append("Promocion: " + pedidos.getPromocion() + "\n");
            enlaceMisPedidos.misPedidos.append("Cantidad: " + pedidos.getCantidadPromocon() + "\n");
            enlaceMisPedidos.misPedidos.append("Metodo de Pago: " + pedidos.getMetodoPago() + "\n");
            enlaceMisPedidos.misPedidos.append("Direccion: " + pedidos.getDireccion() + "\n"
                    + "---------------------------------------------------------------------------------\n");

        }
    }

    public void EnviarPedido() {
        try  {

            // Enviar el objeto
            outObjeto.writeObject(Main.listaPedidos);
            outObjeto.flush();

            // Recibir el objeto de respuesta
            Object objetoRecibido = inObjeto.readObject();

            if (objetoRecibido instanceof ArrayList<?>) {
                // Muestra un JOptionPane con el contenido del ArrayList
                ArrayList<Pedido> listaPedidosRecibidos = (ArrayList<Pedido>) objetoRecibido;
                StringBuilder mensaje = new StringBuilder("Pedidos recibidos:\n");
                for (Pedido pedido : listaPedidosRecibidos) {
                    mensaje.append(pedido.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString(), "Pedidos Recibidos",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Si el objeto no es un ArrayList<Pedido>, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "El objeto recibido no es un ArrayList<Pedido>", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: Host desconocido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada/salida durante la comunicación con el servidor.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el objeto recibido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void EnviarAplicante() {

        try  {

            // Enviar el objeto
            outObjeto.writeObject(Main.listaAplicantes);
            outObjeto.flush();

            // Recibir el objeto de respuesta
            Object objetoRecibido = inObjeto.readObject();

            if (objetoRecibido instanceof ArrayList<?>) {
                // Muestra un JOptionPane con el contenido del ArrayList
                ArrayList<Aplicante> listaAplicantes = (ArrayList<Aplicante>) objetoRecibido;
                StringBuilder mensaje = new StringBuilder("Aplicante recibidos:\n");
                for (Aplicante aplicante : listaAplicantes) {
                    mensaje.append(aplicante.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString(), "Pedidos Recibidos",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Si el objeto no es un ArrayList<Pedido>, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "El objeto recibido no es un ArrayList<Pedido>", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: Host desconocido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada/salida durante la comunicación con el servidor.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el objeto recibido.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    public void enviarMensaje() {
        try {
            if (socket != null && !socket.isClosed()) {
                String mensaje = enlaceSoporte.areaReporte.getText();
                out.writeUTF(mensaje);
                JOptionPane.showMessageDialog(null, "Mensaje enviado");
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexión establecida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada/salida durante el envío del mensaje.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void recibirMensaje() {
        try {
            if (socket != null && !socket.isClosed()) {
                String mensajeRecibido = in.readUTF();
                enlaceSoporte.areaRespuesta.append(mensajeRecibido);
            } else {
                JOptionPane.showMessageDialog(null, "No hay conexión establecida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada/salida durante la recepción del mensaje.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void conectarData() {
        if (socket == null || socket.isClosed()) { // Verificar si el socket no existe o está cerrado
            try {
                socket = new Socket(HOST, PUERTO);
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
                

                JOptionPane.showMessageDialog(null, "Cliente conectado con el Servidor");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El cliente ya está conectado con el servidor.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void conectarObject() {
        if (socket == null || socket.isClosed()) { // Verificar si el socket no existe o está cerrado
            try {
                socket = new Socket(HOST, PUERTO);
                outObjeto = new ObjectOutputStream(socket.getOutputStream());
                inObjeto = new ObjectInputStream(socket.getInputStream());
                

                JOptionPane.showMessageDialog(null, "Cliente conectado con el Servidor");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El cliente ya está conectado con el servidor.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void desconectar() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                JOptionPane.showMessageDialog(null, "Cliente desconcectado del servidor");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
