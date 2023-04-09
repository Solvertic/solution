# 솔루션

## 통과한 코드

```python

from collections import defaultdict

def solution(weights):
    answer = 0
    # 이부분에서 defaultdict를 사용하면, 없는 키에 대해서도 0을 반환해줍니다.
    dic = defaultdict(int)

    # 저도 답을 참고 했습니다. 이렇게 풀면 되는구나.. 라는 생각이 들었습니다.
    for weight in weights:
        # 기본적으로 weight에 해당하는 키로 먼저 접근합니다.
        # X = [ W, 2W/3, W/2, 3W/2, 3W/4, 2W, 4W/3 ]
        # answer += dic[weight]
        # answer += dic[weight * 2 / 3]
        # answer += dic[weight / 2]
        # answer += dic[weight * 3 / 2]
        # answer += dic[weight * 3 / 4]
        # answer += dic[weight * 2]
        # answer += dic[weight * 4 / 3]

        # 더 간단하게
        answer += sum([dic[weight * i] for i in [1,2/3, 1/2, 3/2, 3/4, 2, 4/3]])
        dic[weight] += 1
        
        # 그리고 weight에 해당하는 키에 1을 더해줍니다.
        dic[weight] += 1
    return answer
```

## 풀이 해설

이중 삼중으로 전체를 조사한다면 분명히 시간 초과로 통과 못합니다..
시소이고 비율이 정해져 있기 때문에, 만약 어떤 무게가 주어졌을 때,
그 무게를 만들 수 있는지 없는지를 판단하는 것이 중요합니다.

어떤 무게 W가 있습니다.

토크는 중심으로 부터 떨어진 거리와 무게의 곱으로 구할 수 있습니다.

그렇다면 어떤 무게 W는 2W, 3W, 4W의 토크를 만들 수 있고
미지의 토크 X는 2X, 3X, 4X의 토크를 만들 수 있습니다.

방정식을 활용해서 아홉 가지 조합을 구해봅시다.

- 2W = 2X -> X = W
- 2W = 3X -> X = 2W/3
- 2W = 4X -> X = W/2
- 3W = 2X -> X = 3W/2
- 3W = 3X -> X = W
- 3W = 4X -> X = 3W/4
- 4W = 2X -> X = 2W
- 4W = 3X -> X = 4W/3
- 4W = 4X -> X = W

이제 9가지 경우에서 중복을 제거하면 7가지 경우가 남습니다.

X = [ W, 2W/3, W/2, 3W/2, 3W/4, 2W, 4W/3 ]

이제 이 X를 정렬하고, 주어진 무게를 키로 하는 딕셔너리를 조회하면 됩니다.

## 부족한 점

2번의 갈아 엎음 이후, 답을 참고해서 풀었습니다. ㅎㅎ...