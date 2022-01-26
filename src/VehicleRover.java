public interface VehicleRover {
    public Object[] readInstruction(String instruct) throws Exception;

    public void moveRover() throws Exception;

    public void turnRight();

    public void turnLeft();
}
