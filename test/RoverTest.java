import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    public Rover rover; // declare as a private class member

    @BeforeEach
    public void setUp() throws Exception {
        rover = new Rover(1, 2, Direction.North); // instantiate it before every test
    }

    @Test
    public void checkInstruction_L() throws Exception {
        rover.readInstruction("LMLMLMLMM");
        assertEquals(rover.getX_axis(), 1);
        assertEquals(rover.getY_axis(), 3);
        assertEquals(rover.getD(), Direction.North);
    }

    @Test
    public void checkMove() throws Exception {
        boolean thrown = false;

        try {
            rover.readInstruction("MMMMMMMMMMM");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

}