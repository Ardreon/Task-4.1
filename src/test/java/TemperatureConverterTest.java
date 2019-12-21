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

       @Parameterized.Parameters
       public static Collection data(){
           return Arrays.asList(new Object[][] {
                   {0.0, 273.2, 32.0},
                   {-273.2, 0.0, -459.4},
                   {3.0, 276.2, 37.4},
                   {-5.0, 268.2, 23.0}
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
    }

    @Test
    public void convertKtoF() {
    }
}