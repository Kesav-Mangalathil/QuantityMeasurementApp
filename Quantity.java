public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    // ENUM FOR OPERATIONS

    private enum ArithmeticOperation {

        ADD {
            @Override
            double compute(double a, double b) {
                return a + b;
            }
        },

        SUBTRACT {
            @Override
            double compute(double a, double b) {
                return a - b;
            }
        },

        DIVIDE {
            @Override
            double compute(double a, double b) {

                if (b == 0) {
                    throw new ArithmeticException(
                            "Cannot divide by zero");
                }

                return a / b;
            }
        };

        abstract double compute(double a, double b);
    }

    // CONSTRUCTOR

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

    // GETTERS

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // VALIDATION HELPER

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        if (targetUnitRequired
                && targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        if (this.unit.getClass()
                != other.unit.getClass()) {

            throw new IllegalArgumentException(
                    "Cross-category arithmetic not allowed");
        }

        if (Double.isNaN(other.value)
                || Double.isInfinite(other.value)) {

            throw new IllegalArgumentException(
                    "Invalid operand value");
        }
    }

    // CORE ARITHMETIC HELPER

    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        double thisBase =
                unit.convertToBaseUnit(this.value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value);

        return operation.compute(
                thisBase,
                otherBase);
    }

    // ROUNDING HELPER

    private double roundToTwoDecimals(
            double value) {

        return Math.round(value * 100.0)
                / 100.0;
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

        convertedValue =
                roundToTwoDecimals(
                        convertedValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    // ADDITION

    public Quantity<U> add(
            Quantity<U> other) {

        return add(other, this.unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double resultBase =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.ADD);

        double result =
                targetUnit.convertFromBaseUnit(
                        resultBase);

        result =
                roundToTwoDecimals(result);

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

        validateArithmeticOperands(
                other,
                targetUnit,
                true);

        double resultBase =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double result =
                targetUnit.convertFromBaseUnit(
                        resultBase);

        result =
                roundToTwoDecimals(result);

        return new Quantity<>(
                result,
                targetUnit);
    }

    // DIVISION

    public double divide(
            Quantity<U> other) {

        validateArithmeticOperands(
                other,
                null,
                false);

        return performBaseArithmetic(
                other,
                ArithmeticOperation.DIVIDE);
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
                unit.convertToBaseUnit(
                        this.value);

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