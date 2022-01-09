import pandas as pd
from pandas.core.indexes.base import Index	
data = {
  "Usernames": ["Admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"],
}

dataframe = pd.DataFrame(data)
dataframe.to_csv("Files\credentials.csv",index=False)

print("===============")
print("Username:")
print(dataframe["Usernames"])

	
print("===============")
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

	
#Sort the Usernames column in ascending order
print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames',ascending=True))
 
#Sort the Passwords column in descending order
print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))