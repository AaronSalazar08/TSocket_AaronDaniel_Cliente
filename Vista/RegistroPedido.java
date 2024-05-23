package Vista;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controlador.Metodos;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Image;

public class RegistroPedido extends JFrame implements ActionListener {

    public JTextField areaNombre, areaDireccion;
    public JComboBox tipoPago, tipoPromocion, cantidadPromo;
    public JButton botonEnviar, botonCancelar;
    public JRadioButton SuperRoma, JamonQueso, margarita;
    public JLabel labelNombre, labelDireccion, labelPago, labelPromo, labelCantidad, imagenRoma, imagenJamon,imagenMargarita;
    private ImageIcon imagen;
    private Icon icono;

    public JPanel panelPedido = new JPanel();

    public RegistroPedido() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Registro de Pedido");
        setSize(600, 600);
        panelPedido.setBackground(new Color(255, 255, 255));
        setContentPane(panelPedido);
        panelPedido.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        Elementos();

    }

    public void Elementos() {
        // Llamada del metodo
        Metodos metodos = new Metodos(this);

        // JRadioButton
        SuperRoma = new JRadioButton("Pizza Super Roma - ₡12 500");
        SuperRoma.setBackground(new Color(255, 255, 255));
        SuperRoma.setBounds(30, 70, 230, 40);
        

        JamonQueso = new JRadioButton("Pizza Clásica Italiana - ₡9 500");
        JamonQueso.setBackground(new Color(255, 255, 255));
        JamonQueso.setBounds(30, 160, 230, 40);

        margarita = new JRadioButton("Margarita por Venecia - ₡15 000");
        margarita.setBounds(30, 250, 230, 40);
        margarita.setBackground(new Color(255, 255, 255));

        // JComboBox

        cantidadPromo = new JComboBox();
        cantidadPromo.addItem(1);
        cantidadPromo.addItem(2);
        cantidadPromo.addItem(3);
        cantidadPromo.setBounds(35, 370, 70, 30);

        tipoPago = new JComboBox();
        tipoPago.addItem("Efectivo");
        tipoPago.addItem("Tarjeta");
        tipoPago.setBounds(405, 270, 100, 30);

        // JLabel

        imagenRoma = new JLabel();
        imagenRoma.setBounds(260, 45, 80, 80);
        this.Pintar(this.imagenRoma, "Imagenes\\PizzaRomaPromo1.png");
        imagenRoma.setToolTipText("Deliciosa Pizza Grande a la Roma de 16 pedazos acompañada con: \n" + "-2 Refrescos \n" +  "-Porcion de pan de ajo (4 rebanadas) ");

        imagenJamon = new JLabel();
        imagenJamon.setBounds(260,130, 80, 80);
        this.Pintar(this.imagenJamon, "Imagenes\\ClasicaItalianaPromo2.png");
        imagenJamon.setToolTipText("Pizza Clásica Pequeña de jamón y queso de 8 pedazos acompañada por: -2 Refrescos -Spagetti con albónigas  ");

        imagenMargarita = new JLabel();
        imagenMargarita.setBounds(260,220, 80, 80);
        this.Pintar(this.imagenMargarita, "Imagenes\\MargaritaPorVeneciaPromo3.png");
        imagenMargarita.setToolTipText("Exquisita Pizza Margartita Mediana con 12 pedazos acompañada por: -2 Margaritas -Postre según la cocina del Chef ");


        labelCantidad = new JLabel("Cantidad de promoción:");
        labelCantidad.setBounds(30, 300, 170, 70);
        Font fuente6 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        labelCantidad.setFont(fuente6);
        labelCantidad.setForeground(new Color(237, 195,0));

        labelPago = new JLabel("Metodo de pago:");
        labelPago.setBounds(405, 215, 150, 70);
        Font fuente7 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        labelPago.setFont(fuente7);
        labelPago.setForeground(new Color(237, 195,0));




        labelPromo = new JLabel("Promociones:");
        labelPromo.setBounds(30, 0, 100, 70);
        Font fuente1 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        labelPromo.setFont(fuente1);
        labelPromo.setForeground(new Color(237, 195,0));

        labelNombre = new JLabel("Nombre:");
        labelNombre.setBounds(405, 15, 100, 70);
        Font fuente2 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        labelNombre.setFont(fuente2);
        labelNombre.setForeground(new Color(237, 195, 0));

        labelDireccion = new JLabel("Dirección");
        labelDireccion.setBounds(405, 120, 70, 70);
        Font fuente3 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        labelDireccion.setFont(fuente3);
        labelDireccion.setForeground(new Color(237, 195, 0));

        

        // JTexfield
        areaNombre = new JTextField();
        areaNombre.setBounds(405, 75, 90, 20);

        areaDireccion = new JTextField();
        areaDireccion.setBounds(405, 180, 170, 20);

        
        // JButton

        botonCancelar = new JButton("cancelar");
        botonCancelar.setBounds(30, 490, 80, 30);
        botonCancelar.addActionListener(metodos);
        botonCancelar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonCancelar, "Imagenes\\deshacer (2).png");
        botonCancelar.setBorderPainted(false);
        botonCancelar.setOpaque(false);


        botonEnviar = new JButton("enviar");
        botonEnviar.setBounds(475, 490, 80, 30);
        botonEnviar.addActionListener(metodos);
        botonEnviar.setBackground(new Color(255, 255, 255));
        this.PintarB(this.botonEnviar, "Imagenes\\avion-de-papel (1).png");
        botonEnviar.setBorderPainted(false);
        botonEnviar.setOpaque(false);

        

        // Agregar elementos al panel

        panelPedido.add(botonEnviar);
         panelPedido.add(labelNombre);
         panelPedido.add(areaNombre);
        panelPedido.add(labelDireccion);
        panelPedido.add(SuperRoma);
        panelPedido.add(JamonQueso);
        panelPedido.add(areaDireccion);
        panelPedido.add(margarita);
        panelPedido.add(tipoPago);
        panelPedido.add(cantidadPromo);
        panelPedido.add(labelPromo);
        panelPedido.add(labelCantidad);
        panelPedido.add(labelPago);
        panelPedido.add(botonCancelar);
        panelPedido.add(imagenRoma);
        panelPedido.add(imagenJamon);
        panelPedido.add(imagenMargarita);

    }

    public void actionPerformed(ActionEvent e) {

    }

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
    }// Fin del meto
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

}
