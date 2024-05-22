package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraVista extends JFrame implements ActionListener {

        private JButton botonBilletera, botonRealizarPedido, botonSoporte, botonVerPedido, botonRegistroEmpleado,
                        botoonApagar;
        public JPanel panelOpciones = new JPanel();
        private ImageIcon imagen;
        private Icon icono;
        public JLabel logo, iconoUsuario, usuario;

        public PrimeraVista() {
                this.setTitle("Pizza Roma - Menú Principal");
                this.setSize(500, 530);
                panelOpciones.setBackground(new Color(255, 255, 255));
                this.setContentPane(panelOpciones);
                this.setLocationRelativeTo(null);
                this.setLayout(null);

                Elementos();
        }

        public void Elementos() {
                // Inicializar constantes

                botonBilletera = new JButton("Billetera");
                botonBilletera.setBounds(400, 10, 80, 40);
                botonBilletera.addActionListener(this);
                botonBilletera.setBackground(new Color(255, 255, 255));
                this.PintarB(this.botonBilletera, "Imagenes\\flecha-de-billetera.png");
                botonBilletera.setBorderPainted(false);
                botonBilletera.setOpaque(false);

                botoonApagar = new JButton("Apagar");
                botoonApagar.setBounds(430, 440, 50, 30);
                botoonApagar.addActionListener(this);
                botoonApagar.setBackground(new Color(255, 255, 255));
                this.PintarB(this.botoonApagar, "Imagenes\\apagar.png");
                botoonApagar.setBorderPainted(false);
                botoonApagar.setOpaque(false);

                botonRealizarPedido = new JButton("Hacer Pedido");
                botonRealizarPedido.setBounds(170, 240, 160, 30);
                botonRealizarPedido.setBackground(new Color(255, 255, 51));
                ImageIcon iconoRealizarPedido = new ImageIcon("Imagenes/porcion-de-pizza.png");
                Image imagenRealizarPedido = iconoRealizarPedido.getImage();
                Image imagenRealizarPedidoAjustada = imagenRealizarPedido.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
                ImageIcon iconoRealizarPedidoAjustada = new ImageIcon(imagenRealizarPedidoAjustada);
                botonRealizarPedido.setIcon(iconoRealizarPedidoAjustada);
                //botonRealizarPedido.addActionListener(metodos);
                botonRealizarPedido.setBorderPainted(false);

                botonVerPedido = new JButton("Mis Pedidos");
                botonVerPedido.setBounds(170, 300, 160, 30);
                botonVerPedido.setBackground(new Color(255, 255, 51));
                ImageIcon iconoVerPedido = new ImageIcon("Imagenes/verPedido (1).png");
                Image imagenVerPedido = iconoVerPedido.getImage();
                Image imagenVerPedidoAjustada = imagenVerPedido.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
                ImageIcon iconoVerPedidoAjustada = new ImageIcon(imagenVerPedidoAjustada);
                botonVerPedido.setIcon(iconoVerPedidoAjustada);
                //botonRealizarPedido.addActionListener(metodos);
                botonVerPedido.setBorderPainted(false);

                botonRegistroEmpleado = new JButton("Ser Gladiador");
                botonRegistroEmpleado.setBounds(170, 360, 160, 30);
                botonRegistroEmpleado.setBackground(new Color(255, 255, 51));
                ImageIcon iconoEmpleado = new ImageIcon("Imagenes/casco-griego.png");
                Image imagenEmpleado = iconoEmpleado.getImage();
                Image imagenEmpleadoAjustada = imagenEmpleado.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
                ImageIcon iconoEmpleadoAjustada = new ImageIcon(imagenEmpleadoAjustada);
                botonRegistroEmpleado.setIcon(iconoEmpleadoAjustada);
                //botonRealizarPedido.addActionListener(metodos);
                botonRegistroEmpleado.setBorderPainted(false);

                botonSoporte = new JButton("   Soporte     ");
                botonSoporte.setBounds(170, 420, 160, 30);
                botonSoporte.setBackground(new Color(255, 255, 51));
                ImageIcon iconoSoporte = new ImageIcon("Imagenes/servicio-al-cliente.png");
                Image imagenSoporte = iconoSoporte.getImage();
                Image imagenSoporteAjustada = imagenSoporte.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
                ImageIcon iconoSoporteAjustada = new ImageIcon(imagenSoporteAjustada);
                botonSoporte.setIcon(iconoSoporteAjustada);
                //botonRealizarPedido.addActionListener(metodos);
                botonSoporte.setBorderPainted(false);

                // JLabel
                logo = new JLabel();
                logo.setBounds(150, 30, 200, 200);
                this.Pintar(this.logo, "Imagenes\\LogoBlanco.png");

                iconoUsuario = new JLabel();
                iconoUsuario.setBounds(10, 5, 35, 35);
                this.Pintar(this.iconoUsuario, "Imagenes\\gente-pic.png");

                // Agregar elementos al panel
                panelOpciones.add(botonBilletera);
                panelOpciones.add(logo);
                panelOpciones.add(botonRealizarPedido);
                panelOpciones.add(botonVerPedido);
                panelOpciones.add(botonRegistroEmpleado);
                panelOpciones.add(botonSoporte);
                panelOpciones.add(iconoUsuario);
                panelOpciones.add(botoonApagar);
        }

        public void actionPerformed(ActionEvent e) {

        }

        private void Pintar(JLabel lbl, String ruta) { // Este metodo se utiliza para ponerle imagenes de fondo a los
                                                       // Labels
                this.imagen = new ImageIcon(ruta);
                this.icono = new ImageIcon(
                                this.imagen.getImage().getScaledInstance(
                                                lbl.getWidth(),
                                                lbl.getHeight(),
                                                Image.SCALE_DEFAULT));
                lbl.setIcon(this.icono);
                this.repaint();
        }// Fin del metodo Pintar

        private void PintarB(JButton lbl, String ruta) { // Este metodo se utiliza para ponerle imagenes de fondo a los
                                                         // Labels
                this.imagen = new ImageIcon(ruta);
                this.icono = new ImageIcon(
                                this.imagen.getImage().getScaledInstance(
                                                lbl.getWidth(),
                                                lbl.getHeight(),
                                                Image.SCALE_DEFAULT));
                lbl.setIcon(this.icono);
                this.repaint();
        }// Fin del metodo Pintar

}
