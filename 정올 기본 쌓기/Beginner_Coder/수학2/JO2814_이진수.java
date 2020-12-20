package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO2814_이진수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String binary = br.readLine();
		System.out.println(Integer.parseInt(binary, 2));
	}
}
