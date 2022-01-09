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
print("1)The number of rows and coloumn the Credentails.xlsx is : "+str(dataframe.shape) +" respectivly")
print("2)The data in Email's column is ",dataframe["Email"])
print("3)The data in ascending order of FirstName ",dataframe.sort_values("FirstName",ascending=True))