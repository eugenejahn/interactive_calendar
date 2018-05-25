import java.awt.*;
import javax.swing.*;

public class CldPanel extends JPanel{
//    public CldPanel ()  {
//       DrawingPanel panel = new DrawingPanel(700,1000);
//       Graphics g = panel.getGraphics();
//       rect(g);
//    }
   public void paintComponent (Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      for(int i = 0; i < 7; i++) {
          g.drawRect(i*100,0,100,1000);
      }
      g.drawLine(0,20,1000,20);
      g.drawString("Monday",0,15);
      g.drawString("Tuesday",100,15);
      g.drawString("Wednesday",200,15);
      g.drawString("Thursday",300,15);
      g.drawString("Friday",400,15);
      g.drawString("Saturday",500,15);
      g.drawString("Sunday",600,15);      
   }
}