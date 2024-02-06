# AI-Project-1
Nishant Water Pitcher Solver
Introduction
The Nishant Water Pitcher Solver is a Java program designed to solve the water pitcher problem using the A* search algorithm. This program calculates the minimum number of steps required to reach a target quantity using a set of water pitchers with different capacities.

Usage
Requirements
Java Development Kit (JDK) 8 or higher installed on your system.
Running the Program
Clone or download the repository to your local machine.

Navigate to the NishantWaterPitcherSolver directory using the command line.

Compile the Java source file using the following command:

Copy code
javac NishantWaterPitcherSolver.java
Create a text file named input.txt in the same directory with the following format:

Copy code
2,5,6,72
143
Replace the capacities and target quantity with your desired values.

Run the program by executing the following command:

Copy code
java NishantWaterPitcherSolver
The program will read the input from input.txt and display the minimum number of steps required to reach the target quantity or -1 if no solution exists.

Lower Bound Calculation
The lower bound for this problem is calculated using a heuristic function based on the remaining quantity needed to reach the target. It estimates the minimum number of steps required for the A* search algorithm.

Algorithm
The program uses the A* search algorithm to find the shortest path from the initial state (all pitchers empty) to the target state (specified target quantity in one of the pitchers). The steps involved in the A* search algorithm are explained in the code comments.

Example
For example, if you run the program with input.txt containing the following data:

Copy code
2,5,6,72
143
The program will output:

typescript
Copy code
Minimum number of steps: 15
Nishant Water Pouring Solver
Introduction
The Nishant Water Pouring Solver is a Java program designed to solve the water pouring problem using the A* search algorithm. This program calculates the minimum number of steps required to reach a target quantity using a set of water pitchers with different capacities.

Usage
Requirements
Java Development Kit (JDK) 8 or higher installed on your system.
Running the Program
Clone or download the repository to your local machine.

Navigate to the NishantWaterPouring directory using the command line.

Compile the Java source file using the following command:

Copy code
javac NishantWaterPouring.java
Create a text file named input.txt in the same directory with the following format:

Copy code
2,5,6,72
143
Replace the capacities and target quantity with your desired values.

Run the program by executing the following command:

Copy code
java NishantWaterPouring
The program will read the input from input.txt and display the minimum number of steps required to reach the target quantity or -1 if no solution exists.

Lower Bound Calculation
The lower bound for this problem is calculated using a heuristic function based on the remaining quantity needed to reach the target. It estimates the minimum number of steps required for the A* search algorithm.

Algorithm
The program uses the A* search algorithm to find the shortest path from the initial state (all pitchers empty) to the target state (specified target quantity in one of the pitchers). The steps involved in the A* search algorithm are explained in the code comments.

Example
For example, if you run the program with input.txt containing the following data:

Copy code
2,5,6,72
143
The program will output:

typescript
Copy code
Minimum number of steps: 15
These README.md files provide detailed instructions on how to run the code, explanations of the algorithms used, and examples of usage.
