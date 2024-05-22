package Vista;

import Controlador.Metodos;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;

public class RegistroAplicante extends JFrame {

    public JPanel panelRegistroAplicante = new JPanel();
    public JLabel nombreLabel, cedulaLabel, puestoLabel, residenciaLabel, motivoTrabajoLabel;
    public JButton botonEnviar, botonVolver;
    public JTextField nombre_txt, cedula_txt, residencia_txt;
    public JComboBox puestoTrabajo;
    public JTextArea motivoTrabajo_txt;
    public ImageIcon imagen;
    public Icon icono;

    public RegistroAplicante() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pizza Roma - Registrarme como trabajador");
        setSize(600, 600);
        panelRegistroAplicante.setBackground(new Color(255, 255, 255));
        setContentPane(panelRegistroAplicante);
        setLocationRelativeTo(null);
        setLayout(null);

        Elementos();

    }

    public void Elementos() {

        Metodos metodos = new Metodos(this);

        botonVolver = new JButton();
        botonVolver.setBounds(30, 500, 80, 40);
        botonVolver.addActionListener(metodos);
        botonVolver.setBackground(new Color(255, 255, 51));
        this.PintarB(this.botonVolver, "Imagenes\\deshacer (2).png");
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);

        botonEnviar = new JButton();
        botonEnviar.setBounds(400, 400, 80, 40);
        botonEnviar.addActionListener(metodos);
        botonEnviar.setBackground(new Color(255, 255, 51));
        this.PintarB(this.botonEnviar, "Imagenes\\avion-de-papel (1).png");
        botonEnviar.setBorderPainted(false);
        botonEnviar.setOpaque(false);

        panelRegistroAplicante.add(botonVolver);
        panelRegistroAplicante.add(botonEnviar);

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
