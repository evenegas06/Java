/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.dto;

/**
 *
 * @author leina
 */
public class UsuarioDto {
    private int idUsuario;
    private String nombre;
    private String apellidoM;
    private String apellidoP;
    private String telefono;
    private String tarjeta;
    private String cv;
    private String contrasena;
    private String correo;
    private String tipo;

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "idUsuario="+idUsuario+"\t-\t nombre="+nombre+"\t - \t ApellidoM="+apellidoM+"\t - \t ApellidoP="+apellidoP+"\t - \t telefono="+telefono+"\t - \t tarjeta="+tarjeta+"\t - \t cv="+cv+"\t - \t contrasena="+contrasena+"\t - \t correo="+correo+"\t - \t tipo="+tipo;
    }
}
