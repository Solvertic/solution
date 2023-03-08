# 솔루션

## 통과한 코드

```python

class Node(object):
    def __init__(self, info):
        self.value = info[2]
        self.pos = info[:2]
        self.left = None
        self.right = None

def add_node(parent, info):
    if parent.pos[0] > info[0]:
        if parent.left:
            add_node(parent.left, info)
        else:
            parent.left = Node(info)
    else:
        if parent.right:
            add_node(parent.right, info)
        else:
            parent.right = Node(info)


def solution(nodeinfo):
    answer = [[]]
    # value가 될 값을 마지막에 넣어줌.
    for index in range(len(nodeinfo)):
        nodeinfo[index].append(index + 1)
    nodeinfo.sort(key=lambda x: (-x[1], x[0]))
    # 트리 초기화
    t = Node(nodeinfo[0])
    for info in nodeinfo[1:]:
        add_node(t, info)

    return [pre_order(t), post_order(t)]


def pre_order(curr):
    path = [curr.value]
    if curr.left:
        path += pre_order(curr.left)
    if curr.right:
        path += pre_order(curr.right)
    return path


def post_order(curr):
    path = []
    if curr.left:
        path += post_order(curr.left)
    if curr.right:
        path += post_order(curr.right)
    path.append(curr.value)
    return path
```

## 풀이 해설

(퇴근 시간 후에 풀고 나면 시간이 늦어지네요...ㅠㅠ)
레벨 3인 이유가 전위와 후위를 알고 있고 구현할 수 있는지인 것 같습니다.
가장 먼저 고전 적인 방법으로 Node 객체를 만들고 트리를 만들어야 한다고 생각했습니다.
트리를 완성한다음에 전위와 후위를 돌면 끝이긴 한데... 재귀적으로 전위와 후위를
구현하는 것을 잊어버린지 오래였기 때문에 보고... 했습니다.

구현한 코드 자체는 두 문제가 계속 런타임 에러가 났는데, 다른 분들의 코드를 보고 sys.setrecursionlimit(number)의 개념을 처음 알았어요.

재귀의 최대 깊이를 제한 해주는 스킬도 생긴 것 같아 많이 배우는 시간이네요.

## 부족한 점

전위와 후위, 중위 잊어버리고 있었던 개념들이 많았습니다.
