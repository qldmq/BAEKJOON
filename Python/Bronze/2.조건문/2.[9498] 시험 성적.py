import sys

grade = int(sys.stdin.readline())

if (grade >= 90 and grade <= 100):
    print("A")
elif(grade >=80 and grade <=89):
    print("B")
elif(grade >=70 and grade <=79):
    print("C")
elif(grade >=60 and grade <= 69):
    print("D")
else:
    print("F")

# 파이썬은 스위치 문법이 없어 if문 활용
# &는 비트연산자, 논리연산자인 and 사용해야함