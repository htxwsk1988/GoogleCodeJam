package com.cc.cad.t9spelling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/*
 * @Author: Qing Li
 * @Comments: Google Code Jam Practice
 * 
 * The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. 
 * We would like to make it easier to write a message to your friend using a sequence of keypresses to indicate the desired characters. 
 * The letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22. 
 * In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second time. 
 * The space character ' ' should be printed to indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B.
 * */

public class T9Spelling {
	
	private static final String INPUT_DIR = "\\resource\\T9Spelling.in"; 
	
	private static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	/*
	 * Translate String contents into number sequences.
	 * */
	private static String tranStrToNum(String message){

		String result=""; 
		
		for(char c: message.toCharArray()){
			// Put the space character as a pause between characters with same keys.
			if(result.endsWith(tranCharToNum(c).substring(0, 1))){
				result = result + " " +tranCharToNum(c); 
			}else{
				result = result + tranCharToNum(c); 
			}		
		}	
		
		return result; 
	}
	
	/*
	 * Map each Latin alphabet character with corresponding String type numbers.
	 * */
	private static String tranCharToNum(char c){
		
		String sNum = ""; 
		
		switch(c){
			case 'a': sNum="2"; 
					break; 
					
			case 'b': sNum="22"; 
					break; 	
						
			case 'c': sNum="222"; 
					break; 
					
			case 'd': sNum="3"; 
					break; 
					
			case 'e': sNum="33"; 
					break; 
					
			case 'f': sNum="333"; 
					break; 
					
			case 'g': sNum="4"; 
					break; 
			
			case 'h': sNum="44"; 
					break; 
					
			case 'i': sNum="444"; 
					break; 
					
			case 'j': sNum="5"; 
					break; 
	
			case 'k': sNum="55"; 
					break; 
					
			case 'l': sNum="555"; 
					break; 
					
			case 'm': sNum="6"; 
					break; 
					
			case 'n': sNum="66"; 
					break; 
			
			case 'o': sNum="666"; 
					break;
					
			case 'p': sNum="7"; 
					break;
					
			case 'q': sNum="77"; 
					break;
					
			case 'r': sNum="777"; 
					break;
					
			case 's': sNum="7777"; 
					break;
					
			case 't': sNum="8"; 
					break;
			
			case 'u': sNum="88"; 
					break;
					
			case 'v': sNum="888"; 
					break;
					
			case 'w': sNum="9"; 
					break;
					
			case 'x': sNum="99"; 
					break;
			
			case 'y': sNum="999"; 
					break;
					
			case 'z': sNum="9999"; 
					break;
					
			case ' ': sNum="0"; 
					break; 
			
			default: sNum= c + ""; 
					break; 
					
		}
			
		return sNum; 
		
	}
	

	public static void main(String[] args) {

		try(BufferedReader br = new BufferedReader(new FileReader(new java.io.File( "." ).getCanonicalPath().concat(INPUT_DIR)))){
			
			String line = ""; 
			String token = ""; 
			
			while((line = br.readLine())!=null){
				
				token = line.trim(); 
				
				if(!isNumeric(token)){
					System.out.println(tranStrToNum(line)); 
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}