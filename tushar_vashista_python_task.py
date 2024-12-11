import pandas as pd
import matplotlib.pyplot as plt
import sqlite3
import torch
import torch.nn as nn

########################## Task 1a: Data Loading and Preprocessing #######################
file_path = "sales_data.csv"
df = pd.read_csv(file_path)

# print(df.info())

df.loc[df["Total"].isnull(), "Total"] = df["Quantity"] * df["Price"]
df.loc[df["Price"].isnull(), "Price"] = df["Total"] / df["Quantity"]

for i, row in df[df["Product"].isnull()].iterrows():
    similar_data = df[
        (df["Price"] == row["Price"])
        & (df["Quantity"] == row["Quantity"])
        & (df["Total"] == row["Total"])
        & df["Product"].notnull()
    ]

    if not similar_data.empty:
        df.loc[i, "Product"] = similar_data["Product"].iloc[0]

# print(df.info())

df["Date"] = pd.to_datetime(df["Date"], format="mixed")

if all(col in df.columns for col in ["Quantity", "Price", "Total"]):
    df["Total"] = df["Quantity"] * df["Price"]


newfile = "cleaned_sales_data.csv"
df.to_csv(newfile, index=False)


####################### Task 1b: Data Visualisation ###############################
ps = df.groupby("Product")["Quantity"].sum()
ps.plot(kind="bar")
plt.title("Total Quantity Sold for Each Product")
plt.xlabel("Product")
plt.ylabel("Total Quantity Sold")
plt.show()

df["Date"] = pd.to_datetime(df["Date"])
df["Month"] = df["Date"].dt.to_period("M")
ms = df[df["Date"].dt.year == 2023].groupby("Month")["Total"].sum()

ms.plot(kind="line")
plt.title("Total Sales in 2023")
plt.xlabel("Month")
plt.ylabel("Total Sales")
plt.grid(True)
plt.show()


########################## Python Task 2: Python Database Management #############################

conn = sqlite3.connect("SalesDB.db")
cursor = conn.cursor()

cursor.execute(
    """
    CREATE TABLE IF NOT EXISTS Sales (Date TEXT,Product TEXT, Quantity INTEGER, Price REAL,Total REAL,UNIQUE(Date, Product, Quantity, Price, Total))"""
)


data = pd.read_csv("cleaned_sales_data.csv")
data.to_sql("Sales", conn, if_exists="replace", index=False)


total_sales_query = """
    SELECT SUM(Total) 
    FROM Sales 
    WHERE strftime('%Y', Date) = '2023';
"""
total_sales = cursor.execute(total_sales_query).fetchone()[0]
print(f"Total Sales in 2023: {total_sales}")

product_sales_query = """
    SELECT Product, SUM(Quantity) AS TotalQuantity
    FROM Sales
    WHERE strftime('%Y', Date) = '2023'
    GROUP BY Product
    ORDER BY TotalQuantity DESC;
"""
product_sales_summary = cursor.execute(product_sales_query).fetchall()

print("Product Sales Summary in 2023:")
for product, quantity in product_sales_summary:
    print(f"{product}: {quantity}")

conn.close()

######################### Task 3a: Model Initialization ##################################33


class SimpleNN(nn.Module):
    def __init__(self):
        super(SimpleNN, self).__init__()
        self.fc1 = nn.Linear(10, 5)
        self.relu1 = nn.ReLU()
        self.fc2 = nn.Linear(5, 3)
        self.relu2 = nn.ReLU()
        self.fc3 = nn.Linear(3, 1)
        self.sigmoid = nn.Sigmoid()

    def forward(self, x):
        x = self.relu1(self.fc1(x))
        x = self.relu2(self.fc2(x))
        x = self.sigmoid(self.fc3(x))
        return x


model = SimpleNN()
criterion = nn.MSELoss()
optimizer = torch.optim.SGD(model.parameters(), lr=0.01)

################ Task 3b: Data Generation ######################################
inputs = torch.randn(100, 10)
targets = torch.randn(100, 1)

############################# Task 3c: Training the Network #################################
num_epochs = 20
losses = []

for epoch in range(num_epochs):
    outputs = model(inputs)
    loss = criterion(outputs, targets)
    losses.append(loss.item())

    optimizer.zero_grad()
    loss.backward()
    optimizer.step()

    print(f"Epoch {epoch+1}/{num_epochs}, Loss: {loss.item():.4f}")

############################## Task 3d: Loss Visualisation #################################
plt.plot(range(1, num_epochs + 1), losses, marker="o")
plt.title("Training Loss Curve")
plt.xlabel("Epoch")
plt.ylabel("Loss")
plt.grid(True)
plt.show()
