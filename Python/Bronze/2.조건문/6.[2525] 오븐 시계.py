import sys

h, m = map(int, sys.stdin.readline().split())
cook = int(sys.stdin.readline())

result = m + cook

if result>=60:
    h = h + result//60  # //는 소수점 뒷자리 없이나옴
    m = result%60
    if h>=24:
        h=h%24
else:
    m = result

print(h, m)


# -------------------------------
# 다른 답안
# import sys

# h, m = map(int, sys.stdin.readline().split())
# cook = int(sys.stdin.readline())

# result = m + cook

# h = (h + result // 60) % 24  # 시간에 대한 계산
# m = result % 60  # 분에 대한 계산

# print(h, m)