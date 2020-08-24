def solution(clothes):
    answer = 1
    kind = dict()

    for cloth in clothes:
        if(cloth[1] not in kind.keys()):
            kind[cloth[1]] = 1
        else:
            kind[cloth[1]] += 1

    kindCount = list(kind.values())

    for kc in kindCount:
        answer = answer * (kc+1)

    return answer-1
