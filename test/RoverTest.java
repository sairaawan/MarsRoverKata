
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class RoverTest {
    public Rover rover;
    public Plateau plateau;

    @BeforeEach
    public void setUp() throws Exception {
        plateau=new Plateau(5,5);
        rover = new Rover( 1, 2, Direction.North);

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
        rover.readInstruction("L");
        assertEquals(rover.getD(), Direction.West);

    }

    @Test
    public void checkRoverCanTurnRight() throws Exception {
        rover.readInstruction("R");
        assertEquals(rover.getD(), Direction.East);

    }

    @Test
    public void checkRoverCanMove() throws Exception {
        rover.readInstruction("M");
        assertEquals(rover.getY_axis(), 3);
    }

    @Test
    public void checkMoveRoverCanThrowExceptionWhenMovementExceedsPlateauBoundary() throws Exception {
        boolean thrown = false;
        try {
            rover.readInstruction("MMMMMMMMMMM");
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void checkMoveRoverCanThrowExceptionWhenRoverCoordinatesExceedsPlateau() throws Exception {
        boolean thrown=false;
        try {
            rover = new Rover( 6, 6, Direction.North); //given plateau coordinates=> (5,5)
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void checkFirstTestInstruction() throws Exception {
        rover.readInstruction("LMLMLMLMM");
        assertEquals(rover.getX_axis(), 1);
        assertEquals(rover.getY_axis(), 3);
        assertEquals(rover.getD(), Direction.North);
    }

    @Test
    public void checkSecondTestInstruction() throws Exception {
        rover = new Rover(3, 3, Direction.East);
        rover.readInstruction("MMRMMRMRRM");
        assertEquals(rover.getX_axis(), 5);
        assertEquals(rover.getY_axis(), 1);
        assertEquals(rover.getD(), Direction.East);

    }
}