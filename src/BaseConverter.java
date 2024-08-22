public class BaseConverter {
    public static boolean isBinary (String input) {
        return input.matches("^[01]+$");
    }


//    public void decimalToBinary(String expression) {
//        int size = expression.length();
//        int number = Integer.parseInt(expression);
//        //Using right-shift operator to check bit
//        for (int i = size; i >= 0; i--) {
//            int k = number >> i;
//            if ((k & 1) > 0) {
//                System.out.print("1");
//            } else {
//                System.out.print("0");
//            }
//        }
//    }

    public int binaryToDecimal(String expression) {
        //Initialized decimal
        int decimal = 0;
        int len = expression.length();
        int base = 1; //Represent 2^0
        for (int i = len - 1; i >= 0; i--) {
            if (expression.charAt(i) == '1') {
                decimal += base;
            }
            base *=2;
        }
        return decimal;
    }
}
