package com.prospecta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringJoiner;

public class CSVCalculator {
	public static void main(String[] args) throws IOException {
		inputFile();
	}

	/**
	 * 
	 * To retrieve the data from the input file and perform the operation to evaluate data
	 * and call the outputFile method to store the results in output file
	 * 
	 * 
	 */
	private static void inputFile() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
        try {
        	FileReader fr = new FileReader(new File("input.csv"));
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!= null&&line.trim().length()!=0) {
                String[] ar = line.trim().split("\\,\\s+");
                for (int i = 0; i < ar.length; i++) {
                    String[] re = ar[i].trim().split(":");
                    
                    if (re[1].trim().startsWith("=")) { 
                    	
                    	int res = evaluate(map,re[1].trim().substring(1));
                        map.put(re[0], res);
                    } else {
                    	
                        map.put(re[0],Integer.parseInt(re[1].trim()));
                    }
                }  
                
            }
          
            outputFile(map);
            br.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		
	}

	/**
	 * To store the evaluated data in the output.csv file
	 * @param map
	 */
	private static void outputFile(Map<String, Integer> map) {
		System.out.println("output file");
		try {
			File file = new File("output.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			StringJoiner string = new StringJoiner(",");
			for(String a : map.keySet()) {
				string.add(a+":"+map.get(a));
			}
			System.out.println(string);
			bw.append(string.toString());
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Is to evaluate the operations
	 * 
	 * @param map
	 * @param formula
	 * @return 
	 */
	private static int evaluate(Map<String, Integer> map, String formula) {
		// TODO Auto-generated method stub
		List<String> operators = new ArrayList<>();
	    
		for(int i=0;i<formula.length();i++) {
			if(formula.charAt(i)=='+') {
				operators.add("+");

			}
			else if(formula.charAt(i)=='-') {
				operators.add("-");
			}
			else if(formula.charAt(i)=='/') {
				operators.add("/");
			}
			else if(formula.charAt(i)=='*') {
				operators.add("*");
			}
		}
		
		
		 String[] tokens = formula.split("[\\+\\-\\*/]");
		 
		 List<Integer> values = new ArrayList<>();
		 
		 for(int i=0;i<tokens.length;i++) {
			 
			 if(isInteger(tokens[i])) {
				 values.add(Integer.parseInt(tokens[i]));
			 }else {
				 
				 values.add(map.get(tokens[i]));
			 }
		 }
		 if(values.isEmpty()) {
			 return 0;
		 }
		 int sum = values.get(0);
		 int i = 1,j=0;
		 while(i<values.size()) {
			 int value2 = values.get(i);
			 String op = operators.get(j);
			 sum = operations(sum,value2,op);
			 i++;
			 j++;
			 
		 }
		 
		 return sum;
		
	}
	
	/**
	 * To do arithmetic operations
	 * 
	 * @param a
	 * @param b
	 * @param op
	 * @return
	 */
	private static int operations(int a, int b, String op) {
		// TODO Auto-generated method stub
		int sum = 0;
		switch(op) {
			case "*":
				sum = a*b;
				break;
			case "+":
				sum = a+b;
				break;
			case "-":
				sum = a-b;
				break;
			case "/":
				if(b!=0) {
					sum= a/b;
				}
				break;
				
		}
		return sum;
	}

	
	
	/**
	 * Is to check whether the string is number or not
	 * 
	 * @param str 
	 * @return
	 * 
	 */
	public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
