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

public class Consulta1_79Dao {
    public ArrayList<Consulta1VO_79> consulta1() throws SQLException {

        ArrayList<Consulta1VO_79> respuesta = new ArrayList<Consulta1VO_79>();
        Connection conexion = null;

        try {
            conexion = JDBCUtilities.getConnection();
            // SELECT * FROM Lider;
            PreparedStatement statement = conexion
                    .prepareStatement("SELECT ID_proyecto," + "Fecha_Inicio," + "Banco_vinculado," + "serial"
                            + " FROM Proyecto p " + "WHERE ID_proyecto > 4 and ID_proyecto < 12;");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Cargar el registro actual en un Value Object
                Consulta1VO_79 consulta1 = new Consulta1VO_79();
                consulta1.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                consulta1.setFecha_Inicio(resultSet.getString("Fecha_Inicio"));
                consulta1.setBanco_Vinculado(resultSet.getString("Banco_Vinculado"));
                consulta1.setSerial(resultSet.getString("Serial"));

                respuesta.add(consulta1);
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
        return respuesta;
    }

}