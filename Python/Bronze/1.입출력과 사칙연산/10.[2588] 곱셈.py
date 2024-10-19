import sys

a = int(sys.stdin.readline())
b = sys.stdin.readline()    # 한자리씩 배열을 통해서 구해야하기 때문에 b는 int로 받지 않고 문자열로 받음

print(a * int(b[2]))
print(a * int(b[1]))
print(a * int(b[0]))
print(a * int(b))

# 먼저 입력된 수에 두번째 입력된 수의 세번째 자리 수를 곱하고, 그다음은 두번째, 첫번째 순으로 곱한값을 줄바꿈하여 출력
