	
fruit_dict =	{
  "APPLE": 20,
  "BANANA": 15,
  "KIVI": 22
}

fruit = input("Enter the fruit name you want to search :").upper()

if fruit in fruit_dict:
    print("The fruit is available in the market.")
else:
    print("The fruit is not available in the market.")
 