/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.dao;

import esperenme.dto.ServicioDto;
import esperenme.dto.UsuarioDto;
import esperenme.dto.CompraDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dan
 */
public class CompraDao {

    private static final String SQL_INSERT
            = "INSERT INTO compra("
            + "idCompra, id_Usuario, id_Servicio, codigo, fechaCompra,cantidad,costoNeto"
            + ")VALUES(?,?,?,?,?,?,?)";

    private static final String SQL_SELECT
            = "SELECT id_Usuario, id_Servicio, codigo, fechaCompra,cantidad,costoNeto"
            + "FROM compra where idCompra = ?";
    
    private static final String SQL_SELECT2
            = "SELECT id_Usuario, id_Servicio, codigo, fechaCompra, cantidad, costoNeto, idCompra"
            + "FROM compra "
            + "WHERE codigo = ?";
    
    private static final String SQL_SELECT_ALL
            = "SELECT * "
            + "FROM compra";
    private static final String SQL_UPDATE
            = "UPDATE compra SET "
            + "id_Usuario = ?,id_Servicio = ?,codigo = ?,fechaComopra = ?,cantidad = ?,costoNeto = ? "
            + "WHERE "
            + "idComopra = ?";
    private static final String SQL_DELETE
            = "DELETE FROM compra "
            + "WHERE idCompra=?";

    /*private static final String SQL_COMPRA_USUARIO
            = "SELECT idCompra, id_Servicio, codigo, fechaCompra, cantidad, costoNeto"
            + "FROM compra WHERE id_Usuario = ?";*/

    public void create(CompraDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getIdCompra());
            ps.setInt(2, dto.getId_Usuario().getIdUsuario());
            ps.setInt(3, dto.getId_Servicio().getIdServicio());
            ps.setString(4, dto.getCodigo());
            ps.setDate(5, dto.getFechaCompra());
            ps.setInt(6, dto.getCantidad());
            ps.setDouble(7, dto.getCostoNeto());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }

    public CompraDto load(CompraDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getIdCompra());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return (CompraDto) results.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
    }

       public CompraDto select(CompraDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT2);
            ps.setString(1, dto.getCodigo());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return (CompraDto) results.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
    }
    
    
    public List loadAll(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0) {
                return results;
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
    }

   /* public List comprasPorUsuario(CompraDto dto,Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_COMPRA_USUARIO);
            ps.setInt(1, dto.getId_Usuario().getIdUsuario());
            rs = ps.executeQuery();
            List results = getResultsB(rs);
            if (results.size() > 0) {
                return results;
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
    }*/

    private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            CompraDto dto = new CompraDto();
            UsuarioDto UDto = new UsuarioDto();
            ServicioDto SDto = new ServicioDto();
            dto.setIdCompra(rs.getInt("idCompra"));
            UDto.setIdUsuario(rs.getInt("id_Usuario"));
            SDto.setIdServicio(rs.getInt("id_Servicio"));
            dto.setCodigo(rs.getString("codigo"));
            dto.setFechaCompra(rs.getDate("fehcaCompra"));
            dto.setCantidad(rs.getInt("cantidad"));
            dto.setCostoNeto(rs.getDouble("costoNeto"));
            dto.setId_Usuario(UDto);
            dto.setId_Servicio(SDto);
            results.add(dto);
        }
        return results;
    }

    /*private List getResultsB(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            CompraDto dto = new CompraDto();
            UsuarioDto UDto = new UsuarioDto();
            ServicioDto SDto = new ServicioDto();
            dto.setIdCompra(rs.getInt("idCompra"));
            //UDto.setIdUsuario(rs.getInt("id_Usuario"));
            SDto.setIdServicio(rs.getInt("id_Servicio"));
            dto.setCodigo(rs.getString("codigo"));
            dto.setFechaCompra(rs.getDate("fehcaCompra"));
            dto.setCantidad(rs.getInt("cantidad"));
            dto.setCostoNeto(rs.getDouble("costoNeto"));
          //  dto.setId_Usuario(UDto);
            dto.setId_Servicio(SDto);
            results.add(dto);
        }
        return results;
    } */

    public void update(CompraDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getIdCompra());
            ps.setInt(2, dto.getId_Usuario().getIdUsuario());
            ps.setInt(3, dto.getId_Servicio().getIdServicio());
            ps.setString(4, dto.getCodigo());
            ps.setDate(5, (Date) dto.getFechaCompra());
            ps.setInt(6, dto.getCantidad());
            ps.setDouble(7, dto.getCostoNeto());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }

    public void delete(CompraDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getIdCompra());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    
      

    private void cerrar(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            }
        }
    }

    private void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    private void cerrar(Connection cnn) {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException e) {
            }
        }
    }
    
    //******************///
    
    
}
