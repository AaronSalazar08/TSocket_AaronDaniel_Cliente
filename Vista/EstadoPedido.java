package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.Metodos;

public class EstadoPedido extends JFrame implements ActionListener {

    public JPanel panelEstadoPedido = new JPanel();
    public JButton botonConsultar, botonVolver;
    public JTextArea estadoPedido;
    public JScrollPane scrollEstadoPedido;
    public JLabel numeroFacturaLabel, estadoPedidoLabel;
    public JTextField numeroFactura_txt;
    public ImageIcon imagen;
    public Icon icono;

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;


    public EstadoPedido() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Estado de mi Pedido");
        setSize(400, 500);
        panelEstadoPedido.setBackground(new Color(255, 255, 255));
        setContentPane(panelEstadoPedido);
        panelEstadoPedido.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);


        

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
        botonVolver.addActionListener(this);
        botonVolver.setBackground(new Color(255, 255, 51));
        this.PintarB(this.botonVolver, "Imagenes\\deshacer (2).png");
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.setToolTipText("Volver al menú principal");

        botonConsultar = new JButton();
        botonConsultar.setBounds(240, 30, 60, 30);
        botonConsultar.addActionListener(this);
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

        // JScrollPane
        estadoPedido = new JTextArea();
        Font fuente5 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        estadoPedido.setFont(fuente5);
        estadoPedido.setEditable(false);
        scrollEstadoPedido = new JScrollPane(estadoPedido);
        scrollEstadoPedido.setBounds(40, 150, 300, 200);
        scrollEstadoPedido.setToolTipText("Aquí tendrás toda la información que necesitas\n saber sobre el estado de tu pedido");
        scrollEstadoPedido.setBorder(BorderFactory.createCompoundBorder(scrollEstadoPedido.getBorder(),BorderFactory.createLineBorder(Color.BLACK, 5)));
        

        panelEstadoPedido.add(numeroFacturaLabel);
        panelEstadoPedido.add(estadoPedidoLabel);
        panelEstadoPedido.add(botonVolver);
        panelEstadoPedido.add(numeroFactura_txt);
        panelEstadoPedido.add(botonConsultar);
        panelEstadoPedido.add(scrollEstadoPedido);

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
    }// Fin del metodo Pintar

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == botonVolver){

            metodos.estadoAprincipal();
        }
    }

}
