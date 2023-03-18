package com.classes;

import java.util.HashMap;
import java.util.Map;

public class Easy {
	
	interface Operation {
	    int calculate(int a, int b);
	}

	static final Map<String,Operation> opByName = new HashMap<String,Operation>();
	static {
	    opByName.put("+", new Operation() {
	        public int calculate(int a, int b) {
	            return a+b;
	        }
	    });
	    opByName.put("−", new Operation() {
	        public int calculate(int a, int b) {
	            return a-b;
	        }
	    });
	    opByName.put("×", new Operation() {
	        public int calculate(int a, int b) {
	            return a*b;
	        }
	    });
	    opByName.put("/", new Operation() {
	        public int calculate(int a, int b) {
	            return a/b;
	        }
	    });
	}
	
	
	public int genarateInt(int min, int max) { //method to generate random  values
		
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	public int correctAnswer(int v1, String s1, int v2, String s2, int v3) { //method of get value and calculate final answer
		
		int res = opByName.get(s1).calculate(v1, v2);
		int ans = opByName.get(s2).calculate(res, v3);
		return ans;
	}
	

}
