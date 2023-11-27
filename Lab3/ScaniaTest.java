import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ScaniaTest {
    @Test
    public void testgetCurrentSpeed() {
        Scania scaniatest = new Scania(Direction.WEST, 0,0);
        assertEquals(0, scaniatest.getCurrentSpeed(), 0);
    }

    @Test
    public void testRaisePlatform() {
        Scania scaniatest = new Scania(Direction.WEST, 0,0);


        scaniatest.raisePlatform(69);
        assertEquals(69, scaniatest.getPlatformAngle(),0);

    }

    @Test
    public void testLowerPlatform() {
        Scania scaniatest = new Scania(Direction.WEST, 0,0);
        scaniatest.raisePlatform(70);

        scaniatest.lowerPlatform(20);

        assertEquals(50, scaniatest.getPlatformAngle(),0);

    }


    @Test
    public void testScaniaMoveUp() {
        Scania scaniatest = new Scania(Direction.SOUTH, 0, 0);
        scaniatest.raisePlatform(70);

        scaniatest.startEngine();
        scaniatest.move();

        assertEquals(0, scaniatest.getY(), 0);
    }

    @Test
    public void testScaniaMoveDown() {
        Scania scaniatest = new Scania(Direction.SOUTH, 0, 0);
        scaniatest.raisePlatform(70);
        scaniatest.lowerPlatform(70);


        scaniatest.startEngine();
        scaniatest.move();

        assertEquals(0, scaniatest.getY(), 0);
    }



}
