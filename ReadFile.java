import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class ReadFile 
{
	
	private String fileName;
	
	public ReadFile(String fileName)
	{
		this.fileName = fileName;
	}
	
	
	public ArrayList<String>readFile() throws Exception
	{

		ArrayList<String>list = new ArrayList<String>();
		
		FileReader fstream = new FileReader(fileName);
		BufferedReader in = new BufferedReader(fstream);
		
		String value = ""; 
		while( value != null)
		{
		    value = in.readLine();
		    if(value != null)
		    {
		    		list.add(value);
		    }
		}
		
		in.close();
		
		return list;
	}
	


}
