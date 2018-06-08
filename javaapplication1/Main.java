package javaapplication1;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.time.LocalDateTime;
import java.util.Calendar;
/*  w w w .ja  v  a  2  s  .c o  m*/
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class Main{
    
  private void displayGUI()
    {
        LocalDateTime now = LocalDateTime.now();
    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();
    
    JPanel contentPanel = new JPanel();
        contentPanel.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
    contentPanel.setLayout(new CardLayout());
    
    MonthPanel monthPanel = new MonthPanel(contentPanel, month,day, year);
    
    
    
    WeekPanel weekPanel = new WeekPanel(contentPanel);
    
    monthPanel.set(weekPanel);
    
    JFrame frame = new JFrame();
    
    
    contentPanel.add(monthPanel, "Panel1");
    contentPanel.add(weekPanel, "Panel2");
    
    
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setLayout(new FlowLayout());
    frame.setContentPane(contentPanel);
    frame.setSize(1100,650);
//    frame.setLocationByPlatform(true);
    frame.setVisible(true);
    }
    
  public static void main(String[] args) {
      

    
   SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().displayGUI();
            }
        });
  }
}