n, x = map(int, input().split())

a = list(map(int, input().split()))

l = []

for i in range(len(a)):
    if a[i] < x:
        l.append(a[i])

print(" ".join(map(str, l)))    # join()메소드를 사용할 때는 리스트의 요소가 문자열이어야 함
                                # 그렇기에 join(l)로 사용할 수 없음