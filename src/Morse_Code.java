/**
 * Morse code decoding program
 * By Shane Leinbach
 * Takes an input morse code line and takes out all possible letters of the given line of morse code
 * Created 10/3/2018 
 */
import java.io.*;
import java.util.*;
public class Morse_Code {

	/*Hash map created to store the array list and make them easier to compare Shown to me by @Jacob Brown*/
	static HashMap <String , String> Morsecode = new HashMap<>();
	
	/*ArrayList of the morse symbols and the alphabet*/
	static String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
			"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
			"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--..", ".----", "..---", "...--", "....-", ".....",
			"-....", "--...", "---..", "----.", "-----"};
	static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "0"};
	
	
	/*Main body for program that takes the given morse code and does all the calling to the decoding methods*/
	public static void main(String[] args) 
	{
		/* Goes through and adds the letters and morse symbols to the hash map
		 * @Jacob Brown*/
		for(int i = 0 ; i <alphabet.length ; i++)
		{
			Morsecode.put(morseCodes[i], alphabet[i]);
		}
		
		
		solveMorse("-.-.-" , ""); /*Runs the program*/
	}
	
	
	/*Solves morse string through recusrsion
	 * @param input is the morse code
	 * @param ouput it the empty string to return answers
	 * @param adder is the decoded characters that are added to the 
	 **/
	public static void solveMorse(String input , String output)
	{
		if(input.length() == 0)
			{
				System.out.println(output);
			}
		for(int i = 1; i <=input.length() ; i++)
			{
			/*Runs through the input string and takes all possible combinations of the first symbol and then the following symbols*/
				String adder = decode(input.substring(0, i));
				if(adder.length() != 0)
					{
						solveMorse(input.substring(i) , output+adder);
					}
			}
	}
	
	
	/*Decoding method
	 * Takes the input substring and translate it into the letter that corresponds to the given substirng of the original
	 * morse code string
	 */
	public static String decode(String start)
	{
		if(!Morsecode.containsKey(start))
		{
			return "";
		}
		else {
			return Morsecode.get(start);
		}
	}
}

/*What are you looking at down here?
 * Scroll up and look at the code*/