import sys

h, m = map(int, sys.stdin.readline().split())

m=m-45

if m < 0:
    h=h-1
    m=60+m
    if h<0:
        h=23

print(h, m)
