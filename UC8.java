public class UC8 {

    public static void main(String[] args) {

        QuantityLength q1 =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength q2 =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength q3 =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength q4 =
                new QuantityLength(30.48, LengthUnit.CENTIMETERS);

        // Equality
        System.out.println("1 FEET == 12 INCHES : "
                + q1.equals(q2));

        // Conversion
        System.out.println("1 FEET to INCHES : "
                + q1.convertTo(LengthUnit.INCHES));

        // Addition
        System.out.println("1 FEET + 12 INCHES in FEET : "
                + q1.add(q2, LengthUnit.FEET));

        // Yards equality
        System.out.println("36 INCHES == 1 YARD : "
                + new QuantityLength(36, LengthUnit.INCHES)
                .equals(q3));

        // Centimeter conversion
        System.out.println("30.48 CM to FEET : "
                + q4.convertTo(LengthUnit.FEET));

        // Addition in yards
        System.out.println("1 YARD + 3 FEET in YARDS : "
                + q3.add(
                        new QuantityLength(3, LengthUnit.FEET),
                        LengthUnit.YARDS));

        // Direct enum conversion checks
        System.out.println("12 INCHES to base unit : "
                + LengthUnit.INCHES.convertToBaseUnit(12));

        System.out.println("1 FEET to inches using enum : "
                + LengthUnit.INCHES.convertFromBaseUnit(1));
    }
}