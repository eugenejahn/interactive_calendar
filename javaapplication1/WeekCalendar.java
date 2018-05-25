import java.awt.*;
import javax.swing.*;


public class WeekCalendar {
   public static void main(String[] args) {
     JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(1000,1000);
     frame.setTitle("WeekCalendar");
     frame.setForeground(Color.WHITE);
     CldPanel panel = new CldPanel();
     frame.add(panel);
     frame.setVisible(true);
   }
}

   
   