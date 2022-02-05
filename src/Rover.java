import java.util.Locale;

public class Rover implements VehicleRover {
    private int x_axis;
    private int y_axis;
    private Plateau plateau = null;
    private Direction direction;

    public int getX_axis() {
        return x_axis;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }

    public Direction getD() {
        return direction;
    }

    public Rover(Plateau p, int x_axis, int y_axis, Direction d) throws Exception {
        this.plateau = p;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.direction = d;
        checkRoverPosition();
    }

    public void checkRoverPosition() throws Exception {
        if (x_axis > plateau.getX_MAX() && y_axis > plateau.getY_MAX())
            throw new Exception("Rovers position is incorrect. Please enter correct coordinates");
    }

    public void readInstruction(String instruct) throws Exception {
        instruct = instruct.toUpperCase();
        instruct = instruct.replaceAll("[^LRM]", "");
        for (int ins = 0; ins < instruct.length(); ins++) {
            char x = instruct.charAt(ins);
            if (x == 'L') turnLeft();
            if (x == 'R') turnRight();
            if (x == 'M') moveRover();
        }

    }

    public void moveRover() throws Exception {
        if (direction == Direction.North && this.y_axis + 1 <= this.plateau.getY_MAX())
            this.y_axis += 1;
        else if (direction == Direction.East && this.x_axis + 1 <= this.plateau.getX_MAX())
            this.x_axis += 1;
        else if (direction == Direction.West && this.x_axis - 1 >= 0)
            this.x_axis -= 1;
        else if (direction == Direction.South && this.y_axis - 1 >= 0)
            this.y_axis -= 1;
        else
            throw new Exception("Exceeding plateau coordinates: Movement not allowed further, Please change your direction after " + plateau.getY_MAX() + " moves");
    }

    public void turnRight() {
        if (this.direction == Direction.North) {
            this.direction = Direction.East;
        } else if (this.direction == Direction.South) {
            this.direction = Direction.West;

        } else if (this.direction == Direction.East) {
            this.direction = Direction.South;

        } else if (this.direction == Direction.West) {
            this.direction = Direction.North;
        }

    }

    public void turnLeft() {
        if (this.direction == Direction.North) {
            this.direction = Direction.West;
        } else if (this.direction == Direction.South) {
            this.direction = Direction.East;

        } else if (this.direction == Direction.East) {
            this.direction = Direction.North;

        } else if (this.direction == Direction.West) {
            this.direction = Direction.South;
        }
    }


    @Override
    public String toString() {
        return "{" +
                "x_axis=" + x_axis +
                ", y_axis=" + y_axis +
                ", d=" + direction +
                '}';
    }
}
