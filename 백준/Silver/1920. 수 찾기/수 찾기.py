'''
    문제
        N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

    입력
        첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
        다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 

        다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
        다음 줄에는 M개의 수들이 주어지는데, 
        
        이 수들이 A안에 존재하는지 알아내면 된다. 
        모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다.

    입력                        출력
        5                       1
        4 1 5 2 3               1
        5                       0
        1 3 7 9 5               0
                                1

    my_note ::
        if 두 번째 원소 ∈  네 번째 원소 :
            print("1")
        else :
            print("0")

'''
import sys

def binary_search(element, some_list, start = 0, end = None) :
    if end == None :
        end = len(some_list) - 1
    if start > end :
        return 0

    mid = (start + end) // 2

    if element == some_list[mid] :
        return 1
    elif element < some_list[mid] :
        end = mid -1
    elif element > some_list[mid] :
        start = mid + 1
    return binary_search(element, some_list, start, end)
    
N = int(sys.stdin.readline())
N_list = list(map(int, sys.stdin.readline().split()))
N_list.sort()

M = int(sys.stdin.readline())
M_list = list(map(int, sys.stdin.readline().split()))

for i in range(len(M_list)) :
    print(binary_search(M_list[i], N_list))