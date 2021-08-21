package view;


import controller.*;
import model.vo.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame implements ActionListener, ChangeListener{

    private JLabel label1, nombre1, password, bienvenido,bienvenido2,usuario1, texbienvenido;
    private JTextArea muestraConsultaTxA;
    private JButton botonCerrar, botonConsultar, botonLimpiar, inicio;
    private JTextField Nombre, contraseña;
    private JScrollPane escrollPane;
    private JRadioButton consulta1, consulta2, consulta3;
    private ButtonGroup bg;
    private JMenuBar menubar;
    private JMenu menu1, menu2;
    private JMenuItem item1, item2, item3;
    private JTable tabla1, tabla2, tabla3 ;


    public Formulario() {
            initui();       

    }

    private void initui(){

        //menu
        menubar = new JMenuBar();
        menubar.setVisible(false);
        setJMenuBar(menubar);
        menu1 = new JMenu("Opciones");
        menubar.add(menu1);
        item1 = new JMenuItem("Consultas");
        item1.addActionListener(this);
        menu1.add(item1);
        item3 = new JMenuItem("Salir");
        item3.addActionListener(this);
        menu1.add(item3);

        menu2 = new JMenu("Ayuda");
        menubar.add(menu2);
        item2 = new JMenuItem("Acerca de");
        item2.addActionListener(this);
        menu2.add(item2);


//boton cerrar
      botonCerrar = new JButton("Cerrar");
        botonCerrar.setBounds(700, 600, 100, 30);
        botonCerrar.setVisible(false);
        add(botonCerrar);
        botonCerrar.addActionListener(this);

        //ingreso

        Nombre = new JTextField();
        Nombre.setBounds(50, 200, 200, 30);
        Nombre.setVisible(true);
        add(Nombre);
        contraseña = new JTextField();
        contraseña.setBounds(50, 260, 200, 30);
        contraseña.setVisible(true);
        add(contraseña);

        nombre1 = new JLabel("Usuario:");
        nombre1.setBounds(50, 170, 300, 30);
        nombre1.setVisible(true);
        add(nombre1);

        password = new JLabel("Password:");
        password.setBounds(50, 230, 300, 30);
        password.setVisible(true);
        add(password);

        //bienvenido
        ImageIcon img = new ImageIcon("src/main/java/img/BDM.png");
        bienvenido = new JLabel();
        bienvenido.setBounds(15, 50, 670, 300);
        bienvenido.setIcon(img);
        bienvenido.setVisible(false);
        add(bienvenido);

        ImageIcon img2 = new ImageIcon("src/main/java/img/post1.jpg");
        bienvenido2 = new JLabel();
        bienvenido2.setBounds(250, 5, 450, 430);
        bienvenido2.setIcon(img2);
        bienvenido2.setVisible(false);
        add(bienvenido2);

        ImageIcon img3 = new ImageIcon("src/main/java/img/Usuario.jpg");
        usuario1 = new JLabel();
        usuario1.setBounds(50, 0, 200,200);
        usuario1.setIcon(img3);
        usuario1.setVisible(true);
        add(usuario1);

        texbienvenido = new JLabel("Bienvenido: ");
        texbienvenido.setBounds(240, 10, 670, 30);
        texbienvenido.setFont(new Font("Serif", Font.PLAIN, 25));
        texbienvenido.setVisible(false);
        add(texbienvenido);

        label1 = new JLabel("Consultas base de datos Reto 5");
        label1.setBounds(10, 20, 300, 30);
        label1.setVisible(false);
        add(label1);



    setLayout(null);      
    inicio = new JButton("Aceptar");
    inicio.setBounds(100, 350, 100, 30);
    inicio.setVisible(true);
    add(inicio);
    inicio.addActionListener(this);

    botonCerrar = new JButton("Cerrar");
    botonCerrar.setBounds(550, 400, 100, 30);
    botonCerrar.setVisible(false);
    add(botonCerrar);
    botonCerrar.addActionListener(this);

    //botones de consulta

    botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(50, 400, 100, 30);
        botonConsultar.setVisible(false);
        add(botonConsultar);
        botonConsultar.addActionListener(this);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(200, 400, 100, 30);
        botonLimpiar.setVisible(false);
        add(botonLimpiar);
        botonLimpiar.addActionListener(this);

        bg = new ButtonGroup();
        consulta1 = new JRadioButton("Consulta 1");
        consulta1.setBounds(10, 90, 100, 30);
        consulta1.setVisible(false);
        consulta1.addChangeListener(this);
        add(consulta1);
        bg.add(consulta1);

        consulta2 = new JRadioButton("Consulta 2");
        consulta2.setBounds(10, 190, 100, 30);
        consulta2.setVisible(false);
        consulta2.addChangeListener(this);
        add(consulta2);
        bg.add(consulta2);

        consulta3 = new JRadioButton("Consulta 3");
        consulta3.setBounds(10, 290, 100, 30);
        consulta3.setVisible(false);
        add(consulta3);
        bg.add(consulta3);

        //texarea
        muestraConsultaTxA = new JTextArea();
        escrollPane = new JScrollPane(muestraConsultaTxA);
        escrollPane.setBounds(250, 5, 400, 400);
        add(escrollPane);
        escrollPane.setVisible(false);


    }

    /// eventos
    private void validaradio() {

        if (consulta1.isSelected()) {
            
            ArrayList<Consulta1VO_79>Resultado= VistaRequerimientosReto4_79.consulta1();
        Object [][] matriz = new Object[Resultado.size()][4];
        for(int i=0; i< Resultado.size(); i++){
             matriz[i][0]= Resultado.get(i).getID_Proyecto();
             matriz[i][1]= Resultado.get(i).getFecha_Inicio();
             matriz[i][2]= Resultado.get(i).getBanco_Vinculado();
             matriz[i][3]= Resultado.get(i).getSerial();

        }
        Modelo modelo = new Modelo();
        modelo.datos=matriz;
        
        JTable tabla= new JTable(modelo);      
          JScrollPane scroll= new JScrollPane(tabla);
        JOptionPane.showMessageDialog(this, scroll);

        VistaRequerimientosReto4_79.consulta1();
            
        }
        if (consulta2.isSelected()) {

            ArrayList<Consulta2VO_79>Resultado2= VistaRequerimientosReto4_79.consulta2();
            Object [][] matriz = new Object[Resultado2.size()][4];
            for(int i=0; i< Resultado2.size(); i++){
                matriz[i][0]= Resultado2.get(i).getNombre();
                matriz[i][1]= Resultado2.get(i).getSalario();
                matriz[i][2]= Resultado2.get(i).getDeducible();
                matriz[i][3]= Resultado2.get(i).getApellidos();
    
            }
            
            Modelo modelo2 = new Modelo();
            modelo2.datos=matriz;
            JTable tabla2= new JTable(modelo2);
            JScrollPane scroll= new JScrollPane(tabla2);
            JOptionPane.showMessageDialog(this, scroll);
           
        }
        if (consulta3.isSelected()) {
            ArrayList<Consulta3VO_79>Resultado3= VistaRequerimientosReto4_79.consulta3();
            Object [][] matriz = new Object[Resultado3.size()][2];
            for(int i=0; i< Resultado3.size(); i++){
                matriz[i][0]= Resultado3.get(i).getID_Proyecto();
                matriz[i][1]= Resultado3.get(i).getNom_ape();
                // matriz[i][2]= Resultado3.get(i).getDeducible();
                // matriz[i][3]= Resultado3.get(i).getApellidos();
    
            }
            
            Modelo modelo3 = new Modelo();
            modelo3.datos=matriz;
            JTable tabla3= new JTable(modelo3);
            JScrollPane scroll= new JScrollPane(tabla3);
            JOptionPane.showMessageDialog(this, scroll);
            
        }
    }



    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonConsultar) {
            validaradio();

        }               
             
        String contraseña1 = "12345";     
        String pass;       
        pass = contraseña.getText();

        if (contraseña1.equals(pass)) {

            if (e.getSource() == inicio && contraseña1.equals(pass)) {
                String texto = Nombre.getText();
                texbienvenido.setText("Bienvenido " + texto);
        setSize(720,500);
        inicio.setVisible(false);
        botonConsultar.setVisible(false);
        botonLimpiar.setVisible(false);
        consulta1.setVisible(false);
        consulta2.setVisible(false);
        consulta3.setVisible(false); 
        Nombre.setVisible(false);
        nombre1.setVisible(false);
        contraseña.setVisible(false);
        password.setVisible(false);
        menubar.setVisible(true);
        botonCerrar.setVisible(true);
        texbienvenido.setVisible(true);
       label1.setVisible(false);
       bienvenido.setVisible(true);
       bienvenido2.setVisible(false);
       usuario1.setVisible(false);


      }
    } else {
        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
    }

      if (e.getSource() == botonCerrar) {
        System.exit(0);
    }

    if (e.getSource() == item1) {
        botonConsultar.setVisible(true);
        botonLimpiar.setVisible(false);
        consulta1.setVisible(true);
        consulta2.setVisible(true);
        consulta3.setVisible(true);
        escrollPane.setVisible(true);
        label1.setVisible(true);
        texbienvenido.setVisible(false);
        bienvenido.setVisible(false);
        bienvenido2.setVisible(true);
        tabla1.setVisible(true);
    }

    if (e.getSource() == item3) {
        System.exit(0);
    }

    if (e.getSource() == item2) {

        JOptionPane.showMessageDialog(null,
                "Consulta base de datos RETO 5 \n Ing.Carlos Andres Amaya Bautista\n Grupo 79");

    }




    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        
    }







    
}
