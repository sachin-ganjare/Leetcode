class BinaryToDecimal {

    static int binaryToDecimal(String binary) {
        int decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            char bit = binary.charAt(length - 1 - i);
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        String binary = "1101";
        int decimal = Integer.parseInt(binary, 2);
        String binary2 = "1010";
        int decimal2 = binaryToDecimal(binary2);

        System.out.println("Decimal equivalent of " + binary + " is: " + decimal);
        System.out.println("Decimal equivalent of " + binary2 + " is: " + decimal2);
    }
}
