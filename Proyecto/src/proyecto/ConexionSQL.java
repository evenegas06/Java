package proyecto;

import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionSQL {

    private Connection conexion;
    private Statement statement;

    public void crearConexion(String schema, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/" + schema, "root", password);
            statement = conexion.createStatement();
            JOptionPane.showMessageDialog(null, "La conexion se establecio Correctamente");

        } catch (Exception e) {
            System.err.println("no se pudo conectar a la BD");
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la BD", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarBD(String query) {
        try {
            System.out.println("ejecutara siguiente consulta: " + query);
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "BD modificada correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error de SQL", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
