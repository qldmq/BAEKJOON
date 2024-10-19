import sys

num = int(sys.stdin.readline())
z = []

for i in range(num):
    a, b = map(int, sys.stdin.readline().split())
    z.append(a+b)

for i in range(num):
    print(z[i])

# python은 데이터 타입을 지정하지 않고 배열 선언
# a = [] 이런식으로 배열 선언
# a.append(1)
# a.append("abc") 이런식으로 배열에 값을 삽입
# a[1, 'abc'] 출력됨