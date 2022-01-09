import pandas as pd
from pandas.core.indexes.base import Index
from pandas import ExcelWriter
	
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

dataframe = pd.DataFrame(data)
writer = ExcelWriter("Files\Credentials.xlsx")
dataframe.to_excel(writer,'Credentials',index=False)	
writer.save()
print(dataframe)