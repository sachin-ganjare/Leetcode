public class TypeCastingConversionPromotion {
    public static void main(String[] args) {
        // Type Casting
        int i = 10;
        double d = (double) i; // Explicit casting from int to double
        System.out.println("Explicit Casting: " + d);

        // Type Conversion
        float f = 5.5f;
        double convertedDouble = f; // Implicit conversion from float to double
        System.out.println("Implicit Conversion: " + convertedDouble);

        // Type Promotion
        byte b1 = 10;
        byte b2 = 20;
        int sum = b1 + b2; // byte is promoted to int during addition
        System.out.println("Type Promotion: " + sum);
    }
}