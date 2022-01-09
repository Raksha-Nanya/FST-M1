import pandas as pd	
data = {
  "UserName": ["admin", "Charles", "Deku"],
  "Password": ["password", "Charl13", "AllMight"],
}

dataframe = pd.DataFrame(data)
print(dataframe)
dataframe.to_csv("Files\credentials.csv",index=False)
