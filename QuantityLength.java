public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to another unit
    public QuantityLength convertTo(LengthUnit targetUnit) {

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityLength(convertedValue, targetUnit);
    }

    // Add two quantities and return result in target unit
    public QuantityLength add(
            QuantityLength other,
            LengthUnit targetUnit) {

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityLength(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityLength)) {
            return false;
        }

        QuantityLength other = (QuantityLength) obj;

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        return Math.abs(thisBase - otherBase) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}