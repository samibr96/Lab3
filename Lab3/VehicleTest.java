

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;


public class VehicleTest {
  
  
  @Test
  public void getNrDoorsReturns()
  {
    Volvo240 volvo240test = new Volvo240( Direction.WEST ,  0,  0);
    assertEquals(4, volvo240test.getNrDoors());
  }

  @Test
  public void getEnginePowerReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.WEST ,  0,  0);
        assertEquals(4, volvo240test.getEnginePower(), 0);
    }


    @Test
  public void xReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.WEST ,  50,  0);
        assertEquals(50, volvo240test.getX(),0);
    }

    @Test
    public void yReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.WEST ,  0,  100);
        assertEquals(100, volvo240test.getY(),0);
    }


    @Test
    public void getColorReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.WEST ,  0,  0);
        assertEquals(Color.BLUE,volvo240test.getColor());
    }


    @Test
    public void getTurnRightReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.EAST ,  0,  0);
        assertEquals (Direction.EAST, volvo240test.getDirection()); ///// Fråga
    }

    @Test
    public void getTurnLeftReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.WEST ,  0,  0);
        assertEquals (Direction.WEST, volvo240test.getDirection()); ///// Fråga
    }

    @Test
    public void moveReturns() {
        
        

        Volvo240 volvo240test = new Volvo240(Direction.EAST ,  0,  50);

        volvo240test.startEngine();
        volvo240test.turnLeft();
        assertEquals(50, volvo240test.getY(),0); //// ask about 0

    }

    @Test
    public void gasReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.EAST ,  0,  50);
        volvo240test.startEngine();
        volvo240test.gas(0.5);
        assertEquals(0.075, volvo240test.getCurrentSpeed(),0.0001); /// ask about 0.225

    }

    @Test
    public void breakReturns() {
        Volvo240 volvo240test = new Volvo240(Direction.EAST ,  0,  50);
        volvo240test.gas(0.5);
        volvo240test.brake(0.5);
        assertEquals(0, volvo240test.getCurrentSpeed(),0);

    }
 


}



