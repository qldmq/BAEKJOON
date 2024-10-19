import sys

T = int(sys.stdin.readline())

l = []
for i in range(T):
    a, b = map(int, sys.stdin.readline().split())
    l.append(a+b)

for i in range(T):
    print(l[i])