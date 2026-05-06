public class UC11 {

    public static void main(String[] args) {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> v3 =
                new Quantity<>(1.0,
                        VolumeUnit.GALLON);

        // Equality
        System.out.println("1 L == 1000 mL : "
                + v1.equals(v2));

        // Conversion
        System.out.println("1 L to MILLILITRE : "
                + v1.convertTo(
                VolumeUnit.MILLILITRE));

        System.out.println("1 GALLON to LITRE : "
                + v3.convertTo(
                VolumeUnit.LITRE));

        // Addition
        System.out.println("1 L + 1000 mL : "
                + v1.add(v2));

        // Addition with target unit
        System.out.println("1 L + 1000 mL in mL : "
                + v1.add(v2,
                VolumeUnit.MILLILITRE));

        // Gallon addition
        System.out.println("1 GALLON + 1 L in GALLON : "
                + v3.add(v1,
                VolumeUnit.GALLON));

        // Cross-category check
        Quantity<LengthUnit> length =
                new Quantity<>(1.0,
                        LengthUnit.FEET);

        System.out.println("Volume vs Length : "
                + v1.equals(length));
    }
}