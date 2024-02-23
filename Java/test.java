

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

    public static Float baseToDec(String str, int base) {
        float result = 0;
        int length = str.length();

        if (isBinary(str).equals("false")) {
            System.err.println("Error: Not a binary number");
            return 0.0f;
        }
        for (int i = length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(str.charAt(i));
            result += digit * base;
            base *= 2;
        }
        System.out.println("Decimal value is : " + result);
        return result;
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Test <operation> <base> <operand1> <operand2>");
            return;
        }

        String operation = args[0];
        int base = 0;

        try {
            base = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Base is not an integer");
            return;
        }

        if (isBinary(args[2]).equals("true") && isBinary(args[3]).equals("true")) {
            System.out.println(args[2] + " + " + args[3] + " = " + (calc(operation, baseToDec(args[2], base), baseToDec(args[3], base))));
        } else {
            Float operand1 = Float.parseFloat(args[2]);
            Float operand2 = Float.parseFloat(args[3]);
            System.out.print("Result is : ");
            System.out.println(calc(operation, operand1, operand2));
        }
    }
}
