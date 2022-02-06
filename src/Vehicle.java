public class Vehicle {

    private VehicleRover vehicle;

    public Vehicle(VehicleRover vehicle) {
        this.vehicle = vehicle;
    }

    public void readInstruction(String instruct) throws Exception {
        instruct = instruct.toUpperCase();
        instruct = instruct.replaceAll("[^LRM]", "");
        for (int ins = 0; ins < instruct.length(); ins++) {
            char x = instruct.charAt(ins);
            if (x == 'M') vehicle.moveRover();
            if (x == 'R') vehicle.turnRight();
            if (x == 'L') vehicle.turnLeft();
        }
    }

    @Override
    public String toString() {
        return "vehicle=" + vehicle +
                '}';
    }
}
