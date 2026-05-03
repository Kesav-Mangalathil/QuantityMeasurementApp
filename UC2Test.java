import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC2Test {

    // Feet Tests
    @Test
    void testFeetEquality_SameValue() {
        assertTrue(UC2.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(UC2.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        UC2.Feet f = new UC2.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        UC2.Feet f = new UC2.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        UC2.Feet f = new UC2.Feet(1.0);
        assertFalse(f.equals("Invalid"));
    }

    // Inches Tests
    @Test
    void testInchesEquality_SameValue() {
        assertTrue(UC2.compareInches(1.0, 1.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(UC2.compareInches(1.0, 2.0));
    }

    @Test
    void testInchesEquality_NullComparison() {
        UC2.Inches i = new UC2.Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testInchesEquality_SameReference() {
        UC2.Inches i = new UC2.Inches(1.0);
        assertTrue(i.equals(i));
    }

    @Test
    void testInchesEquality_NonNumericInput() {
        UC2.Inches i = new UC2.Inches(1.0);
        assertFalse(i.equals("Invalid"));
    }
}