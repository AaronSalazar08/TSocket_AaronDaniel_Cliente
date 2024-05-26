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

    public static ArrayList <Aplicante> listaAplicantes = new ArrayList<>();
    public static ArrayList <Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {

        RegistroInicio registroInicio = new RegistroInicio();
        PrimeraVista primeraVista = new PrimeraVista();
        RegistroPedido registroPedido = new RegistroPedido();
        EstadoPedido estadoPedido = new EstadoPedido();
        MisPedidos misPedidos = new MisPedidos();
        RegistroAplicante registroAplicante = new RegistroAplicante();
        Noticias noticias = new Noticias();
        VistaSoporte vistaSoporte = new VistaSoporte();
        IngresoDinero ingresoDinero = new IngresoDinero();

        Metodos metodos = new Metodos(registroPedido, registroInicio, primeraVista, registroAplicante, estadoPedido, misPedidos, ingresoDinero, noticias, vistaSoporte);

        registroInicio.setMetodos(metodos);
        primeraVista.setMetodos(metodos);
        registroPedido.setMetodos(metodos);
        estadoPedido.setMetodos(metodos);
        misPedidos.setMetodos(metodos);
        registroAplicante.setMetodos(metodos);
        noticias.setMetodos(metodos);
        vistaSoporte.setMetodos(metodos);
        ingresoDinero.setMetodos(metodos);

        registroInicio.setVisible(true);
       

    }
}
