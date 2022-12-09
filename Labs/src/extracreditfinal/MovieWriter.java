package extracreditfinal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieWriter {

	public static String createFile(Scanner input) {								// takes in a String fileName and creates the file
		boolean validInput = false;
		String fileName = "";
		
		while (!validInput) {
			System.out.print("Enter name of file to save: ");
			fileName = input.nextLine();
			
			try {
			      File newFile = new File(fileName);
			      if (newFile.createNewFile()) {
			        validInput = true;
			     
			      } else {
			        // file exists error
			      }
			      
			    } catch (IOException ex) {
			      // file error
			    }
		}
		
		return fileName;
	}
	
	public static void writeToTextFile(String fileName, ArrayList<Movie> movies) {
		try {
			FileWriter movieWriter = new FileWriter(fileName);
		     
			for (Movie movie : movies) {
				movieWriter.write(movie.toTabbedString());
				movieWriter.write("\n");
			}
		     movieWriter.close();														// closes file
		     
		} catch (IOException ex) {														// should never happen since this is already
			// file error																// checked in createFile()
		}
	}
	
}
