
def getDivisor (n: int, k:int) -> int :
    n_lists = []
    n_measure = int(n ** (1/2)) + 1

    for i in range(1, n_measure) :
        if n % i == 0 :
            n_lists.append(i)
            if i * i == n : continue
            n_lists.append(int(n//i))

    n_lists.sort()
    result =  int(0) if len(n_lists) < k else n_lists[k-1]
    return result

def main() :
    n, k = map(int, input().split())
    print(getDivisor(n, k))

if __name__ == "__main__" :
    main()