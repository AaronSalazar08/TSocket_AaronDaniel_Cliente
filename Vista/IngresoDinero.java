package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.Metodos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.Icon;

public class IngresoDinero extends JFrame implements ActionListener {

    public JPanel panelDinero = new JPanel();

    public JButton botonCancelar, botonAceptar;// JButtons para regresar al menu prinicpal y aceptar acción
    JLabel indicacionDinero, indicacionTarjeta, titulo, colon;
    public JTextField areaDinero; // JTexfield para ingresar el dinero a tener
    public JTextField areaTarjeta; // JTexfield para ingresar la tarjeta a utilizar
    // Atributos para poner imagines a constantes
    private ImageIcon imagen;
    private Icon icono;

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    // Metodo Constructor
    public IngresoDinero() {

        setTitle("Pizza Roma - Ingreso de Dinero");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(410, 400);
        panelDinero.setBackground(new Color(255, 255, 255));
        setContentPane(panelDinero);
        setLocationRelativeTo(null);
        setLayout(null);

        // JLabel
        titulo = new JLabel("Billetera Digital:");
        titulo.setBounds(10, 0, 120, 30);
        Font fuente1 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        titulo.setFont(fuente1);
        titulo.setForeground(new Color(237, 195, 0));

        indicacionDinero = new JLabel("Dinero a depositar");
        indicacionDinero.setBounds(145, 125, 200, 70);
        Font fuente3 = new Font("Yu Mincho Demibold", Font.BOLD, 12);
        indicacionDinero.setFont(fuente3);
        indicacionDinero.setForeground(new Color(0, 0, 0));

        indicacionTarjeta = new JLabel("Número de tarjeta a registrar");
        indicacionTarjeta.setBounds(125, 20, 190, 70);
        Font fuente2 = new Font("Yu Mincho Demibold", Font.BOLD, 12);
        indicacionTarjeta.setFont(fuente2);
        indicacionTarjeta.setForeground(new Color(0, 0, 0));

        // JButton

        botonCancelar = new JButton();
        botonCancelar.setBounds(30, 305, 50, 30);
        botonCancelar.addActionListener(this);
        botonCancelar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonCancelar, "Imagenes\\deshacer (2).png");
        botonCancelar.setBorderPainted(false);
        botonCancelar.setOpaque(false);
        botonCancelar.setToolTipText("Volve al Menú Principal");

        botonAceptar = new JButton();
        botonAceptar.setBounds(305, 305, 50, 30);
        botonCancelar.addActionListener(this);
        botonAceptar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonAceptar, "Imagenes\\billetera.png");
        botonAceptar.setBorderPainted(false);
        botonAceptar.setOpaque(false);
        botonAceptar.setToolTipText("Depositas Dinero a la tarjeta virtual");

        // JTexfield

        areaDinero = new JTextField();
        areaDinero.setBounds(155, 194, 90, 20);
        areaDinero.setToolTipText("Especifíque la cantidad de Dinero que desea agregar en Colones");

        colon = new JLabel();
        colon.setBounds(130, 194, 20, 20);
        this.Pintar(this.colon, "Imagenes\\signo-de-colon.png");

        areaTarjeta = new JTextField();
        areaTarjeta.setBounds(140, 84, 130, 20);
        areaTarjeta.setToolTipText("Digite el número de su tarjeta");

        // añadir Costantes al panel

        panelDinero.add(indicacionDinero);
        panelDinero.add(indicacionTarjeta);
        panelDinero.add(areaDinero);
        panelDinero.add(titulo);
        panelDinero.add(areaTarjeta);
        panelDinero.add(botonCancelar);
        panelDinero.add(botonAceptar);
        panelDinero.add(colon);

    }

    // Metodo para poner imagines a JButtons

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

    // Metodo para poner imagines a JLabel

    private void Pintar(JLabel lbl, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonCancelar) {

            metodos.dineroAprincipal();
        }
    }

}
