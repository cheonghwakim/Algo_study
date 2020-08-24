import sys
sys.stdin=open("input.txt","rt")

lenBuns=int(input())
buns=input()

maxBun=lenBuns
while maxBun>2:
    maxBun-=1
    d={}
    for i in range(lenBuns-maxBun+1):
        tmp=buns[i:maxBun+i]
        d[tmp]=d.get(tmp,0)+1
        if d[tmp]==2:
            print(len(tmp))
            sys.exit()
else:
    print(0)

