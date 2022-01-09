

def sum(myList):
    res=0
    for i in myList:  
        res = res+i     
    return res

myList = [14,12,43,30]
res = sum(myList)
print("The sum of List is : ",res)
