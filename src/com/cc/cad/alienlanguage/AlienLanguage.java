package com.cc.cad.alienlanguage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author: Qing Li
 * @Comments: Google Code Jam Practice
 * 
 * After years of study, scientists at Google Labs have discovered an alien language transmitted from a faraway planet. The alien language is very unique in that every word consists of exactly L lowercase letters. Also, there are exactly D words in this language.
 * Once the dictionary of all the words in the alien language was built, the next breakthrough was to discover that the aliens have been transmitting messages to Earth for the past decade. Unfortunately, these signals are weakened due to the distance between our two planets and some of the words may be misinterpreted. 
 * In order to help them decipher these messages, the scientists have asked you to devise an algorithm that will determine the number of possible interpretations for a given pattern.
 * A pattern consists of exactly L tokens. Each token is either a single lowercase letter (the scientists are very sure that this is the letter) or a group of unique lowercase letters surrounded by parenthesis ( and ). For example: (ab)d(dc) means the first letter is either a or b, the second letter is definitely d and the last letter is either d or c. 
 * Therefore, the pattern (ab)d(dc) can stand for either one of these 4 possibilities: add, adc, bdd, bdc.
 *
 * [Input]
 * The first line of input contains 3 integers, L, D and N separated by a space. D lines follow, each containing one word of length L. These are the words that are known to exist in the alien language. N test cases then follow, each on its own line and each consisting of a pattern as described above. You may assume that all known words provided are unique.
 *
 * [Output]
 * For each test case, output Case#X: K where X is the test case number, starting from 1, and K indicates how many words in the alien language match the pattern.
 * */
public class AlienLanguage {
	
	private static final String INPUT_DIR = "\\resource\\AlienLanguage.in"; 
	
	/*
	 * L - every word in this alien language consist of exactly L lower-case letters. 
	 * D - there are exactly D words in this language.
	 * N - number of test cases. 
	 * */ 
	private static List<Integer> getLDN(){
		
		List<Integer> list = new ArrayList<>(); 
		int L =0, D=0, N=0; 
		
		try(BufferedReader br = new BufferedReader(new FileReader(new java.io.File( "." ).getCanonicalPath().concat(INPUT_DIR)))){
			
			String line = br.readLine(); 
			
			if(line!=null){
				line = line.trim(); 
				String[] sArray = line.split(" "); 
				
				L = Integer.parseInt(sArray[0]); 
				D = Integer.parseInt(sArray[1]); 
				N = Integer.parseInt(sArray[2]); 
				
				list.add(L); 
				list.add(D); 
				list.add(N); 
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list; 	
	}
	
	// Load all the dictionary values into HashSet. 
	private static HashSet<String> alienDictoionary(){
		
		HashSet<String> set = new HashSet<String>(); 
		
		int num = getLDN().get(1); 
		
		try(BufferedReader br = new BufferedReader(new FileReader(new java.io.File( "." ).getCanonicalPath().concat(INPUT_DIR)))){
			
			// Skip the first line that contains information for L, D, N. 
			br.readLine(); 
			
			String line = null; 
			// Populate hashSet with distinct alien words
			for(int i=1; i<=num; i++){
				if((line=br.readLine())!=null){
					
					line = line.trim(); 
					set.add(line); 
				}
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return set; 
	}
	
	// Load all the test cases into a list. 
	private static List<String> alienTestCases(){
		
		List<String> list = new ArrayList<String>(); 
		
		int numD = getLDN().get(1); 
		int numN = getLDN().get(2); 
		
		try(BufferedReader br = new BufferedReader(new FileReader(new java.io.File( "." ).getCanonicalPath().concat(INPUT_DIR)))){
			
			// Skip the first line that contains information for L, D, N. 
			br.readLine(); 
			
			// Skip all lines that contains dictionary words. 
			for(int i=1; i<=numD; i++){
				br.readLine(); 
			}
			
			String line = null; 
			
			for(int i=1; i<=numN; i++){
				if((line=br.readLine())!=null){
					
					line = line.trim(); 
					list.add(line); 	
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return list; 
	}
	
	// Verify whether provided test case match dictionary value
	private static boolean matchDictionary(String test, String dictionary){
		
		boolean b = false; 
		
		String regex = null; 
		
		if(test.contains("(") && test.contains(")")){
			test = test.replace("(", "["); 
			test = test.replace(")", "]"); 
			regex = test; 		
		}else{
			regex = test; 
		}
		
		
		Pattern p = Pattern.compile(regex); 
		Matcher m = p.matcher(dictionary); 
		
		b = m.matches(); 
		
		return b; 
		
	}
	
	
	
	public static void main(String args[]){
		
		int numCase = 0; 
		Iterator<String> it = null; 
		
		for(String s: alienTestCases()){
			
			int numMatch = 0; 
			numCase++; 
			
			it = alienDictoionary().iterator(); 
			
			while(it.hasNext()){
				if(matchDictionary(s,it.next())){
					numMatch++; 
				}
			}
			
			System.out.println("Case #" + numCase + ": " + numMatch); 
		}

	}
}
