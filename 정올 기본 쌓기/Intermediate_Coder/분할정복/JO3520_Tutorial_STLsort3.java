package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO3520_Tutorial_STLsort3 {
	static int N, Q;
	static ArrayList<Student> students = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			students.add(new Student(st.nextToken(), i + 1, Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(students);
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			sb.append(students.get(Integer.parseInt(st.nextToken()) - 1).idx).append(" ");
		}
		System.out.println(sb);
	}
	
	static class Student implements Comparable<Student> {
		String name;
		int idx;
		int priority;
		
		Student (String name, int idx, int priority) {
			this.name = name;
			this.idx = idx;
			this.priority = priority;
		}

		@Override
		public int compareTo(Student o) {
			if(o.priority != this.priority)
				return o.priority - this.priority;
			else if(o.name != this.name)
				return this.name.compareTo(o.name);
			return this.idx - o.idx;
		}
	}
}