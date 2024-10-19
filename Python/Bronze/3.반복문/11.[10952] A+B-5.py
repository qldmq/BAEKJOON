import sys

l = []

while True:
    a, b = map(int, sys.stdin.readline().split())
    if a==0 and b==0:
        break
    else:
        l.append(a+b)

for i in range(len(l)):
    print(l[i])

# print('\n'.join(map(int, l))) 이렇게 쓸수도 있음.
# '지정할 구분자'.join(구분할것)
# ex) ','.join(number) 일 때 number에 ['1', '2', '3']이 들어있다면 쉼표로 연결함