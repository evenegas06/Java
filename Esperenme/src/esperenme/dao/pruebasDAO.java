/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.dao;

import esperenme.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger;


/**
 *
 * @author leina
 */
public class pruebasDAO {
   /* public static void main(String[] args) { 
        Connection cnn = null;
        String user = "root";       
        String pwd = "";      
        String url = "jdbc:mysql://localhost:3306/esperenme";      
        String mySqlDriver = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(mySqlDriver);          
            cnn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();    
        }   
        
        
        /// Crear instancias
        UsuarioDto dto = new UsuarioDto();
        UsuarioDao dao = new UsuarioDao();
        
      //  String a="7.000";
       // int num=Integer.valueOf(a);
       // System.out.println(""+num);
        try{
            
           // System.out.println(dao.loadAll(cnn));
            
          /* agregar un registro nuevo
          dto.setNombre("Lalo");
          dto.setApellidoM("LALA");
          dto.setApellidoP("LULU");
          dto.setTelefono("595112324");
          dto.setTarjeta("2345665432456543");
          dto.setCv("345");
          dto.setContrasena("contrasena");
          dto.setCorreo("correo@vorreo.hotmail");
          dto.setTipo("A");
          dao.create(dto, cnn);*/
          
          
          
          // actualizar un usuario 
      /*    dto.setIdUsuario(6);
          dto.setNombre("xD");
          dto.setApellidoM("xD");
          dto.setApellidoP("Ayala");
          dto.setTelefono("595112324");
          dto.setTarjeta("2543");
          dto.setCv("3");
          dto.setContrasena("contrasena");
          dto.setCorreo("correo@vorreo.hotmail");
          dto.setTipo("A");
          dao.update(dto, cnn);
          
          
          //buscar usuario
          /*dto.setContrasena("sss");
          dto.setCorreo("correo@vorreo.hotmail");
          //System.out.println(dto.getIdUsuario());
          dto = dao.loadSesion(dto, cnn);
          System.out.println(dto);
          
          */
  /*     } catch (SQLException ex) {
            Logger.getLogger(pruebasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }*/
}
