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

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java test <operation> <operand1> <operand2>");
            return;
        }

        String operation = args[0];
        Float operand1 = Float.parseFloat(args[1]);
        Float operand2 = Float.parseFloat(args[2]);

        System.out.print("Result is : ");
        System.out.println(calc(operation, operand1, operand2));
    }
}