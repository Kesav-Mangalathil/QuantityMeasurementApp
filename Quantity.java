public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        if (Double.isNaN(value)
                || Double.isInfinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // CONVERT

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    // ADDITION

    public Quantity<U> add(Quantity<U> other) {

        return add(other, this.unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        if (this.unit.getClass()
                != other.unit.getClass()) {

            throw new IllegalArgumentException(
                    "Cross-category addition not allowed");
        }

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        double sumBase =
                thisBase + otherBase;

        double result =
                targetUnit.convertFromBaseUnit(
                        sumBase);

        return new Quantity<>(
                result,
                targetUnit);
    }

    // SUBTRACTION

    public Quantity<U> subtract(
            Quantity<U> other) {

        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        if (this.unit.getClass()
                != other.unit.getClass()) {

            throw new IllegalArgumentException(
                    "Cross-category subtraction not allowed");
        }

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        double differenceBase =
                thisBase - otherBase;

        double result =
                targetUnit.convertFromBaseUnit(
                        differenceBase);

        return new Quantity<>(
                result,
                targetUnit);
    }

    // DIVISION

    public double divide(
            Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (this.unit.getClass()
                != other.unit.getClass()) {

            throw new IllegalArgumentException(
                    "Cross-category division not allowed");
        }

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        if (otherBase == 0) {

            throw new ArithmeticException(
                    "Cannot divide by zero");
        }

        return thisBase / otherBase;
    }

    // EQUALS

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Quantity<?>)) {
            return false;
        }

        Quantity<?> other =
                (Quantity<?>) obj;

        if (this.unit.getClass()
                != other.unit.getClass()) {

            return false;
        }

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(
                thisBase - otherBase)
                < EPSILON;
    }

    // HASHCODE

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(value);

        return Double.hashCode(baseValue);
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Quantity("
                + value
                + ", "
                + unit.getUnitName()
                + ")";
    }
}