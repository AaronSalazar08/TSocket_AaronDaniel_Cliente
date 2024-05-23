package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Metodos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Image;
import javax.swing.Icon;


public class IngresoDinero extends JFrame {


    public JPanel panelDinero = new JPanel();
   public JButton botonCancelar, botonAceptar;
    JLabel indicacionDinero, indicacionTarjeta, titulo ;
    public JTextField areaDinero, areaTarjeta;
    private ImageIcon imagen;
    private Icon icono;



    public IngresoDinero() {
        setTitle("Pizza Roma - Ingreso de Dinero");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(410, 400);
        panelDinero.setBackground(new Color(255, 255, 255));
        setContentPane(panelDinero);
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos (){
        Metodos metodos = new Metodos(this);
        //Inicializar constantes




        //JLabel
        titulo = new JLabel("Billetera Digital:");
        titulo.setBounds (10,0,120,30);
        Font fuente1 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        titulo.setFont(fuente1);
        titulo.setForeground(new Color(237, 195,0));

        
        indicacionDinero = new JLabel("Dinero a depositar");
        indicacionDinero.setBounds(145,125,200,70);
        Font fuente3 = new Font("Yu Mincho Demibold", Font.BOLD, 12);
        indicacionDinero.setFont(fuente3);
        indicacionDinero.setForeground(new Color(0, 0,0));

        indicacionTarjeta = new JLabel("Número de tarjeta a registrar");
        indicacionTarjeta.setBounds(125, 20, 190, 70);
        Font fuente2 = new Font("Yu Mincho Demibold", Font.BOLD, 12);
        indicacionTarjeta.setFont(fuente2);
        indicacionTarjeta.setForeground(new Color(0, 0,0));


        //JButton

        botonCancelar = new JButton("atras");
        botonCancelar.setBounds(30, 305, 50, 30);
        botonCancelar.addActionListener(metodos);
        botonCancelar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonCancelar, "Imagenes\\deshacer (2).png");
        botonCancelar.setBorderPainted(false);
        botonCancelar.setOpaque(false);

        botonAceptar = new JButton("Depositar");
        botonAceptar.setBounds(305, 305, 50, 30);
        //botonCancelar.addActionListener(metodos);
        botonAceptar.setBackground(new Color(255, 255, 0));
        this.PintarB(this.botonAceptar, "Imagenes\\billetera.png");
        botonAceptar.setBorderPainted(false);
        botonAceptar.setOpaque(false);



        

        



        //JTexfield

        areaDinero = new JTextField();
        areaDinero.setBounds(155,84,90,20);

        areaTarjeta = new JTextField();
        areaTarjeta.setBounds(155,194,90,20);

        


        //añadir Costantes al panel


        panelDinero.add(indicacionDinero);
        panelDinero.add(indicacionTarjeta);
        panelDinero.add(areaDinero);
        panelDinero.add(titulo);
        panelDinero.add(areaTarjeta);
        panelDinero.add(botonCancelar);
        panelDinero.add(botonAceptar);


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
    }// Fin del meto

    

}
