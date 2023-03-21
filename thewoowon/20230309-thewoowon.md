# 솔루션

## 통과한 코드

```python

def solution(storey):
    answer = 0
    storey_reversed_int = [int(i) for i in str(storey).zfill(9)[::-1]]
    for index, value in enumerate(storey_reversed_int):
        if value == 0:
            continue
        n = index + 1
        if value > 5 or (5 == value and storey_reversed_int[index+1] >=5):
            answer += 10 - value
            storey_reversed_int[index + 1] += 1
        else:
            answer += value
    return answer
```

## 풀이 해설

이번 문제 자체를 이해하고 구현하기까지는 쉬웠습니다.
하지만 역시나...반례에서 시련이 있었습니다.
1, 3, 12번이 계속 오답이 나왔고 반례 확인을 결국 했습니다.

자릿수는 길이에 맞춰서 할 수도 있는데 비용이 큰 연산도 아니라서... 그냥 9자리로 맞췄습니다.
받은 층수를 문자열로 변환 후 역으로 만든 후 반복문을 돌았습니다.
enumerate를 사용해서 index와 value를 받아 5보다 크거나 5랑 같은데 뒷자리가 5 이상인 수에 대해서 if문을 사용했습니다.

여기서 정말 중요한게 앞이 5일 때, 뒤에 오는 자리의 값이 5이상인지 확인하는 것입니다.
이걸.. 생각 못하고 그냥 5는 내리고 했던 것에 패착이 있었네요 ㅎㅎㅎ...

## 부족한 점

반례 찾는 것 그리고 반례 찾기는 고통이다.
