/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableListSelectionListener {

  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JTable table;

    String[] columnTitles = { "A", "B", "C", "D" };
    Object[][] rowData = { 
        { "", "12", "13", "14" }, 
        { "21", "22", "23", "24" },
        
        { "31", "32", "33", "34" },
        { "31", "32", "33", "34" },
        { "31", "32", "33", "34" },
        { "41", "42", "44", "44" } };

    table = new JTable(rowData, columnTitles);

    table.setCellSelectionEnabled(true);
    ListSelectionModel cellSelectionModel = table.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        String selectedData = null;

        int selectedRow = table.getSelectedRows()[0];
        int selectedColumns = table.getSelectedColumns()[0];

        int tmpi = 0;
        int tmpj = 0;
        
//        for (int i = 0; i < selectedRow.length; i++) {
//          for (int j = 0; j < selectedColumns.length; j++) {
//            selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
//            tmpi = i;
//            tmpj = j;
//          }
//          
//        }
        selectedData = (String) table.getValueAt(selectedRow, selectedColumns);
        System.out.println("Selected: " + selectedData + "i and j " + selectedRow + selectedColumns);
        ColorRenderer tableCellRendererComponent = new ColorRenderer();
        Component a = tableCellRendererComponent.getTableCellRendererComponent(table,selectedData,true,true,selectedRow,selectedColumns)
      }

    });

    frame.add(new JScrollPane(table));

    frame.setSize(300, 200);
    frame.setVisible(true);
  }

}
// test

class ColorRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected)
            setBackground( table.getSelectionBackground() );
        else
        {
            setBackground( table.getBackground() );

            try
            {
                int number = Integer.parseInt( value.toString() );

                if (number > 24)
                    setBackground( Color.RED );
            }
            catch(Exception e) {}
        }

        return this;
    }
}