package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.Metodos;

public class MisPedidos extends JFrame implements ActionListener {

    public JPanel panelMisPedidos = new JPanel();
    public JButton botonVolver, botonMostrar;
    public JTextArea misPedidos;
    public JScrollPane scrollMisPedidos;
    public JLabel listaPedidosLabel;
    public ImageIcon imagen;
    public Icon icono;
    Font fuente = new Font("Yu Mincho Demibold", Font.BOLD, 14);

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    

    public MisPedidos() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Mis Pedidos");
        setSize(500, 400);
        panelMisPedidos.setBackground(new Color(255, 255, 255));
        setContentPane(panelMisPedidos);
        panelMisPedidos.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);

     
       

        // JButton
        botonVolver = new JButton();
        botonVolver.setBounds(40, 300, 60, 30);
        botonVolver.addActionListener(this);
        botonVolver.setBackground(new Color(237, 195, 0));
        this.PintarB(this.botonVolver, "Imagenes\\deshacer (2).png");
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.setToolTipText("Volver al menú principal");

        botonMostrar = new JButton();
        botonMostrar.setBounds(350, 300, 60, 30);
        botonMostrar.addActionListener(this);
        botonMostrar.setBackground(new Color(237, 195, 0));
        this.PintarB(this.botonMostrar, "Imagenes\\mostrar.png");
         botonMostrar.setBorderPainted(false);
        botonMostrar.setOpaque(false);
        botonMostrar.setToolTipText("Mostrar Datos");

        //JLabel
        listaPedidosLabel = new JLabel("Lista de Mis Pedidos: ");
        listaPedidosLabel.setBounds(40, 30, 150, 30);
        listaPedidosLabel.setFont(fuente);

        //JScrollPane
        misPedidos = new JTextArea();
        misPedidos.setEditable(false);
       scrollMisPedidos = new JScrollPane(misPedidos);
       scrollMisPedidos.setBounds(40, 70, 400, 200);
       scrollMisPedidos.setToolTipText("Aquí aparecerán tus pedidos que has ordenado con nosotros");
       scrollMisPedidos.setBorder(BorderFactory.createCompoundBorder(scrollMisPedidos.getBorder(),
                BorderFactory.createLineBorder(Color.BLACK, 5)));

        //Agregar Elementos al Panel
        panelMisPedidos.add(botonVolver);
        panelMisPedidos.add(listaPedidosLabel);
        panelMisPedidos.add(scrollMisPedidos);
        panelMisPedidos.add(botonMostrar);


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
        metodos.mispedidosAprincipal();
        
       }
    }

}
