# CaseStudyBarrenLand
Find Fertile Land on a piece of land which contains rectangular barren areas
Barren Land Analysis

Problem Statement:

You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). 
A portion of the farm is barren, and all the barren land is in the form of rectangles. 
Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. 
An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles of barren land. 

Read input from STDIN. Print output to STDOUT 

Input 
You are given a set of rectangles that contain the barren land. 
These rectangles are defined in a string, which consists of four integers separated by single spaces, 
with no additional spaces in the string. The first two integers are the coordinates of the bottom left 
corner in the given rectangle, and the last two integers are the coordinates of the top right corner. 

Output 
Output all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space. 

Sample Input 1: {“0 292 399 307”}  
Sample Output 1: 116800  116800

Sample Input 2: {“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”} 
Sample Output 2: 22816 192608 

----------------------------------------------------------------------------------------------------------------------------------------
Solution:

Create a BFS for disconnected components. Each component is going to be traversed and assigned a value (0 or 1). First the entire 
graph is traveresed and each component is assigned a value 0. Then the barren rectangular components are identified by assigning 
a value 1. The graph will look somthing like this

0 0 0 0 0 0 0 0 0

0 0 0 0 0 1 1 1 0

0 0 0 0 0 1 1 1 0

0 1 1 1 0 0 0 0 0

0 1 1 1 0 0 1 1 1

0 0 0 0 0 0 1 1 1

Traverse through the entire adjacency matrix and identify the connected components. The final area is the total nodes 
each connected component has.

The code was written in java and JUnit test cases were written to check the validity of the code.
Import the entire folder and run the main class. Alternatively, the Test class can be run to test each scenario

