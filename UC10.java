public class UC10 {

    public static void main(String[] args) {

        // Length quantities
        Quantity<LengthUnit> l1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> l2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        // Weight quantities
        Quantity<WeightUnit> w1 =
                new Quantity<>(1.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> w2 =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        // Length equality
        System.out.println("1 FEET == 12 INCHES : "
                + l1.equals(l2));

        // Length conversion
        System.out.println("1 FEET to INCHES : "
                + l1.convertTo(LengthUnit.INCHES));

        // Length addition
        System.out.println("1 FEET + 12 INCHES : "
                + l1.add(l2, LengthUnit.FEET));

        // Weight equality
        System.out.println("1 KG == 1000 G : "
                + w1.equals(w2));

        // Weight conversion
        System.out.println("1 KG to GRAM : "
                + w1.convertTo(WeightUnit.GRAM));

        // Weight addition
        System.out.println("1 KG + 1000 G : "
                + w1.add(w2, WeightUnit.KILOGRAM));

        // Cross-category comparison
        System.out.println("Length vs Weight : "
                + l1.equals(w1));
    }
}