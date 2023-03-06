# 솔루션

## 통과한 코드

```python
def plusTenMinute(time):
    sp = time.split(":")
    hour = int(sp[0])
    minute = int(sp[1]) + 10
    if minute >= 60:
        hour += 1
        minute -= 60
    return str(hour).zfill(2) + ":" + str(minute).zfill(2)


def solution(book_time):
    book_time.sort()
    tails = []

    for book in book_time:
        if tails:
            for tail in tails:
                if tail[-1] < book[0] and plusTenMinute(tail[-1]) <= book[0]:
                    tail.append(book[1])
                    break
            else:
                tails.append([book[1]])
        else:
            tails.append([book[1]])

    return len(tails)
```

## 풀이 해설

- 예약 시작 시간 기준으로 오름차순 정렬

- 10분을 더하는 기능 분리 및 함수 생성
주의! : 예약 시작 시간이 24시 안에만 있기 때문에 23:59분 이후의 시간을 굳이 00:07 이런 식으로 계산 안해도 됨.
그래서 그냥 10분만 더해 주고 다시 문자열로만 반환.

- tails라는 2차원 배열 생성, 비어 있으면 방을 배정하고 단지 예약 마감 시간만 바라보면 됨.
주의! : 후번의 주자는 예약 시작 시간을 신경쓰지 않아도 됨.

- 오름차순 정렬된 book의 시작 시간과 tails의 시간들을 이중 for문을 활용해 순회.
- 청소까지 끝나는 시간이 나의 시작 시간보다 작거나 같으면 해당 배열에 삽입
- tails의 길이는 방의 개수, 반환

## 부족한 점

- 10분 더하는 과정을 줄일 수 있을 것 같다.
- 이중 for문으로 시간 복잡도면에서 불리함.
- 해쉬테이블이나 딕셔너리를 활용해서 성능 향상을 시킬 수 있을 것 같다.
