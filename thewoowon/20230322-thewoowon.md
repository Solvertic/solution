# 솔루션

## 통과한 코드

처음 시도는 반복이 발생, 최적화 미흡.

```python
def solution(s):
    answer = 1
    for i in range(len(s)):
        left_1 = i
        right_1 = i
        # 홀수일 때
        while left_1 - 1 >= 0 and right_1 + 2 <= len(s) and s[left_1] == s[right_1]:
            left_1 -= 1
            right_1 += 1
        answer = max(right_1 - left_1 + 1, answer)
        # 짝수일 때
        left_2 = i
        right_2 = i + 1

        while left_2 - 1 >= 0 and right_2 + 2 <= len(s) and s[left_2] == s[right_2]:
            left_2 -= 1
            right_2 += 1
        answer = max(right_2 - left_2 + 1, answer)

    return answer
```

안봐도 별로입니다. 반복을 줄이고 정리를 해봅니다.

```python
def calIteration(l,r,s):
    left = l
    right = r
    while left>=0 and right<len(s) and s[left] == s[right]:
        left-=1
        right+=1
    return right-left-1
    

def solution(s):
    answer = 1
    for i in range(len(s)):
        answer = max(answer,calIteration(i,i,s))
        answer = max(answer,calIteration(i,i+1,s))
    return answer
```

## 풀이 해설

홀수일 때, 짝수일 때를 나눠서 풀었습니다.
중간에 반복이 발생하는 것을 발견하고, 반복을 줄이고 정리했습니다.
효율성에서는 최악은  300ms 나왔긴 했는데 다른 방법으로 풀어서 줄일 수 있을 것 같아요.

## 부족한 점

올리는 코드이니 깔끔하게 보이기 위해 노력했지만, 아직 부족한 것 같습니다.
