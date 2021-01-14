import javax.swing.JList;
import javax.swing.JOptionPane;

public class BaseConverter{
	private static String startValue;
	private static String startBase;
	private static String endBase;
	private static String [] bases = new String[] {"Binary(base 2)", "Decimal(base 10)", "Hexadecimal(base 16)"};
	private static String [] secondaryBases = new String [2];
	
	//set boolean flags for starting and ending base
	private static boolean startBinary = false;
	private static boolean startDecimal = false;
	private static boolean startHex = false;
	private static boolean endBinary = false;
	private static boolean endDecimal = false;
	private static boolean endHex = false;
	
	
	public static void main(String [] args) {
		displayMenu();
		userPrompt(startBase);
		setStartFlag();
		setEndFlag();
		
		if(startDecimal==true && endBinary== true) {
			decimalToBinary(startValue);
		}else if(startDecimal == true && endHex == true) {
			decimalToHex(startValue);
		}else if(startBinary == true && endDecimal == true) {
			int r = binaryToDecimal(startValue);
			displayOutput(startValue, r);
		}else if(startBinary == true && endHex == true) {
			binaryToHex(startValue);
		}else if(startHex == true && endBinary == true) {
			hexToBinary(startValue);
		}else if(startHex == true && endDecimal == true) {
			hexToDecimal(startValue);
		}
	}
	
	//combines startMenu and secondaryMenu to display 
	public static void displayMenu() {
		int startChoice = startMenu();
		setStartBase(startChoice);
		setSecondaryBaseList(startChoice);
		
		int endChoice = secondaryMenu();
		setEndBase(endChoice);
	}
	
	//display initial menu for conversion selection
	public static int startMenu() {
		JList list = new JList(bases);
		JOptionPane.showMessageDialog(null, list, "Start Base Selection", JOptionPane.PLAIN_MESSAGE);
		int result = list.getSelectedIndex();
		return result;
	}
	
	//establishes starting base
	public static void setStartBase(int startChoice) {
		startBase = bases[startChoice];
	}
	
	//change list according to options left
	public static void setSecondaryBaseList(int startBase) {
		if(startBase == 0) {
			secondaryBases [0] = bases[1];
			secondaryBases [1] = bases[2];
		}else if(startBase == 1) {
			secondaryBases [0] = bases[0];
			secondaryBases [1] = bases[2];
		}else if(startBase == 2) {
			secondaryBases [0] = bases[0];
			secondaryBases [1] = bases[1];
		}
	}
	
	//display menu for resulting base selection
	public static int secondaryMenu() {
		JList list = new JList(secondaryBases);
		JOptionPane.showMessageDialog(null, list, "End Base Selection", JOptionPane.PLAIN_MESSAGE);
		int result = list.getSelectedIndex();
		return result;
	}
	
	//establishes ending base
	public static void setEndBase(int endChoice) {
		endBase = secondaryBases[endChoice];
	}
	
	//prompt user for number
	public static void userPrompt(String p) {
		String prompt = "Enter "+ p + " number: ";
		startValue = JOptionPane.showInputDialog(prompt);
	}
	
	//set flag for starting base
	public static void setStartFlag() {
		if(startBase.equals(bases[0])) {
			startBinary = true;
		}else if(startBase.equals(bases[1])) {
			startDecimal = true;
		}else if(startBase.equals(bases[2])) {
			startHex = true;
		}
	}
	
	//set flag for starting base
	public static void setEndFlag() {
		if(endBase.equals(bases[0])) {
			endBinary = true;
		}else if(endBase.equals(bases[1])) {
			endDecimal = true;
		}else if(endBase.equals(bases[2])) {
			endHex = true;
		}
	}
	
	
	
	//Convert binary number to decimal number
	public static int binaryToDecimal(String b) {
		int result = 0;
		for(int i = 0;i<b.length();i++) {
			if(b.charAt(i) == '1') {
				result += Math.pow(2, b.length() - (i+1));
			}
		}
		return result;
	}
	
	//Convert binary to hexadecimal
	public static void binaryToHex(String b) {
		
	}
	
	//Convert decimal to binary
	public static void decimalToBinary(String d) {
		int [] end = new int[d.length()];
		for(int i = 0;i<d.length();i++) {
			end[i] = (int) Math.pow(10, (int)d.charAt(d.length() - (i+1)));
			System.out.println();
		}
	}
	
	//Convert decimal to Hexadecimal
	public static void decimalToHex(String d) {
		
	}
	
	//Convert hexadecimal number to binary form
	public static void hexToBinary(String h) {
		for(int i = 0; i < h.length();i++) {
			if(h.charAt(i) == '1') {
				
			}
		}
	}
	
	//Convert hexadecimal number to Decimal form
	public static void hexToDecimal(String h) {
		
	}
	
	//display converted number
	public static void displayOutput(String s, int i) {
		String ret =  s + " " + startBase + " is equal to " + i + " " + endBase;
		JOptionPane.showMessageDialog(null, ret);
	}
}
