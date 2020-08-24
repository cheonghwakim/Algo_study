# 듣보잡 (https://www.acmicpc.net/problem/1764)

import sys
n,m = map(int, input().split())
#한줄에 입력값 받는 법
n_list = set([sys.stdin.readline().strip() for i in range(n)])
m_list =set([sys.stdin.readline().strip() for i in range(m)]) 
res = sorted(list(n_list&m_list))
print(len(res))
for i in res:
    print(i)
