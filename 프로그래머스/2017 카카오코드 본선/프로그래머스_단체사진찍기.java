package programmers;

// 43:41:86  실패
public class 프로그래머스_단체사진찍기 {
	static char[] result, member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int totalCnt;
	static boolean[] visited;
	
	public static void main(String[] args) {
		solution(2, new String[] {"N~F=0", "R~T>2"});
		
		// {"N~F=0", "R~T>2"}
		// {"M~C<2", "C~M>1"}
	}
	
	static public int solution(int n, String[] data) {
		result = new char[8];
		visited = new boolean[8];
		
		totalCnt = 0;
		perm(0, data);
		
		return totalCnt;
	}

	private static void perm(int cnt, String[] data) {
		if(cnt == 8) {
			if(isPossible(result, data))
				totalCnt++;
			return;
		}
		
		for (int i = 0; i < member.length; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			result[cnt] = member[i];
			perm(cnt + 1, data);
			visited[i] = false;
		}
	}

	private static boolean isPossible(char[] result, String[] data) {

		for (int d = 0; d < data.length; d++) {
			
			char family1 = data[d].charAt(0);
			char family2 = data[d].charAt(2);
			
			int idx1 = 0, idx2 = 0;
			for (int i = 0; i < result.length; i++) {
				if(result[i] == family1)
					idx1 = i;
				else if (result[i] == family2)
					idx2 = i;
			}
			
			int distance = Math.abs(idx1 - idx2) - 1;
			
			if(data[d].charAt(3) == '>') {
				if(distance <= data[d].charAt(4) - '0')
					return false;
				
			} else if(data[d].charAt(3) == '<') {
				if(distance >= data[d].charAt(4) - '0')
					return false;
				
			} else {
				
				if(distance != data[d].charAt(4) - '0')
					return false;
			}
		}
		return true;
	}
}