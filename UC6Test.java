import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC6Test {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(2.0, UC6.LengthUnit.FEET);

        UC6.Quantity result = q1.add(q2);

        assertEquals(3.0, result.add(new UC6.Quantity(0, UC6.LengthUnit.FEET)).value, EPS);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(12.0, UC6.LengthUnit.INCH);

        UC6.Quantity result = q1.add(q2);

        assertEquals(2.0, result.value, EPS);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        UC6.Quantity q1 = new UC6.Quantity(12.0, UC6.LengthUnit.INCH);
        UC6.Quantity q2 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);

        UC6.Quantity result = q1.add(q2);

        assertEquals(24.0, result.value, EPS);
    }

    @Test
    void testAddition_YardPlusFeet() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.YARD);
        UC6.Quantity q2 = new UC6.Quantity(3.0, UC6.LengthUnit.FEET);

        UC6.Quantity result = q1.add(q2);

        assertEquals(2.0, result.value, EPS);
    }

    @Test
    void testAddition_WithZero() {
        UC6.Quantity q1 = new UC6.Quantity(5.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(0.0, UC6.LengthUnit.INCH);

        UC6.Quantity result = q1.add(q2);

        assertEquals(5.0, result.value, EPS);
    }

    @Test
    void testAddition_NegativeValues() {
        UC6.Quantity q1 = new UC6.Quantity(5.0, UC6.LengthUnit.FEET);
        UC6.Quantity q2 = new UC6.Quantity(-2.0, UC6.LengthUnit.FEET);

        UC6.Quantity result = q1.add(q2);

        assertEquals(3.0, result.value, EPS);
    }

    @Test
    void testAddition_Null() {
        UC6.Quantity q1 = new UC6.Quantity(1.0, UC6.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            q1.add(null);
        });
    }
}