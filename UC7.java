public class UC7 {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.0328084);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeet;
        }
    }

    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toBase() {
            return unit.toFeet(value);
        }

        // UC6 method (unchanged)
        public Quantity add(Quantity other) {
            if (other == null) {
                throw new IllegalArgumentException("Other cannot be null");
            }

            double sum = this.toBase() + other.toBase();
            double result = this.unit.fromFeet(sum);

            return new Quantity(result, this.unit);
        }

        // ✅ UC7 METHOD (IMPORTANT)
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double sumInFeet = this.toBase() + other.toBase();

            double resultValue = targetUnit.fromFeet(sumInFeet);

            return new Quantity(resultValue, targetUnit);
        }

        // Optional static version
        public static Quantity add(Quantity q1, Quantity q2, LengthUnit targetUnit) {
            if (q1 == null || q2 == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            return q1.add(q2, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;
            return Double.compare(this.toBase(), other.toBase()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.add(q2, LengthUnit.FEET));     // 2 FEET
        System.out.println(q1.add(q2, LengthUnit.INCH));     // 24 INCH
        System.out.println(q1.add(q2, LengthUnit.YARD));     // ~0.667 YARD
    }
}    
}
