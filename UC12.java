public class UC12 {

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> l1 =
                new Quantity<>(10.0,
                        LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(6.0,
                        LengthUnit.INCHES);

        // WEIGHT
        Quantity<WeightUnit> w1 =
                new Quantity<>(10.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(5000.0,
                        WeightUnit.GRAM);

        // VOLUME
        Quantity<VolumeUnit> v1 =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(500.0,
                        VolumeUnit.MILLILITRE);

        // SUBTRACTION

        System.out.println(
                "10 FEET - 6 INCHES = "
                + l1.subtract(l2));

        System.out.println(
                "10 KG - 5000 G = "
                + w1.subtract(w2));

        System.out.println(
                "5 L - 500 mL = "
                + v1.subtract(v2));

        // Explicit target unit

        System.out.println(
                "10 FEET - 6 INCHES in INCHES = "
                + l1.subtract(
                l2,
                LengthUnit.INCHES));

        // DIVISION

        System.out.println(
                "10 FEET / 2 FEET = "
                + l1.divide(
                new Quantity<>(2.0,
                LengthUnit.FEET)));

        System.out.println(
                "10 KG / 5 KG = "
                + w1.divide(
                new Quantity<>(5.0,
                WeightUnit.KILOGRAM)));

        System.out.println(
                "5 L / 10 L = "
                + v1.divide(
                new Quantity<>(10.0,
                VolumeUnit.LITRE)));

        // Negative subtraction

        System.out.println(
                "5 FEET - 10 FEET = "
                + new Quantity<>(5.0,
                LengthUnit.FEET)
                .subtract(
                new Quantity<>(10.0,
                LengthUnit.FEET)));

        // Zero subtraction

        System.out.println(
                "10 FEET - 120 INCHES = "
                + new Quantity<>(10.0,
                LengthUnit.FEET)
                .subtract(
                new Quantity<>(120.0,
                LengthUnit.INCHES)));
    }
}