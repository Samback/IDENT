import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author sebek
 *
 */

public class Calculation {
	private String filePathName;	
	private Integer NumberOfColumns;
	private Integer NumberOfFields;
	private Double inputMatrix [][];


	public Calculation(String fileP, Integer numberOfX) throws IDENTException {
		filePathName = fileP;
		NumberOfColumns = numberOfX;	
		NumberOfFields  = calculateNumberOfFieldsInFile();

		inputMatrix = new Double [NumberOfColumns -1][];
		for (int i = 0; i < NumberOfFields; i++)
		{
			inputMatrix[i] = new Double [NumberOfColumns];
			for (int j = 0; j < NumberOfColumns; j++)
				inputMatrix[i][j] = new Double(0);			
		}
		fillInputMatrix();			
		for (int i = 0; i < inputMatrix.length; i++)
		{
			for(int j = 0; j < inputMatrix[i].length; j++)
				System.out.print(" "+ inputMatrix[i][j]);
			System.out.println();
		}
		
		
		
	}
	
	public void fillInputMatrix() throws IDENTException
	{
		int n = 0;
		int i = 0;
		int j = 0;
		Scanner inpfile;	
		try {
			inpfile = new Scanner(
					new BufferedReader(new FileReader(filePathName)));

			while (inpfile.hasNext()) 
			{
				
				if (n < NumberOfColumns ) 
				{
					inputMatrix[i][n] = new Double(inpfile.next());
					n++;
				}
				else
				{
					n = 0;
					i++;
					inputMatrix[i][n] = new Double(inpfile.next());
					n++;
				}
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new IDENTException("File not found");
		}
				
	}

	public Integer calculateNumberOfFieldsInFile() throws IDENTException
	{
		int i = 0;
		Scanner inpfile;	
		try {
			inpfile = new Scanner(
					new BufferedReader(new FileReader(filePathName)));

			while (inpfile.hasNext()) 
			{
				inpfile.next();
				i++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new IDENTException("File not found");
		}
		if (i % NumberOfColumns != 0)
			throw new IDENTException("Icorect data!");
		return i/ NumberOfColumns;
	}

}
