import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        int[] plateau = new int[2];
        int[] coordinates = new int[2];
        Direction d = null;
        String direction;


        Scanner scan = new Scanner(System.in);
        System.out.println("Enter no of Rovers");
        int r = scan.nextInt();


        System.out.println("Enter P1 coordinates");
        int p1 = scan.nextInt();
        System.out.println("Enter P2 coordinates");
        int p2 = scan.nextInt();

        plateau[0] = p1;
        plateau[1] = p2;

        for (int i = 0; i < r; i++) {
            System.out.println("Enter x coordinates");
            int x = scan.nextInt();
            System.out.println("Enter y coordinates");
            int y = scan.nextInt();

            coordinates[0] = x;
            coordinates[1] = y;

            System.out.println("Enter Rovers position");
            direction = scan.next();
            if (direction.equalsIgnoreCase("N"))
                d = Direction.North;
            else if (direction.equalsIgnoreCase("S"))
                d = Direction.South;
            else if (direction.equalsIgnoreCase("E"))
                d = Direction.East;
            else if (direction.equalsIgnoreCase("W"))
                d = Direction.West;

            Rover rover = new Rover(new Plateau(p1, p2), x, y, d);
            System.out.println("Rover current position: " + rover);

            System.out.println("Enter instruction for rover");
            String instruct = scan.next();
            rover.readInstruction(instruct);
            System.out.println("Rover new position: " + rover);
        }

    }

}
