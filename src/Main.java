
import java.util.Scanner;

public class Main {

    public static int getPlateauX() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter P1 coordinates");
        int p1 = scan.nextInt();
        return p1;
    }

    public static int getPlateauY() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter P2 coordinates");
        int p2 = scan.nextInt();
        return p2;
    }

    public static int getCoordinatesX() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter x coordinates");
        int x = scan.nextInt();
        return x;
    }

    public static int getCoordinatesY() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter y coordinates");
        int y = scan.nextInt();
        return y;
    }

    public static Direction getDirection() {
        Direction d = null;
        Scanner scan = new Scanner(System.in);
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
        int p1 = getPlateauX();
        int p2 = getPlateauY();

        System.out.println("First Rover");

        int x = getCoordinatesX();
        int y = getCoordinatesY();
        Direction d = getDirection();


        Rover rover = new Rover(new Plateau(p1, p2), x, y, d);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter instruction for rover");
        String instruct = scan.next();

        System.out.println("First Rover starting position: " + rover);
        rover.readInstruction(instruct);
        System.out.println("First Rover new position: " + rover);

        x = getCoordinatesX();
        y = getCoordinatesY();
        d = getDirection();

        Rover rover2 = new Rover(new Plateau(p1, p2), x, y, d);
        System.out.println("Rover current position: " + rover2);

        System.out.println("Second Rover");

        System.out.println("Enter instruction for second rover");
        instruct = scan.next();
        rover2.readInstruction(instruct);
        System.out.println("Rover new position: " + rover2);

        if (rover.x_axis == rover2.x_axis && rover.y_axis == rover2.y_axis) {
            throw new Exception("Warning! Rovers are at same position");
        }

        System.out.println("See you next time. Bye");


    }


}
