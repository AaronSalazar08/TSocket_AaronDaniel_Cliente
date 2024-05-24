package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class Noticias extends JFrame {

    public JPanel panelNoticias = new JPanel();
    public JButton botonVolver;
    public JTextArea noticias;
    public JScrollPane scrollNoticias;
    public JLabel noticiasLabel;
    public ImageIcon imagen;
    public Icon icono;
    Font fuente = new Font("Yu Mincho Demibold", Font.BOLD, 14);
    

    public Noticias () {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Noticias");
        setSize(500, 400);
        panelNoticias.setBackground(new Color(255, 255, 255));
        setContentPane(panelNoticias);
        panelNoticias.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
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
        noticiasLabel = new JLabel("Noticias Pizza Roma" );
        noticiasLabel.setBounds(40, 30, 150, 30);
        noticiasLabel.setFont(fuente);

        //JScrollPane
        noticias = new JTextArea();
        noticias.setEditable(false);
        JScrollPane scrollNoticias = new JScrollPane(noticias);
        scrollNoticias.setBounds(40, 70, 400, 200);
        scrollNoticias.setToolTipText("¡Conocé las últimas novedades de Pizza Roma!");
        scrollNoticias.setBorder(BorderFactory.createCompoundBorder(noticias.getBorder(),
                BorderFactory.createLineBorder(Color.BLACK, 5)));

        //Agregar Elementos al Panel
        panelNoticias.add(botonVolver);
        panelNoticias.add(noticiasLabel);
        panelNoticias.add(scrollNoticias);


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
