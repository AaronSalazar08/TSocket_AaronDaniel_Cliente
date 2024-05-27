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

    public final String HOST = "192.168.86.55"; //Aqui se crea una constante donde se recibe la IP del servidor con el que se trabajara

    public final int PUERTO = 5000; //Se asigna un numero de puerto para lograr la conexion via socket
    DataInputStream in;//Declaracion de variable para recibir datos del cliente
    DataOutputStream out;//Declaracion de variable para enviar datos al cliente
    private Socket socket;//Declaracion de variable tipo Socket para controlar la conexion del Cliente al servidor

    ObjectOutputStream outObjeto;//Declaracion de variable para enviar Objetos del cliente
    ObjectInputStream inObjeto;//Declaracion de variable para recibir Objetos del cliente

    //Declaracion de clases JFrame
    private RegistroPedido enlacePedido;
    private RegistroInicio enlanceLogin;
    private PrimeraVista enlaceVista;
    private RegistroAplicante enlaceAplicante;
    private EstadoPedido enlaceEstadoPedido;
    private MisPedidos enlaceMisPedidos;
    private IngresoDinero enlaceDinero;
    private Noticias enlaceNoticias;
    private VistaSoporte enlaceSoporte;

    //Contructor de respectivas clases 
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

    // Metodos para pasar de ventana JFrame a otra
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


     //Metodo que le lanzara una pregunta al usuario, dependiendo de su respuesta, el programa terminara su ejecucion o permanecera en la misma
    public void CerrarPrograma() {

        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Deseas salir del Programa?", "confirmacion",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Saliendo del programa...");

            enlaceVista.dispose();
        }
    }

    //Mediante este metodo se registra el usuario
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

    //Metodo para cerrar sesion del usuario
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

    //Metodo para enviar pedido al servidor en donde se llama el metodo de EnviarPedido (mas adelante se detalla)
    public void EnviarPedidoServer() {

        boolean entradaPromocion1 = enlacePedido.SuperRoma.isSelected();
        boolean entradaPromocion2 = enlacePedido.JamonQueso.isSelected();
        boolean entradaPromocion3 = enlacePedido.margarita.isSelected();
        String entradaNombre = enlacePedido.areaNombre.getText().trim();
        String entradaDireccion = enlacePedido.areaDireccion.getText().trim();
        String cantidadSeleccionda = String.valueOf(enlacePedido.cantidadPromo.getSelectedItem());
        String metodoPagoSeleccionado = (String) enlacePedido.tipoPago.getSelectedItem();

        if (entradaNombre.isEmpty() && entradaDireccion.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, especifíca tu nombre y dirección para darnos nuestra mejor atención");
        } else if (!entradaNombre.isEmpty() && !entradaDireccion.isEmpty()) {

            try {

                if (entradaPromocion1) {
                    String promocion1 = "Pizza Super Roma - ₡12 500";
                    GuardarPedido(promocion1, entradaNombre, entradaDireccion, metodoPagoSeleccionado,
                            cantidadSeleccionda);
                    EnviarPedido();
                    JOptionPane.showMessageDialog(null, "Pedido realizado con éxito");
                   
                    enlaceVista.setVisible(true);
                    enlacePedido.setVisible(false);

                }

                // Puedes añadir más condiciones para las otras promociones
                if (entradaPromocion2) {
                    String promocion2 = "Pizza Clásica Italiana - ₡9 500"; // Ejemplo de otra promoción
                    GuardarPedido(promocion2, entradaNombre, entradaDireccion, metodoPagoSeleccionado,
                            cantidadSeleccionda);
                    EnviarPedido();
                    JOptionPane.showMessageDialog(null, "Pedido realizado con éxito");
                    enlaceVista.setVisible(true);
                    enlacePedido.setVisible(false);
                    

                }

                if (entradaPromocion3) {
                    String promocion3 = "Margarita por Venecia - ₡15 000"; // Ejemplo de otra promoción
                    GuardarPedido(promocion3, entradaNombre, entradaDireccion, metodoPagoSeleccionado,
                            cantidadSeleccionda);
                    EnviarPedido();
                    JOptionPane.showMessageDialog(null, "Pedido realizado con éxito");

                    enlaceVista.setVisible(true);
                    enlacePedido.setVisible(false);
                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }
    }

    //Metodo para enviar solicitud al servidor en donde se llama el metodo de EnviarAplicante (mas adelante se detalla)
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

    // Metodo para guardar elementos de los aplicantes al arrayList
    public void GuardarAplicante(String cedula, String nombre, String correo, String postulacion, String provincia,
            int numero) {

        Main.listaAplicantes.add(new Aplicante(cedula, nombre, correo, postulacion, provincia, numero));
    }

    //Metodo para guardar elementos de los pedidos al arrayList
    public void GuardarPedido(String promocion, String nombre, String direccion, String metodoPago,
            String cantidadSeleccionda) {

        Main.listaPedidos.add(new Pedido(promocion, nombre, direccion, metodoPago, cantidadSeleccionda));
    }

    //Metodo para mostrar el arrayList de pedidos en un JTextArea
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

    //Metodo para enviar pedido; se estima que al llamar este metodo, ya haya una conexion del socket con el servidor (mas adelante se detalla)
    public void EnviarPedido() {
        try {

            // Enviar el objeto
            outObjeto.writeObject(Main.listaPedidos);
            outObjeto.flush();

            // Recibir el objeto de respuesta
            Object objetoRecibido = inObjeto.readObject();

            if (objetoRecibido instanceof ArrayList<?>) {
                
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

//Metodo para enviar solicitud para aplicar a trabajar en Pizza Roma; se estima que al llamar este metodo, ya haya una conexion del socket con el servidor (mas adelante se detalla)
    public void EnviarAplicante() {

        try {

            // Enviar el objeto
            outObjeto.writeObject(Main.listaAplicantes);
            outObjeto.flush();

            // Recibir el objeto de respuesta
            Object objetoRecibido = inObjeto.readObject();

            if (objetoRecibido instanceof ArrayList<?>) {
                
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

    //Metodo para enviar un mensaje al servidor; se estima que al llamar este metodo, ya haya una conexion del socket con el servidor (mas adelante se detalla)
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

    //Metodo para recibir un mensaje del servidor
    //En este metodo se obtuvieron latencias ya que no se recibe el mensaje, por razones de que el servidor no logro enviar el mensaje correctamente; 
    //se estima que al llamar este metodo, ya haya una conexion del socket con el servidor (mas adelante se detalla)
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

    //Este metodo es el encargado de establecer la conexion de el Cliente al Servidor. Esto se controla llamando primero a este metodo y secuencialmente a los anteriores que dependan 
    //de una apertura de socket. 
    //Aqui se establece una conexion socket para el flujo de datos
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

    //Este metodo es el encargado de establecer la conexion de el Cliente al Servidor. Esto se controla llamando primero a este metodo y secuencialmente a los anteriores que dependan 
    //de una apertura de socket. 
    //Aqui se establece una conexion socket para el flujo de objetos
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

    //Este metodo desconecta la conexion del socket si este no es nulo y no ha sido cerrado
    //De igual forma se debera llamar a este metodo de manera ordenada, despues que el flujo de datos/objetos entre el cliente y el servidor hayan concluido exitosamente
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
