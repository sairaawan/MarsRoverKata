public interface VehicleRover {
    void readInstruction(String instruct) throws Exception;

    void moveRover() throws Exception;

    void turnRight();

    void turnLeft();
}
