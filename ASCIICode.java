
public class ASCIICode 
{
	private int value; //holds the integer representation of the ASCII
	private String symbol; //holds the ASCII symbol
	
	public ASCIICode(int val, String sym)
	{
		value = val;
		symbol = sym;
	}
	
	
	public int getValue()
	{
		return this.value;
	}
	
	public String getSymbol()
	{
		return this.symbol;
	}

}
