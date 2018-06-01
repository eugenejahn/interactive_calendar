/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ros_eyjahn
 */
public class WeekPanel extends JPanel{
    
    private JButton jcomp4;
    private JPanel contentPane;
    private Calendar calendar;
    
    public WeekPanel(JPanel panel) 
    {
        
        
        
        Object rowData[][] =  { {"1","","","","","","",""},
            {"2","","","","","","",""},
            {"3","","","","","","",""},
            {"4","","","","","","",""},
            {"5","","","","","","",""},
            {"6","","","","","","",""},
            {"7","","","","","","",""},
            {"8","","","","","","",""},
            {"9","","","","","","",""},
            {"10","","","","","","",""},
            {"11","","","","","","",""},
            {"12","","","","","","",""},
            {"13","","","","","","",""},
            {"14","","","","","","",""},
            {"15","","","","","","",""},
            {"16","","","","","","",""},
            {"17","","","","","","",""},
            {"18","","","","","","",""},
            {"19","","","","","","",""},
            {"20","","","","","","",""},
            {"9","","","","","","",""},
            {"10","","","","","","",""},
            {"11","","","","","","",""},
            {"12","","","","","","",""},
    };

    Object columnNames[] = { "Time/Date", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    JTable table = new JTable(rowData, columnNames);
    table.setRowHeight(35);
  
    tableListener(table);
    
    JScrollPane scrollPane = new JScrollPane(table);
    
        contentPane = panel;
//        setOpaque(true);
//        setBackground(Color.BLUE);
        //construct components
        jcomp4 = new JButton ("openNewWindow");
        jcomp4.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
        // add the go back button
        add(jcomp4);
        // add the week panel into the panel
        add(scrollPane);
    }
    
   
    
    public void buttonText(String tmp){
        jcomp4.setText(tmp);
    }
    
    // it is the litener and changes the color of the cell
    public void tableListener(JTable table){
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
        table.getColumnModel().getColumn(selectedColumns).setCellRenderer(new ColorRenderer());

      }

    });
    }
    
    // the date data is passed by this method, so the values of year month and day are value of the date that user click 
    public void setDate(int year , int month , int day){
        System.out.println(month + " " + day + "" + year);
        calendar = new GregorianCalendar(year,month-1,day);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}



