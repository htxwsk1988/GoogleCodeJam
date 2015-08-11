package com.cc.cad.reportintranet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Qing Li
 * @Comments: Google Code Jam Practice
 * 
 * A company is located in two very tall buildings. The company intranet connecting the buildings consists of many wires, each connecting a window on the first building to a window on the second building.
 * You are looking at those buildings from the side, so that one of the buildings is to the left and one is to the right. The windows on the left building are seen as points on its right wall, and the windows on the right building are seen as points on its left wall. 
 * Wires are straight segments connecting a window on the left building to a window on the right building.
 * 
 * [Input]
 * The first line of the input gives the number of test cases, T. T test cases follow. Each case begins with a line containing an integer N, denoting the number of wires you see.
 * The next N lines each describe one wire with two integers Ai and Bi. These describe the windows that this wire connects: Ai is the height of the window on the left building, and Bi is the height of the window on the right building.
 * 
 * [Output]
 * For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is the number of intersection points you see.
 * 
 * */
public class RopeIntranet {
	
	private static final String INPUT_DIR = "\\resource\\RopeIntranet.in"; 
	
	// Load test cases into List of List<String>.
	private static List<List<String>> initTestCase(){
		
		List<List<String>> lstAll = null; 
		
		try(BufferedReader br = new BufferedReader(new FileReader(new java.io.File( "." ).getCanonicalPath().concat(INPUT_DIR)))){
			
			lstAll = new ArrayList<List<String>>(); 
			List<String> lstNode = null; 
			
			// Read the number of test cases T. 
			int numCases = Integer.parseInt(br.readLine().trim()); 
			
			String line = null; 

			// Populate list of list with cases that contains wires. 
			while((line = br.readLine())!=null){
				
				line = line.trim(); 
				
				if(!hasWhiteSpace(line)){
					
					int numWires = Integer.parseInt(line); 
					
					lstNode = new ArrayList<String>(); 
					
					for(int i=0; i<numWires; i++){
						lstNode.add(br.readLine().trim()); 
					}
					
					lstAll.add(lstNode); 
					
				}
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return lstAll; 
		
	}
	
	// Verify whether String contains whitespace character. 
	public static boolean hasWhiteSpace(String s){
		boolean b = false; 
		
		for(char c: s.toCharArray()){
			if(Character.isWhitespace(c)){
				b = true; 
			}
		}
		
		return b; 
	}
	
	
	// Verify whether 2 wires have intersections.
	public static boolean IsRopeCross(String wire1, String wire2){
		boolean b = false; 
		
		String[] w1 = wire1.split(" "); 
		String[] w2 = wire2.split(" "); 
		
		int startA = Integer.parseInt(w1[0]); 
		int endA = Integer.parseInt(w1[1]); 
		
		int startB = Integer.parseInt(w2[0]); 
		int endB = Integer.parseInt(w2[1]); 
		
		/*
		 * In 2 situations the wires cross over each other
		 * (startA-startB) > 0 && (endA-endB) < 0
		 *  OR 
		 * (startA-startB) < 0 && (endA-endB) > 0
		 * */ 
		if((startA-startB)*(endA-endB)<0){
			b = true; 
		}
		
		return b; 
		
	}
	
	
	public static void main(String[] args) {
		
		int numCase = 0; 
		
		List<List<String>> lstCases = initTestCase(); 
		
		for(List<String> cases: lstCases){
			
			int numCross = 0; 
			numCase++; 
			
			int lstSize = cases.size(); 
			
			if(lstSize!=1){
				
				for(int i=0; i< lstSize-1; i++){
					for(int j=i+1; j< lstSize; j++){
						 
						if(IsRopeCross(cases.get(i), cases.get(j))){
							numCross++; 
						}
						
					}
				}
				
			}

			System.out.println("Case #"+ numCase + ": " + numCross); 
			
		}
		
	}
}
