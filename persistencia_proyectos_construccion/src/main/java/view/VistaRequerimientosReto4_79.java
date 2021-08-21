package view;

import controller.*;
import model.vo.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class VistaRequerimientosReto4_79 {
    

    
    public static final ControladorRequerimientosReto4_79 controlador = new ControladorRequerimientosReto4_79();

    public static ArrayList<Consulta1VO_79> consulta1() {

        ArrayList<Consulta1VO_79> lista = new ArrayList<>();

        System.out.println("-----Consulta 1-------");
        System.out.println("Id_Proyecto  Fecha_Inicio  Banco Serial");
        try {
            lista = controlador.consulta1();

            // for (Consulta1VO_79 lista1 : listas) {
            //     System.out.printf("%d\t%s\t %s\t %s\t %n", lista1.getID_Proyecto(), lista1.getFecha_Inicio(),
            //             lista1.getBanco_Vinculado(), lista1.getSerial());
                
                
            // }
            // Encabezado del resultado
            // Cada VO cargado, mostrarlo en la vista
        } catch (SQLException e) {
            
        }return lista;
    }
    public static ArrayList<Consulta2VO_79> consulta2(){

        ArrayList<Consulta2VO_79> lista2 = new ArrayList<>();
        System.out.println("-----Consulta 2-------");
        System.out.println("Nombre  Salario  Deducible      Apellidos");
        try {
            lista2 = controlador.consulta2();
            // for (Consulta2VO_79 lista2 : listas2) {
            //     System.out.printf("%s\t%d\t%s\t%s\t %n", lista2.getNombre(), lista2.getSalario(),  lista2.getDeducible()+"0000" ,
            //             lista2.getApellidos());
            // }
            // Encabezado del resultado
            // Cada VO cargado, mostrarlo en la vista
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }return lista2;
    }
    public static ArrayList<Consulta3VO_79> consulta3(){
        ArrayList<Consulta3VO_79> lista3 = new ArrayList<>();
        System.out.println("-----Consulta 3-------");
        System.out.println("id_proyecto, nom_ape");
        try {
             lista3 = controlador.consulta3();
            // for (Consulta3VO_79 lista1 : listas1) {
            //     System.out.printf("%d\t%s\t %n", lista1.getID_Proyecto(), lista1.getNom_ape()
            //     );
            // } // Encabezado del resultado
            // Cada VO cargado, mostrarlo en la vista
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }return lista3;
    }

   
    
    
    
}
