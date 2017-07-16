package test;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Test {
	
	public static void main(String[] args){				
		new Test().getHint("1078", "7802");
		
	}
	public String getHint(String secret, String guess) {
	    int bulls = 0;
	    int cows = 0;
	    int[] numbers = new int[10];
	    for (int i = 0; i<secret.length(); i++) {
	        if (secret.charAt(i) == guess.charAt(i)) bulls++;
	        else {
	            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
	            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
	        }
	    }
	    return bulls + "A" + cows + "B";
	}
	
	 

}
