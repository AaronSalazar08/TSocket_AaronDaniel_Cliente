package Vista;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.*;

public class RegistroAplicante extends JFrame {

    public JPanel panelRegistroAplicante = new JPanel();

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

    public void Elementos (){


    }

}
