# 솔루션

## 통과한 코드

```python
def solution(sequence, k):
    answer = [0,0]
    n = len(sequence)
    minimum = n
    interval_sum = 0
    end = 0
    for start in range(n):
        while interval_sum < k and end < n:
            interval_sum += sequence[end]
            end += 1    
        if interval_sum == k:
            if end-start == 1:
                return [start,end-1]
            if end-start == n:
                return [start,end-1]
            if end-start < minimum:
                answer = [start,end-1]
                minimum = end-start
        interval_sum -= sequence[start]
    return answer
```

## 풀이 해설

부분 수열의 합을 구하는 문제입니다. 투 포인터를 활용하여 풀 수 있습니다.
투 포인터는 찌르면 바로 나올 정도로 익숙해져야 할 것 같습니다.

## 부족한 점

최악은 242.37ms 정도 나오는데, 더 빠르게 풀 수 있을 것 같습니다.