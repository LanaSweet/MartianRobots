# MartianRobots
App calculating the route of a robot in a given grid


The surface of Mars can be modelled by a rectangular grid around which robots are able to move according to instructions provided from Earth. 
This app allow you to enter the instructions for the robot to move around and as a result of the app you will receive the final position of the robot on the grid, the direction in which it is looking and if it was its final position before falling from the edge of the grid the app will print LOST at the end of the output string.

+ First line you have to enter is dimension of the grid, separated by the whitespace. (e.g. 5 3). Each of the dimensions x, y can not exceed the value of 50.

+ Second line should indicate the initial position of the robot on the grid. A robot position consists of a grid coordinate (a pair of integers: x-coordinate followed by y-coordinate) and an orientation (N, S, E, W for north, south, east, and west)

+ And a third line - robots instruction or route.

  A robot instruction is a string of the letters "L", "R", and "F" which represent, respectively, the instructions:

    *   Left: the robot turns left 90 degrees and remains on the current grid point.
    *   Right: the robot turns right 90 degrees and remains on the current grid point.
    *   Forward: the robot moves forward one grid point in the direction of the current orientation and maintains the same orientation.

Since the grid is rectangular and bounded (...yes Mars is a strange planet), a robot that moves "off" an edge of the grid is lost forever. However, lost robots leave a robot "scent" that prohibits future robots from dropping off the world at the same grid point. The scent is left at the last grid position the robot occupied before disappearing over the edge. An instruction to move "off" the world from a grid point from which a robot has been previously lost and it prevents the current robot of falling off the grid. However the robot can not continue its route and its last coordinates registered are those of the "scent" position.

The app calculates the route of the robots and returns the last position on the grid. If the robot has fallen off the grid the last position is followed by the word LOST.

## Example of an input:
```
5 3
1 1 E
RFRFRFRF
```



