import java.awt.*;
import javax.swing.*;


public class WeekCalendar {
   public static void main(String[] args) {
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(2000,2000);
     frame.setTitle("WeekCalendar");
     frame.setForeground(Color.WHITE); 
     frame.setLayout(new BorderLayout());
     JPanel north = new JPanel(new FlowLayout());
     north.add(new JTextField(1));
     CldPanel panel = new CldPanel();
     panel.setBackground(Color.WHITE);

     frame.add(panel, BorderLayout.CENTER);
     frame.add(north, BorderLayout.NORTH); 
     frame.setVisible(true);

   }
}

   
   