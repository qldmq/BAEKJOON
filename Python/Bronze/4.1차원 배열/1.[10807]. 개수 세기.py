import sys

n = int(sys.stdin.readline())
l = []

l = list(map(int, sys.stdin.readline().split()))

v = int(sys.stdin.readline())

cnt = l.count(v)
print(cnt)


# ----------------------------
# 답지
# n = int(input())
# n_list = list(map(int, input().split()))
# v = int(input())
# print(n_list.count(v))
