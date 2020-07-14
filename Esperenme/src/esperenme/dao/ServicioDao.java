/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.dao;


import esperenme.dto.ServicioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leina
 */
public class ServicioDao {
    private static final String SQL_INSERT =
            "INSERT INTO servicio("
            +"idServicio,nombre,tarifa"
            +")VALUES(?,?,?)";
    
    private static final String SQL_SELECT = 
            "SELECT nombre,tarifa"
            +"FROM usuario Where idServicio = ?";
    
    private static final String SQL_SELECT_ALL =
            "SELECT *"
            + "FROM servicio";
    
    private static final String SQL_UPDATE=
            "UPDATE servicio SET "
            +"nombre = ? , tarifa = ? "
            +"WHERE "
            + " idServicio = ?";
    
    private static final String SQL_DELETE = 
            "DELETE FROM servicio"
            +"WHERE idServicio = ?";
    
    public void create(ServicioDto dto,Connection conn) throws SQLException{
       PreparedStatement ps = null;
       try{
           ps = conn.prepareStatement(SQL_INSERT);
           ps.setInt(1,dto.getIdServicio());
           ps.setString(2,dto.getNombre());
           ps.setDouble(3,dto.getTarifa());
           ps.executeUpdate();
       }finally{
           cerrar(ps);
           cerrar(conn);
       }
    }
    
    public ServicioDto load(ServicioDto dto, Connection conn)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1,dto.getIdServicio());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if(results.size()>0){
                return(ServicioDto) results.get(0);
            }else{
                return null;
            }
        }finally{
            cerrar(rs);
            cerrar(ps);
        }
    }
    
    
    public List loadAll(Connection conn) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List results = getResults(rs);
             if(results.size()>0){
                return results;
            }else{
                return null;
            }
        }finally{
                    cerrar(rs);
                    cerrar(ps);
                    cerrar(conn);
                    }
    }
    
    public void update(ServicioDto dto,Connection conn) throws SQLException{
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(SQL_UPDATE); 
            ps.setString(1,dto.getNombre());
            ps.setDouble(2,dto.getTarifa());
            ps.setInt(3,dto.getIdServicio());
            ps.executeUpdate();
            
        }finally{
            cerrar(ps);
            cerrar(conn);
                    }
    }
    
    
    public void delete(ServicioDto dto, Connection conn)throws SQLException{
            PreparedStatement ps = null;
        try{
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setInt(1,dto.getIdServicio());
        ps.executeUpdate();
    }finally{
        cerrar(ps);
        cerrar(conn);
    }
    }
    
    
    private List getResults(ResultSet rs)throws SQLException{
        List results = new ArrayList();
        while(rs.next()){
            ServicioDto dto = new ServicioDto();
            dto.setIdServicio(rs.getInt("idServicio"));
            dto.setNombre(rs.getString("nombre"));
            dto.setTarifa(rs.getDouble("tarifa"));
            
            results.add(dto);
        }
        return results;
    }
    
     private void cerrar(PreparedStatement ps){
        if(ps!=null){
            try{
                ps.close();
            }catch(SQLException e){
            }
        }
    }
    
    private void cerrar(ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){ 
            }
        }
    }
    
    private void cerrar (Connection cnn){
        if(cnn != null){
            try{
                cnn.close();
            }catch(SQLException e){
            }
        }
    } 
}

