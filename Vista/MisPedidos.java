package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class MisPedidos extends JFrame {

    public JPanel panelMisPedidos = new JPanel();
    public JButton botonVolver;
    public JTextArea misPedidos;
    public JScrollPane scrollMisPedidos;
    public JLabel listaPedidosLabel;
    public ImageIcon imagen;
    public Icon icono;
    Font fuente = new Font("Yu Mincho Demibold", Font.BOLD, 14);
    

    public MisPedidos() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Mis Pedidos");
        setSize(500, 400);
        panelMisPedidos.setBackground(new Color(255, 255, 255));
        setContentPane(panelMisPedidos);
        panelMisPedidos.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        Elementos();
    }

    public void Elementos() {

        Metodos metodos = new Metodos (this);

        // JButton
        botonVolver = new JButton();
        botonVolver.setBounds(40, 300, 60, 30);
        botonVolver.addActionListener(metodos);
        botonVolver.setBackground(new Color(237, 195, 0));
        this.PintarB(this.botonVolver, "Imagenes\\deshacer (2).png");
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.setToolTipText("Volver al menú principal");

        //JLabel
        listaPedidosLabel = new JLabel("Lista de Mis Pedidos: ");
        listaPedidosLabel.setBounds(40, 30, 150, 30);
        listaPedidosLabel.setFont(fuente);

        //JScrollPane
        misPedidos = new JTextArea();
        misPedidos.setEditable(false);
        JScrollPane scrollMisPedidos = new JScrollPane(misPedidos);
        scrollMisPedidos.setBounds(40, 70, 400, 200);
        scrollMisPedidos.setToolTipText("Aquí aparecerán tus pedidos que has ordenado con nosotros");
        scrollMisPedidos.setBorder(BorderFactory.createCompoundBorder(misPedidos.getBorder(),
                BorderFactory.createLineBorder(Color.BLACK, 5)));

        //Agregar Elementos al Panel
        panelMisPedidos.add(botonVolver);
        panelMisPedidos.add(listaPedidosLabel);
        panelMisPedidos.add(scrollMisPedidos);


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

}