
myTupple = tuple(input("Enter the number seperated by comma. :").split(","))
myList = []
print("Data in the tupple is ",myTupple)
for i in myTupple:
    if (int(i)%5==0):
        print(i) 
for i in myTupple:
    if (int(i)%5==0):
        myList.append(i)
    
print("These are the number divisible by 5 :",myList)
    



    