import sys

# a = int(sys.stdin.readline())
# b = int(sys.stdin.readline())

# print(a+b)
a, b = map(int, sys.stdin.readline().split())
# a, b = map(int, input().split())
print(a+b)
# map은 for문 비슷한거라 변수 설정한만큼 돌아감
# split은 소괄호 안에 있는 것을 기준으로 나눔