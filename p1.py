
def solve(st):
    xres=ord(st[0])
    for i in range(1,len(st)):
        xres=xres^ord(st[i])
    
    print(xres)

n=input()
solve(n)