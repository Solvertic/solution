# 솔루션

## 통과한 코드

```python
def solution(numbers):
    stack = []
    answer = [0] * len(numbers)

    for i in range(len(numbers)):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
    while stack:
            answer[stack.pop()] = -1
    
    return answer
```

## 풀이 해설

이중 for문으로 배열의 크기를 줄여가는 단순한 생각
효율성이 좋지 못한 문제 발생.
스택을 활용해서 원소보다 큰 부분을 슬라이싱해서 탐색하는 것이 아니라,
작은 것들을 확인하며 탐색하는 것이 보다 효율적.

## 부족한 점

변형