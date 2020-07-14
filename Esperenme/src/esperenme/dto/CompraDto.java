/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.dto;

import java.sql.Date;


/**
 *
 * @author leina
 */
public class CompraDto {
    private int idCompra;
    private UsuarioDto id_Usuario;
    private ServicioDto id_Servicio;
    private String codigo;
    java.sql.Date fechaCompra;
    private int cantidad;
    private double costoNeto;

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public UsuarioDto getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(UsuarioDto id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public ServicioDto getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(ServicioDto id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoNeto() {
        return costoNeto;
    }

    public void setCostoNeto(double costoNeto) {
        this.costoNeto = costoNeto;
    }
    
}
