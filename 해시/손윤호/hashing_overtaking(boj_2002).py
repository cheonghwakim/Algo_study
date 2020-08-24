# 추월 (https://www.acmicpc.net/problem/2002)

##import sys
##sys.stdin = open("input.txt")

n = int(input())
before = dict()
after = dict()
cnt = 0

# 적재 
for i in range(n):
    before[input()] = i

for i in range(n):
    after[input()] = i

##print(before)
##print(after)
    
# 판별
for key,val in before.items():
    print(before[key],after[key])
    if before[key] > after[key]:
        cnt+=1

print(cnt)

