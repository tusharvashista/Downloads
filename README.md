# Downloads
Part 1: Python Question

This exam consists of three tasks. You are required to write the code for each task in the same Python source file. You should name the file your_name_python_task.py (fill in your own name).

Python Task 1: Python Basics and Data Manipulation [13 Marks]

Download this "sales_data.csv" file

You have been provided with a CSV file sales_data.csv containing sales data for a corner shop. The file contains the following columns: Date, Product, Quantity, Price, and Total. Your task is to write a Python program that performs the following operations:

Task 1a: Data Loading and Preprocessing

Load the Data: Load the CSV file into a Pandas DataFrame. [2 mark]
Data Cleaning:
Ensure there are no missing values. If any are found, fill them with appropriate values. [3 mark]
Convert the Date column to a datetime object. [2 mark]
Ensure the Total column correctly represents the product of Quantity and Price. If any discrepancies are found, correct them. [2 mark]


LOADING:

import pandas as pd <br>
file_path = 'sales_data.csv' <br> 
data = pd.read_csv(file_path)
