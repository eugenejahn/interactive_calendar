import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class WeekCalendar2 {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    frame.setForeground(Color.GREEN);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(1000, 1000);
    frame.setVisible(true);
  }
}