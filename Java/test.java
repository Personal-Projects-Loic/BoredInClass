public class test {

    public static float calc(String calc, Float a, Float b) {
        if (calc.equals("add")) {
            return a + b;
        } else if (calc.equals("sub")) {
            return a - b;
        } else if (calc.equals("mul")) {
            return a * b;
        } else if (calc.equals("div")) {
            if (b != 0) {
                return a / b;
            } else {
                System.err.println("Error: Damn bro, don't do that");
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static String isBinary(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return "false";
            }
        }
        return "true";
    }

    public static Float binaryToDec(String str) {
        float result = 0;
        int base = 1;
        int length = str.length();

        if (isBinary(str) == "false") {
            System.err.println("Error: Not a binary number");
            return 0.0f;
        }
        for (int i = length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(str.charAt(i));
            result += digit * base;
            base *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        String operation = args[0];

        if (args.length != 3) {
            System.out.println("Usage: java test <operation> <operand1> <operand2>");
            return;
        }

        if (isBinary(args[1]) == "true" && isBinary(args[2]) == "true") {
            System.out.println(args[1] + " + " + args[2] + " = " + (calc(operation, binaryToDec(args[1]), binaryToDec(args[2]))));
        } else {
            Float operand1 = Float.parseFloat(args[1]);
            Float operand2 = Float.parseFloat(args[2]);
            System.out.print("Result is : ");
            System.out.println(calc(operation, operand1, operand2));
        }

    }
}