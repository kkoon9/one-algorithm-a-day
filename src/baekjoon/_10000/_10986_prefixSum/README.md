# 10986 나머지 합

[링크](https://www.acmicpc.net/problem/10986)

| 난이도 | 정답률(\_%) |
|:--:|:--------:|
|  골드 3  |  28.951  |

## 설계

### 나머지 공식과 경우의 수 공식
- (A+B) % C 은 ((A % C) + (B%C)) % C 와 같다.
- 즉, 나머지가 같은 개수를 구한 뒤,그 개수로 2개를 뽑는 경우의 수를 구하면 된다.
- 2개를 뽑는 경우의 수 공식 : A * (A-1) / 2



## 시간

| 내 코드 (ms) | 빠른 코드 (ms) |
|:---------:|:----------:|
|    516    |      184      |

## 꼭 알아둬야 할 점
- 경우의 수 공식과 나머지 공식을 외워두자.
