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
    Object rowData[][] =  { {"1  am","","","","","","",""},
                           {"2  am","","","","","","",""},
                           {"3  am","","","","","","",""},
                           {"4  am","","","","","","",""},
                           {"5  am","","","","","","",""},
                           {"6  am","","","","","","",""},
                           {"7  am","","","","","","",""},
                           {"8  am","","","","","","",""},
                           {"9  am","","","","","","",""},
                           {"10am","","","","","","",""},
                           {"11am","","","","","","",""},
                           {"12am","","","","","","",""},
                           {"1  pm","","","","","","",""},
                           {"2  pm","","","","","","",""},
                           {"3  pm","","","","","","",""},
                           {"4  pm","","","","","","",""},
                           {"5  pm","","","","","","",""},
                           {"6  pm","","","","","","",""},
                           {"7  pm","","","","","","",""},
                           {"8  pm","","","","","","",""},
                           {"9  pm","","","","","","",""},
                           {"10pm","","","","","","",""},
                           {"11pm","","","","","","",""},
                           {"12pm","","","","","","",""},
                            };
    
    Object columnNames[] = { "Time/Date", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    JTable table = new JTable(rowData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(1000, 1000);
    frame.setVisible(true);
  }
}