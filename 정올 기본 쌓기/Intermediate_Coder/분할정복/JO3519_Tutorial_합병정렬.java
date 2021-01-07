package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ** 알아두기
public class JO3519_Tutorial_합병정렬 {
	static int N, arr[], tmp[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, N - 1);
		System.out.println(sb);
	}

	private static void mergeSort(int low, int high) {
		
		// 1. base condition
		if(low >= high)
			return;
		
		// 2. 분할(divide)
		int mid = (low + high) / 2;
		
		// 3. 정복(conquer)
		mergeSort(low, mid);
		mergeSort(mid + 1, high);
		
		// 4. 결합(merge)
		int i = low, j = mid + 1, k = low;
		while(i <= mid && j <= high) {
			
			if(arr[i] <= arr[j]) 
				tmp[k++] = arr[i++];
			else 
				tmp[k++] = arr[j++];
		}

		while(i <= mid) tmp[k++] = arr[i++];
		while(j <= high) tmp[k++] = arr[j++];
		
		// 5. 복사
		for (i = low; i <= high; i++) {
			arr[i] = tmp[i];
		}
		
		for (i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.append("\n");
	}
}