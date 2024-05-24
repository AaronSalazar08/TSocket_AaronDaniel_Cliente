package Vista;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controlador.Metodos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Image;

public class VistaSoporte extends JFrame {

    JPanel panelSoporte = new JPanel();
    JLabel titulo, indicacion, respuesta;
    public JButton botonCancelar, botonAceptar;
    public JTextArea areaReporte, areaRespuesta;
    private ImageIcon imagen;
    private Icon icono;

    public VistaSoporte() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Menú Principal");
        setSize(500, 530);
        panelSoporte.setBackground(new Color(255, 255, 255));
        setContentPane(panelSoporte);
        panelSoporte.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        Elementos();

    }

    public void Elementos() {

        // Llamada al metodo
        Metodos metodos = new Metodos(this);

        // Inicializar variables

        // JLabel
        titulo = new JLabel("Soporte:");
        titulo.setBounds(10, 5, 120, 30);
        Font fuente1 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        titulo.setFont(fuente1);
        titulo.setForeground(new Color(237, 195, 0));

        indicacion = new JLabel("¿Escribe como podemos ayudarte?");
        indicacion.setBounds(20, 20, 300, 70);
        Font fuente3 = new Font("Yu Mincho Demibold", Font.BOLD, 12);
        indicacion.setFont(fuente3);
        indicacion.setForeground(new Color(0, 0, 0));

        respuesta = new JLabel("Respuesta:");
        respuesta.setBounds(60, 230, 300, 70);
        Font fuente4 = new Font("Yu Mincho Demibold", Font.BOLD, 12);
        respuesta.setFont(fuente4);
        respuesta.setForeground(new Color(0, 0, 0));

        // JTexArea
        areaReporte = new JTextArea();
        areaReporte.setBounds(60, 80, 375, 150);
        areaReporte.setBorder(BorderFactory.createLineBorder(new Color(237, 195, 0), 4));

        areaRespuesta = new JTextArea();
        areaRespuesta.setBounds(60, 280, 375, 150);
        areaRespuesta.setBorder(BorderFactory.createLineBorder(new Color(237, 195, 0), 4));
        areaRespuesta.setEditable(false);

        // Jbutton
        botonCancelar = new JButton("atras");
        botonCancelar.setBounds(20, 440, 40, 30);
        botonCancelar.addActionListener(metodos);
        botonCancelar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonCancelar, "Imagenes\\deshacer (2).png");
        botonCancelar.setBorderPainted(false);
        botonCancelar.setOpaque(false);

        botonAceptar = new JButton("Depositar");
        botonAceptar.setBounds(430, 440, 40, 30);
        // botonCancelar.addActionListener(metodos);
        botonAceptar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonAceptar, "Imagenes\\avion-de-papel (1).png");
        botonAceptar.setBorderPainted(false);
        botonAceptar.setOpaque(false);

        // Añadir elementos al panel

        panelSoporte.add(indicacion);
        panelSoporte.add(titulo);
        panelSoporte.add(areaReporte);
        panelSoporte.add(areaRespuesta);
        panelSoporte.add(respuesta);
        panelSoporte.add(botonCancelar);
        panelSoporte.add(botonAceptar);

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
    }// Fin del metodo

}
