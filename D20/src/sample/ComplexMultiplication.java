package sample;

public class ComplexMultiplication {
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
    }

    public static String complexNumberMultiply(String a, String b) {
        String[] aArr = a.split("\\+");
        String[] bArr = b.split("\\+");

        int aa = Integer.parseInt(aArr[0]);
        int ab = Integer.parseInt(aArr[1].split("i")[0]);
        int ba = Integer.parseInt(bArr[0]);
        int bb = Integer.parseInt(bArr[1].split("i")[0]);

        return ((aa * ba) - (ab * bb)) + "+" + ((aa * bb) + (ab * ba)) + "i";
    }
}
