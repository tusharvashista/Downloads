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

Task 1b: Data Visualisation

Product Sales Distribution: Create a bar chart showing the total quantity sold for each product. [2 mark]

Sales Over Time: Create a line plot to show the trend of total sales over the months of 2023. The x-axis should represent the months, and the y-axis should represent the total sales. [2 mark]

Python Task 2: Python Database Management [15 marks]

Problem: Managing Sales Data with SQLite. You are required to create a database to store and manage the sales data processed in Part 1.

Task 2a: Database Creation and Data Insertion

Create an SQLite database named SalesDB. [2 mark]
Create a table named Sales with appropriate columns to store the data (Date, Product, Quantity, Price, Total). [3 mark]
Insert the cleaned and processed data from Part 1 into the Sales table. Ensure no duplicate entries are added. [4 marks]
Task 2b: Querying the Database

Total Sales Calculation: Write a query to calculate the total sales for the year 2023 and display the result. [3 marks]
Product Sales Summary: Write a query to list each product and its total quantity sold in 2023. Display the result in descending order of quantity. [3 marks]

Python Task 3: Basic Neural Network Implementation [12 marks]

In this task, you will define a simple fully connected neural network using PyTorch. You will train the network on synthetic data, evaluate its performance by tracking the loss during training, and visualize the results.

Instructions:

Neural Network Definition: Define a class SimpleNN that extends torch.nn.Module.

The network should have the following layers:

Input Layer: 10 input features.

Hidden Layer 1: A fully connected layer with 5 neurons and ReLU activation.

Hidden Layer 2: A fully connected layer with 3 neurons and ReLU activation.

Output Layer: A fully connected layer with 1 neuron and Sigmoid activation.

 

Task 3a: Model Initialization [4 marks]

Instantiate the SimpleNN model.

Use torch.nn.MSELoss() as the loss function.

Use torch.optim.SGD as the optimizer with a learning rate of 0.01.

 

Task 3b: Data Generation [2 mark]

Generate synthetic data with 100 samples, each having 10 features. The target should be a tensor with 100 values.

Use torch.randn to generate the synthetic input data and target values.

 

Task 3c: Training the Network [3 marks]

Train the network for 20 epochs.

During each epoch, compute the loss, perform backpropagation, and update the model's weights.

Record the training loss for each epoch.

 

Task 3d: Loss Visualisation [3 marks]

Plot the training loss over epochs using matplotlib.

Example Output:

Your plot should display the training loss decreasing over time, indicating that the model is learning.

Bhai?? Kar raha haii
