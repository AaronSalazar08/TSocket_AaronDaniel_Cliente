package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class EstadoPedido extends JFrame {

    public JPanel panelEstadoPedido = new JPanel();
    public JButton botonConsultar, botonVolver;//JButtons para consultar pedido y regresar al menú principal 
    public JTextArea estadoPedido; //JTexArea para poder visualizar el estado del pedido del usario
    public JScrollPane scrollEstadoPedido;
    public JLabel numeroFacturaLabel, estadoPedidoLabel;
    public JTextField numeroFactura_txt;
    //Atributos para poder asignarle imagenes a las constantes 
    public ImageIcon imagen;
    public Icon icono;

    public EstadoPedido() {
        //Inicializando JPanel

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Estado de mi Pedido");
        setSize(400, 500);
        panelEstadoPedido.setBackground(new Color(255, 255, 255));
        setContentPane(panelEstadoPedido);
        panelEstadoPedido.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        Elementos();
    }

    //Metodo para poder inicializar e invocar las constantes 
    public void Elementos() {

        //Metodo para las funciones de los botones

        Metodos metodos = new Metodos(this);

        //Inicializar constantes 

        // JLabel
        numeroFacturaLabel = new JLabel("Número Factura: ");
        numeroFacturaLabel.setBounds(40, 30, 120, 30);
        Font fuente2 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        numeroFacturaLabel.setFont(fuente2);

        estadoPedidoLabel = new JLabel("Estado del Pedido: ");
        estadoPedidoLabel.setBounds(40, 100, 150, 30);
        Font fuente3 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        estadoPedidoLabel.setFont(fuente3);

        // JButton
        botonVolver = new JButton();
        botonVolver.setBounds(30, 400, 80, 40);
        botonVolver.addActionListener(metodos);
        botonVolver.setBackground(new Color(255, 255, 51));
        this.PintarB(this.botonVolver, "Imagenes\\deshacer (2).png");
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.setToolTipText("Volver al menú principal");

        botonConsultar = new JButton();
        botonConsultar.setBounds(240, 30, 60, 30);
        botonConsultar.addActionListener(metodos);
        botonConsultar.setBackground(new Color(237, 195, 0));
        ImageIcon iconoConsultar = new ImageIcon("Imagenes/busqueda.png");
        Image imagenConsultar = iconoConsultar.getImage();
        Image imagenConsultarAjustada = imagenConsultar.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoConsultarAjustada = new ImageIcon(imagenConsultarAjustada);
        botonConsultar.setIcon(iconoConsultarAjustada);
        botonConsultar.setBorderPainted(false);
        botonConsultar.setOpaque(false);
        botonConsultar.setToolTipText("Consultar el estado de mi pedido");

        // JTextField
        numeroFactura_txt = new JTextField();
        numeroFactura_txt.setBounds(160, 35, 60, 20);
        Font fuente4 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        numeroFactura_txt.setFont(fuente4);

        //JTextArea
       
        estadoPedido = new JTextArea();
        Font fuente5 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        estadoPedido.setFont(fuente5);
        estadoPedido.setEditable(false);

         // JScrollPane
        scrollEstadoPedido = new JScrollPane(estadoPedido);
        scrollEstadoPedido.setBounds(40, 150, 300, 200);
        scrollEstadoPedido.setToolTipText("Aquí tendrás toda la información que necesitas\n saber sobre el estado de tu pedido");
        scrollEstadoPedido.setBorder(BorderFactory.createCompoundBorder(scrollEstadoPedido.getBorder(),BorderFactory.createLineBorder(Color.BLACK, 5)));
        

        //Añadir elementos al panel

        panelEstadoPedido.add(numeroFacturaLabel);
        panelEstadoPedido.add(estadoPedidoLabel);
        panelEstadoPedido.add(botonVolver);
        panelEstadoPedido.add(numeroFactura_txt);
        panelEstadoPedido.add(botonConsultar);
        panelEstadoPedido.add(scrollEstadoPedido);

    }

    //Metodo para poner imagenes a JButton

    private void PintarB(JButton lbl, String ruta) { 
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();
    }

}
