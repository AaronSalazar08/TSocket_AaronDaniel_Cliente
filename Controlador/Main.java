package Controlador;

import java.util.ArrayList;

import Modelo.Aplicante;
import Modelo.Pedido;
import Vista.EstadoPedido;
import Vista.IngresoDinero;
import Vista.MisPedidos;
import Vista.Noticias;
import Vista.PrimeraVista;
import Vista.RegistroAplicante;
import Vista.RegistroInicio;
import Vista.RegistroPedido;
import Vista.VistaSoporte;

public class Main {

    //Creación de Arraylist para poder guardar los datos del aplicante en cursar 
    public static ArrayList <Aplicante> listaAplicantes = new ArrayList<>();

    //Creación de Arraylist para guardar los datos de los pedidos 
    public static ArrayList <Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {

        //Se crea una instancia de las respectivas clases que han sido heredadas con JFrame implementando la 
        //libreria javax.swing.*;
        RegistroInicio registroInicio = new RegistroInicio();
        PrimeraVista primeraVista = new PrimeraVista();
        RegistroPedido registroPedido = new RegistroPedido();
        EstadoPedido estadoPedido = new EstadoPedido();
        MisPedidos misPedidos = new MisPedidos();
        RegistroAplicante registroAplicante = new RegistroAplicante();
        Noticias noticias = new Noticias();
        VistaSoporte vistaSoporte = new VistaSoporte();
        IngresoDinero ingresoDinero = new IngresoDinero();

        //Se crea una instancia de la Clase Metdos en donde se le pasan como paramatreos las instancias de las clases anteriormente mencionadas
        Metodos metodos = new Metodos(registroPedido, registroInicio, primeraVista, registroAplicante, estadoPedido, misPedidos, ingresoDinero, noticias, vistaSoporte);

         //Para cada instancia se le incova el metodo se "setMetodos", el cual es un metodo constructor para poder trabajar con la clase metodos en todas las clases instanciadas anteriormente
        registroInicio.setMetodos(metodos);
        primeraVista.setMetodos(metodos);
        registroPedido.setMetodos(metodos);
        estadoPedido.setMetodos(metodos);
        misPedidos.setMetodos(metodos);
        registroAplicante.setMetodos(metodos);
        noticias.setMetodos(metodos);
        vistaSoporte.setMetodos(metodos);
        ingresoDinero.setMetodos(metodos);

        //Se hace visible la clase registroInicio que es donde el usuario se registra en la aplicacion
        registroInicio.setVisible(true);
       

    }
}
