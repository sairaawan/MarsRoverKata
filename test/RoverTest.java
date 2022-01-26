import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    public Rover rover; // declare as a private class member


    @Test
    public void checkInstruction_L() throws Exception {
        rover = new Rover( 1, 2, Direction.North);
        rover.readInstruction("LMLMLMLMM");
        assertEquals(rover.getX_axis(), 1);
        assertEquals(rover.getY_axis(), 3);
        assertEquals(rover.getD(), Direction.North);
    }

    @Test
    public void checkSecondInstruction() throws Exception {
        rover = new Rover( 3, 3, Direction.East);
        rover.readInstruction("MMRMMRMRRM");
        assertEquals(rover.getX_axis(), 5);
        assertEquals(rover.getY_axis(), 1);
        assertEquals(rover.getD(), Direction.East);

    }

    @Test
    public void checkMove() throws Exception {
        rover = new Rover( 1, 3, Direction.East);
        boolean thrown = false;

        try {
            rover.readInstruction("MMMMMMMMMMM");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue(thrown);

    }


}