package view;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class Modelo extends AbstractTableModel{

    private static final String[] COLUMN_NAMES_STRINGS={"ID_Proyecto","Fecha_Inicio", " Banco", "Serial"};
    


    Object datos[][] = { 
        { "uno", "dos", "tres", "cuatro" }, 
        { "cinco", "seis", "siete", "ocho" },
        { "nueve", "diez", "once", "doce" } };

public Modelo() {
    
    addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent evt) {
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[0].length; j++) {
                    System.out.print(datos[i][j] + " ");
                }
                System.out.println();
            }
        }
    });
}


// public static String[] getColumnNamesStrings() {
//     return COLUMN_NAMES_STRINGS;
// }

@Override
public String getColumnName(int colum) {
    return COLUMN_NAMES_STRINGS [colum];
}

@Override
public int getRowCount() {
    return datos.length;
}

@Override
public int getColumnCount() {
    return datos[0].length;
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    return datos[rowIndex][columnIndex];
}

@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    datos[rowIndex][columnIndex] = aValue;
    fireTableDataChanged();
}

@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
}

}

    

