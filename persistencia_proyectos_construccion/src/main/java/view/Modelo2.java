package view;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class Modelo2 extends AbstractTableModel{

    private static final String[] COLUMN_NAMES_STRINGS={"Nombre","Salario", "Deducible", "Apellido"};
    


    Object datos2[][] = { 
        { "uno", "dos", "tres", "cuatro" }, 
        { "cinco", "seis", "siete", "ocho" },
        { "nueve", "diez", "once", "doce" } };

public Modelo2() {
    
    addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent evt) {
            for (int i = 0; i < datos2.length; i++) {
                for (int j = 0; j < datos2[0].length; j++) {
                    System.out.print(datos2[i][j] + " ");
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
public String getColumnName(int colum2) {
    return COLUMN_NAMES_STRINGS [colum2];
}

@Override
public int getRowCount() {
    return datos2.length;
}

@Override
public int getColumnCount() {
    return datos2[0].length;
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    return datos2[rowIndex][columnIndex];
}

@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    datos2[rowIndex][columnIndex] = aValue;
    fireTableDataChanged();
}

@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
}

}

    
