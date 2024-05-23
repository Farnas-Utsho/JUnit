import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class CalculatorTest {

    @Test
    public void testAdd_NormalShouldPass() {
        Calculator c = new Calculator(5, 4);
        double result = c.add();
        double expected = 9;

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testDiv_shouldThrowArithmaticExp(){
        Calculator c = new Calculator(5, 0);
        Throwable e = Assertions.assertThrows(ArithmeticException.class,
                ()->{c.div();});

        Assertions.assertEquals("/ by zero", e.getMessage());
    }

    @Test
    public void testMul_WithLargeNumbers(){
        Calculator c = new Calculator(8585, 3232);

        Assertions.assertEquals(27746721, c.mul());

        Assertions.assertTimeout(Duration.ofNanos(10),
                ()->{c.mul();});



    }


}
