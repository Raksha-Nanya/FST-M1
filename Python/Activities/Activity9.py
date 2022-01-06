myList1 = [12,4,67,44,56,77,65,43]
myList2 = [3,5,44,65,66,12,33,66]
myList3 = []
#j=0
for i in myList1:
    result1 = i%2
    if(result1!=0):
        #myList3.insert(myList1[j],i) 
        myList3.append(i)
    """ j=j+1
    else:
       # j=j+1
j=0"""
for i in myList2:
    result2 = i%2
    if(result2==0):
        #myList3.insert(myList1[j],i)
        myList3.append(i)
        """j=j+1
    else:
        j=j+1"""
print(myList3)


