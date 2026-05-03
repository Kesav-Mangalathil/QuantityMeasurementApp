import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC3Test {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        UC3.Quantity q1 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);
        UC3.Quantity q2 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        UC3.Quantity q1 = new UC3.Quantity(1.0, UC3.LengthUnit.INCH);
        UC3.Quantity q2 = new UC3.Quantity(1.0, UC3.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        UC3.Quantity q1 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);
        UC3.Quantity q2 = new UC3.Quantity(12.0, UC3.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        UC3.Quantity q1 = new UC3.Quantity(12.0, UC3.LengthUnit.INCH);
        UC3.Quantity q2 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentValue() {
        UC3.Quantity q1 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);
        UC3.Quantity q2 = new UC3.Quantity(2.0, UC3.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_NullComparison() {
        UC3.Quantity q1 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        UC3.Quantity q1 = new UC3.Quantity(1.0, UC3.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC3.Quantity(1.0, null);
        });
    }
}