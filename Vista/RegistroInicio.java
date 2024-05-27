package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Metodos;

import javax.swing.Icon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class RegistroInicio extends JFrame implements ActionListener {

    JPanel panelUsuario = new JPanel();

    JLabel usuarioLabel;
    public static JTextField areaNombre;
    public JButton botonEntrar;

    //Atributos para lograr poner imagines a constantes
    private ImageIcon imagen;
    private Icon icono;

    //Constante para insertar el logo de la Pizzeria
    JLabel logo;

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;


    public RegistroInicio() {
        //Inicializando JPanel

        setTitle("Pizza Roma - Regístrate");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(410, 420);
        panelUsuario.setBackground(new Color(255, 0, 0));
        setContentPane(panelUsuario);
        setLocationRelativeTo(null);
        setLayout(null);

      
      
        // Inicializar constantes

        // JLabel

        logo = new JLabel();
        logo.setBounds(80, 15, 240, 200);
        this.Pintar(this.logo, "Imagenes\\PIZZA_ROMA_ROJO.jpg");

        usuarioLabel = new JLabel("Usuario");
        usuarioLabel.setBounds(180, 180, 500, 70);
        Font fuente2 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        usuarioLabel.setFont(fuente2);
        usuarioLabel.setForeground(new Color(255, 255, 255));

        // JButton
        botonEntrar = new JButton(" Entrar");
        botonEntrar.setBounds(146, 300, 120, 30);
        botonEntrar.addActionListener(this);
        botonEntrar.setBackground(new Color(255, 255, 255));
        ImageIcon iconoEntrar = new ImageIcon("Imagenes/entrar-en-el-portal.png");
        Image imagenEntrar = iconoEntrar.getImage();
        Image imagenEntrarAjustada = imagenEntrar.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
        ImageIcon iconoEntrarAjustada = new ImageIcon(imagenEntrarAjustada);
        botonEntrar.setIcon(iconoEntrarAjustada);
        botonEntrar.setBorderPainted(false);

        // JTexfield
        areaNombre = new JTextField();
        areaNombre.setBounds(130, 240, 150, 20);
        Font fuente3 = new Font("Yu Mincho Demibold", Font.BOLD, 14);
        areaNombre.setFont(fuente3);
        areaNombre.setToolTipText("Ingrese su nombre de usuario");

        // Agregar constantes al panel

        panelUsuario.add(usuarioLabel);
        panelUsuario.add(areaNombre);
        panelUsuario.add(botonEntrar);
        panelUsuario.add(logo);

    }


    //Metoodo para poner imagines a JLabel

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
       
        if(e.getSource() == botonEntrar){

            metodos.loginAprincipal();
        }
    }

}
