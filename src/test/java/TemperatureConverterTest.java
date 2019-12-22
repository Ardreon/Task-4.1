import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

    @RunWith(Parameterized.class)

public class TemperatureConverterTest {
       private TemperatureConverter converter;

       @Parameterized.Parameter
      public double parametr;

       @Parameterized.Parameter(1)
      public double expected;

       @Parameterized.Parameter(2)
       public double expected1;

       @Parameterized.Parameter(3)
       public double expected2;

       @Parameterized.Parameter(4)
       public double expected3;

       @Parameterized.Parameter(5)
       public double expected4;


       @Parameterized.Parameters
       public static Collection data(){
           return Arrays.asList(new Object[][] {
                   {0.0, 273.2, 32.0, -17.7, 255.3, -459.7},
                   {-273.2, 0.0, -459.4, -169.5, 103.6, -951.46},
                   {3.0, 276.2, 37.4, -16.1, 257.0, -454.3},
                   {-5.0, 268.2, 23.0, -20.5, 252.6, -468.7}
           });
       }

    @Before
    public void setUp(){
    converter = new TemperatureConverter();
    }


    @Test
    public void convertCtoK() {
        double temperature = converter.convertCtoK(parametr);
        assertEquals(expected, temperature, 0.002);
    }

    @Test
    public void convertFtoC() {
           assertEquals(expected2,converter.convertFtoC(parametr), 0.1);

    }

    @Test
    public void convertCtoF() {
           assertEquals(expected1, converter.convertCtoF(parametr), 0.4);
    }

    @Test
    public void convertKtoC() {
           assertEquals(parametr, converter.convertKtoC(expected), 0.005);
    }

    @Test
    public void convertFtoK() {
        assertEquals(expected3, converter.convertFtoK(parametr), 0.09);
    }

    @Test
    public void convertKtoF() {
        assertEquals(expected4, converter.convertKtoF(parametr), 0.0001);
    }
}