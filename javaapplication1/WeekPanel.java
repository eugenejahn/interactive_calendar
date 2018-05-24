/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author ros_eyjahn
 */
public class WeekPanel extends JPanel{
     private JButton jcomp4;
    private JPanel contentPane;

    public WeekPanel(JPanel panel) 
    {
        contentPane = panel;
        setOpaque(true);
        setBackground(Color.BLUE);
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
    
    public void buttonText(String tmp){
        jcomp4.setText(tmp);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}
