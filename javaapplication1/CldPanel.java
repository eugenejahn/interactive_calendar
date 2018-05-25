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
}