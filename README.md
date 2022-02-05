# Move rovers around mars

Assumptions:

•	Surface of mars is a rectangular/square grid plateau

•	Plateau has x and y  coordinates defining total grid for example 5*5

# Rover:

Rover is represented by (attributes):

1.	X and y coordinates	
2.	Direction (N,S,E,W)

Rover can do the following when given following instruction (Methods):
1.	L: Turn left 90 degrees
2.	R: Turn right 90 degrees
3.	M: move rover one grid point maintaining the direction
To run the program we have to provide following task in a sequence:
1.	Give the upper-right coordinates for the plateau=>(x,y)
2.	Rover coordinates and direction it is facing=>(x,y)
3.	Instruction to the rover=> L/r/m


# Rover receiving instruction:

•	Case Left:

1.	If direction is North, change it to West.
2.	If direction is South, change it to East.
3.	If direction is East, change to North.
4.	If direction is West, change to South.

•	Case Right:

1.	If direction is North, change to East.
2.	If direction is South, change to West.
3.	If direction is East, change to South.
4.	If direction is West, change to North.

•	Case Move:

1.	If direction is North, do => y_axis+1, making sure it’s not exceeding max y-axis value of the plateau.
2.	If direction is South, do => x_axis+1, making sure it’s not exceeding max x-axis value of the plateau.
3.	If direction is East, do => x_axis-1, making sure it’s not exceeding min x-axis value (0) of the plateau.
4.	If direction is West, do => y_axis-1, making sure it’s not exceeding min y-axis value (0) of the plateau.

# Future Considerations:

Creating Plateau for different shapes

Using obstacles and restricting movements

Creating more than two rovers and moving them around Plateau



