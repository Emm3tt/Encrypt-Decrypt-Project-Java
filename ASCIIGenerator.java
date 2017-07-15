	
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class ASCIIGenerator 
{
	

	private ArrayList <String> list;
	
	
	private ArrayList<ASCIICode> codes;
	
	public ASCIIGenerator()
	{
		this.readAllASCIIData();
		this.createAllASCIICodes();
	}
	
	
	

	public ArrayList<ASCIICode> getAllCodes()
	{
		return  this.codes;
	}
	
	
	

	public ASCIICode getASCIICode(int index)
	{
	
		if(index >= 0 && index <= 255)
		{
			return this.codes.get(index);
		}
		
		return null;
	}
	
	public int getValueFromString(String symbol)
	
	{
		
		for(int i = 0; i < codes.size(); i++)
		
		{

			if(codes.get(i).getSymbol().equals(symbol))
			
			{
			
				int value = (codes.get(i)).getValue();
				return value;
			
			}
		
		}
		
		return -1;
		
		
	}
	

	private void readAllASCIIData()
	{
		ReadFile reader = new ReadFile("AsciiCodes.txt");
		
		try
		{
		         list = reader.readFile();
		      
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, 
					"", 
					"", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	private void createAllASCIICodes()
	{
		codes = new ArrayList<ASCIICode>();		
		ArrayList <String> temp = new ArrayList<String>();
		for(int i = 0; i  < list.size(); i++)
		{
			temp = getValueAndSymbol(i);
			if(!temp.isEmpty())
			{	
				int value = Integer.parseInt(temp.get(0));
				String symbol = temp.get(1);
			
				ASCIICode ascii = new ASCIICode(value, symbol);
			
				codes.add(ascii);
			}
		}
		
		
		ASCIICode space = new ASCIICode(32, " ");
		codes.add(32, space);
		
	}
	
	
	
	
	
	
	private ArrayList<String> getValueAndSymbol(int index)
	{
		ArrayList <String> valueAndSymbol = new ArrayList<String>();
		String currentASCIIString = list.get(index);
		StringTokenizer t = new StringTokenizer(currentASCIIString);
		ArrayList <String> temp = new ArrayList<String>();

		while(t.hasMoreTokens())
		{
			
			temp.add(t.nextToken()); 
		}
		
		if(temp.size() > 3) 
		{
			valueAndSymbol.add(temp.get(2));
			valueAndSymbol.add(temp.get(3));
		}
		
		return valueAndSymbol;
	}
	
	
	

}
