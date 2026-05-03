import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC4Test {

    @Test
    void testEquality_YardToYard_SameValue() {
        assertTrue(new UC4.Quantity(1.0, UC4.LengthUnit.YARD)
                .equals(new UC4.Quantity(1.0, UC4.LengthUnit.YARD)));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new UC4.Quantity(1.0, UC4.LengthUnit.YARD)
                .equals(new UC4.Quantity(3.0, UC4.LengthUnit.FEET)));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new UC4.Quantity(1.0, UC4.LengthUnit.YARD)
                .equals(new UC4.Quantity(36.0, UC4.LengthUnit.INCH)));
    }

    @Test
    void testEquality_CmToInch_EquivalentValue() {
        assertTrue(new UC4.Quantity(1.0, UC4.LengthUnit.CENTIMETER)
                .equals(new UC4.Quantity(0.393701, UC4.LengthUnit.INCH)));
    }

    @Test
    void testEquality_DifferentValues() {
        assertFalse(new UC4.Quantity(1.0, UC4.LengthUnit.YARD)
                .equals(new UC4.Quantity(2.0, UC4.LengthUnit.FEET)));
    }

    @Test
    void testEquality_SameReference() {
        UC4.Quantity q = new UC4.Quantity(1.0, UC4.LengthUnit.YARD);
        assertTrue(q.equals(q));
    }

    @Test
    void testEquality_NullComparison() {
        UC4.Quantity q = new UC4.Quantity(1.0, UC4.LengthUnit.YARD);
        assertFalse(q.equals(null));
    }

    @Test
    void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC4.Quantity(1.0, null);
        });
    }
}