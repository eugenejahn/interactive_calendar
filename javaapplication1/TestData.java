/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;

/**
 *
 * @author ros_eyjahn
 */
public class TestData {
    public static void main(String[] args) {
                
		DateData crunchify = new DateData();
		crunchify.setDate("16-2-1");
		crunchify.setData( new String[] {"1","2","3","4"});
 
		// Save data to file
                StoreData store = new StoreData();
		store.crunchifyWriteToFile(crunchify.getDate(),crunchify);
		
		// Retrieve data from file
		DateData result = store.crunchifyReadFromFile("16-2-3");
                
                log("--------------");
                        
		log("Company Name: " + result.getDate());
		String[] employee = result.getData();
		log("# of Employees: " + Arrays.toString(employee));
	}
    
    public static void log(String string) {
		System.out.println(string);
	}
}
