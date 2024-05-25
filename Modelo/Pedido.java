package Modelo;

import java.io.Serializable;

public class Pedido implements Serializable{

    


    protected String promocion, nombre, direccion, metodoPago, cantidadPromocion;
    

    
    public Pedido(String promocion, String nombre, String direccion, String metodoPago, String cantidadPromocion) {
        this.promocion = promocion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.metodoPago = metodoPago;
        this.cantidadPromocion = cantidadPromocion;
    }


    public String getPromocion() {
        return promocion;
    }


    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getMetodoPago() {
        return metodoPago;
    }


    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }


    public String getCantidadPromocon() {
        return cantidadPromocion;
    }


    public void setCantidadPromocon(String cantidadPromocion) {
        this.cantidadPromocion = cantidadPromocion;
    }


    @Override
    public String toString() {
        return "Pedido\n Promocion: " + promocion + "\nDireccion: " + direccion + "\nNombre: " + nombre
        + "\nMetodoPago: " + metodoPago + "\nCantidad de Promocion: " + cantidadPromocion;
    }

    

}
