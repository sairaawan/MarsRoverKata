
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class RoverTest {
    public Vehicle vehicle;
    public Rover rover;
    public Plateau plateau;

    @BeforeEach
    public void setUp() throws Exception {
        plateau=new Plateau(5,5);
        rover = new Rover( plateau,1, 2, Direction.North);
        vehicle=new Vehicle(rover);

    }

    @Test
    public void checkRoverReturnX_axis(){
        assertEquals(rover.getX_axis(), 1);
    }

    @Test
    public void checkRoverReturnY_axis(){
        assertEquals(rover.getY_axis(), 2);
    }

    @Test
    public void checkRoverReturnDirection(){
        assertEquals(rover.getD(), Direction.North);
    }

    @Test
    public void checkPlateauCoordinates(){
        assertEquals(plateau.getX_MAX(), 5);
        assertEquals(plateau.getY_MAX(), 5);
    }

    @Test
    public void checkRoverCanTurnLeft() throws Exception {
        vehicle.readInstruction("L");
        assertEquals(rover.getD(), Direction.West);

    }

    @Test
    public void checkRoverCanTurnRight() throws Exception {
        vehicle.readInstruction("R");
        assertEquals(rover.getD(), Direction.East);

    }

    @Test
    public void checkRoverCanMove() throws Exception {
        vehicle.readInstruction("M");
        assertEquals(rover.getY_axis(), 3);
    }

    @Test
    public void checkMoveRoverCanThrowExceptionWhenMovementExceedsPlateauBoundary() throws Exception {
        boolean thrown = false;
        try {
            vehicle.readInstruction("MMMMMMMMMMM");
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void checkMoveRoverCanThrowExceptionWhenRoverCoordinatesExceedsPlateau() throws Exception {
        boolean thrown=false;
        try {
            rover = new Rover( plateau, 6, 6, Direction.North);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void checkFirstTestInstruction() throws Exception {
        vehicle.readInstruction("LMLMLMLMM");
        assertEquals(rover.getX_axis(), 1);
        assertEquals(rover.getY_axis(), 3);
        assertEquals(rover.getD(), Direction.North);
    }

    @Test
    public void checkSecondTestInstruction() throws Exception {
        rover = new Rover(plateau, 3, 3, Direction.East);
        vehicle=new Vehicle(rover);
        vehicle.readInstruction("MMRMMRMRRM");
        assertEquals(rover.getX_axis(), 5);
        assertEquals(rover.getY_axis(), 1);
        assertEquals(rover.getD(), Direction.East);

    }
}