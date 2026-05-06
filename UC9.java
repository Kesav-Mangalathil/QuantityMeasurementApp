public class UC9 {

    public static void main(String[] args) {

        QuantityWeight w1 =
                new QuantityWeight(1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1000.0,
                        WeightUnit.GRAM);

        QuantityWeight w3 =
                new QuantityWeight(2.20462,
                        WeightUnit.POUND);

        // Equality
        System.out.println("1 KG == 1000 G : "
                + w1.equals(w2));

        // Conversion
        System.out.println("1 KG to GRAM : "
                + w1.convertTo(WeightUnit.GRAM));

        System.out.println("2.20462 LB to KG : "
                + w3.convertTo(WeightUnit.KILOGRAM));

        // Addition
        System.out.println("1 KG + 1000 G : "
                + w1.add(w2));

        // Addition with target unit
        System.out.println("1 KG + 1000 G in GRAM : "
                + w1.add(w2, WeightUnit.GRAM));

        // Pound + Kilogram
        System.out.println("2.20462 LB + 1 KG in POUND : "
                + w3.add(w1, WeightUnit.POUND));

        // Zero conversion
        System.out.println("0 KG to GRAM : "
                + new QuantityWeight(0,
                WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM));

        // Negative conversion
        System.out.println("-1 KG to GRAM : "
                + new QuantityWeight(-1,
                WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM));
    }
}