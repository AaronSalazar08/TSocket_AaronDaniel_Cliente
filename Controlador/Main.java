package Controlador;

import java.util.ArrayList;

import Modelo.Aplicante;
import Modelo.Pedido;
import Vista.PrimeraVista;
import Vista.RegistroAplicante;
import Vista.RegistroInicio;
import Vista.RegistroPedido;

public class Main {

    //Creación de Arraylist para poder guardar los datos del aplicante en cursar 
    public static ArrayList <Aplicante> listaAplicantes = new ArrayList<>();

    //Creación de Arraylist para guardar los datos de los pedidos 
    public static ArrayList <Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {

        //Creacion de un objeto como instancia para poder llamar al JFrame de RegistroInicio
        
        RegistroInicio registroInicio = new RegistroInicio();
        registroInicio.setVisible(true);
       

    }
}
