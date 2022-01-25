import java.util.Locale;

public class Rover extends MainRover {
    Plateau p = new Plateau(5, 5);

    public Rover(int x_axis, int y_axis, Direction direction) throws Exception {
        super(x_axis, y_axis, direction);
        checkRoverPosition();
    }


    public boolean checkRoverPosition() throws Exception {
        if (x_axis >= p.getX_MAX() || y_axis >= p.getY_MAX())
            throw new Exception("Rovers position is incorrect. Please enter correct coordinates");
        return true;
    }

    public void readInstruction(String instruct) {
        String i= instruct.toUpperCase();
       String[] instructionArray = i.split("");
       for (int ins=0; ins<instructionArray.length; ins++) {
           System.out.println(instructionArray[ins]);
           switch (instructionArray[ins]) {
               case "L" -> turnLeft();
               case "R" -> turnRight();
               case "M" -> moveRover();
               default -> System.out.println("Enter correct value");
           }

        }
    }

}
