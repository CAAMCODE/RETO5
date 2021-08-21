package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta2_79Dao {

    public ArrayList<Consulta2VO_79> consulta2() throws SQLException {

        ArrayList<Consulta2VO_79> respuesta2 = new ArrayList<Consulta2VO_79>();
        Connection conexion = null;

        try {
            conexion = JDBCUtilities.getConnection();
            // SELECT * FROM Lider;
            PreparedStatement statement = conexion.prepareStatement("SELECT Nombre," + "Salario,"
                    + " Salario*0.08 AS deducible," + " Primer_Apellido||'-'||Segundo_Apellido AS 'apellidos' "
                    + " FROM Lider l" + " WHERE  Salario >= 500000 and Salario <= 650000");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Cargar el registro actual en un Value Object
                Consulta2VO_79 consulta2 = new Consulta2VO_79();
                consulta2.setNombre(resultSet.getString("Nombre"));
                consulta2.setSalario(resultSet.getInt("salario"));
                consulta2.setDeducible(resultSet.getString("deducible"));
                consulta2.setApellidos(resultSet.getString("apellidos"));

                respuesta2.add(consulta2);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultando líderes: " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        // Retornamos la colección de VO's obtenida de la BD (Vacía, con un VO o muchos)
        return respuesta2;
    }

}