import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    public MainRover rover; // declare as a private class member

    @BeforeEach
    public void setUp() throws Exception {
        rover = new Rover(1, 2, Direction.North); // instantiate it before every test
    }

    @Test
    public void checkInstruction_L()  {
        rover.readInstruction("MM");
        assertEquals(rover.getY_axis(), 4);
    }

    @Test
    public void checkInstruction_LR()  {
        rover.readInstruction("LR");
        assertEquals(rover.getD(), Direction.North);
    }


}