
"""myList = []
for i in range(1,6):
    Element = input("Enter the number : " )  
    myList.insert(i,Element)
print(myList)

sum=0
for i in myList:
    sum=sum+int(i)

print(sum)"""

myList = list(input("Enter the number with comma : ").split(','))
print(myList)

print("List is ",myList)
result=0
for i in myList:
    result+=int(i)

print("The total Sum of the List is : ", result )
