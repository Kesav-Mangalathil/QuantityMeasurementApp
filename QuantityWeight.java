public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 0.0001;

    public QuantityWeight(double value, WeightUnit unit) {

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

    public WeightUnit getUnit() {
        return unit;
    }

    // Convert weight
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // Add using same unit
    public QuantityWeight add(QuantityWeight other) {

        return add(other, this.unit);
    }

    // Add using target unit
    public QuantityWeight add(
            QuantityWeight other,
            WeightUnit targetUnit) {

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityWeight)) {
            return false;
        }

        QuantityWeight other = (QuantityWeight) obj;

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