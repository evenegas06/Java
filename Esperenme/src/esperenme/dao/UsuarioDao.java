/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.dao;

import esperenme.dto.UsuarioDto;
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
public class UsuarioDao {

    private static final String SQL_INSERT
            = "INSERT INTO usuario("
            + "nombre,apellidoM,apellidoP,telefono,tarjeta,cv,contrasena,correo,tipo"
            + ")VALUES(?,?,?,?,?,?,?,?,?)";

    private static final String SQL_SELECT
            = "SELECT * "
            + " FROM usuario Where idUsuario = ?";

    private static final String SQL_SELECT_ALL
            = "SELECT *"
            + "FROM usuario";

    private static final String SQL_UPDATE
            = "UPDATE usuario SET"
            + " nombre = ?,apellidoM = ?,apellidoP = ?,telefono = ?,tarjeta = ?,cv = ?,contrasena = ?,correo = ?,tipo = ?"
            + " WHERE "
            + " idUsuario = ?";

    private static final String SQL_DELETE
            = "DELETE FROM usuario "
            + "WHERE idUsuario = ?";

    private static final String SQL_SESION
            = "SELECT * "
            + "FROM usuario WHERE correo = ? AND contrasena = ?";
        
    private static final String SQL_SESIONWP
            = "SELECT * "
            + "FROM usuario WHERE correo = ?";
    

    public UsuarioDto load(UsuarioDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getIdUsuario());
            rs = ps.executeQuery();
            List results = getResults(rs);
            System.out.println("encontró resultados");
            if (results.size() > 0) {
                return (UsuarioDto) results.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
    }

    public UsuarioDto loadSesion(UsuarioDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SESION);
            ps.setString(1, dto.getCorreo());
            ps.setString(2, dto.getContrasena());
            rs = ps.executeQuery();
            List results = getResults(rs);
            System.out.println("encontró resultados");
            if (results.size() > 0) {
                return (UsuarioDto) results.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
    }
    

    
    public UsuarioDto loadSesionWP(UsuarioDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SESIONWP);
            ps.setString(1, dto.getCorreo());
            rs = ps.executeQuery();
            List results = getResults(rs);
            System.out.println("encontró resultados");
            if (results.size() > 0) {
                return (UsuarioDto) results.get(0);
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

    public void update(UsuarioDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getApellidoM());
            ps.setString(3, dto.getApellidoP());
            ps.setString(4, dto.getTelefono());
            ps.setString(5, dto.getTarjeta());
            ps.setString(6, dto.getCv());
            ps.setString(7, dto.getContrasena());
            ps.setString(8, dto.getCorreo());
            ps.setString(9, dto.getTipo());
            ps.setInt(10, dto.getIdUsuario());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }
    public void create(UsuarioDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getApellidoM());
            ps.setString(3, dto.getApellidoP());
            ps.setString(4, dto.getTelefono());
            ps.setString(5, dto.getTarjeta());
            ps.setString(6, dto.getCv());
            ps.setString(7, dto.getContrasena());
            ps.setString(8, dto.getCorreo());
            ps.setString(9, dto.getTipo());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }

    public void delete(UsuarioDto dto, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getIdUsuario());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(conn);
        }
    }

    private List getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList();
        while (rs.next()) {
            UsuarioDto dto = new UsuarioDto();
            dto.setIdUsuario(rs.getInt("idUsuario"));
            dto.setNombre(rs.getString("nombre"));
            dto.setApellidoM(rs.getString("apellidoM"));
            dto.setApellidoP(rs.getString("apellidoP"));
            dto.setTelefono(rs.getString("telefono"));
            dto.setTarjeta(rs.getString("tarjeta"));
            dto.setCv(rs.getString("cv"));
            dto.setContrasena(rs.getString("contrasena"));
            dto.setCorreo(rs.getString("correo"));
            dto.setTipo(rs.getString("tipo"));

            results.add(dto);
        }
        return results;
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
}
