import sys

T = int(sys.stdin.readline())
la = []
lb = []

for i in range(T):
    a, b = map(int, sys.stdin.readline().split())
    la.append(a)
    lb.append(b)

for i in range(T):
    print(f'Case #{i+1}: {la[i]} + {lb[i]} = {la[i] + lb[i]}')