# 솔루션

## 통과한 코드

```python
from collections import Counter

def solution(k, tangerine):
    answer = 0
    tangerine.sort()
    count=Counter(tangerine)
    
    for key,i in count.most_common():
        temp = i
        if k <= temp:
            answer+=1
            break
        else:
            k-=temp
        answer+=1
    
    return answer
```

## 풀이 해설

most_common()라는 메소드를 먼저 이해하기 전에 Counter를 이해해야합니다.
Counter는 배열을 받아서 Counter 객체를 반환합니다.
Counter 객체는 배열의 요소를 key로, 요소의 개수를 value로 가지는 딕셔너리입니다.
그리고 most_common()은 Counter 객체의 메소드로, value를 기준으로 내림차순으로 정렬한 배열을 반환합니다.
그래서 most_common()을 사용하면, 가장 많은 개수를 가진 key부터 정렬된 배열을 얻을 수 있습니다.

## 부족한 점

void