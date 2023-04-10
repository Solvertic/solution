# 솔루션

## 통과한 코드

```python
from collections import deque
# 이런 방식이 익숙하지 않았음.
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]

def bfs(maps, i, j, visited):
    # 갱신
    visited[i][j] = 1
    queue = deque([[i,j]])
    count = 0
    while queue:
        i, j = queue.popleft()
        count += int(maps[i][j])
        for d in range(4):
            x, y = i + dx[d], j + dy[d]
            if not(0 <= x < len(maps) and 0 <= y < len(maps[0])): continue
            if visited[x][y] == 0 and maps[x][y] != 'X':
                queue.append([x, y])
                visited[x][y] = 1
    return count


def solution(maps):
    answer = []
    # 문자열 분리
    for i in range(len(maps)):
        maps[i] = list(maps[i])
    # 파이썬 언더바, 파이썬 배열 설정
    visited = [[0] * len(maps[0]) for _ in range(len(maps))]
    # 전수 조사 / mutable한 visited 갱신
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            # 조건 확인 / 바다가 아니고 아직 방문하지 않은 곳 
            if maps[i][j] != 'X' and visited[i][j] == 0:
                # 파라미터 구성, maps, 갱신용 좌표, visited
                answer.append(bfs(maps, i, j, visited))
    if answer:
        return sorted(answer)
    else:
        return [-1]
```

## 풀이 해설

bfs를 활용한 전형적인 완탐 문제입니다.
메모이제이션을 활용하여 중복된 연산을 줄이는 것이 핵심입니다. => visited

## 부족한 점

4방향 탐색에서 일일이 if로 조건을 걸어주는 것이 아닌, dx, dy를 활용하여 for문을 돌려주는 것이 더 효율적이네요.

```python
for i in range(4):
    x, y = i + dx[i], j + dy[i]
    if not(0 <= x < len(maps) and 0 <= y < len(maps[0])): continue
    if visited[x][y] == 0 and maps[x][y] != 'X':
        queue.append([x, y])
        visited[x][y] = 1
```