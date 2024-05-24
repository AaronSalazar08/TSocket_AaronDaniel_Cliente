package Controlador;

import java.util.ArrayList;

import Modelo.Aplicante;
import Modelo.Pedido;
import Vista.PrimeraVista;
import Vista.RegistroAplicante;
import Vista.RegistroInicio;
import Vista.RegistroPedido;

public class Main {

    public static ArrayList <Aplicante> listaAplicantes = new ArrayList<>();
    public static ArrayList <Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {

        
        RegistroInicio registroInicio = new RegistroInicio();
        registroInicio.setVisible(true);
       

    }
}
