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
        add(jcomp4);
        add(scrollPane);
    }
    
   
    
    public void buttonText(String tmp){
        jcomp4.setText(tmp);
    }
    
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
