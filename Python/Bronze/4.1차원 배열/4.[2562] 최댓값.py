num_list = []

for i in range(9):
    num_list.extend(map(int, input().split()))
# for문 안에 num_list를 만들면 마지막에 입력한 값만 저장되기 때문에 for문 밖에 리스트를 생성해야함

print(max(num_list))
print(num_list.index(max(num_list))+1)
