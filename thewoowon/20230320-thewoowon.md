# 솔루션

## 통과한 코드

```python
from collections import deque

def solution(board):
    answer = 0
    R = len(board)
    C = len(board[0])
    rx, ry = 0, 0
    for i in range(R):
        for j in range(C):
            if board[i][j]=='R':
                rx, ry = i, j
                
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    def bfs():
        q = deque()
        q.append((rx, ry))
        visited = [[0]*C for _ in range(R)]
        visited[rx][ry] = 1
        
        while q:
            px, py = q.popleft()
            if board[px][py] == 'G':
                return visited[px][py]
            for i in range(4):
                nx, ny = px, py
                while True:
                    nx, ny = nx+dx[i], ny+dy[i]
                    if 0<=nx<R and 0<=ny<C and board[nx][ny]=='D':
                        nx -= dx[i]
                        ny -= dy[i]
                        break
                    if nx<0 or nx>=R or ny<0 or ny>=C:
                        nx -= dx[i]
                        ny -= dy[i]
                        break
                if not visited[nx][ny]:
                    visited[nx][ny] = visited[px][py] + 1
                    q.append((nx, ny))
        return -1
                    
    answer = bfs()
    if answer > 0:
        answer -= 1
        
    return answer
```

## 풀이 해설

"벽을 만나지 않으면 계속 직진하고, 그렇지 않으면 지나친다"
문제가 처음에 예시로 7번이 최소 횟수라고 나와있어서, 아래쪽 그리고 왼쪽만 가면 되는것 아닌가...
했는데 그것이 아니라 G를 만나더라도 근처 벽에 부딫히지 않으면 계속 직진한다는 특징이 있어서
2번이 아니라 7번의 최소 횟수가 나온다는 것을 파악하는데 5분 걸렸습니다.

dx dy를 통해서 사방위를 나타내는 경우를 만들고 방문하지 않은 노드에 한해서 큐에 넣어주는 방식으로 풀었습니다. 중간에는 사방위를 돌면서 끝지점인지 아닌지를 확인하는데, 이때 벽을 만나면 그 전 좌표를 기준으로 다시 돌아가는 방식으로 풀었습니다.


## 부족한 점

이해하는 것도 구현력도 많이...부족하다는 것이 느껴집니다.
그리고 괴물도 많다..