package Vista;

import Controlador.Metodos;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegistroAplicante extends JFrame implements ActionListener{

    private static final String COCINERO = "Cocinero";
    private static final String REPARTIDOR = "Repartidor";
    public JPanel panelRegistroAplicante = new JPanel();
    public JLabel nombreLabel, cedulaLabel, puestoLabel, correolabel, numeroLabel, residenciaLabel;
    public JButton botonEnviar, botonVolver;
    public JTextField nombre_txt, cedula_txt, correo_txt, numero_txt;
    public JComboBox puestoTrabajo, provincia;
    public ImageIcon imagen;
    public Icon icono;

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;


    public RegistroAplicante() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pizza Roma - Registrarme como trabajador");
        setSize(600, 450);
        panelRegistroAplicante.setBackground(new Color(255, 255, 255));
        setContentPane(panelRegistroAplicante);
        panelRegistroAplicante.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 4));
        setLocationRelativeTo(null);
        setLayout(null);

     

       

        botonVolver = new JButton();
        botonVolver.setBounds(30, 350, 80, 40);
        botonVolver.addActionListener(this);
        botonVolver.setBackground(new Color(255, 255, 51));
        this.PintarB(this.botonVolver, "Imagenes\\deshacer (2).png");
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.setToolTipText("Volver al menú principal");

        botonEnviar = new JButton();
        botonEnviar.setBounds(460, 350, 80, 40);
        botonEnviar.addActionListener(this);
        botonEnviar.setBackground(new Color(255, 255, 51));
        this.PintarB(this.botonEnviar, "Imagenes\\avion-de-papel (1).png");
        botonEnviar.setBorderPainted(false);
        botonEnviar.setOpaque(false);
        botonEnviar.setToolTipText("Enviar solicitud a Pizza Roma");

        cedulaLabel = new JLabel("Cédula: ");
        cedulaLabel.setBounds(40, 30, 140, 30);
        cedulaLabel.setBackground(new Color(0, 0, 0));

        cedula_txt = new JTextField();
        cedula_txt.setBounds(165, 38, 140, 20);
        cedula_txt.setToolTipText("Digite su número de cédula");

        nombreLabel = new JLabel("Nombre Completo: ");
        nombreLabel.setBounds(40, 60, 140, 30);
        nombreLabel.setBackground(new Color(0, 0, 0));

        nombre_txt = new JTextField();
        nombre_txt.setBounds(165, 68, 200, 20);
        nombre_txt.setToolTipText("Escriba su nombre completo ");

        correolabel = new JLabel("Correo electrónico: ");
        correolabel.setBounds(40, 90, 140, 30);
        correolabel.setBackground(new Color(0, 0, 0));

        correo_txt = new JTextField();
        correo_txt.setBounds(165, 98, 200, 20);
        correo_txt.setToolTipText("Digite correo electrónico");

        numeroLabel = new JLabel("Número Telefónico: ");
        numeroLabel.setBounds(40, 120, 140, 30);
        numeroLabel.setBackground(new Color(0, 0, 0));

        numero_txt = new JTextField();
        numero_txt.setBounds(165, 128, 100, 20);
        numero_txt.setToolTipText("Digite su número telefónico de contacto");

        puestoLabel = new JLabel("Puesto Preferencia: ");
        puestoLabel.setBounds(40, 150, 140, 30);
        puestoLabel.setBackground(new Color(0, 0, 0));

        puestoTrabajo = new JComboBox<>();
        puestoTrabajo.addItem(REPARTIDOR);
        puestoTrabajo.addItem(COCINERO);
        puestoTrabajo.setBounds(165, 158, 120, 20);
        puestoTrabajo.setToolTipText("Seleccione su puesto de preferencia para trabajar con Pizza Roma");

        residenciaLabel = new JLabel("Provincia: ");
        residenciaLabel.setBounds(40, 210, 140, 30);
        residenciaLabel.setBackground(new Color(0, 0, 0));

        provincia = new JComboBox();
        provincia.setBounds(165, 215, 200, 20);
        provincia.setToolTipText("Especifíque su lugar de residencia");
        provincia.addItem("San José");
        provincia.addItem("Alajuela");
        provincia.addItem("Cartago");
        provincia.addItem("Heredia");
        provincia.addItem("Guanacaste");
        provincia.addItem("Puntarenas");
        provincia.addItem("Limón");

        panelRegistroAplicante.add(botonVolver);
        panelRegistroAplicante.add(botonEnviar);
        panelRegistroAplicante.add(nombreLabel);
        panelRegistroAplicante.add(cedulaLabel);
        panelRegistroAplicante.add(residenciaLabel);
        panelRegistroAplicante.add(puestoLabel);
        panelRegistroAplicante.add(puestoTrabajo);
        panelRegistroAplicante.add(nombre_txt);
        panelRegistroAplicante.add(cedula_txt);
        panelRegistroAplicante.add(provincia);
        panelRegistroAplicante.add(correolabel);
        panelRegistroAplicante.add(correo_txt);
        panelRegistroAplicante.add(numeroLabel);
        panelRegistroAplicante.add(numero_txt);

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

            metodos.desconectar();
            metodos.solicitudesAprincipal();
        }

        if(e.getSource() == botonEnviar){

            metodos.EnviarAplicanteServer();
        }
    }

}
