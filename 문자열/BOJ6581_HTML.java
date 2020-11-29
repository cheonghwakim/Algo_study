package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6581_HTML {
	static int length;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string = null;
		while((string = br.readLine()) != null) {
			String words[] = string.split(" |	");
			for (int i = 0; i < words.length; i++) {
			
				String tmp = words[i]; 
				if(tmp.equals("<br>")) {
					sb.append("\n");
					length = 0;
				}
				else if (tmp.equals("<hr>")) {
					if(length != 0) {
						length = 0;
						sb.append("\n");
					}
					sb.append("--------------------------------------------------------------------------------").append("\n");
				} else if(tmp.equals("")); 
				else {
					length += tmp.length();
					if(length <= 80)
						sb.append(tmp);
					
					else {
						length = tmp.length();
						sb.append("\n").append(tmp);
					}
					checkForSpace();
				}
			}
		}
		
		System.out.println(sb);
	}

	private static void checkForSpace() {
		if(length < 80) {
			sb.append(" ");
			length++;
		}
	}

}
