public class Cryptic 
{

	private String keyCode;
	private ASCIIGenerator asciiGen;
	
	public Cryptic()
	
	{
		
		asciiGen = new ASCIIGenerator();
		keyCode = "MONDAY";
		//The shift values are as follows
		//M = 9, O = 2, N = 0, D = 1, A = 7, Y = 5
	}
	
	 
	//Converts a single character String into a coded String
	public String getCode(String sourceChar, String keyChar)
	
	{
		
		String coded = "";
		int value = asciiGen.getValueFromString(sourceChar);
		
		if(keyChar.equals("M"))
			
		{
			
			value+=9;
			
		}
		
		else if(keyChar.equals("O"))
			
		{
			
			value+=2;
			
		}
		
		else if(keyChar.equals("N"))
			
		{
			
			value+=0;
			
		}
		
		else if(keyChar.equals("D"))
			
		{
			
			value+=1;
			
		}
		
		else if(keyChar.equals("A"))
			
		{
			
			value+=7;
			
		}
		
		else if(keyChar.equals("Y"))
			
		{
			
			value+=5;
			
		}
		
		coded = asciiGen.getASCIICode(value).getSymbol();
		
		return coded;
	}
	
	//Converts coded single character String back into the message
	public String getSource(String codedChar, String keyChar)
	{
		String message = "";
		
		
		
		int value = asciiGen.getValueFromString(codedChar);
		
		
		if(keyChar.equals("M"))
			
		{
			
			value-=9;
			
		}
		
		else if(keyChar.equals("O"))
			
		{
			
			value-=2;
			
		}
		
		else if(keyChar.equals("N"))
			
		{
			
			value-=0;
			
		}
		
		else if(keyChar.equals("D"))
			
		{
			
			value-=1;
			
		}
		
		else if(keyChar.equals("A"))
			
		{
			
			value-=7;
		}
		
		else if(keyChar.equals("Y"))
			
		{
			
			value-=5;
			
		}
		
		message = asciiGen.getASCIICode(value).getSymbol();
		
		return message;
	}
	
	//Converts an entire message into a coded message
	public String encrypt(String source, String key)
	{
		String encrypted = "";
		
		String temp = null;
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < source.length(); i++)
		{
			if(source.length()<= 6)
			{
				temp = getCode(source.substring(i, i+1), keyCode.substring(i, i+1));
				 
			}
			else 
			{
				int x = i % 6;
				temp = getCode(source.substring(i, i+1), keyCode.substring(x, x+1));
			}
		
			str.append(temp);
			encrypted = String.valueOf(str);
		}
		
		return encrypted;
	}
	
	//Convert a coded message back into the original message
	public String decrypt(String coded, String key)
	{
		String decrypted = "";
		
		String temp = null;
		StringBuilder str = new StringBuilder();
		
		for(int i=0; i< coded.length(); i++)
			
		{
			
			if(coded.length()<= 6)
				
		{
				
			 temp = getSource(coded.substring(i, i+1), keyCode.substring(i, i+1));
			 
		}
			
		else 
			
		{
			
			int x = i % 6;
			temp = getSource(coded.substring(i, i+1), keyCode.substring(x, x+1));
		
		}
			
			str.append(temp);
			decrypted = String.valueOf(str);
			
		}
		
		return decrypted;
	}
	
}
