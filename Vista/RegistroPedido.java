package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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


public class RegistroPedido extends JFrame implements ActionListener {

    public JTextField areaNombre;
    public JButton botonEnviar;

    public JPanel panelPedido = new JPanel();

    public RegistroPedido() {

        this.setTitle("Pizza Roma - Registro de Pedido");
        this.setSize(600, 600);
        panelPedido.setBackground(new Color(255, 255, 255));
        this.setContentPane(panelPedido);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        Elementos();

    }

    public void Elementos() {
        Metodos metodos = new Metodos(this);

        areaNombre = new JTextField();
        areaNombre.setBounds(150, 200, 90, 30);

        botonEnviar = new JButton("enviar");
        botonEnviar.setBounds(150, 240, 60, 30);

        botonEnviar.addActionListener(metodos);

        panelPedido.add(botonEnviar);
        panelPedido.add(areaNombre);

    }


    public void actionPerformed(ActionEvent e) {

        




    }

}
