/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.delegate;


import esperenme.dto.ServicioDto;
import esperenme.facade.ServicioFacade;
import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.List;
import static java.lang.Class.forName;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author dan
 */
public class ServicioDelegate {
    private Connection cnn;
    private ServicioFacade autFacade;
    private Statement statement;
    
    public ServicioDelegate(){
    String user = "root";
    String pwd = "";
    String url = "jdbc:mysql://localhost:3306/esperenme";
    String mySqlDriver = "com.mysql.jdbc.Driver"; 
    try{
    Class.forName(mySqlDriver);
    cnn = DriverManager.getConnection(url, user,pwd);
    statement = cnn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    autFacade = new ServicioFacade(cnn);
    }
    
    public void crearServicio(ServicioDto dto) throws SQLException{
        autFacade.crear(dto);
    }
    
    public List listaServicios() throws SQLException{
        return autFacade.listar();
    }
    
    public ServicioDto leerServicio(ServicioDto dto) throws SQLException{
        return autFacade.leer(dto);
    }
    
    public void actualizaServicio(ServicioDto dto) throws SQLException{
        autFacade.actualiza(dto);;
    }
    
    public void eliminaServicio(ServicioDto dto) throws SQLException{
        autFacade.elimina(dto);
    }
    
    
          public ResultSet ejecutarConsulta(String query) {
        ResultSet r = null;
        try {
            r = statement.executeQuery(query);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
}

