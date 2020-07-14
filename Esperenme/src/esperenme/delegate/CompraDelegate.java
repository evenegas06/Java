/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.delegate;


import esperenme.dto.CompraDto;
import esperenme.facade.CompraFacade;
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
public class CompraDelegate {
    private Connection cnn;
    private CompraFacade autFacade;
    private Statement statement;
    
    public CompraDelegate(){
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
    autFacade = new CompraFacade(cnn);
    }
    
    public void crearCompra(CompraDto dto) throws SQLException{
        autFacade.crear(dto);
    }
    
    public List listaCompra() throws SQLException{
        return autFacade.listar();
    }
    
    ///**//
  /*  public List listarComprasUsuario(CompraDto dto) throws SQLException{
        return autFacade.comprasUsuario(dto);
    }*/
    
    public CompraDto leerCompra(CompraDto dto) throws SQLException{
        return autFacade.leer(dto);
    }
    
    public void actualizaComopra(CompraDto dto) throws SQLException{
        autFacade.actualiza(dto);;
    }
    
    public void eliminaCompra(CompraDto dto) throws SQLException{
        autFacade.elimina(dto);
    }
    
     public CompraDto seleccionaCompra(CompraDto dto) throws SQLException{
        return autFacade.selecciona(dto);
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

