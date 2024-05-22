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

        private JButton botonBilletera, botonRealizarPedido, botonSoporte, botonVerPedido, botonRegistroEmpleado, botoonApagar;
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
                botonBilletera.setBounds(400, 10, 50, 30);
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


                botonRealizarPedido = new JButton("Hacer pedido");
                botonRealizarPedido.setBounds(180, 240, 140, 30);
                botonRealizarPedido.addActionListener(this);
                botonRealizarPedido.setBackground(new Color(255, 255, 51));

                botonVerPedido = new JButton("Ver mis pedidos");
                botonVerPedido.setBounds(180, 300, 140, 30);
                botonVerPedido.addActionListener(this);
                botonVerPedido.setBackground(new Color(255, 255, 51));

                botonRegistroEmpleado = new JButton("Ser un Gladiador");
                botonRegistroEmpleado.setBounds(180, 360, 140, 30);
                botonRealizarPedido.addActionListener(this);
                botonRegistroEmpleado.setBackground(new Color(255, 255, 51));

                botonSoporte = new JButton("Soporte al cliente");
                botonSoporte.setBounds(180, 420, 140, 30);
                botonSoporte.addActionListener(this);
                botonSoporte.setBackground(new Color(255, 255, 51));


                // JLabel
                logo = new JLabel();
                logo.setBounds(150, 30, 200, 200);
                this.Pintar(this.logo, "Imagenes\\LogoBlanco.png");

                iconoUsuario = new JLabel();
               iconoUsuario.setBounds(10,5,35,35);
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
