package model;
import java.sql.SQLException;
import java.sql.Connection;
import util.JDBCUtilities;
import view.*;
import javax.swing.JFrame;


/**
 * Persistencia Proyectos Construcción
 *
 */
public class App_79 {
    public static void main( String[] args ){    
        
     Formulario ventana =new Formulario();
     ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
    ventana.setResizable(false);
    ventana.setSize(320,500);
    ventana.setTitle("***RETO 5 GRUPO 79***");
        //Casos de prueba 
        //Consulta 1
        VistaRequerimientosReto4_79.consulta1();
        System.out.println();
        //Consulta 2
        VistaRequerimientosReto4_79.consulta2();
        System.out.println();
        //Consulta 3
        VistaRequerimientosReto4_79.consulta3();
        System.out.println();
        //////////Fin de los llamados a los requerimientos

    }
}
