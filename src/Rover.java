import java.util.Locale;

public class Rover {
    public int x_axis = 1;
    public int y_axis = 2;
    Plateau p = null;
    Direction d;

    public int getX_axis() {
        return x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public Direction getD() {
        return d;
    }

    public Rover(Plateau p, int x_axis, int y_axis, Direction d) throws Exception {
        this.p = p;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.d = d;
        checkRoverPosition();
    }

    public Rover(int x_axis, int y_axis, Direction d) throws Exception {
        this(new Plateau(5, 5), x_axis, y_axis, d);
        checkRoverPosition();
    }

    public void moveRover() throws Exception {
        if (d == Direction.North && this.y_axis + 1 <= this.p.getY_MAX())
            this.y_axis += 1;
        else if (d == Direction.East && this.x_axis + 1 <= this.p.getX_MAX())
            this.x_axis += 1;
        else if (d == Direction.West && this.x_axis - 1 >= 0)
            this.x_axis -= 1;
        else if (d == Direction.South && this.y_axis - 1 >= 0)
            this.y_axis -= 1;
        else
            throw new Exception("Exceeding plateau coordinates: Movement not allowed further, Please change your direction after 5 moves");
    }

    public void turnRight() {
        if (this.d == Direction.North) {
            this.d = Direction.East;
        } else if (this.d == Direction.South) {
            this.d = Direction.West;

        } else if (this.d == Direction.East) {
            this.d = Direction.South;

        } else if (this.d == Direction.West) {
            this.d = Direction.North;
        }

    }

    public void turnLeft() {
        if (this.d == Direction.North) {
            this.d = Direction.West;
        } else if (this.d == Direction.South) {
            this.d = Direction.East;

        } else if (this.d == Direction.East) {
            this.d = Direction.North;

        } else if (this.d == Direction.West) {
            this.d = Direction.South;
        }
    }

    public void setPlateauMax(int x, int y) {
        this.p = new Plateau(x, y);
    }

    public Plateau getPlateau() {
        return this.p;
    }

    public void checkRoverPosition() throws Exception {
        if (x_axis > p.getX_MAX() || y_axis > p.getY_MAX())
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
}
