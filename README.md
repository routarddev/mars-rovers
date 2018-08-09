# mars-rovers

### Introduction

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover’s position and location is represented by a combination of x and y co- ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same Heading.
 
Assume that the square directly North from (x, y) is (x, y+1).

INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower- left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation.

Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished Moving.

OUTPUT:
The output for each rover should be its final co-ordinates and heading.

EXAMPLE OF INPUT AND OUTPUT

Test Input:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```
Expected Output:
```
1 3 N
5 1 E
```

(Introduction text by &copy;XING)

### Assumptions:
- Assuming that the plateau is just one piece of the planet and, therefore, not "limitless", when the rover is in the limits of it and trying to move forward, nothing will be done.
- For the coordinates and orientation data, if the line pattern is not the expected (two integers and a letter separated by spaces), the program ends.
- For the instructions line, the full line will be taken and processed, but only the known instructions will be accepted and executed.
- By default, the program will read the information from a file. The default file is the inputFile.txt in the resources folder and can be modified. Executing the program by command line is possible to specify another filename with the full path. In both cases, the output solution will be found in the outputFile.txt of the resources folder.

### Execution:
This program has been developed in **Java** and **Spring Boot** and **Maven** has been used to build the project.

- Project build: inside the root of the project folder, where the `pom.xml` is:
		```mvn clean install``` --> builds the project, downloading the dependencies and executes the tests

- Program execution:
  - Run the main program from the Run options of your IDE.
  - Or navigate to the folder containing the `pom.xml` file and execute the following command:
	```mvn spring-boot:run -Dspring-boot.run.arguments="firstArgument,secondArgument"```
	* Where:
		* firstArgument:
			- 1 : read from file
			- 2 : read from console
		* secondArgument: only valid for option 1, should be the name of the input file with full pathname.

Example:

```mvn spring-boot:run -Dspring-boot.run.arguments="1,"/home/user/inputFileTest.txt"```
