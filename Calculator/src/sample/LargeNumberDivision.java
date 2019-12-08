package sample;

public class LargeNumberDivision {
    public String divide(String number1, String number2) {

        boolean negative = false;
        if(number2.equals("0")){
            return "Error";
        }
        if (number1.charAt(0) == '-' && number2.charAt(0) == '-') {
            negative = false;
            number1 = number1.substring(1);
            number2 = number2.substring(1);
        } else if (number1.charAt(0) == '-') {
            negative = true;
            number1 = number1.substring(1);
        } else if (number2.charAt(0) == '-') {
            negative = true;
            number2 = number2.substring(1);
        }
        LargeNumberSubtraction subtractor = new LargeNumberSubtraction();
        LargeNumberAddition adder = new LargeNumberAddition();
        LargeNumberMultiplication multiplier = new LargeNumberMultiplication();
        String result = "0";
        String decimal;
        while (number1.equals(getLarger(number1, number2))) {
            number1 = subtractor.subtract(number1, number2);
            result = adder.add(result, "1");
        }

        if(!number1.equals("0")){
            result += ".";
            for (int i = 0; i < 3; i++) {
                decimal = "0";
                number1 = multiplier.multiply(number1, "10");
                while (number1.equals(getLarger(number1, number2))){
                    number1 = subtractor.subtract(number1, number2);
                    decimal = adder.add(decimal, "1");
                }

                result += decimal;
                if(number1.equals("0")){
                    break;
                }
            }
        }

        if(negative){
            return "-" + result;
        }else {
            return result;
        }
    }

    String getLarger(String number1, String number2) {
        if (number1.length() > number2.length()) {
            return number1;
        } else if (number2.length() > number1.length()) {
            return number2;
        } else {
            String larger = number1;
            for (int i = 0; i < number1.length(); i++) {
                if (number1.charAt(i) > number2.charAt(i)) {
                    larger = number1;
                    break;
                } else if (number2.charAt(i) > number1.charAt(i)) {
                    larger = number2;
                    break;
                }
            }
            return larger;
        }
    }

    public static void main(String[] args) {
        LargeNumberDivision divider = new LargeNumberDivision();
        System.out.println(divider.divide("4", "2"));
    }

}
