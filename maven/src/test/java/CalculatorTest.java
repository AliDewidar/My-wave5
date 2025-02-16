import com.vodafone.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp(){
        //الداله دي بترن قبل كل داله وانا عاوز طبعا اعرف اوبجكت من Calculator عشان استخدمه في كل ميثود
        calculator = new Calculator();
    }
    @After
    public void after(){
        calculator = null;
        System.out.println("After the unit test");
    }

    @Test
    public void testAdd() {
        //بيعرضلك كل الاحتمالات ممكن في مره يكون سالب وممكن الرقمين يكونو موجب وممكن في مره يكون صفر
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-4, 3));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-7, calculator.subtract(-4, 3));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-12, calculator.multiply(-4, 3));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        // هنا في الداله دي لازم هنحط براميتر تاني اللي هوا delta: الحد الأقصى للفرق المسموح به بين القيمتين عشان الداله (divide)من نوع double
        //يعني لو الداله اللي هستدعيها من نوع double يبقى ال assertEquals هياخد ثلاثه باراميتر
        double delta = 0.00001;

        assertEquals(2.5, calculator.divide(5, 2), delta);
        assertEquals(-1.5, calculator.divide(-3, 2), delta);
        assertEquals(0, calculator.divide(0, 5), delta);

    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
