/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ros_eyjahn
 */
public class WeekPanel extends JPanel{
    
    private JButton returnButton;
    private JPanel contentPane;
    private Calendar calendar;
    private JTable table;
    private DateData firstDateData;
    private String firstDate;
    
    private DateData[] weekData = new DateData[7];
    private String [] weekDate = new String[7];
    private Object weekColumnNames[] = { "Time/Date", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun" };
    
    private Object weekRowData[][] =  { {"1","","","","","","",""},
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
            {"21","","","","","","",""},
            {"22","","","","","","",""},
            {"23","","","","","","",""},
            {"24","","","","","","",""},
    };
    
    public WeekPanel(JPanel panel) 
    {
        
        setBackground(Color.GREEN);
        setLayout(new BorderLayout());
        
        table = new JTable(weekRowData, weekColumnNames);
        table.setRowHeight(25);
        table.setPreferredSize(new Dimension(800,650));
        table.setBackground(Color.LIGHT_GRAY);
  
        tableListener();
   
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(800,650));
    
        contentPane = panel;

        returnButton = new JButton ("Return");
        buttonText("Return");
        returnButton.setSize(10, 10);
        returnButtonListener();
   
        JTable colorTable = new JTable(new Object[][] {{"RED","SLEEPING","R"},{"BLUE","FREE TIME","B"},{"GREEN","WORK","G"},{"YELLOW","EATING","Y"},{"ORANGE","READING","O"}}, new Object[] {"COLOR","DESCRIPITION","CODE"});
        colorTable.setBackground(Color.cyan);
        JScrollPane colorScrollPane = new JScrollPane(colorTable);

        
        // add the week panel into the panel
        add(scrollPane,BorderLayout.WEST);
        add(colorScrollPane,BorderLayout.CENTER);
        add(returnButton,BorderLayout.EAST); 
        
        
        
    }
    
   
    
    public void buttonText(String tmp){
        returnButton.setText(tmp);
    }
    
    private void returnButtonListener(){
    	returnButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                StoreData store = new StoreData();
                for(int j = 0; j<7;j++){
                	String[] tmp = weekData[j].getData(); 
                    for(int i =0;  i <24;i ++){
                        tmp[i] = (String) table.getValueAt(i,j+1);
                    }
                    weekData[j].setData(tmp);
//                    System.out.println("=---------------------------------------=");
//                    System.out.println(weekData[j].getDate());
//                    System.out.println(Arrays.toString(weekData[j].getData()));
                    store.crunchifyWriteToFile(weekDate[j], weekData[j]);
                	
                }
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });
    }
    
    // it is the litener and changes the color of the cell
    private void tableListener(){
    	table.setCellSelectionEnabled(true);
    	ListSelectionModel cellSelectionModel = table.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    	cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
    		public void valueChanged(ListSelectionEvent e) {
    			String selectedData = null;

    			int selectedRow = table.getSelectedRows()[0];
    			int selectedColumns = table.getSelectedColumns()[0];

    			selectedData = (String) table.getValueAt(selectedRow, selectedColumns);
    			table.getColumnModel().getColumn(selectedColumns).setCellRenderer(new ColorRenderer());
    		}
    	});
    }
    
    // the date data is passed by this method, so the values of year month and day are value of the date that user click 
    public void setDate(int year , int month , int day){
    
        calendar = new GregorianCalendar(year,month-1,day);
        int DayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(DayOfWeek + "-------------------------");
        if(DayOfWeek == 1)
            calendar.add(Calendar.DATE, -6);
        else   
            calendar.add(Calendar.DATE, -DayOfWeek+2);
        
        for(int i = 1; i < 8;i++){
        	weekDate[i-1]=  calendar.get(Calendar.YEAR) + "-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH);
            calendar.add(Calendar.DATE, 1);
            changeName(i,  weekColumnNames[i] + " " + weekDate[i-1]);
            weekData[i-1] =  getDateData(weekDate[i-1]);
            for(int j =0;  j <24;j ++){
                table.setValueAt( weekData[i-1].getData()[j],j,i);
            }
            table.getColumnModel().getColumn(i).setCellRenderer(new ColorRenderer());
        }    	
    }
    
    private DateData getDateData(String date){
        StoreData store = new StoreData();
        return store.crunchifyReadFromFile(date);
    }
   
    public void changeName(int col_index, String col_name){
    	  table.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
    }
}



//change the color by this class
class ColorRenderer extends DefaultTableCellRenderer{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// if the cell is selected then the color should be same as backgorund
                Color setColor;
                String boxValue =  value.toString() ;
                System.out.println(column+ "cloumn !!!!!!!!!!");
                

		if (isSelected){
                        
				// if the box value equal this then change color to this
				if (boxValue.equalsIgnoreCase("r"))
					setColor = Color.RED ;
				else if (boxValue.equalsIgnoreCase("b"))
					setColor = Color.BLUE ;
				
				else if (boxValue.equalsIgnoreCase("g"))
					setColor=  Color.GREEN ;
				
				else if (boxValue.equalsIgnoreCase("y"))
					setColor =( Color.YELLOW );
				
				else if (boxValue.equalsIgnoreCase("o"))
					setColor = ( Color.ORANGE );
                                else
                                    setColor = table.getSelectionBackground();
                                
			setBackground( bleach(setColor,0.8f) );
			//         setBackground( Color.gray );
		}
             
           else{
                    if (boxValue.equalsIgnoreCase("r"))
					setColor = Color.RED ;
				else if (boxValue.equalsIgnoreCase("b"))
					setColor = Color.BLUE ;
				
				else if (boxValue.equalsIgnoreCase("g"))
					setColor=  Color.GREEN ;
				
				else if (boxValue.equalsIgnoreCase("y"))
					setColor =( Color.YELLOW );
				
				else if (boxValue.equalsIgnoreCase("o"))
					setColor = ( Color.ORANGE );
                                else
                                    setColor = table.getSelectionBackground();
                                setBackground( setColor );
                }
		return this;
	}
        
        public static Color bleach(Color color, float amount)
        {
            int red = (int) ((color.getRed() * (1 - amount) / 255 + amount) * 255);
            int green = (int) ((color.getGreen() * (1 - amount) / 255 + amount) * 255);
            int blue = (int) ((color.getBlue() * (1 - amount) / 255 + amount) * 255);
            return new Color(red, green, blue);
        }
}


