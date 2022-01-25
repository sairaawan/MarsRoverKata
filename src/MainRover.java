abstract class MainRover implements Vehicle {
    public int x_axis = 1;
    public int y_axis = 2;
    Direction d;

    @Override
    public String toString() {
        return "MainRover{" +
                "x_axis=" + x_axis +
                ", y_axis=" + y_axis +
                ", d=" + d +
                '}';
    }

    public int getX_axis() {
        return x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public Direction getD() {
        return d;
    }

    public MainRover(int x_axis, int y_axis, Direction d) {
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.d = d;
    }

    public void moveRover() {
        if (d == Direction.North)
            this.y_axis = this.y_axis+1;
        if (d == Direction.East)
            this.x_axis = this.x_axis+1;
        if (d == Direction.West)
            this.x_axis = this.x_axis-1;
        if (d == Direction.South)
            this.y_axis -= 1;
    }

    public void turnRight() {
        if (this.d == Direction.North) {
            this.d = Direction.East;
        }
        if (this.d == Direction.South) {
            this.d = Direction.West;

        }
        if (this.d == Direction.East) {
            this.d = Direction.South;

        }
        if (this.d == Direction.West) {
            this.d = Direction.North;
        }

    }

    public void turnLeft() {
        if (this.d == Direction.North) {
            this.d = Direction.West;
        }
        if (this.d == Direction.South) {
            this.d = Direction.East;

        }
        if (this.d == Direction.East) {
            this.d = Direction.North;

        }
        if (this.d == Direction.West) {
            this.d = Direction.South;
        }
    }

    abstract void readInstruction(String instruct);
}
