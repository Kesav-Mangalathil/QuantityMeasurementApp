import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC7Test {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_TargetFeet() {
        UC7.Quantity q1 = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity q2 = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        UC7.Quantity result = q1.add(q2, UC7.LengthUnit.FEET);

        assertEquals(2.0, result.value, EPS);
    }

    @Test
    void testAddition_TargetInches() {
        UC7.Quantity q1 = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity q2 = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        UC7.Quantity result = q1.add(q2, UC7.LengthUnit.INCH);

        assertEquals(24.0, result.value, EPS);
    }

    @Test
    void testAddition_TargetYard() {
        UC7.Quantity q1 = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity q2 = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        UC7.Quantity result = q1.add(q2, UC7.LengthUnit.YARD);

        assertEquals(0.666666, result.value, 1e-3);
    }

    @Test
    void testAddition_Commutativity() {
        UC7.Quantity a = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity b = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        assertEquals(
            a.add(b, UC7.LengthUnit.FEET).value,
            b.add(a, UC7.LengthUnit.FEET).value,
            EPS
        );
    }

    @Test
    void testAddition_NullTarget() {
        UC7.Quantity q1 = new UC7.Quantity(1.0, UC7.LengthUnit.FEET);
        UC7.Quantity q2 = new UC7.Quantity(12.0, UC7.LengthUnit.INCH);

        assertThrows(IllegalArgumentException.class, () -> {
            q1.add(q2, null);
        });
    }
}