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
    }
    
    public void paintComponent (Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      g.drawLine(0,0,0,1000);
      for(int i = 1; i <= 7; i++) {
          g.drawRect(i*100,0,100,1000);
      }
      for(int j = 1; j <= 12; j++) {
         g.drawString ("" + j + "am",10,40*j);
      }
      for(int j = 13; j <= 24; j++) {
         g.drawString ("" + j + "pm",10,40*j);
      }
      for(int k = 0; k < 24; k++) {
         g.drawLine(0,k*40 + 20,800,k*40 + 20);
      }
      g.drawLine(0,20,800,20);
      g.drawString("Monday",110,15);
      g.drawString("Tuesday",210,15);
      g.drawString("Wednesday",310,15);
      g.drawString("Thursday",410,15);
      g.drawString("Friday",510,15);
      g.drawString("Saturday",610,15);
      g.drawString("Sunday",710,15);      
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
