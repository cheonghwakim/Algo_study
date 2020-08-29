def solution(record):
    # record를 세 리스트(satus, id, alias)로 나누어 담기
    status=[]
    user_id=[]
    alias=[]
    for i in range(len(record)):
        if record[i][0]=='L':
            a,b=record[i].split(' ')
            for j in range(i):
                if user_id[j]==b:
                    c=alias[j]
        else:
            a,b,c=record[i].split(' ')
        status.append(a)
        user_id.append(b)
        alias.append(c)
    # status가 Enter이나 Change를 만나면 해당 아이디의 이전 alias기록을 갱신한다.
    for i in range(len(record)):
        if status[i]!='Leave':
            for j in range(i,-1,-1):
                if user_id[i]==user_id[j]:
                    alias[j]=alias[i]
    # Enter과 Leave기록을 문자열과 함께 리스트에 담아 출력한다.(Change는 기록남지 않는다)
    res=[]
    for i in range(len(record)):
        if status[i]=='Enter':
            res.append("%s님이 들어왔습니다." % alias[i])
        elif status[i]=='Leave':
            res.append("%s님이 나갔습니다." % alias[i])
    return res
