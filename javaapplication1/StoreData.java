/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author ros_eyjahn
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
 
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * @author Crunchify.com 
 * Best and simple Production ready utility to save/load
 *         (read/write) data from/to file
 */
 
public class StoreData {
    

	private static Gson gson = new Gson();

	// Save to file Utility
	public  void crunchifyWriteToFile(String date, DateData data) {
		
		String crunchify_file_location = "data/"+ date + ".txt";
                   
		File file = new File(crunchify_file_location);
  
                  
		try {
        
			// Convenience class for writing character files
            
			FileWriter crunchifyWriter;
            
			crunchifyWriter = new FileWriter(file.getAbsoluteFile(), false);
                        
            
			// Writes text to a character-output stream
            
			BufferedWriter bufferWriter = new BufferedWriter(crunchifyWriter);
            
			bufferWriter.write(gson.toJson(data));
            
			bufferWriter.close();
             
			log("Company data saved at file location: " + crunchify_file_location + " Data: " + data + "\n");
            
		} catch (IOException e) {
			log("Hmm.. Got an error while saving Company data to file " + e.toString());   
		}
        
		file.exists();
	}
 
	// Read From File Utility
	public  DateData crunchifyReadFromFile(String date) {
      
		DateData result = new DateData();
        
		result.setDate(date);
        
		result.setData(new String[] {"","","","","","","","","","","","","","","","","","","","","","","",""});
        
		String crunchify_file_location = "data/"+ date + ".txt"; 
		File crunchifyFile = new File(crunchify_file_location);
		if (!crunchifyFile.exists()){
			try {
				File directory = new File(crunchifyFile.getParent());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				crunchifyFile.createNewFile();
                 
				FileWriter crunchifyWriter;
                
				crunchifyWriter = new FileWriter(crunchifyFile.getAbsoluteFile(), true);
 
			// Writes text to a character-output stream
            	
				BufferedWriter bufferWriter = new BufferedWriter(crunchifyWriter);
                
				bufferWriter.write(gson.toJson(result));
                
				bufferWriter.close();
			} catch (IOException e) {
				log("Excepton Occured: " + e.toString());
			}
                
		}else{

			InputStreamReader isReader;
            
			try {
			
				isReader = new InputStreamReader(new FileInputStream(crunchifyFile), "UTF-8");

				JsonReader myReader = new JsonReader(isReader);
                      
				result = gson.fromJson(myReader, DateData.class);
            
			} catch (Exception e) {        
				log("error load cache from file " + e.toString());
			}
		}
		log("\nComapny Data loaded successfully from file " + crunchify_file_location);                
		crunchifyFile.exists();
		return result; 
	}
 
	private  void log(String string) {
		System.out.println(string);
	}
 
}


