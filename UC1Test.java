import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC1Test {

    @Test
    void testEquality_SameValue() {
        UC1.Feet f1 = new UC1.Feet(1.0);
        UC1.Feet f2 = new UC1.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        UC1.Feet f1 = new UC1.Feet(1.0);
        UC1.Feet f2 = new UC1.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        UC1.Feet f1 = new UC1.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        UC1.Feet f1 = new UC1.Feet(1.0);

        assertTrue(f1.equals(f1));
    }

    @Test
    void testEquality_NonNumericInput() {
        UC1.Feet f1 = new UC1.Feet(1.0);

        assertFalse(f1.equals("Invalid"));
    }
}