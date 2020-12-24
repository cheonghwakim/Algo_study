package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BOJ2108_통계학 {
	static int N, nums[], cnt[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		cnt = new int[500001];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		int mid = 0, max = 0, range = 0;
		double avg = 0.0;
		for (int i = 0; i < N; i++) {
			if(i == 0) range -= nums[i];
			if(i == N - 1) range += nums[i];
			if(i == N / 2) mid = nums[i];
			
			avg += nums[i];
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		avg /= N;
		for (int key : map.keySet()) {
			if(max < map.get(key)) {
				max = map.get(key);
			}
		}
		
		ArrayList<Integer> bin = new ArrayList<>();
		for (int key : map.keySet()) {
			if(max == map.get(key)) {
				bin.add(key);
			}
		}
		
		Collections.sort(bin);
		int maxbin = 0;
		if(bin.size() == 1)
			maxbin = bin.get(0);
		else
			maxbin = bin.get(1);
		
		sb.append(Math.round(avg)).append("\n").append(mid).append("\n").append(maxbin).append("\n").append(range);
		System.out.println(sb);
	}
}
