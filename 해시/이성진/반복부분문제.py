# 시간초과가 발생함. 뭘 더 이상 줄일 수 있는지..,

import sys
sys.stdin=open("input.txt","rt")

lenBuns=int(input())
buns=input()
lt=0
rt=lenBuns
while lt<=rt:
    mid=(lt+rt)//2
    d=dict()
    for i in range(lenBuns-mid+1):
        tmp=buns[i:mid+i]
        if tmp not in d.keys():
            d[tmp]=1
        else:
            lt=mid+1  
            break
    else:
        rt=mid-1
if mid!=0:
    print(mid)
else:
    print(0)
