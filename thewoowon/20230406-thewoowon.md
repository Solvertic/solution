# 솔루션

## 통과한 코드

```python
def solution(n, works):
    if len(works) == 1:
        if works[0]-n < 1:
            return 0
        else:
            return (works[0]-n)**2
    works.sort(reverse=True)
    t = n
    while t:
        m = works[0]
        for iter,value in enumerate(works):
            if value == m:
                works[iter] -= 1
                t -= 1
                if t == 0:
                    break
            else:
                break
    return sum([i**2 if i >0 else 0 for i in works])
    
```

## 풀이 해설

시소짝꿍보다 쉽게 풀렸습니다.

## 부족한 점