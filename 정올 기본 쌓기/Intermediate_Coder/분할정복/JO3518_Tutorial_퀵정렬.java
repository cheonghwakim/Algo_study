package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO3518_Tutorial_퀵정렬 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		quickSort(arr, 0, N - 1);
		System.out.println(sb);
	}

    private static void quickSort(int[] arr, int low, int high) {
        
    	if (low < high) {
	        // divide process
	        int i = low - 1;
	        int pivot = arr[high];
	        for (int j = low; j < high; j++) {
	            if (arr[j] < pivot) {
	                swap(arr, ++i, j);
	            }
	        }
	        swap(arr, ++i, high);
	        
	        for (int j = 0; j < N; j++) {
	            sb.append(arr[j]).append(" ");
	        }
	        sb.append("\n");
	
	        // conquer process
	        quickSort(arr, low, i - 1);
	        quickSort(arr, i + 1, high);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
