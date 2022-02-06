
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);


    public static int getPlateauX() {
        System.out.println("Enter P1 coordinates");
        int p1 = scan.nextInt();
        return p1;
    }


    public static int getPlateauY() {
        System.out.println("Enter P2 coordinates");
        int p2 = scan.nextInt();
        return p2;
    }

    public static int getCoordinatesX() {
        System.out.println("Enter x coordinates");
        int x = scan.nextInt();
        return x;
    }

    public static int getCoordinatesY() {
        System.out.println("Enter y coordinates");
        int y = scan.nextInt();
        return y;
    }

    public static Direction getDirection() {
        Direction d = null;
        System.out.println("Enter Rovers position");
        String direction = scan.next();
        if (direction.equalsIgnoreCase("N"))
            return Direction.North;
        else if (direction.equalsIgnoreCase("S"))
            return Direction.South;
        else if (direction.equalsIgnoreCase("E"))
            return Direction.East;
        else if (direction.equalsIgnoreCase("W"))
            return Direction.West;
        return Direction.West;
    }

    public static void main(String[] args) throws Exception {

//        First Rover creation

        int p1 = getPlateauX();
        int p2 = getPlateauY();
        System.out.println("First Rover");

        int x = getCoordinatesX();
        int y = getCoordinatesY();
        Direction d = getDirection();
        Rover rover = new Rover(new Plateau(p1, p2), x, y, d);
        Vehicle vehicle = new Vehicle(rover);
        System.out.println("First Rover starting position: " + vehicle);

//        Second Rover creation

        System.out.println("Second Rover");
        x = getCoordinatesX();
        y = getCoordinatesY();
        d = getDirection();
        Rover rover2 = new Rover(new Plateau(p1, p2), x, y, d);
        Vehicle vehicle2 = new Vehicle(rover2);
        System.out.println("Second Rover current position: " + vehicle2);

//        Giving instructions to both rovers

        String response;
        do {

            System.out.println("Enter instruction for rovers");
            String instruct = scan.next();
            vehicle.readInstruction(instruct);
            System.out.println("First Rover new position: " + rover);
            vehicle2.readInstruction(instruct);
            System.out.println("Second Rover new position: " + rover2);
            if (rover.getX_axis() == rover2.getX_axis() && rover.getY_axis() == rover2.getY_axis()) {
                throw new Exception("Warning! Rovers are at same position. Collision expected");
            }
            System.out.println("Continue moving Rovers ? Enter y/n");
            response = scan.next();
        } while (response.equalsIgnoreCase("y"));

        System.out.println("See you next time. Bye");
    }


}
