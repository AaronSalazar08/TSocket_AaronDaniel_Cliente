package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Icon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class RegistroInicio extends JFrame implements ActionListener{
    
    JPanel panelUsuario = new JPanel();

    JLabel entrada ;
    JLabel indicacion;
    JTextField areaNombre;
    JButton botonEntrar;
    private ImageIcon imagen;
    private Icon icono;
    JLabel logo; 



public RegistroInicio (){

    this.setTitle("Pizza Roma - Menú Principal");
this.setSize(410,420);
panelUsuario.setBackground(new Color(255, 0, 0));
this.setContentPane(panelUsuario);
this.setLocationRelativeTo(null);
this.setLayout(null);

Elementos ();

}

public void Elementos (){
//Inicializar constantes

//JLabel

 entrada = new JLabel("Registro de usuario");
entrada.setBounds(20, 1, 500, 70);
Font fuente1 = new Font("Stencil", Font.PLAIN, 14); 
entrada.setFont(fuente1);
entrada.setForeground(new Color(255, 255, 51));



logo = new JLabel();
logo.setBounds(105,30,200,200);
this.Pintar(this.logo, "Imagenes\\PIZZA_ROMA_1_B.png");


indicacion =  new JLabel("Nombre");
indicacion.setBounds(130, 200, 500, 70);
Font fuente2 = new Font("Yu Mincho Demibold", Font.PLAIN, 14); 
indicacion.setFont(fuente2);
indicacion.setForeground(new Color(255, 255, 255));


//JButton
botonEntrar = new JButton("Entrar");
botonEntrar.setBounds(155, 300, 100, 30);
botonEntrar.addActionListener(this);
botonEntrar.setBackground(new Color(255, 255, 255));




//JTexfield
areaNombre = new JTextField();
areaNombre.setBounds(130, 260, 150, 20);
areaNombre.setToolTipText("Ingrese su nombre de usuario");





//Agregar constantes al panel
panelUsuario.add(entrada);
panelUsuario.add(indicacion);
panelUsuario.add(areaNombre);
panelUsuario.add(botonEntrar);
panelUsuario.add(logo);


}

public void actionPerformed(ActionEvent e) {
    

    }

    private void Pintar (JLabel lbl, String ruta) { //Este metodo se utiliza para ponerle imagenes de fondo a los Labels
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT)
                );
        lbl.setIcon(this.icono);
        this.repaint();
        }//Fin del metodo Pintarel m

}
