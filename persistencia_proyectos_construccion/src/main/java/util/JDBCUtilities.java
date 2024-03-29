package util;

import java.io.File;//Para verificación de longitud de base de datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

    //Atributos de clase para gestión de conexión con la base de datos    
    private static final String UBICACION_BD = "D:/Documents/MInTIC_UTP/CICLO_2/PROGRAMACION/UNIDAD_4/RETO_4/reto4/persistencia_proyectos_construccion/ProyectosConstruccion.db";    
    //private static final String UBICACION_BD = "ProyectosConstruccion.db";    

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;        
        return DriverManager.getConnection(url);
    }

    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);
        // //Salida de diagnóstixo
        // System.out.println("UBICACION -> "+ JDBCUtilities.UBICACION_BD);
        // System.out.println("Longitud -> "+ archivo.length());
        return archivo.length() == 0;
    }



}
