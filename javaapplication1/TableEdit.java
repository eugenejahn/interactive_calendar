/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class TableEdit extends JFrame
{
    TableEdit()
    {
        JTable table = new JTable(5,5);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollpane = new JScrollPane(table);
        getContentPane().add(scrollpane);

        //  Use a custom editor

        TableCellEditor fce = new FiveCharacterEditor();
        table.setDefaultEditor(Object.class, fce);
    }

    class FiveCharacterEditor extends DefaultCellEditor
    {
        FiveCharacterEditor()
        {
            super( new JTextField() );
        }

        public boolean stopCellEditing()
        {
            try
            {
                String editingValue = (String)getCellEditorValue();

                if(editingValue.length() != 5)
                {
                    JTextField textField = (JTextField)getComponent();
                    textField.setBorder(new LineBorder(Color.red));
                    textField.selectAll();
                    textField.requestFocusInWindow();

                    JOptionPane.showMessageDialog(
                        null,
                        "Please enter string with 5 letters.",
                        "Alert!",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            catch(ClassCastException exception)
            {
                return false;
            }

            return super.stopCellEditing();
        }

        public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            Component c = super.getTableCellEditorComponent(
                table, value, isSelected, row, column);
            ((JComponent)c).setBorder(new LineBorder(Color.black));

            return c;
        }

    }

    public static void main(String [] args)
    {
        JFrame frame = new TableEdit();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}