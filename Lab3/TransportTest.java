import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TransportTest {

    @Test
    public void testLoadCar() {
        Transport transport = new Transport(Direction.NORTH, 0, 0);

        Volvo240 volvo240 = new Volvo240(Direction.SOUTH, 0, 0);
        Saab95 saab95 = new Saab95(Direction.WEST, 0, 0);

        transport.lowerPlatform();

        transport.loadCar(volvo240);
        transport.loadCar(saab95);


        assertEquals(2, transport.getCars().size());
        assertEquals(volvo240, transport.getCars().get(0));
        assertEquals(saab95, transport.getCars().get(1));

    }


    @Test
    public void testUnloadCar() {
        Transport transport = new Transport(Direction.NORTH, 0, 0);

        Volvo240 volvo240 = new Volvo240(Direction.SOUTH, 0, 0);
        Saab95 saab95 = new Saab95(Direction.WEST, 0, 0);


        transport.lowerPlatform();

        transport.loadCar(volvo240);
        transport.loadCar(saab95);

        transport.unloadCar(saab95);

        assertEquals(volvo240, transport.getCars().get(0));
        assertEquals(1, transport.getCars().size());

    }

    @Test
    public void testMove() {
        Transport transport = new Transport(Direction.NORTH, 0, 0);


        Volvo240 volvo240 = new Volvo240(Direction.SOUTH, 0, 0);
        Saab95 saab95 = new Saab95(Direction.WEST, 0, 0);

        transport.lowerPlatform();

        transport.loadCar(volvo240);
        transport.loadCar(saab95);

        transport.move();

    }
    }
